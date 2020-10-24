package com.bgy.gateway.util;

import com.bgy.gateway.constant.Constant;
import com.bgy.gateway.enums.CommandType;
import com.bgy.gateway.enums.MessageType;
import com.bgy.gateway.exception.BusinessException;
import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.model.vo.ResultEnum;
import com.bgy.gateway.model.vo.ResultVo;
import com.bgy.gateway.service.RedisService;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class ServiceUtil {


    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceUtil.class);

    public static ResultVo sendAndRetryIfFailedAsync(Channel channel, Message message, RedisService redisService)
            throws BusinessException {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        Callable<ResultVo> callable = () -> sendAndRetryIfFailed(channel, message, redisService, 1);

        Future<ResultVo> future = executor.submit(callable);
        try {
            return future.get();
        } catch (Exception e) {
            throw new BusinessException(ResultEnum.OTHER_ERROR, e.getMessage());
        }
    }

    /**
     * 若指定时间内未收到回复，则重发 N 次
     * */
    private static ResultVo sendAndRetryIfFailed(Channel channel, Message message, RedisService redisService, int toSendTime){

        String requestHashKey = getRequestHashKey(message);
        redisService.pushHash(Constant.REDIS_RESPONSE_KEY, requestHashKey, Constant.REQUEST_REQUEST_FLAG);
        if(toSendTime > Constant.REQUEST_MAX_RETRY_TIME) {
            LOGGER.warn("未收到客户端回复：{}", message);
            redisService.removeHash(Constant.REDIS_RESPONSE_KEY, requestHashKey);
            return ResultVo.error(ResultEnum.DEVICE_CTRL_TIMEOUT);
        }

        LOGGER.info("命令第{}次发送：{}", toSendTime, message);

        if(toSendTime == 1) {
            redisService.pushHash(Constant.REDIS_RESPONSE_KEY, requestHashKey, Constant.REQUEST_REQUEST_FLAG);
        }

        channel.writeAndFlush(message).addListener(new ChannelFutureListener(){
            @Override
            public void operationComplete(ChannelFuture future)
                    throws Exception {
                if (future.isSuccess()) {
                   // LOGGER.info("服务端发送信息成功 ip {},发送的数据：",channel.remoteAddress(),message);
                } else {
                    LOGGER.error("服务端发送信息失败 ip {},发送的数据：{} ，异常信息 {}",channel.remoteAddress(),message, future.cause());

                }
            }
        });

        if(hasRequestReply(redisService, requestHashKey)) {
            redisService.removeHash(Constant.REDIS_RESPONSE_KEY, requestHashKey);
            //return ResultVo.success();
            Map keyMap = new HashMap();
            keyMap.put(Constant.REQUEST_RESPONSE_KEY,message.getUniqueKey());
            return ResultVo.success(keyMap);
        }

        return sendAndRetryIfFailed(channel, message, redisService, toSendTime + 1);
    }

    /**
     * 不重发，等待若干时间确认是否收到回复
     * */
   /* public static ResultVo sendAndWaitForResponse(Channel channel, Message message, RedisService redisService) {
        boolean flag;
        String requestHashKey = getRequestHashKey(message);

        channel.writeAndFlush(message);

        long currentTimeMillisecond = System.currentTimeMillis();
        Map<String, Object> replyMap;

        while (true) {
            replyMap = hasRequestReplyResult(redisService, requestHashKey);

            if(RespondStatus.SUCESS.equals(replyMap.get(Constant.REQUEST_RESPONSE_RESULT))) {
                break;
            }

            if(System.currentTimeMillis() - currentTimeMillisecond > Constant.WAIT_RESPONSE_TIMEOUT_MILLISECOND) {
                break;
            }
        }

        if(StringUtils.isEmpty(replyMap.get(Constant.REQUEST_RESPONSE_RESULT))) {
            flag = false;
            LOGGER.warn("未收到客户端回复：{}", message);

        }else{
            flag = true;
            LOGGER.warn("收到客户端回复结果：{}", replyMap.get(Constant.REQUEST_RESPONSE_RESULT));
        }

      //  redisService.removeHash(Constant.REDIS_RESPONSE_KEY, requestHashKey);
        return flag ? ResultVo.success(replyMap) : ResultVo.error(ResultEnum.DEVICE_CTRL_TIMEOUT);
    }*/

    public static void sendRequestCommonReply(ChannelHandlerContext ctx, Message msg) {
        Message responseMessage = new Message();
        responseMessage.setHeader(msg.getHeader());
        responseMessage.setMessageType(MessageType.RESPONSE);
        responseMessage.setUniqueKey(msg.getUniqueKey());
        responseMessage.setDeviceType(msg.getDeviceType());
        responseMessage.setDeviceId(msg.getDeviceId());
        ctx.writeAndFlush(responseMessage);
    }

    public static byte[] getFileBytes(String fileName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);

            return bytes;
        } catch (Exception e) {
            LOGGER.error("读取文件失败：" + fileName, e);
        }

        return null;
    }

    private static String getRequestHashKey(Message message) {
        return message.getDeviceId() + "_" + message.getUniqueKey();
    }

   /* private static boolean hasRequestReply(RedisService redisService, String requestHashKey) {
        try {
            TimeUnit.MILLISECONDS.sleep(Constant.WAIT_RESPONSE_SLEEP_MILLISECOND);
            String flag = redisService.getHash(Constant.REDIS_RESPONSE_KEY, requestHashKey, String.class);
            if(Constant.REQUEST_RESPONSE_FLAG.equals(flag)) {
                return true;
            }
        } catch (InterruptedException e) {
//                throw new BusinessException(ResultEnum.OTHER_ERROR, e.getMessage());
        }

        return false;
    }
*/

    private static boolean hasRequestReply(RedisService redisService, String requestHashKey) {
        try {
            Long time = System.currentTimeMillis();
            String flag = redisService.getHash(Constant.REDIS_RESPONSE_KEY, requestHashKey, String.class);
            while(!Constant.REQUEST_RESPONSE_FLAG.equals(flag)){
                TimeUnit.MILLISECONDS.sleep(Constant.WAIT_RESPONSE_POLL_MILLISECOND);
                Long endTime = System.currentTimeMillis() - time;
                flag = redisService.getHash(Constant.REDIS_RESPONSE_KEY, requestHashKey, String.class);
                if(!Constant.REQUEST_RESPONSE_FLAG.equals(flag)  && endTime > Constant.WAIT_RESPONSE_REPLY_RETRY_MILLISECOND){
                    LOGGER.error("回复超时 耗时{}",endTime);
                    return false;
                }
            }
            if(Constant.REQUEST_RESPONSE_FLAG.equals(flag)) {
                return true;
            }
        } catch (Exception e) {
            LOGGER.error("轮询回复出错{}",e);
        }

        return false;
    }




    /**
     * 不重发，等待若干时间确认是否收到回复
     * */
    public static ResultVo sendAndWaitForResponse(Channel channel, Message message, RedisService redisService ) {

        Map<String, Object> replyMap = new HashMap();
        try {
            //LOGGER.info("带结果回复命令发送：{}", message);
            String requestHashKey = getRequestHashKey(message);
            channel.writeAndFlush(message).addListener(new ChannelFutureListener(){
                @Override
                public void operationComplete(ChannelFuture future)
                        throws Exception {
                    if (future.isSuccess()) {
                        //LOGGER.info("带回复命令服务端发送信息成功 ip {},发送的数据：",channel.remoteAddress(),message);
                    } else {
                        LOGGER.error("带回复命令服务端发送信息失败 ip {},发送的数据：{} ，异常信息 {}",channel.remoteAddress(),message, future.cause());

                    }
                }
            });
            Long time = System.currentTimeMillis();
            String flag = redisService.getHash(Constant.REDIS_RESPONSE_RESULT_KEY, requestHashKey, String.class);
            while (StringUtils.isEmpty(flag)) {
                TimeUnit.MILLISECONDS.sleep(Constant.WAIT_RESPONSE_POLL_MILLISECOND);
                flag = redisService.getHash(Constant.REDIS_RESPONSE_RESULT_KEY, requestHashKey, String.class);
                Long endTime = System.currentTimeMillis() - time;
                if (StringUtils.isEmpty(flag) &&  endTime> Constant.WAIT_RESPONSE_RESULT_TIMEOUT_MILLISECOND) {
                    LOGGER.info("回复超时,耗时 {}",endTime);
                    return ResultVo.error(ResultEnum.DEVICE_CTRL_TIMEOUT);
                }

            }
            replyMap.put(Constant.REQUEST_RESPONSE_RESULT, flag);
            if(Constant.REQUEST_RESPONSE_RESULT_VALUE.equals(flag)){
                replyMap.put(Constant.REQUEST_RESPONSE_STATE, CommandType.ONE.getStatus());
            }else{
                replyMap.put(Constant.REQUEST_RESPONSE_STATE, CommandType.TWO.getStatus());
            }

            replyMap.put(Constant.REQUEST_RESPONSE_KEY,message.getUniqueKey());
            LOGGER.info("收到客户端回复结果：{}", replyMap.get(Constant.REQUEST_RESPONSE_RESULT));
            redisService.removeHash(Constant.REDIS_RESPONSE_RESULT_KEY, requestHashKey);
        } catch (Exception e) {
            LOGGER.error("处理sendAndWaitForResponse 出错：{}",e);
        }
        return ResultVo.success(replyMap);
    }


}

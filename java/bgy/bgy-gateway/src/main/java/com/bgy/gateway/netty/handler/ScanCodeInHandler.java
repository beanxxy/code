package com.bgy.gateway.netty.handler;

import com.bgy.gateway.model.kafka.ScanCodeDischarge;
import com.bgy.gateway.service.KafkaService;
import com.bgy.gateway.constant.Constant;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author caijunwei
 * date 2020/2/25 19:02
 */

@Component
@ChannelHandler.Sharable
public class ScanCodeInHandler extends ChannelInboundHandlerAdapter {
    private static int count;

    private static final Logger LOGGER = LoggerFactory.getLogger(ScanCodeInHandler.class);

    @Autowired
    private KafkaService kafkaService;


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        try {
            ByteBuf buf = (ByteBuf) msg;
            String code = getMessage(buf);
            LOGGER.info("扫码接收数据：" + ctx.channel().remoteAddress() + "---" + code);
            String ip = ctx.channel().remoteAddress().toString().substring(1).split(":")[0];
            Integer port = Integer.valueOf(ctx.channel().remoteAddress().toString().substring(1).split(":")[1]);
            ScanCodeDischarge scanCodeDischarge = new ScanCodeDischarge();
            scanCodeDischarge.setIp(ip);
            scanCodeDischarge.setPort(port);
            scanCodeDischarge.setCode(code);
            LOGGER.info("kafkaService 对象：{}", kafkaService);
            kafkaService.pushToInside(Constant.KAFKA_SCAN_CODE,scanCodeDischarge);
        } catch (Exception e) {
            LOGGER.info("扫码数据处理异常：{}", e.getCause());
        } finally {
            ReferenceCountUtil.release(msg);
            String callbackStr = "4001000C00010003000100010001";
            byte[] buf = callbackStr.getBytes();
            ByteBuf firstMessage = Unpooled.buffer(buf.length);//发送类
            firstMessage.writeBytes(buf);
            ctx.writeAndFlush(firstMessage);
            ctx.writeAndFlush(buf).addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future)
                        throws Exception {
                    LOGGER.info("发送消息成功！" + Arrays.toString(buf));
                }
            });
        }
    }

    /**
     * @param buf
     * @return
     * @author Taowd
     * TODO  此处用来处理收到的数据中含有中文的时  出现乱码的问题
     * 2017年8月31日 下午7:57:28
     */
    private String getMessage(ByteBuf buf) {
        byte[] con = new byte[buf.readableBytes()];
        buf.readBytes(con);
        try {
            return new String(con, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
      //scanCodeService.handleActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
      //scanCodeService.handleInactive(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    public static String getIPString(ChannelHandlerContext ctx) {
        String ipString = "";
        String socketString = ctx.channel().remoteAddress().toString();
        int colonAt = socketString.indexOf(":");
        ipString = socketString.substring(1, colonAt);
        return ipString;
    }


    public static String getRemoteAddress(ChannelHandlerContext ctx) {
        String socketString = "";
        socketString = ctx.channel().remoteAddress().toString();
        return socketString;
    }


    private String getKeyFromArray(byte[] addressDomain) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < 5; i++) {
            sBuffer.append(addressDomain[i]);
        }
        return sBuffer.toString();
    }

    protected String to8BitString(String binaryString) {
        int len = binaryString.length();
        for (int i = 0; i < 8 - len; i++) {
            binaryString = "0" + binaryString;
        }
        return binaryString;
    }

    protected static byte[] combine2Byte(byte[] bt1, byte[] bt2) {
        byte[] byteResult = new byte[bt1.length + bt2.length];
        System.arraycopy(bt1, 0, byteResult, 0, bt1.length);
        System.arraycopy(bt2, 0, byteResult, bt1.length, bt2.length);
        return byteResult;
    }
}
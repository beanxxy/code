package com.bgy.gateway.netty.handler;

import com.bgy.gateway.enums.CommandType;
import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.netty.ChannelSupervise;
import com.bgy.gateway.service.MessageService;
import com.bgy.gateway.service.store.ChineseFoodService;
import com.bgy.gateway.service.store.FastFoodSelfService;
import com.bgy.gateway.service.store.FastFoodService;
import com.bgy.gateway.service.store.HotpotService;
import com.bgy.gateway.service.store.SimpleChineseFoodService;
import com.bgy.gateway.util.TaskUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * MessageHandler 业务处理
 * 1. 接收到新消息时回复消息(Request 除外，需要在各个业态的 Service 单独处理)
 * 2. 处理 Active, Inactive, exceptionCaught 逻辑
 * 3. 接收到新消息时更新设备最后一次通信时间 (messageCommonAction)
 */

@Component
@ChannelHandler.Sharable
public class MessageHandler extends SimpleChannelInboundHandler<Message> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageHandler.class);

    @Autowired
    private MessageService messageService;
    @Autowired
    private SimpleChineseFoodService simpleChineseFoodService;
    @Autowired
    private HotpotService hotpotService;
    @Autowired
    private FastFoodService fastFoodService;
    @Autowired
    private ChineseFoodService chineseFoodService;
    @Autowired
    private FastFoodSelfService fastFoodSelfService;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
        if (TaskUtil.isHeartLog()) {
            LOGGER.info("接收：{}", msg);
        } else {
            if (msg.getMessageType().getType() != CommandType.ZERO.getStatus()) {
                LOGGER.info("接收：{}", msg);
            }
        }

        switch (msg.getMessageType()) {
            case HEARTBEAT:
                messageService.handleHeartbeat(ctx, msg);
                break;
            case REQUEST:
                switch (msg.getDeviceType()) {
                    case COOK_SIMPLE_CHINESE_FOOD:
                        simpleChineseFoodService.handleCookRequest(ctx, msg);
                        break;
                    case COLD_SIMPLE_CHINESE_FOOD:
                        simpleChineseFoodService.handleColdRequest(ctx, msg);
                        break;
                    case COLD_HOTPOT:
                        hotpotService.handleColdRequest(ctx, msg);
                        break;
                    case TABLE_HOTPOT:
                        hotpotService.handleTableRequest(ctx, msg);
                        break;
                    case BELT_HOTPOT:
                        hotpotService.handleBeltRequest(ctx, msg);
                        break;
                    case UPDISH_HOTPOT:
                        hotpotService.handleUpdishRequest(ctx, msg);
                        break;
                    case CUT_HOTPOT:
                        hotpotService.handleCutRequest(ctx, msg);
                        break;
                    case DRINK_HOTPOT:
                        hotpotService.handleDrinkRequest(ctx, msg);
                        break;
                    case STEAMER_FAST_FOOD:
                        fastFoodService.handleStreamRequest(ctx, msg);
                        break;
                    case COLD_STEAMER_FAST_FOOD:
                        fastFoodService.handleClodStreamRequest(ctx, msg);
                        break;
                    case BELT_STEAMER_FAST_FOOD:
                        fastFoodService.handleBeltStreamRequest(ctx, msg);
                        break;
                    case BELT_STEAMER_SELF_FAST_FOOD:
                        fastFoodSelfService.handleBeltSelfStreamRequest(ctx, msg);
                        break;
                    case WARM_WATER_FAST_FOOD:
                        fastFoodSelfService.handleBeltSelfWaterStreamRequest(ctx, msg);
                        break;
                    case UPDISH_CHINESE_FOOD:
                        chineseFoodService.handleUpdishRequest(ctx, msg);
                        break;
                    case COOK_CHINESE_FOOD:
                        chineseFoodService.handleCookRequest(ctx, msg);
                        break;
                    case COLD_CHINESE_FOOD:
                        chineseFoodService.handleColdRequest(ctx, msg);
                        break;
                    case STEAMER_CHINESE_FOOD:
                        chineseFoodService.handleSteamRequest(ctx, msg);
                        break;
                    case DOWN_CHINESE_FOOD:
                        chineseFoodService.handleDownRequest(ctx, msg);
                        break;
                    case CLAYPOT_CHINESE_FOOD:
                        chineseFoodService.handleClaypotRequest(ctx, msg);
                        break;
                    default:
                        break;
                }
                //状态上报 检测是否有登录 没登录即添加登录信息  防止设备没及时上报登录又下发不了命令
                //ChannelSupervise.addChannel(ctx.channel(), msg);
                messageService.handleRequest(ctx, msg);
                break;
            case RESPONSE:
                messageService.handleResponse(ctx, msg);
                break;
            case HEARTBEAT_RESPONSE:
                messageService.handleHeartbeatResponse(ctx, msg);
                break;
            case RESULT_RESPONSE:
                messageService.handleResultResponse(ctx, msg);
                break;
            case LOGIN:
                messageService.handleLogin(ctx, msg);
                break;
            case LOGIN_RESPONSE:
                messageService.handleLoginResponse(ctx, msg);
                break;
            default:
                break;
        }

        messageService.messageCommonAction(ctx, msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        messageService.handleActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        messageService.handleInactive(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        LOGGER.info("发生异常 exceptionCaught ctx {} ,cause {}", ctx, cause.getStackTrace());
        messageService.handleExceptionCaught(ctx, cause);
    }
}

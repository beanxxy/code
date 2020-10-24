package com.bgy.gateway.netty.handler;

import com.bgy.gateway.enums.CommandType;
import com.bgy.gateway.enums.DeviceType;
import com.bgy.gateway.enums.MessageType;
import com.bgy.gateway.model.message.HeartbeatInOut;
import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.model.message.NewHeartbeatInOut;
import com.bgy.gateway.model.message.RespondMessageIn;
import com.bgy.gateway.model.message.belt.BeltHotpotIn;
import com.bgy.gateway.model.message.belt.BeltStreamFastFoodIn;
import com.bgy.gateway.model.message.belt.BeltStreamSelfFastFoodIn;
import com.bgy.gateway.model.message.belt.BeltStreamSelfWaterFastFoodIn;
import com.bgy.gateway.model.message.claypot.ClaypotChineseFoodIn;
import com.bgy.gateway.model.message.cold.ColdChineseFoodIn;
import com.bgy.gateway.model.message.cold.ColdHotpotIn;
import com.bgy.gateway.model.message.cold.ColdSimpleChineseFoodIn;
import com.bgy.gateway.model.message.cold.ColdStreamFastFoodIn;
import com.bgy.gateway.model.message.cook.CookChineseFoodIn;
import com.bgy.gateway.model.message.cook.CookSimpleChineseFoodIn;
import com.bgy.gateway.model.message.cut.CutHotpotIn;
import com.bgy.gateway.model.message.down.DownChineseFoodIn;
import com.bgy.gateway.model.message.drink.DrinkHotpotIn;
import com.bgy.gateway.model.message.steam.SteamChineseFoodIn;
import com.bgy.gateway.model.message.steam.SteamFastFoodIn;
import com.bgy.gateway.model.message.table.TableHotpotIn;
import com.bgy.gateway.model.message.updish.UpdishChineseFoodIn;
import com.bgy.gateway.model.message.updish.UpdishHotpotIn;
import com.bgy.gateway.util.NettyUtil;
import com.bgy.gateway.util.TaskUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MessageDecoder extends ByteToMessageDecoder {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageDecoder.class);

    private boolean isBigEndian;
    private String version;

    public MessageDecoder(boolean isBigEndian, String version) {
        this.isBigEndian = isBigEndian;
        this.version = version;
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        // if(LOGGER.isInfoEnabled()) {
        byte[] bytes = new byte[in.readableBytes()];
        in.getBytes(in.readerIndex(), bytes);
        //  LOGGER.info("客户端地址：{},接收报文：{}", ctx.channel().remoteAddress(),NettyUtil.bytesToHexString(bytes));
        // }
        int header = NettyUtil.readShort(in, isBigEndian);
        int dataLength = NettyUtil.readShort(in, isBigEndian);
        MessageType messageType = MessageType.fromType(NettyUtil.readShort(in, isBigEndian));
        int uniqueKey = NettyUtil.readShort(in, isBigEndian);
        DeviceType deviceType = DeviceType.fromType(NettyUtil.readShort(in, isBigEndian));
        int deviceId = NettyUtil.readShort(in, isBigEndian);
        if (TaskUtil.isHeartLog()) {
            LOGGER.info("客户端地址：{},接收报文：{}", ctx.channel().remoteAddress(), NettyUtil.bytesToHexString(bytes));
        } else {
            if (messageType.getType() != CommandType.ZERO.getStatus()) {
                LOGGER.info("客户端地址：{},接收报文：{}", ctx.channel().remoteAddress(), NettyUtil.bytesToHexString(bytes));
            }
        }

        Message message = null;
        switch (messageType) {
            case HEARTBEAT:
                if (CommandType.ONE.getStatus() == Integer.valueOf(version)) {
                    HeartbeatInOut heartbeatInOut = new HeartbeatInOut();
                    heartbeatInOut.decode(in, isBigEndian);
                    message = new Message<HeartbeatInOut>();
                    message.setExtraData(heartbeatInOut);
                } else {
                    NewHeartbeatInOut newHeartbeatInOut = new NewHeartbeatInOut();
                    newHeartbeatInOut.decode(in, isBigEndian);
                    message = new Message<HeartbeatInOut>();
                    message.setExtraData(newHeartbeatInOut);
                }
                break;
            case REQUEST:
                switch (deviceType) {
                    case COOK_SIMPLE_CHINESE_FOOD:
                        CookSimpleChineseFoodIn cookSimpleChineseFoodIn = new CookSimpleChineseFoodIn();
                        cookSimpleChineseFoodIn.decode(in, isBigEndian);
                        message = new Message<CookSimpleChineseFoodIn>();
                        message.setExtraData(cookSimpleChineseFoodIn);
                        break;
                    case COLD_SIMPLE_CHINESE_FOOD:
                        ColdSimpleChineseFoodIn coldSimpleChineseFoodIn = new ColdSimpleChineseFoodIn();
                        coldSimpleChineseFoodIn.decode(in, isBigEndian);

                        message = new Message<ColdSimpleChineseFoodIn>();
                        message.setExtraData(coldSimpleChineseFoodIn);
                        break;
                    case COLD_HOTPOT:
                        ColdHotpotIn coldHotpotIn = new ColdHotpotIn();
                        coldHotpotIn.decode(in, isBigEndian);
                        message = new Message<ColdHotpotIn>();
                        message.setExtraData(coldHotpotIn);
                        break;
                    case TABLE_HOTPOT:
                        TableHotpotIn tableHotpotIn = new TableHotpotIn();
                        tableHotpotIn.decode(in, isBigEndian);
                        message = new Message<TableHotpotIn>();
                        message.setExtraData(tableHotpotIn);
                        break;
                    case BELT_HOTPOT:
                        BeltHotpotIn beltHotpotIn = new BeltHotpotIn();
                        beltHotpotIn.decode(in, isBigEndian);
                        message = new Message<BeltHotpotIn>();
                        message.setExtraData(beltHotpotIn);
                        break;
                    case UPDISH_HOTPOT:
                        UpdishHotpotIn updishHotpotIn = new UpdishHotpotIn();
                        updishHotpotIn.decode(in, isBigEndian);
                        message = new Message<UpdishHotpotIn>();
                        message.setExtraData(updishHotpotIn);
                        break;
                    case CUT_HOTPOT:
                        CutHotpotIn cutHotpotIn = new CutHotpotIn();
                        cutHotpotIn.decode(in, isBigEndian);
                        message = new Message<CutHotpotIn>();
                        message.setExtraData(cutHotpotIn);
                        break;
                    case DRINK_HOTPOT:
                        DrinkHotpotIn drinkHotpotIn = new DrinkHotpotIn();
                        drinkHotpotIn.decode(in, isBigEndian);
                        message = new Message<DrinkHotpotIn>();
                        message.setExtraData(drinkHotpotIn);
                        break;
                    case STEAMER_FAST_FOOD:     //一体化 自助式蒸箱
                        SteamFastFoodIn streamFastFoodIn = new SteamFastFoodIn();
                        streamFastFoodIn.decode(in, isBigEndian);
                        message = new Message<DrinkHotpotIn>();
                        message.setExtraData(streamFastFoodIn);
                        break;
                    //水保温柜
                    case WARM_WATER_FAST_FOOD:
                        BeltStreamSelfWaterFastFoodIn beltStreamSelfWaterFastFoodIn = new BeltStreamSelfWaterFastFoodIn();
                        beltStreamSelfWaterFastFoodIn.decode(in, isBigEndian);
                        message = new Message<BeltStreamSelfWaterFastFoodIn>();
                        message.setExtraData(beltStreamSelfWaterFastFoodIn);
                        break;
                    case COLD_STEAMER_FAST_FOOD:
                        ColdStreamFastFoodIn coldStreamFastFoodIn = new ColdStreamFastFoodIn();
                        coldStreamFastFoodIn.decode(in, isBigEndian);
                        message = new Message<ColdStreamFastFoodIn>();
                        message.setExtraData(coldStreamFastFoodIn);
                        break;
                    case BELT_STEAMER_FAST_FOOD:
                        BeltStreamFastFoodIn beltStreamFastFoodIn = new BeltStreamFastFoodIn();
                        beltStreamFastFoodIn.decode(in, isBigEndian);
                        message = new Message<BeltStreamFastFoodIn>();
                        message.setExtraData(beltStreamFastFoodIn);
                        break;
                    case BELT_STEAMER_SELF_FAST_FOOD:
                        BeltStreamSelfFastFoodIn beltStreamSelfFastFoodIn = new BeltStreamSelfFastFoodIn();
                        beltStreamSelfFastFoodIn.decode(in, isBigEndian);
                        message = new Message<BeltStreamSelfFastFoodIn>();
                        message.setExtraData(beltStreamSelfFastFoodIn);
                        break;
                    case UPDISH_CHINESE_FOOD:
                        UpdishChineseFoodIn updishChineseFoodIn = new UpdishChineseFoodIn();
                        updishChineseFoodIn.decode(in, isBigEndian);
                        message = new Message<UpdishChineseFoodIn>();
                        message.setExtraData(updishChineseFoodIn);
                        break;
                    case COOK_CHINESE_FOOD:
                        CookChineseFoodIn cookChineseFoodIn = new CookChineseFoodIn();
                        cookChineseFoodIn.decode(in, isBigEndian);
                        message = new Message<CookChineseFoodIn>();
                        message.setExtraData(cookChineseFoodIn);
                        break;
                    case COLD_CHINESE_FOOD:
                        ColdChineseFoodIn coldChineseFoodIn = new ColdChineseFoodIn();
                        coldChineseFoodIn.decode(in, isBigEndian);
                        message = new Message<ColdChineseFoodIn>();
                        message.setExtraData(coldChineseFoodIn);
                        break;
                    case STEAMER_CHINESE_FOOD:
                        SteamChineseFoodIn streamChineseFoodIn = new SteamChineseFoodIn();
                        streamChineseFoodIn.decode(in, isBigEndian);
                        message = new Message<SteamChineseFoodIn>();
                        message.setExtraData(streamChineseFoodIn);
                        break;
                    case DOWN_CHINESE_FOOD:
                        DownChineseFoodIn downChineseFoodIn = new DownChineseFoodIn();
                        downChineseFoodIn.decode(in, isBigEndian);
                        message = new Message<DownChineseFoodIn>();
                        message.setExtraData(downChineseFoodIn);
                        break;
                    case CLAYPOT_CHINESE_FOOD:
                        ClaypotChineseFoodIn claypotChineseFoodIn = new ClaypotChineseFoodIn();
                        claypotChineseFoodIn.decode(in, isBigEndian);
                        message = new Message<ClaypotChineseFoodIn>();
                        message.setExtraData(claypotChineseFoodIn);
                        break;
                    default:
                        break;
                }
                break;
            case RESPONSE:
                message = new Message();
                break;
            case HEARTBEAT_RESPONSE:
                message = new Message();
                break;
            case RESULT_RESPONSE:
                RespondMessageIn respondMessageIn = new RespondMessageIn();
                respondMessageIn.decode(in, isBigEndian);
                message = new Message<RespondMessageIn>();
                message.setExtraData(respondMessageIn);
                break;
            case LOGIN:
                message = new Message();
                break;
            case LOGIN_RESPONSE:
                message = new Message();
                break;
            default:
                break;
        }

        if (message != null) {
            message.setHeader(header);
           // message.setDataLength(bytes.length);
            message.setMessageType(messageType);
            message.setUniqueKey(uniqueKey);
            message.setDeviceType(deviceType);
            message.setDeviceId(deviceId);
            out.add(message);
        }
    }

}

package com.bgy.gateway.util;

import com.bgy.gateway.model.dto.belt.BeltStreamSimpleDto;
import com.bgy.gateway.model.dto.claypot.ClaypotSimpleDto;
import com.bgy.gateway.model.dto.steam.SteamSimpleDto;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;

import java.net.SocketAddress;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class NettyUtil {

    public static int readShort(ByteBuf in, boolean isBigEndian) {
        return isBigEndian ? in.readUnsignedShort() : in.readUnsignedShortLE();
    }

    public static int readInt(ByteBuf in, boolean isBigEndian) {
        return isBigEndian ? in.readInt() : in.readIntLE();
    }

    public static long readLong(ByteBuf in, boolean isBigEndian) {
        return isBigEndian ? in.readLong() : in.readLongLE();
    }

    public static List<Integer> readWarningInfo(ByteBuf in, boolean isBigEndian, boolean isWarningInfoRealLong) {
        List<Integer> warningList = new ArrayList<>();

        int length = isWarningInfoRealLong ? 4 : 3;
        for (int i = 0; i < length; i++) {
            warningList.add(readShort(in, isBigEndian));
        }

        return warningList;
    }

    public static void writeShort(ByteBuf out, boolean isBigEndian, int value) {
        if (isBigEndian) {
            out.writeShort(value);
        } else {
            out.writeShortLE(value);
        }
    }

    public static void writeInt(ByteBuf out, boolean isBigEndian, int value) {
        if (isBigEndian) {
            out.writeInt(value);
        } else {
            out.writeIntLE(value);
        }
    }

    public static void writeLong(ByteBuf out, boolean isBigEndian, long value) {
        if (isBigEndian) {
            out.writeLong(value);
        } else {
            out.writeLongLE(value);
        }
    }

    public static void writeBytes(ByteBuf out, boolean isBigEndian, byte[] value) {
        out.writeBytes(value);
    }
    public static String parseChannelRemoteAddr(final Channel channel) {
        if (null == channel) {
            return "";
        }
        SocketAddress remote = channel.remoteAddress();
        final String addr = remote != null ? remote.toString() : "";

        if (addr.length() > 0) {
            int index = addr.lastIndexOf("/");
            if (index >= 0) {
                return addr.substring(index + 1);
            }

            return addr;
        }

        return "";
    }

    /** @deprecated */
    @Deprecated
    public static int nextUniqueKey() {
        return (int)(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli() % Short.MAX_VALUE);
    }

    public static String bytesToHexString(byte[] src){
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }

        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }

        return stringBuilder.toString();
    }

    public static String[] getChannelIpPortArray(Channel channel) {
        String ipPort = channel.remoteAddress().toString().substring(1);
        return ipPort.split(":");
    }


    /**
     *
     * @param in
     * @param isBigEndian
     * @param length  读取的长度
     * @param readOne ture 读一个字   false 读双字
     * @return
     */
    public static List<Integer> readManyInfo(ByteBuf in, boolean isBigEndian,int length,boolean readOne) {
        List<Integer> manyList = new ArrayList<>();
       if(readOne){
           for (int i = 0; i < length; i++) {
               manyList.add(readShort(in, isBigEndian));
           }
       }else{
           for (int i = 0; i < length; i++) {
               manyList.add(readInt(in, isBigEndian));
           }
       }
        return manyList;
    }

    /**
     *
     * @param in
     * @param isBigEndian
     * @param length  读取的长度
     * @return
     */
    public static List<SteamSimpleDto> readObject(ByteBuf in, boolean isBigEndian, int length, boolean readOne) {
        List<SteamSimpleDto> manyList = new ArrayList<>();
        SteamSimpleDto streamDto;
        if(readOne){
            for (int i = 0; i < length; i++) {
                streamDto = new SteamSimpleDto();
                streamDto.setLayer(readShort(in, isBigEndian));
                streamDto.setMode(readShort(in, isBigEndian));
                streamDto.setCookState(readShort(in, isBigEndian));
                streamDto.setDoorState(readShort(in, isBigEndian));
                manyList.add(streamDto);
            }
        }else{
            for (int i = 0; i < length; i++) {
                streamDto = new SteamSimpleDto();
                streamDto.setLayer(readShort(in, isBigEndian));
                streamDto.setMode(readShort(in, isBigEndian));
                streamDto.setCookState(readShort(in, isBigEndian));
                manyList.add(streamDto);
            }
        }
        return manyList;
    }


    /**
     *
     * @param in
     * @param isBigEndian
     * @param length  读取的长度
     * @param readOne ture 读一个字   false 读双字
     * @return
     */
    public static List readObjectForBelt(ByteBuf in, boolean isBigEndian, int length, boolean readOne) {

        List<BeltStreamSimpleDto> manyList = new ArrayList<>();
            BeltStreamSimpleDto beltStreamSimpleDto = new BeltStreamSimpleDto();
            /*if(readOne){
                manyList.forEach(BeltStreamSimpleDto -> {
                    beltStreamSimpleDto.setPlateId(NettyUtil.readShort(in, isBigEndian));
                    beltStreamSimpleDto.setTakeNum(NettyUtil.readShort(in, isBigEndian));
                    beltStreamSimpleDto.setTakerState(NettyUtil.readShort(in, isBigEndian));
                    manyList.add(beltStreamSimpleDto);
                });
            }*/
        for (int i = 0; i < length; i++) {
            beltStreamSimpleDto.setPlateId(NettyUtil.readShort(in, isBigEndian));
            beltStreamSimpleDto.setTakerId(NettyUtil.readShort(in, isBigEndian));
            beltStreamSimpleDto.setTakerState(NettyUtil.readShort(in, isBigEndian));
            manyList.add(beltStreamSimpleDto);
        }
            return manyList;
    }

    /**
     *
     * @param in
     * @param isBigEndian
     * @param length  读取的长度
     * @param readOne ture 读一个字   false 读双字
     * @return
     */
    public static List readObjectForClaypot(ByteBuf in, boolean isBigEndian, int length, boolean readOne) {

        List<ClaypotSimpleDto> manyList = new ArrayList<>();
        for (int i = 1; i <= length; i++) {
            ClaypotSimpleDto claypotSimpleDto = new ClaypotSimpleDto();
            claypotSimpleDto.setId(NettyUtil.readShort(in, isBigEndian));
            claypotSimpleDto.setState(NettyUtil.readShort(in, isBigEndian));
            claypotSimpleDto.setError(NettyUtil.readShort(in, isBigEndian));
            claypotSimpleDto.setType(NettyUtil.readShort(in, isBigEndian));
            claypotSimpleDto.setDishId(NettyUtil.readInt(in, isBigEndian));
            claypotSimpleDto.setFinish(NettyUtil.readShort(in, isBigEndian));
            manyList.add(claypotSimpleDto);
        }
        return manyList;
    }
}

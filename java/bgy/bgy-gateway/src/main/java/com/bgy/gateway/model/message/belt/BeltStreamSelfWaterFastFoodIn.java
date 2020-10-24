package com.bgy.gateway.model.message.belt;

import com.bgy.gateway.config.SystemConfig;
import com.bgy.gateway.enums.CommandType;
import com.bgy.gateway.model.message.RequestMessageIn;
import com.bgy.gateway.util.NettyUtil;
import io.netty.buffer.ByteBuf;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 自助式蒸箱主控设备
 *
 * @author lzx
 * @date 2020/3/19.
 */
@Data
@NoArgsConstructor
public class BeltStreamSelfWaterFastFoodIn extends RequestMessageIn {
    /**
     * 报警信息
     */
    private List<Integer> errorList;
    /**
     * 经出料类型（1 精料 2出料）
     */
    private int type;
    /**
     * 列数
     */
    private int row;
    /**
     * 数量
     */
    private int num;

    @Override
    public void decode(ByteBuf in, boolean isBigEndian) {
        super.decode(in, isBigEndian);
        if (this.getRequest() == CommandType.ONE.getStatus()) {
            // 长度4个字
            errorList = NettyUtil.readWarningInfo(in, isBigEndian, SystemConfig.IS_WARNING_INFO_REAL_LONG);
        }
        if (this.getRequest() == CommandType.TWO.getStatus()) {
            type = NettyUtil.readShort(in, isBigEndian);
            row = NettyUtil.readShort(in, isBigEndian);
            num = NettyUtil.readShort(in, isBigEndian);
        }
    }
}

package com.bgy.gateway.model.message.belt;

import com.bgy.gateway.config.SystemConfig;
import com.bgy.gateway.enums.CommandType;
import com.bgy.gateway.model.message.RequestMessageIn;
import com.bgy.gateway.util.NettyUtil;
import io.netty.buffer.ByteBuf;

import java.util.List;

/**
 * 自助式蒸箱主控设备
 *
 * @author lzx
 * @date 2020/3/19.
 */
public class BeltStreamSelfFastFoodIn extends RequestMessageIn {
    /**
     * 报警信息
     */
    private List<Integer> errorList;

    public BeltStreamSelfFastFoodIn() {
    }

    @Override
    public void decode(ByteBuf in, boolean isBigEndian) {
        super.decode(in, isBigEndian);
        if (this.getRequest() == CommandType.ONE.getStatus()) {
            // 长度4个字
            errorList = NettyUtil.readWarningInfo(in, isBigEndian, SystemConfig.IS_WARNING_INFO_REAL_LONG);
        }

    }

    public List<Integer> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<Integer> errorList) {
        this.errorList = errorList;
    }
}

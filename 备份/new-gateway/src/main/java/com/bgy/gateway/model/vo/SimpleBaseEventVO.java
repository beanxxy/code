package com.bgy.gateway.model.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author caijunwei
 * date 2020/12/3 10:33
 */
@Setter
@Getter
public class SimpleBaseEventVO extends BaseEvent {
    @Override
    public void action(BasePlcDataModelVO plcDataModelVo, String address, String value) {

    }
}

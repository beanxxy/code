package com.bgy.gateway.model.vo;

import com.alibaba.fastjson.TypeReference;
import com.bgy.gateway.model.dto.ExternalBaseReq;
import com.bgy.gateway.model.dto.ExternalHttpResp;
import com.bgy.gateway.service.HttpService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author caijunwei
 * date 2020/12/2 10:51
 */
@Slf4j
@Getter
@Setter
public class PlcDataModelVO extends BasePlcDataModelVO{

    @Autowired
    HttpService httpService;

    /**
     *Plc 类似状态上报值
     * @param name   参数名称
     * @param dataAddress  参数地址
     * @param value   参数值
     */
    @Override
    public void change(String name,String dataAddress, String value) {
        ExternalBaseReq req = new ExternalBaseReq();
        req.setDataAddress(dataAddress);
        req.setName(name);
        req.setValue(value);
        ExternalHttpResp<Void> execute = httpService.execute(req, new TypeReference<ExternalHttpResp<Void>>() {
        }, "/engine/response");
        if(execute.isSuccess()){
            log.info("回调成功，参数code:{},data:{}",execute.getCode(),execute.getData());
        }else{
            log.info("回调失败，参数code:{},data:{}",execute.getCode(),execute.getData());
        }
        //this.getAttr().get()

    }

}

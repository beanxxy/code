package com.bgy.gateway.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author caijunwei
 * date 2020/12/9 10:39
 */

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BasicInfo {

   private List<PlcInfo> Plc;

   private List<ComponentInfo>  PlcComponent;

   private  List<ConfigVersionInfo> PlcConfigVersion;

   private  List<DataModelInfo>  PlcDataModel;

   private  List<FunctionInfo> PlcFunction;

   private  List<PlcAlarmInfo> PlcAlarm;

   private  List<MonitorInfo> PlcMonitor;

  }

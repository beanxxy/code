package com.iot.gateway.cfg.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.iot.gateway.cfg.model.cfg_Alarm;

public interface AlarmMapper {
	@Select("select * from gw_cfg_alarm where state=1")
	public List<cfg_Alarm> getList();
	
	@Select("select * from gw_cfg_alarm where state=1 and config =#{config};")
	public List<cfg_Alarm> getListByConfig(@Param("config")String config);
}

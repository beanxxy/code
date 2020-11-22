package com.iot.gateway.cfg.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.iot.gateway.cfg.model.cfg_Dev;

public interface DevMapper {
	@Select("select * from gw_cfg_dev where state=1")
	public List<cfg_Dev> getList(); 
	
	@Select("select * from gw_cfg_dev where state=1 and devtype=#{devtype}")
	public List<cfg_Dev> getListByType(@Param("devtype")String devtype);
	 
	@Select("select * from gw_cfg_dev where state=1 and devid=#{devid}")
	public List<cfg_Dev> getListByDevid(@Param("devid")String devid);
}

package com.iot.gateway.cfg.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.iot.gateway.cfg.model.cfg_Function;
 
public interface FunctionMapper {
	@Select("select * from gw_cfg_function where state=1")
	public List<cfg_Function> getList();
	
	@Select("select * from gw_cfg_function where state=1 and config =#{config};")
	public List<cfg_Function> getListByConfig(@Param("config")String config);
}

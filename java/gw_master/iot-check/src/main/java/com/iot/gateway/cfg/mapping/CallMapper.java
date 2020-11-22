package com.iot.gateway.cfg.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.iot.gateway.cfg.model.cfg_Call;


public interface CallMapper {
	@Select("select * from gw_cfg_call where state=1")
	public List<cfg_Call> getList();
	@Select("select * from gw_cfg_call where state=1 and config =#{config};")
	public List<cfg_Call> getListByConfig(@Param("config")String config);
}

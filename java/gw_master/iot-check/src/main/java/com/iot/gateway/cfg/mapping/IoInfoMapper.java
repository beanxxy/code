package com.iot.gateway.cfg.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.iot.gateway.cfg.model.cfg_IoInfo;


public interface IoInfoMapper {
	@Select("select * from gw_cfg_ioinfo where state=1;")
	public List<cfg_IoInfo> getList();
	
	@Select("select * from gw_cfg_ioinfo where state=1 and config =#{config};")
	public List<cfg_IoInfo> getListByConfig(@Param("config")String config);
}

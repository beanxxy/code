package com.iot.gateway.cfg.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.iot.gateway.cfg.model.cfg_DataModel;


public interface DataModelMapper {
	@Select("select * from gw_cfg_datamodel where state=1")
	public List<cfg_DataModel> getList();
	
 }

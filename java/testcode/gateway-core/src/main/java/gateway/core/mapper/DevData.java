package gateway.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import gateway.core.config.DataModel;

public interface DevData {
	@Select("select * from gw_datamodel")
	public List<DataModel> getModel();
}

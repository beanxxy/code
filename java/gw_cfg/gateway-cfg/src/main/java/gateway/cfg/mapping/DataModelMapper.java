package gateway.cfg.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import gateway.cfg.model.cfg_DataModel;
 
public interface DataModelMapper {
	@Select("select * from gw_cfg_dataModel where state=1")
	public List<cfg_DataModel> getList();
}

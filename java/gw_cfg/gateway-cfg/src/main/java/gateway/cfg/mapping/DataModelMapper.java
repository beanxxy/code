package gateway.cfg.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import gateway.cfg.model.DataModel;
 
public interface DataModelMapper {
	@Select("select * from gw_cfg_dataModel where state=1")
	public List<DataModel> getList();
}

package gateway.cfg.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import gateway.cfg.model.cfg_Dev;
 
public interface DevMapper {
	@Select("select * from gw_cfg_dev where state=1")
	public List<cfg_Dev> getList();
}

package gateway.cfg.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import gateway.cfg.model.Function;

public interface FunctionMapper {
	@Select("select * from gw_cfg_function where state=1")
	public List<Function> getList();
}

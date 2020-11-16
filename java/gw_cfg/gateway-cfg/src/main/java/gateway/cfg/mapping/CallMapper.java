package gateway.cfg.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import gateway.cfg.model.Call;

public interface CallMapper {
	@Select("select * from gw_cfg_call where state=1")
	public List<Call> getList();
}

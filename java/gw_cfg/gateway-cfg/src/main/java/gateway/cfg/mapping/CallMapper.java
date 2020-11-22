package gateway.cfg.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import gateway.cfg.model.cfg_Call;

public interface CallMapper {
	@Select("select * from gw_cfg_call where state=1")
	public List<cfg_Call> getList();
}

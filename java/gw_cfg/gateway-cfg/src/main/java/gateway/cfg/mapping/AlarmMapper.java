package gateway.cfg.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import gateway.cfg.model.Alarm;

public interface AlarmMapper {
	@Select("select * from gw_cfg_alarm where state=1")
	public List<Alarm> getList();
}

package gateway.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import gateway.core.config.Alert;

public interface AlertData {
	@Select("select * from gw_alert where state=1")
	public List<Alert> getList();
}

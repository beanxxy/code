package gateway.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import gateway.core.config.Alert;

public interface AlertData {
	@Select("select * from alert")
	public List<Alert> getList();
}

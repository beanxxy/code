package gateway.cfg.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import gateway.cfg.model.cfg_IoInfo;


 

public interface IoInfoMapper {
	@Select("select * from gw_cfg_ioInfo where state=1")
	public List<cfg_IoInfo> getList();
}

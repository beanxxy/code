package gateway.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import gateway.core.config.Ioinfo;

public interface IoinfoMapper {
	@Select("select * from gw_Ioinfo where state=1")
	public List<Ioinfo> getList();
}

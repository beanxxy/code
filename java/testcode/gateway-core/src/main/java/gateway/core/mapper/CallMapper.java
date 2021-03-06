package gateway.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import gateway.core.config.Call;

public interface CallMapper {
	@Select("select * from gw_call where state = 1 and code = #{code}")
	public List<Call> getList(@Param("code")String code);
}

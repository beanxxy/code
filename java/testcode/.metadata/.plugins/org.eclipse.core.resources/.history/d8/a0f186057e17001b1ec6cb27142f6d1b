package gateway.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import gateway.core.config.Function; 

public interface FunctionMapper {
	@Select("select * from gw_function where state=1")
	public List<Function> getList();
	
	@Select("select * from gw_function where deviceId = #{deviceId} and code = #{code} and devtype = #{type} and state=1")
	public List<Function> getAddrFun(
		@Param("deviceId") String deviceId,
		@Param("type") String type,
		@Param("code") String code); 
	
	@Select("select * from gw_function where code = #{code} and devtype = #{type} and state=1")
	public List<Function> getAddrFunByType(
		@Param("type") String type,
		@Param("code") String code); 
}

package waste;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface  DevAddress {

	@Select("select * from addressconfig where state = 1 and type = 1")
	public List<AddressConfig> getAddrDB();  
	
	@Select("select * from addressconfig where deviceId = #{deviceId} and type = #{type}")
	public List<AddressConfig> getAddrFun(@Param("deviceId") int deviceId,@Param("type") int type); 
	
	@Select("select * from addressconfig where  type = #{type}")
	public List<AddressConfig> getAddrFunAll(@Param("type") int type); 
}

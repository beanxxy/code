package gateway.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import gateway.core.config.ServerConfig;

public interface DevServer {
	@Select("select * from gw_serverconfig where state=1")
	public List<ServerConfig> getServer(); 
}

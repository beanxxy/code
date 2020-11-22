import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;
import com.iot.gateway.cfg.mapping.DevMapper;
import com.iot.gateway.cfg.mapping.IoInfoMapper;
import com.iot.gateway.cfg.model.cfg_IoInfo;
import com.iot.gateway.cfg.mybatis.MySql;
import com.iot.gateway.core.Client;
import com.iot.gateway.core.imp.ClientTcp;

public class Star {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gson gs 			= new Gson();
		SqlSession session	= MySql.getSqlSession();
		IoInfoMapper ioinfo = session.getMapper(IoInfoMapper.class);
		String str = "1#上菜口";
		List<cfg_IoInfo> infos  = ioinfo.getListByConfig("1#上菜口");
		//List<cfg_IoInfo> infos  = ioinfo.getList();
	
		
		//Client ct 		= new ClientTcp();  
	}

}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;

import gateway.core.config.Ioinfo;
import gateway.core.mapper.IoinfoMapper;
import gateway.core.mybatis.MySql;
import gateway.core.util.Tool;

public class mqData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SqlSession session = MySql.getSqlSession();
		IoinfoMapper ioinfoMapper = session.getMapper(IoinfoMapper.class);
		List<Ioinfo> ios = ioinfoMapper.getList();
		Gson gson = new Gson();
		//System.out.println(gs.toJson(ios));
		 
		Map<String,Object> outmap 	= new HashMap<String,Object>();
		Map<String,Map> heads 		= new HashMap<String,Map>();
		Map<String,List<Map>> point = new HashMap<String,List<Map>>(); 
		for(Ioinfo ifo : ios) { 
			Map<String,String> head = new HashMap<String,String>();
			Map<String,String> em = new HashMap<String,String>();
			List<Map> ls = point.get(ifo.deviceid);
			if(ls==null) {
				ls = new ArrayList<Map>();
			}
			em.put("parentName", ifo.parentName);
			em.put("estimateName", ifo.estimateName);
			em.put("estimateValue", "0");
			ls.add(em);
			point.put(ifo.deviceid, ls); 
			head.put("storeId", "");
			head.put("id", ifo.deviceid);
			head.put("name", ifo.parentName);
			head.put("partId", Tool.StringToId(ifo.parentName+ifo.deviceid).substring(32));
			//head.put("storeId", ""); 
			heads.put(ifo.deviceid, head);
		}
		
		for(String str : heads.keySet()) {
			outmap.put("storeId", "");
			outmap.put("id", heads.get(str).get("id"));
			outmap.put("name", heads.get(str).get("name"));
			outmap.put("partId", heads.get(str).get("partId"));
			outmap.put("devicePartCheckPoint", point.get(str));
		    String outstr = gson.toJson(outmap);
		    System.out.println(outstr);
		   // mqtt.sendMessage("devicePartCheckPoint", outstr);
		}
		
		
	}

}

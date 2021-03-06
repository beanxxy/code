package waste;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;

import gateway.core.config.Call;
import gateway.core.mapper.CallMapper;
import gateway.core.mybatis.MySql;

public class Sql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SqlSession session 			  = MySql.getSqlSession();
		CallMapper cm = session.getMapper(CallMapper.class);
		List<Call> ls = cm.getList();
		Gson gs = new Gson();
		for(Call cal : ls) {
			System.out.println(gs.toJson(cal));
		}
		session.close();
	}

}

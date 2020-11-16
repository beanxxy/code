package test;

import java.util.List;

import com.google.gson.Gson;

import gateway.cfg.mapping.AlarmMapper;
import gateway.cfg.mapping.CallMapper;
import gateway.cfg.mapping.DataModelMapper;
import gateway.cfg.mapping.DevMapper;
import gateway.cfg.mapping.FunctionMapper;
import gateway.cfg.mapping.IoInfoMapper;
import gateway.cfg.model.Alarm;
import gateway.cfg.model.Call;
import gateway.cfg.model.DataModel;
import gateway.cfg.model.Dev;
import gateway.cfg.model.Function;
import gateway.cfg.model.IoInfo;
import gateway.cfg.mybatis.MySql;

public class Test {
	public static void main(String[] arg) {
		AlarmMapper alarmMapper = MySql.getSqlSession().getMapper(AlarmMapper.class);
		CallMapper callMapper = MySql.getSqlSession().getMapper(CallMapper.class);
		DataModelMapper dataModelMapper = MySql.getSqlSession().getMapper(DataModelMapper.class);
		DevMapper devMapper = MySql.getSqlSession().getMapper(DevMapper.class);
		FunctionMapper functionMapper = MySql.getSqlSession().getMapper(FunctionMapper.class);
		IoInfoMapper ioInfoMapper = MySql.getSqlSession().getMapper(IoInfoMapper.class);
		
		
		List<Alarm> alarms = alarmMapper.getList();
		List<Call> calls = callMapper.getList();
		List<DataModel> dms = dataModelMapper.getList();
		List<Dev> des = devMapper.getList();
		List<Function> fun = functionMapper.getList();
		List<IoInfo> io = ioInfoMapper.getList();
		
		Gson gs = new Gson();
		System.out.println(gs.toJson(alarms));
		System.out.println(gs.toJson(calls));
		System.out.println(gs.toJson(dms));
		System.out.println(gs.toJson(des));
		System.out.println(gs.toJson(fun));
		System.out.println(gs.toJson(io)); 
		
	}
}

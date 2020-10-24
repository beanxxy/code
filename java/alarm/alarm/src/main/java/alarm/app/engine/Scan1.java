package alarm.app.engine;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Scan1 {
	public void test() throws ParseException {
		try {
			Con1 cn 	= 	new Con1();
			String 	sql;
			//多少分钟报一次
			int minute = 5;
			sql 		= 	"SELECT * FROM rule where state ='启动1' AND (nexttime < date_sub(now(),INTERVAL "+minute
							+ " minute) OR nexttime IS NULL) "; 
			ResultSet rs = cn.getStmt().executeQuery(sql); 
			while(rs.next()){
				Con1 c 			= new Con1();
				Con2 c2 		= new Con2();
				String str 		= "";
				//c2.getStmt().executeQuery(""); 
                // 通过字段检索
                int id  		 = rs.getInt("id");
                String sqlstr  	 = rs.getString("sql");
                String dep 		 = rs.getString("dep");
                String msg 		 = rs.getString("msg");
                String name 	 = rs.getString("name");
                String nexttime  = rs.getString("nexttime");
                String alarmtime = rs.getString("alarmtime");
                long 	   range= 300;
                long min 		= 100;
                if(nexttime != null && nexttime.length() != 0) {
                	SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                	Date begin 	= dfs.parse(nexttime);
                	Date end 	= new Date();//现在系统当前时间 
                	long between = (end.getTime() - begin.getTime()) ;
                	long l = (end.getTime() - begin.getTime())  ;
                	long day = l / (24 * 60 * 60 * 1000);
                	long hour = (l / (60 * 60 * 1000) - day * 24);
                    min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
                    long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
                	range = s + 1 ;
                }
                //System.out.println(min);
                /*if(min < 30) {
                	continue;
                }*/
                //if(hour < )
                //String max = rs.getString("maxvalue");
                //String min = rs.getString("minvalue");
                //String url = rs.getString("password"); 
                // 输出数据 
                ///System.out.print("ID: " + id);
                //System.out.println(nexttime+", 站点名称: " + sqlstr+ " AND MeasureTime > date_sub(now(),INTERVAL " +range+ " SECOND)  LIMIT 1");
                String bj 		= "";
                ResultSet rs1 	= c2.getStmt().executeQuery(sqlstr + " AND MeasureTime > date_sub(now(),INTERVAL " +range+ " SECOND)  LIMIT 1"); 
                while(rs1.next()) {
                	 String MeasureValue = rs1.getString("MeasureValue");
                	 str 				 = "" + MeasureValue; 
                	 bj 				 = " ,alarmtime='"+new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss").format(new Date())+"'";//记录报警时间
                	 Con1 cc 			 = new Con1();
                	 ResultSet rrr 		 = cc.getStmt().executeQuery("SELECT * FROM addr WHERE dep = '"+dep+"'"); 
                	 while(rrr.next()) {
                		 String phone = rrr.getString("phone");
                		// SendMsg.set(phone, name, msg, MeasureValue);
                	 }
                	 // 
                } 
                c.getStmt().executeUpdate("update `rule` set nexttime='"+new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss").format(new Date())+"'"+bj+ " where id="+id);
                ///System.out.print(", 站点 URL: " + url);
                //System.out.print("\n");
                c.close();
                c2.close();
            } 
			rs.close();
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

/*if(max != null && max.length() > 0 && MeasureValue !=null && MeasureValue.length() > 0) {
double dmax = Double.parseDouble(max);
double dvalue = Double.parseDouble(MeasureValue);
if(dmax <= dvalue) {
	 bj = " ,alarmtime='"+new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss").format(new Date())+"'";//记录报警时间；
}
}
if(min != null && min.length() > 0 && MeasureValue !=null && MeasureValue.length() > 0) {
double dmin = Double.parseDouble(min);
double dvalue = Double.parseDouble(MeasureValue);
if(dmin >= dvalue) {
	 bj = " ,alarmtime='"+new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss").format(new Date())+"'";//记录报警时间；
}
}*/

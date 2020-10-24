package alarm.app.engine;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Scan extends Thread{
	public void run() {
		Con1 cn 		= 	new Con1();  
		ResultSet rs 	=   null;
		String 	sql;
		//多少分钟报一次
		int minute = 30;
		sql 		= 	"SELECT * FROM rule where state ='启动' AND (alarmtime < date_sub(now(),INTERVAL "+minute
						+ " minute) OR alarmtime IS NULL) "; 
		try {
			rs = cn.getStmt().executeQuery(sql); 
			String bj 		= "";
			
			while(rs.next()){
				int id  		 = rs.getInt("id");
	            String sqlstr  	 = rs.getString("sql");
	            String dep 		 = rs.getString("dep");
	            String msg 		 = rs.getString("msg");
	            String name 	 = rs.getString("name");
	            
	            String nexttime  = rs.getString("nexttime");
	            String alarmtime = rs.getString("alarmtime");
	            
	            String maxvalue  = rs.getString("maxvalue");
	            String minvalue  = rs.getString("minvalue");
	            
	            String sign  	 = rs.getString("sign");
	            String model  	 = rs.getString("model");
	            
	            String value	= new Sql().Test(sqlstr);
	            bj				= "";
	            if(value.length() != 0) {
	            	float max	=	(float) (maxvalue.length()==0 ? 9999.999	:Float.parseFloat(maxvalue));
	 	            float min	=	(float) (minvalue.length()==0 ? -9999.999	:Float.parseFloat(minvalue));
	 	            float val	=	(float) (value.length()==0 ? 0:Float.parseFloat(value)); 
	 	            if(val < min || max < val) { //报警 
	 	            	 //System.out.println(val+" , "+max+" , "+min);
	 	            	 bj = " ,alarmtime='"+new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss").format(new Date())+"'";//记录报警时间 
	 	            	 Con1 cc 			 = new Con1(); 
	 	            	 ResultSet rrr 		 = cc.getStmt().executeQuery("SELECT * FROM addr WHERE dep = '"+dep+"'"); 
	                	 
	 	            	String phone = "";
	 	            	 while(rrr.next()) {
	 	            		 if(phone.length() != 0) {
	 	            			phone += ",";
	 	            		 }
	 	            		 String tmp = rrr.getString("phone").trim();
	 	            		 if(tmp.length() > 0) {
	 	            			phone += tmp;
	 	            		 } 
	                		 //SendMsg.set(phone, name, msg, value,model);
	                	 }  
	 	            	 SendMsg.set(phone, name, msg, value,model,new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss").format(new Date()));
	                	 rrr.close();
	                	 cc.close();  
	 	            }
	            }
	            Con1 cn1 	= 	new Con1();
	            cn1.getStmt().executeUpdate("update `rule` set nexttime='"+new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss").format(new Date())+"'"+ ",standard='"+value+"' "+bj+ " where id="+id);
	            cn1.close();
	            //System.out.println(sqlstr);
			} 
			
			rs.close();
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			try {
				if(rs!=null)rs.close();
				if(cn!=null)cn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
			
		} 
		
		
	}
}

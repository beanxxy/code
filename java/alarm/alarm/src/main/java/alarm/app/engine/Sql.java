package alarm.app.engine;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Sql {
	public String Test(String sql) {
		String valustr = ""; 
		Con2 cn 	   =   null;
		ResultSet rs   =   null;
		try {
			cn		   = 	new Con2();
			rs 		   = cn.getStmt().executeQuery(sql);
			
			while(rs.next()) {
				valustr = rs.getString("MeasureValue");
				//System.out.println("xxx:"+valustr+"x");
			} 
			rs.close();
			cn.close();
		} catch (SQLException e) {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
			} 
			if(cn!=null)cn.close();
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} 
		
		return valustr;
	}
}

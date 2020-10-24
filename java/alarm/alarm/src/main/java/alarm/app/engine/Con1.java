package alarm.app.engine;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Con1 {
	   // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/alarm?characterEncoding=UTF-8";
 
    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    //static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    //static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false&serverTimezone=UTC"; 
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "123456";
    Connection conn = null;
    Statement stmt = null;
    public Statement getStmt() {
    	return stmt;
    }
    public void close() { 
        try {
			 stmt.close();
			 conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
       
    }
    public Con1() {
    	try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
        
            // 打开链接
            //System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // 执行查询
            //System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
           // String sql;
           // sql = "SELECT * FROM rule ";
           // ResultSet rs = stmt.executeQuery(sql);
             
            // 展开结果集数据库
           /* while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String name = rs.getString("sql");
                //String url = rs.getString("password");
                stmt.executeUpdate("update `rule` set nexttime='"+new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss").format(new Date())+"'"
                		+ "where id="+id);
                // 输出数据
                System.out.print("ID: " + id);
                System.out.print(", 站点名称: " + name);
                ///System.out.print(", 站点 URL: " + url);
                System.out.print("\n");
            }*/
            // 完成后关闭
            //rs.close();
            //stmt.close();
            //conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        } 
        //System.out.println("Goodbye!");
    
    }
   
        
}

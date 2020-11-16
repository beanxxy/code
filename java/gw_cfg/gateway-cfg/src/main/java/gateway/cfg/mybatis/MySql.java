package gateway.cfg.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MySql {
	public static SqlSession session;
	public static SqlSessionFactory factory;
	public static String resource = "mybatis-config.xml";
	public static SqlSession getSqlSession() {
		try {  
			InputStream inputStream  = Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			factory = builder.build(inputStream);
			session = factory.openSession(true);
			return session;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
}

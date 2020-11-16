package com.snimay.hibernate;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**   
 * 数据库操作配置
 * @title      : HibernateConfig.java
 * @package    : com.snimay.hibernate
 * @author     : xxy
 * @date       : 2018年8月7日 上午10:40:06
 * @version    : V1.0   
 */
@Configuration
@Scope("prototype")
public class HibernateConfig {
    
	/*@Autowired
	private SessionFactory sessionFactory;*/
    /**
     * 会话工厂
     * @author     : xxy
     * @param emf
     * @return
     * @throws
     */
    @Bean
    public SessionFactory sessionFactory(@Qualifier("entityManagerFactory") EntityManagerFactory emf){
    //	System.out.println("=================EEEEEEEEEEEEEEEEEE===========");
        return emf.unwrap(SessionFactory.class);
    }
    
    /*@Bean
    public ModelService modelService(){
         return new ModelService();
    } */
}

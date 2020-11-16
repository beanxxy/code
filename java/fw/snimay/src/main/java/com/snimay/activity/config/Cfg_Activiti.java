package com.snimay.activity.config;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.activiti.engine.DynamicBpmnService;
import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
 
/**   
 * 中activiti工作流配置 
 * @title      : Cfg_Activiti.java
 * @package    : com.snimay.activiti.config
 * @author     : xxy
 * @date       : 2018年4月27日 上午11:54:59
 * @version    : V1.0   
 */
@Configuration
public class Cfg_Activiti {
    /**
     * 流程配置，与spring整合采用SpringProcessEngineConfiguration这个实现
     * @author     : xxy
     * @param dataSource
     * @param transactionManager
     * @return
     * @throws
     */
    @Bean
    public ProcessEngineConfiguration processEngineConfiguration(DataSource dataSource, PlatformTransactionManager transactionManager){
        SpringProcessEngineConfiguration processEngineConfiguration = new SpringProcessEngineConfiguration();
       
     //   System.out.println("+++++++++++++++++++++++++++++++++++++"+processEngineConfiguration.getDatabaseSchema());
      
        processEngineConfiguration.setDataSource(dataSource);
        // processEngineConfiguration.setDatabaseSchemaUpdate("drop_create");
        processEngineConfiguration.setDatabaseSchemaUpdate("true");
        
        processEngineConfiguration.setJobExecutorActivate(false);
       // processEngineConfiguration.setTransactionManager(transactionManager);
        
        
        processEngineConfiguration.setDatabaseType("mysql");
        processEngineConfiguration.setDatabaseSchema("sample1");//数据库表名
     //   processEngineConfiguration.setDatabaseType("oracle");
      //  processEngineConfiguration.setDatabaseSchema("ACTIVITI");
        processEngineConfiguration.setTransactionManager(transactionManager);
 
        
        //开启定时任务
        processEngineConfiguration.setJobExecutorActivate(true);
        
        processEngineConfiguration.setMailServerHost("smtp.163.com");
        processEngineConfiguration.setMailServerPort(25);
        processEngineConfiguration.setMailServerDefaultFrom("m13553666941_2@163.com");
        
        processEngineConfiguration.setMailServerUsername("m13553666941_2@163.com");
        processEngineConfiguration.setMailServerPassword("******");//邮箱密码
        
        org.activiti.engine.impl.rules.RulesDeployer r = new org.activiti.engine.impl.rules.RulesDeployer();
        List ls = new ArrayList();
        ls.add(r);
        processEngineConfiguration.setCustomPostDeployers(ls);
        //流程图字体
        processEngineConfiguration.setActivityFontName("宋体");
        processEngineConfiguration.setAnnotationFontName("宋体");
        processEngineConfiguration.setLabelFontName("宋体");

        return processEngineConfiguration;
    }
    /**
     * : 流程引擎，与spring整合使用factoryBean
     * @author     : xxy
     * @param processEngineConfiguration
     * @return
     * @throws
     */
    @Bean
    public ProcessEngineFactoryBean processEngine(ProcessEngineConfiguration processEngineConfiguration){
        ProcessEngineFactoryBean processEngineFactoryBean = new ProcessEngineFactoryBean();
        processEngineFactoryBean.setProcessEngineConfiguration((ProcessEngineConfigurationImpl) processEngineConfiguration);
        return processEngineFactoryBean;
    }

    /**
     * 流程历史记录
     * @author     : xxy
     * @param processEngine
     * @return
     * @throws
     */
    @Bean
    public RepositoryService repositoryService(ProcessEngine processEngine){
        return processEngine.getRepositoryService();
    }

    /**
     * 流程执行
     * @author     : xxy
     * @param processEngine
     * @return
     * @throws
     */
    @Bean
    public RuntimeService runtimeService(ProcessEngine processEngine){
        return processEngine.getRuntimeService();
    }

    /**
     * 流程任务
     * @author     : xxy
     * @param processEngine
     * @return
     * @throws
     */
    @Bean
    public TaskService taskService(ProcessEngine processEngine){
        return processEngine.getTaskService();
    }

    /**
     * 历史记录服务
     * @author     : xxy
     * @param processEngine
     * @return
     * @throws
     */
    @Bean
    public HistoryService historyService(ProcessEngine processEngine){
        return processEngine.getHistoryService();
    }

    /**
     * 流程表单服务
     * @author     : xxy
     * @param processEngine
     * @return
     * @throws
     */
    @Bean
    public FormService formService(ProcessEngine processEngine){
        return processEngine.getFormService();
    }

    /**
     * 身份管理和认证，其功能依托于
     * @author     : xxy
     * @param processEngine
     * @return
     * @throws
     */
    @Bean
    public IdentityService identityService(ProcessEngine processEngine){
        return processEngine.getIdentityService();
    }

    /**
     * 提供对activiti数据库的直接访问
     * @author     : xxy
     * @param processEngine
     * @return
     * @throws
     */
    @Bean
    public ManagementService managementService(ProcessEngine processEngine){
        return processEngine.getManagementService();
    }

    /**
     * 动态流程服务
     * @author     : xxy
     * @param processEngine
     * @return
     * @throws
     */
    @Bean
    public DynamicBpmnService dynamicBpmnService(ProcessEngine processEngine){
        return processEngine.getDynamicBpmnService();
    }

    //八大接口 end
}

package com.snimay.app.process.listener;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.delegate.Expression;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**   
 * 流程监听类，用户规则调度 
 * @title      : MyExecutionListener.java
 * @package    : com.snimay.app.process.listener
 * @author     : xxy
 * @date       : 2018年8月7日 上午9:44:01
 * @version    : V1.0   
 */
public class MyExecutionListener implements ExecutionListener {  
	 private Expression fieldName;
	 static WebClient webClient = new WebClient(BrowserVersion.CHROME); //创建一个webclient       
	 static HtmlPage page;
	 static {
		 webClient.getOptions().setJavaScriptEnabled(true); // 启动JS            
		 webClient.getOptions().setUseInsecureSSL(true);//忽略ssl认证              
		 webClient.getOptions().setCssEnabled(false);//禁用Css，可避免自动二次请求CSS进行渲染              
		 webClient.getOptions().setThrowExceptionOnScriptError(false);//运行错误时，不抛出异常            
		 webClient.setAjaxController(new NicelyResynchronizingAjaxController());// 设置Ajax异步  
		 try {
			 page=webClient.getPage("http://localhost:9090//import.html");
		 } catch (FailingHttpStatusCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 } catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		 webClient.waitForBackgroundJavaScript(10000); 
	 } 
	/**
	 * : TODO 
	 * @author     : xxy
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public void notify(DelegateExecution execution) throws Exception {
		String eventName = execution.getEventName(); 
		String rule	=	fieldName.getExpressionText();
		List<String> ls = new ArrayList<String>();
		ls.add(execution.getId());
		ls.add(execution.getCurrentActivityId());
		ls.add(execution.getParentId());
		ls.add(execution.getProcessDefinitionId());
		ls.add(execution.getProcessInstanceId());
		ls.add(execution.getSuperExecutionId());
		ls.add(execution.getTenantId());
		
		//execution.getEngineServices().getTaskService().createTaskQuery().
		
		ThreadRules tr = new ThreadRules(page,execution.getEngineServices().getRuntimeService(),rule,
			execution.getId(),6000);
		tr.setTaskService(execution.getEngineServices().getTaskService());
		
		//List<Task> ld=execution.getEngineServices().getTaskService().createTaskQuery().executionId(execution.getId()).list();
		
		tr.start();
		
		/*	//execution.getEngineServices().getRuntimeService()
		//execution.getEngineServices().getRuntimeService().
	//	execution.
		for(Task pd :ld) {
			System.out.println(pd.getId());
		}*/ 
		//System.out.println(new Gson().toJson(ls));
		//System.out.println(eventName);
		/*if(eventName.equals("take")) {
			ThreadRules tr = new ThreadRules(page,execution.getEngineServices().getRuntimeService(),rule,
					execution.getId(),true);
			tr.start();
		}else {
			ThreadRules tr = new ThreadRules(page,execution.getEngineServices().getRuntimeService(),rule,
					execution.getId(),false);
			tr.start();
		}*/
		//execution.getEngineServices().getTaskService().setVariablesLocal(taskId, variables);
		//execution.getEngineServices().getRuntimeService().set
	
	}
	 
} 
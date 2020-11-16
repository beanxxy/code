package com.snimay.app.process.listener;

import java.util.List;
import java.util.Map;

import org.activiti.engine.task.Task;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.google.gson.Gson;

/**   
 * 流程规则执行，流程名称前面加@的轮循执行 
 * @title      : ThreadRules.java
 * @package    : com.snimay.app.process.listener
 * @author     : xxy
 * @date       : 2018年8月7日 上午9:44:26
 * @version    : V1.0   
 */
public class ThreadRules   extends Thread  {
	RuntimeService execution;
	String id;
	String rule	;
	HtmlPage page;
	int is;
	TaskService taskService;
	/**
	 * 初始化
	 * @author     : xxy
	 * @param page 页码
	 * @param execution
	 * @param rule 规则
	 * @param id  id
	 * @param is 
	 * @throws
	 */
	public ThreadRules(HtmlPage page,RuntimeService execution,String rule,String id,int is) {
		this.execution	=	execution;
		this.rule		=	rule;
		this.page   	=	page;
		this.is			=	is;
		this.id			=	id;
	}
	
	/**
	 * 设置服务
	 * @author     : xxy
	 * @param taskservice
	 * @throws
	 */
	public void setTaskService(TaskService taskservice) {
		this.taskService	=	taskservice;
	}
	/**
	 * 执行规则
	 * @author     : xxy
	 * @return
	 * @throws
	 */
	public boolean runRule() {
		
		List<Task> ld=taskService.createTaskQuery().executionId(id).list();
		//List<Map<String,Object>> ls = new ArrayList<Map<String,Object>>();
		if(ld==null||ld.size()==0)return false;
		else {
			for(Task pd :ld) {
				if(rule.length()!=0) {
					System.out.println("规则:"+rule);
					//构造js
					Map varibles = taskService.getVariables(pd.getId());
					varibles.put("当前任务", pd.getName());
					StringBuffer strjs	=	new StringBuffer();			
					strjs.append("var obj = {};\n");
					//==============获取值
					for(Object s:varibles.keySet()) {
						strjs.append("obj['"+s+"']=\""+varibles.get(s)+"\";\n");
					}
					System.out.println("obj:"+strjs);
					//===============获取规则
					String rulebody = page.executeJavaScript("GetItem(\"Rules\",\"规则代号\",\""+rule+"\")[0][\"规则代码\"];\n").getJavaScriptResult().toString(); 
					System.out.println("rulebody:"+rulebody);
					strjs.append(rulebody);
					
					page.executeJavaScript(strjs+""); 
					//执行完后返填==================================
					String js	=	"JSON.stringify(obj)";
					String strx  = 	page.executeJavaScript(js).getJavaScriptResult().toString();
					Map	map		=	new Gson().fromJson(strx, Map.class);
					execution.setVariables(id,map);
					//taskService.setVariables(pd.getId(),map);
					
				
					System.out.println("当前任务值:"+strx);
				}
			}
			return true;
		}
	}
	/**
	 * 有名称中有@ 的轮循
	 * @author     : xxy
	 * @throws
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i=0;
		int c=this.rule.indexOf('@');
		this.rule	=	this.rule.replaceAll("@", "");
		do {
			try {
				System.out.println("轮循");
				if(!this.runRule()) {
					i++; if(i>3)break;
				}
				Thread.sleep(is);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}while(c!=-1);
		 
	}

}

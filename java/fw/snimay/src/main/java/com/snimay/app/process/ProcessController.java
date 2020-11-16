package com.snimay.app.process;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.FlowNode;
import org.activiti.bpmn.model.SequenceFlow;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.activiti.image.ProcessDiagramGenerator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.snimay.app.Controller;
import com.snimay.common.RestServiceController;
import com.snimay.common.ToWeb;

import io.swagger.annotations.ApiOperation;


/**   
 * 流程api接口 
 * @title      : ProcessController.java
 * @package    : com.snimay.app.process
 * @author     : xxy
 * @date       : 2018年8月7日 上午9:44:43
 * @version    : V1.0   
 */
@RestController
@RequestMapping("process")
public class ProcessController  extends Controller  implements  RestServiceController<Deployment, String>{
	
	/**
	 * : 历史数据服务 
	 * @author     : xxy
	 */
	@Autowired
	private HistoryService historyService;
	/**
	 * : TODO 
	 * @author     : xxy
	 */
	@Autowired
	private ProcessEngine processEngine;
	
	/**
	 * : TODO 
	 * @author     : xxy
	 */
	@Autowired
	private RuntimeService runtimeService;
	/**
	 * : 任务服务 
	 * @author     : xxy
	 */
	@Autowired
	private TaskService taskService;
	
	/**
	 * : TODO 
	 * @author     : xxy
	 */
	@Autowired
	RepositoryService repositoryService;
	/**
	 * : 根据id获取
	 * @author     : xxy
	 * @param id  
	 * @return 发回空
	 * @throws 
	 */
	@Override
	@GetMapping("/")
	public Object getOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * : 查看发布模型
	 * @author     : xxy
	 * @param rowSize
	 * @param page
	 * @return Object
	 * @throws	
	 */
	@ApiOperation(value="查看发布模型")
	@Override
	@GetMapping("/deployment/{name}")
	public Object getList(Integer rowSize, Integer page) {
		ToWeb toweb = new ToWeb();
		List<Deployment> deployments = repositoryService.createDeploymentQuery().list();
		toweb.setObjData(deployments);
		//repositoryService.
		return new Gson().toJson(toweb);
	}
	//historyService
	
	/**
	 * : 历史记录
	 * @author     : xxy
	 * @param rowSize
	 * @param page
	 * @return List<Map>
	 * @throws
	 */
	@ApiOperation(value="历史记录")
	@GetMapping("/htask/{name}")
	public Object getList3(Integer rowSize, Integer page) {
		ToWeb toweb = new ToWeb();
		List<HistoricTaskInstance> pd = historyService.createHistoricTaskInstanceQuery().list();
		List<Map<String,Object>> ls = new ArrayList<Map<String,Object>>();
		for(HistoricTaskInstance p :pd) {
			Map map= new HashMap<>();
			map.put("name", p.getName());
			map.put("id", p.getId());
			map.put("description", p.getDescription());
			map.put("owner", p.getOwner());
			map.put("assignee", p.getAssignee());
			map.put("formKey",p.getFormKey());
			map.put("processInstanceId", p.getProcessInstanceId());
			map.put("taskLocalVariables", p.getTaskLocalVariables());
			map.put("processVariables", p.getProcessVariables());
			ls.add(map);
		}
		toweb.setObjData(ls); 
		return new Gson().toJson(toweb);
	}
	/**
	 * : 查看发布模型
	 * @author     : xxy
	 * @param rowSize
	 * @param page
	 * @return
	 * @throws
	 */
	@ApiOperation(value="查看发布模型")
	@GetMapping("/processDefinition/{name}")
	public Object getList2(Integer rowSize, Integer page) {
		ToWeb toweb = new ToWeb();
		List<ProcessDefinition> pd = repositoryService.createProcessDefinitionQuery().list();
		List<Map<String,Object>> ls = new ArrayList<Map<String,Object>>();
		for(ProcessDefinition p :pd) {
			
			Map map= new HashMap<>();
			map.put("category", p.getCategory());
			map.put("deploymentId", p.getDeploymentId());
			map.put("description", p.getDescription());
			map.put("diagramResourceName", p.getDiagramResourceName());
			map.put("id", p.getId());
			map.put("key", p.getKey());
			map.put("name", p.getName());
			map.put("resourceName", p.getResourceName());
			map.put("tenantId", p.getTenantId());
			map.put("version", p.getVersion());
			ls.add(map);
		}
		toweb.setObjData(ls); 
		return new Gson().toJson(toweb);
	} 
	/**
	 * : 查看发布模型
	 * @author     : xxy
	 * @return
	 * @throws
	 */
	@ApiOperation(value="查看发布模型")
	@GetMapping("/process/{name}")
	public Object getList() { 
		ToWeb toweb = new ToWeb();
		List<ProcessInstance> pi =runtimeService.createProcessInstanceQuery().list();
		List<Map<String,Object>> ls = new ArrayList<Map<String,Object>>();
		for(ProcessInstance p:pi) {
			Map map= new HashMap<>();
			map.put("parentId", p.getParentId());
			map.put("deploymentId", p.getDeploymentId());
			map.put("description", p.getDescription());
			map.put("processDefinitionId", p.getProcessDefinitionId());
			map.put("id", p.getId());
			map.put("activityId", p.getActivityId());
			map.put("name", p.getName());
			map.put("ProcessVariables", p.getProcessVariables());
			map.put("tenantId", p.getTenantId());
			map.put("definitionName", p.getProcessDefinitionName());
			ls.add(map);
		}
		toweb.setObjData(ls);
		return new Gson().toJson(toweb);
	}
	

 
    /**
     * : findOutComeListByTaskId
     * @author     : xxy
     * @param taskId
     * @return
     * @throws
     */
    public List<String> findOutComeListByTaskId(String taskId) {
        //返回存放连线的名称集合
        List<String> list = new ArrayList<String>();
        //1:使用任务ID，查询任务对象
        Task task = taskService.createTaskQuery()//
        		.taskId(taskId)//使用任务ID查询
                    .singleResult();
        //2：获取流程定义ID
        String processDefinitionId = task.getProcessDefinitionId();
        //3：查询ProcessDefinitionEntiy对象
        ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) repositoryService.getProcessDefinition(processDefinitionId);
        //使用任务对象Task获取流程实例ID
        String processInstanceId = task.getProcessInstanceId();
        //使用流程实例ID，查询正在执行的执行对象表，返回流程实例对象
        ProcessInstance pi = runtimeService.createProcessInstanceQuery()//
                    .processInstanceId(processInstanceId)//使用流程实例ID查询
                    .singleResult();
        //获取当前活动的id
        String activityId = pi.getActivityId();
        //4：获取当前的活动
        ActivityImpl activityImpl = processDefinitionEntity.findActivity(activityId);
        //5：获取当前活动完成之后连线的名称
        if(activityImpl!=null) {
        	 List<PvmTransition> pvmList = activityImpl.getOutgoingTransitions();
             if(pvmList!=null && pvmList.size()>0){
                 for(PvmTransition pvm:pvmList){
                     String name = (String) pvm.getProperty("name");
                     if(StringUtils.isNotBlank(name)){
                         list.add(name);
                     }
                     else{
                         //list.add("提交");
                     }
                 }
             }
        }
       
        return list;
    }
	
	
	
	/**
	 * : 查询用户任务
	 * @author     : xxy
	 * @param user
	 * @param id
	 * @return
	 * @throws
	 */
	@GetMapping("/start/{uesr}/{id}")
	public Object st(@PathVariable("uesr") String user,@PathVariable("id") String id) {
		ToWeb toweb = new ToWeb();
		Map map= new HashMap<>();
		Authentication.setAuthenticatedUserId(user);//设置当前任务的办理人
		ProcessInstance  p =runtimeService.startProcessInstanceById(id);
		
		
		
		map.put("parentId", p.getParentId());
		map.put("deploymentId", p.getDeploymentId());
		map.put("description", p.getDescription());
		map.put("processDefinitionId", p.getProcessDefinitionId());
		map.put("id", p.getId());
		map.put("activityId", p.getActivityId());
		map.put("name", p.getName());
		map.put("ProcessVariables", p.getProcessVariables());
		map.put("tenantId", p.getTenantId());
		map.put("definitionName", p.getProcessDefinitionName());
		toweb.setObjData(map);
		return new Gson().toJson(toweb);
	}
	/**
	 * : TODO
	 * @author     : xxy
	 * @param map
	 * @return
	 * @throws
	 */
	@PostMapping("/completeTask/")
	public Object completeTask(@RequestBody Map<String,Object> map) {
		String id = map.get("id").toString();
		//设置批注信息,先获取流程实例Id
		//Map<String,Object> map = new HashMap<String,Object>();
		Task task = taskService.createTaskQuery().taskId(id).singleResult();
		Authentication.setAuthenticatedUserId(map.get("用户").toString());//设置当前任务的办理人
		taskService.complete(id, map);//完成任务，并添加参数		
		ToWeb toweb = new ToWeb();
		//taskService.getTaskComments(taskId)
		return new Gson().toJson(toweb);
	}
	 
	@GetMapping("/task/{name}")
	public Object st1() {
		TaskQuery query = taskService.createTaskQuery(); 
		ToWeb toweb = new ToWeb();
		List<Task> ld = query.list();
		List<Map<String,Object>> ls = new ArrayList<Map<String,Object>>();
		for(Task pd :ld) {
			Map map= new HashMap<>();
			map.put("name", pd.getName());
			map.put("id", pd.getId());
			map.put("description", pd.getDescription());
			map.put("owner", pd.getOwner());
			map.put("assignee", pd.getAssignee());
			map.put("formKey",pd.getFormKey());
			map.put("processInstanceId", pd.getProcessInstanceId());
			map.put("taskLocalVariables",taskService.getVariablesLocal(pd.getId()));
			map.put("taskVariables",taskService.getVariables(pd.getId()));
			map.put("processVariables",runtimeService.getVariables(pd.getProcessInstanceId()));
			map.put("come", findOutComeListByTaskId(pd.getId()));
			//taskService.
			//WorkflowBean
			ls.add(map);
		}
		toweb.setObjData(ls);
		return new Gson().toJson(toweb);
	}
	
	/**
	 * 获取流程图像，已执行节点和流程线高亮显示
	 */
	@GetMapping("/img2/{pProcessInstanceId}")
	public void getActivitiProccessImage(@PathVariable("pProcessInstanceId") String pProcessInstanceId, HttpServletResponse response)
	{
	    //logger.info("[开始]-获取流程图图像");
	    try {
	        //  获取历史流程实例
	        HistoricProcessInstance historicProcessInstance = historyService.createHistoricProcessInstanceQuery()
	                .processInstanceId(pProcessInstanceId).singleResult();

	        if (historicProcessInstance == null) {
	            //throw new BusinessException("获取流程实例ID[" + pProcessInstanceId + "]对应的历史流程实例失败！");
	        }
	        else
	        {
	            // 获取流程定义
	            ProcessDefinitionEntity processDefinition = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService)
	                    .getDeployedProcessDefinition(historicProcessInstance.getProcessDefinitionId());

	            // 获取流程历史中已执行节点，并按照节点在流程中执行先后顺序排序
	            List<HistoricActivityInstance> historicActivityInstanceList = historyService.createHistoricActivityInstanceQuery()
	                    .processInstanceId(pProcessInstanceId).orderByHistoricActivityInstanceId().asc().list();

	            // 已执行的节点ID集合
	            List<String> executedActivityIdList = new ArrayList<String>();
	            int index = 1;
	            //logger.info("获取已经执行的节点ID");
	            for (HistoricActivityInstance activityInstance : historicActivityInstanceList) {
	                executedActivityIdList.add(activityInstance.getActivityId());

	                //logger.info("第[" + index + "]个已执行节点=" + activityInstance.getActivityId() + " : " +activityInstance.getActivityName());
	                index++;
	            }

	            BpmnModel bpmnModel = repositoryService.getBpmnModel(historicProcessInstance.getProcessDefinitionId());

	            // 已执行的线集合
	            List<String> flowIds = new ArrayList<String>();
	            // 获取流程走过的线 (getHighLightedFlows是下面的方法)
	            flowIds = getHighLightedFlows(bpmnModel,processDefinition, historicActivityInstanceList);



	            // 获取流程图图像字符流
	            ProcessDiagramGenerator pec = processEngine.getProcessEngineConfiguration().getProcessDiagramGenerator();
	            //配置字体
	            InputStream imageStream = pec.generateDiagram(bpmnModel, "png", executedActivityIdList, flowIds,"宋体","微软雅黑","黑体",null,2.0);

	            response.setContentType("image/png");
	            OutputStream os = response.getOutputStream();
	            int bytesRead = 0;
	            byte[] buffer = new byte[8192];
	            while ((bytesRead = imageStream.read(buffer, 0, 8192)) != -1) {
	                os.write(buffer, 0, bytesRead);
	            }
	            os.close();
	            imageStream.close();
	        }
	        //logger.info("[完成]-获取流程图图像");
	    } catch (Exception e) {
	        throw new RuntimeException("获取流程图失败"+e);
	        //logger.error("【异常】-获取流程图失败！" + e.getMessage());
	        //throw new BusinessException("获取流程图失败！" + e.getMessage());
	    }
	}

	@Override
	public Object postOne(Deployment entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object putOne(String id, Deployment entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object patchOne(String id, Deployment entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object deleteOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping("/readImage/{processInstanceId}")
	public void transactImage(@PathVariable("processInstanceId") String processInstanceId,HttpServletResponse response) throws IOException {
		// 设置页面不缓存
	    response.setHeader("Pragma", "No-cache");
	    response.setHeader("Cache-Control", "no-cache");
	    response.setDateHeader("Expires", 0);
	    
		HistoricProcessInstance processInstance = historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
		
		ProcessDefinition pd = repositoryService.getProcessDefinition(processInstance.getProcessDefinitionId());

	    if(pd.getDiagramResourceName().endsWith(".png") && StringUtils.isEmpty(processInstanceId) == false)
	    {
	        this.getActivitiProccessImage(processInstanceId,response);
	        //ProcessDiagramGenerator.generateDiagram(pde, "png", getRuntimeService().getActiveActivityIds(processInstanceId));
	    }
	    else
	    {
	        // 通过接口读取
	        InputStream resourceAsStream = repositoryService.getResourceAsStream(pd.getDeploymentId(), pd.getDiagramResourceName());

	        // 输出资源内容到相应对象
	        byte[] b = new byte[1024];
	        int len = -1;
	        while ((len = resourceAsStream.read(b, 0, 1024)) != -1) {
	            response.getOutputStream().write(b, 0, len);
	        }
	    }
		
		
	}
	
	@GetMapping("/img/{id}")
	public void getImg(@PathVariable("id") String id,HttpServletResponse response) {
		try {
			ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(id).singleResult();
			InputStream imgeInputStream = repositoryService.getResourceAsStream(id,processDefinition.getDiagramResourceName());
			OutputStream imageStream =  response.getOutputStream();
			byte[] bytes = new byte[1024];
			int len = -1;
			while((len=imgeInputStream.read(bytes, 0, 1024))!=-1) {
				imageStream.write(bytes, 0, len);
			}
		} catch (IOException e) {
			throw new RuntimeException("图片获取失败！",e);
		}
	}
	
	
	public List<String> getHighLightedFlows(BpmnModel bpmnModel,ProcessDefinitionEntity processDefinitionEntity,List<HistoricActivityInstance> historicActivityInstances)
	{
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //24小时制
	    List<String> highFlows = new ArrayList<String>();// 用以保存高亮的线flowId

	    for (int i = 0; i < historicActivityInstances.size() - 1; i++)
	    {
	        // 对历史流程节点进行遍历
	        // 得到节点定义的详细信息
	        FlowNode activityImpl = (FlowNode)bpmnModel.getMainProcess().getFlowElement(historicActivityInstances.get(i).getActivityId());


	        List<FlowNode> sameStartTimeNodes = new ArrayList<FlowNode>();// 用以保存后续开始时间相同的节点
	        FlowNode sameActivityImpl1 = null;

	        HistoricActivityInstance activityImpl_ = historicActivityInstances.get(i);// 第一个节点
	        HistoricActivityInstance activityImp2_ ;

	        for(int k = i + 1 ; k <= historicActivityInstances.size() - 1; k++)
	        {
	            activityImp2_ = historicActivityInstances.get(k);// 后续第1个节点

	            if ( activityImpl_.getActivityType().equals("userTask") && activityImp2_.getActivityType().equals("userTask") &&
	                    df.format(activityImpl_.getStartTime()).equals(df.format(activityImp2_.getStartTime()))   ) //都是usertask，且主节点与后续节点的开始时间相同，说明不是真实的后继节点
	            {

	            }
	            else
	            {
	                sameActivityImpl1 = (FlowNode)bpmnModel.getMainProcess().getFlowElement(historicActivityInstances.get(k).getActivityId());//找到紧跟在后面的一个节点
	                break;
	            }

	        }
	        sameStartTimeNodes.add(sameActivityImpl1); // 将后面第一个节点放在时间相同节点的集合里
	        for (int j = i + 1; j < historicActivityInstances.size() - 1; j++)
	        {
	            HistoricActivityInstance activityImpl1 = historicActivityInstances.get(j);// 后续第一个节点
	            HistoricActivityInstance activityImpl2 = historicActivityInstances.get(j + 1);// 后续第二个节点

	            if (df.format(activityImpl1.getStartTime()).equals(df.format(activityImpl2.getStartTime()))  )
	            {// 如果第一个节点和第二个节点开始时间相同保存
	                FlowNode sameActivityImpl2 = (FlowNode)bpmnModel.getMainProcess().getFlowElement(activityImpl2.getActivityId());
	                sameStartTimeNodes.add(sameActivityImpl2);
	            }
	            else
	            {// 有不相同跳出循环
	                break;
	            }
	        }
	        List<SequenceFlow> pvmTransitions = activityImpl.getOutgoingFlows() ; // 取出节点的所有出去的线

	        for (SequenceFlow pvmTransition : pvmTransitions)
	        {// 对所有的线进行遍历
	            FlowNode pvmActivityImpl = (FlowNode)bpmnModel.getMainProcess().getFlowElement( pvmTransition.getTargetRef());// 如果取出的线的目标节点存在时间相同的节点里，保存该线的id，进行高亮显示
	            if (sameStartTimeNodes.contains(pvmActivityImpl)) {
	                highFlows.add(pvmTransition.getId());
	            }
	        }

	    }
	    return highFlows;

	}
}

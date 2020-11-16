package com.snimay.activity.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.snimay.common.RestServiceController;
import com.snimay.common.Status;
import com.snimay.common.ToWeb;
 



/**   
 * 模型管理 
 * @title      : ModelerController.java
 * @package    : com.snimay.activiti.controller
 * @author     : xxy
 * @date       : 2018年4月27日 上午11:57:43
 * @version    : V1.0   
 */
@RestController
@RequestMapping("models")
public class ModelerController implements RestServiceController<Model, String>{

    @Autowired
    RepositoryService repositoryService;
    @Autowired
    ObjectMapper objectMapper;

    /**
     * 新建一个空模型
     * @return
     * @throws UnsupportedEncodingException
     */
    @PostMapping("newModel")
    public Object newModel() throws UnsupportedEncodingException {
        //初始化一个空模型
        Model model = repositoryService.newModel();

        //设置一些默认信息
        String name = "new-process";
        String description = "";
        int revision = 1;
        String key = "process";

        ObjectNode modelNode = objectMapper.createObjectNode();
        modelNode.put(ModelDataJsonConstants.MODEL_NAME, name);
        modelNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, description);
        modelNode.put(ModelDataJsonConstants.MODEL_REVISION, revision);

        model.setName(name);
        model.setKey(key);
        model.setMetaInfo(modelNode.toString());

        repositoryService.saveModel(model);
        String id = model.getId();

        //完善ModelEditorSource
        ObjectNode editorNode = objectMapper.createObjectNode();
        editorNode.put("id", "canvas");
        editorNode.put("resourceId", "canvas");
        ObjectNode stencilSetNode = objectMapper.createObjectNode();
        stencilSetNode.put("namespace",
                "http://b3mn.org/stencilset/bpmn2.0#");
        editorNode.put("stencilset", stencilSetNode);
        repositoryService.addModelEditorSource(id,editorNode.toString().getBytes("utf-8"));
        return ToWeb.buildResult().redirectUrl("/modeler.html?modelId="+id);
    }

    /**
     * 新建一个空模型
     * @return
     * @throws UnsupportedEncodingException
     */
    @PostMapping("newModel2")
    public Object newModel2() throws UnsupportedEncodingException {
        //初始化一个空模型
        Model model = repositoryService.newModel();

        //设置一些默认信息
        String name = "new-process";
        String description = "";
        int revision = 1;
        String key = "process";

        ObjectNode modelNode = objectMapper.createObjectNode();
        modelNode.put(ModelDataJsonConstants.MODEL_NAME, name);
        modelNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, description);
        modelNode.put(ModelDataJsonConstants.MODEL_REVISION, revision);

        model.setName(name);
        model.setKey(key);
        model.setMetaInfo(modelNode.toString());

        repositoryService.saveModel(model);
        String id = model.getId();

        //完善ModelEditorSource
        ObjectNode editorNode = objectMapper.createObjectNode();
        editorNode.put("id", "canvas");
        editorNode.put("resourceId", "canvas");
        ObjectNode stencilSetNode = objectMapper.createObjectNode();
        stencilSetNode.put("namespace",
                "http://b3mn.org/stencilset/bpmn2.0#");
        editorNode.put("stencilset", stencilSetNode);
        repositoryService.addModelEditorSource(id,editorNode.toString().getBytes("utf-8"));
        return new ToWeb().setObjData(id);
    }

    /**
     * 发布模型为流程定义
     * @param id
     * @return
     * @throws Exception
     */
    @PostMapping("{id}/deployment")
    public Object deploy(@PathVariable("id")String id) throws Exception {

        //获取模型
        Model modelData = repositoryService.getModel(id);
        
        //modelData.
        byte[] bytes = repositoryService.getModelEditorSource(modelData.getId());

        if (bytes == null) {
            return ToWeb.buildResult().status(Status.FAIL)
                    .msg("模型数据为空，请先设计流程并成功保存，再进行发布。");
        }

        JsonNode modelNode = new ObjectMapper().readTree(bytes);

        BpmnModel model = new BpmnJsonConverter().convertToBpmnModel(modelNode);
        if(model.getProcesses().size()==0){
            return ToWeb.buildResult().status(Status.FAIL)
                    .msg("数据模型不符要求，请至少设计一条主线流程。");
        }
        byte[] bpmnBytes = new BpmnXMLConverter().convertToXML(model);
       // new BpmnXMLConverter().
        //发布流程
        String processName = modelData.getName() + ".bpmn20.xml";
        
      /*  this.getFile(bpmnBytes, "F://",processName);
        Deployment deployment = repositoryService.createDeployment()
        	.addClasspathResource("rules/test.drl")
        	.addClasspathResource("rules/规则.bpmn20.xml").deploy();*/
        	
        	//.addClasspathResource("rules/test.drl")
        	//.addClasspathResource("F://"+processName).deploy();
    	/*Deployment deployment = repositoryService.createDeployment();
    	deployment.addClasspathResource("rules/test.drl")
    	deployment .name(modelData.getName())
            .addString(processName, new String(bpmnBytes, "UTF-8"))
            .deploy(); */
        DeploymentBuilder deploy = repositoryService.createDeployment();  
        deploy.addClasspathResource("rules/test.drl");
        deploy.name(modelData.getName());  
        deploy.addString(processName, new String(bpmnBytes, "UTF-8"));
     //   deploy.
        Deployment deployment = deploy.deploy();   
    	modelData.setDeploymentId(deployment.getId());
    	repositoryService.saveModel(modelData);
         /* */
       
        
        return ToWeb.buildResult().refresh();
    } 
   public static void getFile(byte[] bfile, String filePath,String fileName) {  
        BufferedOutputStream bos = null;  
        FileOutputStream fos = null;  
        File file = null;  
        try {  
            File dir = new File(filePath);  
            if(!dir.exists()&&dir.isDirectory()){//判断文件目录是否存在  
                dir.mkdirs();  
            }  
            file = new File(filePath+"\\"+fileName);  
            fos = new FileOutputStream(file);  
            bos = new BufferedOutputStream(fos);  
            bos.write(bfile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            if (bos != null) {  
                try {  
                    bos.close();  
                } catch (IOException e1) {  
                    e1.printStackTrace();  
                }  
            }  
            if (fos != null) {  
                try {  
                    fos.close();  
                } catch (IOException e1) {  
                    e1.printStackTrace();  
                }  
            }  
        }  
    }   /**/

    @Override
    public Object getOne(@PathVariable("id") String id) {
        Model model = repositoryService.createModelQuery().modelId(id).singleResult();
        return ToWeb.buildResult().setObjData(model);
    }

    @Override
    public Object getList(@RequestParam(value = "rowSize", defaultValue = "1000", required = false) Integer rowSize, @RequestParam(value = "page", defaultValue = "1", required = false) Integer page) {
        List<Model> list = repositoryService.createModelQuery().listPage(rowSize * (page - 1)
                , rowSize);
        long count = repositoryService.createModelQuery().count();

        return ToWeb.buildResult().setRows(
                ToWeb.Rows.buildRows().setCurrent(page)
                        .setTotalPages((int) (count/rowSize+1))
                        .setTotalRows(count)
                        .setList(list)
                        .setRowSize(rowSize)
        );
    }

    @Override
	public Object deleteOne(@PathVariable("id")String id){
        repositoryService.deleteModel(id);
        return ToWeb.buildResult().refresh();
    }

    @Override
    public Object postOne(@RequestBody Model entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object putOne(@PathVariable("id") String s, @RequestBody Model entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object patchOne(@PathVariable("id") String s, @RequestBody Model entity) {
        throw new UnsupportedOperationException();
    }
}

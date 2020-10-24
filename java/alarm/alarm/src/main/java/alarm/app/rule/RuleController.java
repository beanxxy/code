package alarm.app.rule;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;

import javax.websocket.server.PathParam; 
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import alarm.app.engine.Sql;
import alarm.freemarker.FreemarkerUtil;
@RestController
@RequestMapping("rule")
public class RuleController{
	
    String path = "rule";
    
    @Autowired
    RuleMapper mapper;

    @Autowired
	FreemarkerUtil freemarkerUtil;

    @GetMapping
    public Object get(
        @PathParam("p")String p,
        @PathParam("s")String s,
        @PathParam("id")String id,
        @PathParam("w")String w
    ){
    	Rule o = new Rule();
		int pagesize =10;
		int pi=1;
        String word = "";
		if(p==null) p="1";
		if(s!=null||s=="") pagesize = Integer.parseInt(s);
        if(w==null) word="%%"; else word="%"+w+"%";
		
		pi = Integer.parseInt(p);
        List<Rule> ls =	mapper.pageByName((pi-1)*pagesize, pagesize,word);
        int count = mapper.countByName(word);
        Map<String,Object> mp = new HashMap<String,Object>();
        mp.put("objs", ls);
        mp.put("page", pi);
        mp.put("s", s);
        mp.put("w", w);
        mp.put("path", path);
        mp.put("count",count/pagesize+(count%pagesize==0?0:1));
        //---
        if(id != null && id.length() > 0){
            o = mapper.findById(id);
        }
        mp.put("obj",o);
        return freemarkerUtil.getString(path+".html", mp); 
    }
    
    @GetMapping("/delete")
    public Object delete(@PathParam("id")String id,
        HttpServletResponse response) throws IOException{
        mapper.delete(id);
        response.sendRedirect("/"+path);
        return null; 
    }
    
    @GetMapping("/start")
    public Object star(@PathParam("id")String id,
        HttpServletResponse response) throws IOException{
        mapper.start("启动",id);
        response.sendRedirect("/"+path);
        return null; 
    }
    
    @GetMapping("/end")
    public Object end(@PathParam("id")String id,
        HttpServletResponse response) throws IOException{
        mapper.start("停止",id);
        response.sendRedirect("/"+path);
        return null; 
    }
    
    @GetMapping("/add")
    public Object add(@PathParam("id")String id){
    	Rule o = new Rule();
        Map<String,Object> mp = new HashMap<String,Object>();
        if(id != null && id.length() > 0){
            o = mapper.findById(id);
        }
        mp.put("obj",o);
        mp.put("path", path);
        return freemarkerUtil.getString(path+"/add.html",mp);
    }

	@PostMapping("/add")
    public Object add(
		@Param("name")String name,
    	@Param("sql")String sql,
    	@Param("state")String state,
    	@Param("dep")String dep,
    	@Param("timecell")String timecell,
    	@Param("msg")String msg,
    	@Param("nexttime")String nexttime,
    	@Param("alarmtime")String alarmtime, 
        @PathParam("id")String id, 
    	@Param("maxvalue")String maxvalue,
    	@Param("minvalue")String minvalue,
    	
    	@Param("model")String model,
    	@Param("sign")String sign,
    	@Param("standard")String standard,
        HttpServletResponse response
    )throws IOException {
		Map<String,Object> mp = new HashMap<String,Object>();
		Rule o = new Rule();
		o.name 	= name;
		o.sql 	= sql;
		o.state = state;
		o.dep 	= dep;
		o.timecell = timecell;
		o.msg 	   = msg;
		o.nexttime = nexttime;
		o.maxvalue = maxvalue;
		o.minvalue = minvalue; 
		
		mp.put("obj",o);
		mp.put("path", path);
		Sql  sq = new Sql();
		String v= sq.Test(sql);
		if(v.length()==0) {
			mp.put("msg","sql 语句错误!");
			return freemarkerUtil.getString(path+"/add.html",mp);
		}else {
			standard = v;
			state    = "停止";
			if(id==null || id.length() == 0) {
	        	 mapper.insert(
	         		name,
	         		sql,
	         		state,
	         		dep,
	         		timecell,
	         		msg,
	         		nexttime,
	         		alarmtime,
	         		maxvalue,
	         		minvalue,
	         		model,
	         		sign,
	         		standard
	             ); 
	        } else {
	        	mapper.update(name,
	        		sql,
	        		state,
	        		dep,
	        		timecell,
	        		msg,
	        		nexttime,
	        		alarmtime,
	        		maxvalue,
	        		minvalue,
	        		model,
	         		sign,
	         		standard,
	        		id
	            );
	        }
			response.sendRedirect("/"+path);
		} 
		return null;
    }
}

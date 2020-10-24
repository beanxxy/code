package alarm.app.addr;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import alarm.freemarker.FreemarkerUtil;
@RestController
@RequestMapping("addr")
public class AddrController{
	
    String path = "addr";

    @Autowired
    AddrMapper mapper;

    @Autowired
	FreemarkerUtil freemarkerUtil;

    @GetMapping
    public Object get(
        @PathParam("p")String p,
        @PathParam("s")String s,
        @PathParam("id")String id,
        @PathParam("w")String w
    ){
        Addr o = new Addr();
		int pagesize =10;
		int pi=1;
        String word = "";
		if(p==null) p="1";
		if(s!=null||s=="") pagesize = Integer.parseInt(s);
        if(w==null) word="%%"; else word="%"+w+"%";
		
		pi = Integer.parseInt(p);
        List<Addr> ls =	mapper.pageByName((pi-1)*pagesize, pagesize,word);
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
    
    @GetMapping("/add")
    public Object add(@PathParam("id")String id){
        Addr o = new Addr();
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
    	@Param("phone")String phone,
    	@Param("dep")String dep,
        @PathParam("id")String id,
        HttpServletResponse response
    )throws IOException { 
        if(id==null || id.length() == 0)
            mapper.insert(name,phone,dep);
        else
            mapper.update(name,phone,dep,id);
        response.sendRedirect("/"+path);
        return null; 
    }
}

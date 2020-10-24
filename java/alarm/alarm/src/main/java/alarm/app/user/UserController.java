package alarm.app.user;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;

import javax.websocket.server.PathParam;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse; 

import alarm.freemarker.FreemarkerUtil;
@RestController
@RequestMapping("user")
public class UserController{
    String path = "user";
    @Autowired
    UserMapper usermapper;

    @Autowired
	FreemarkerUtil freemarkerUtil;

    @GetMapping
    public Object get(
        @PathParam("p")String p,
        @PathParam("s")String s,
        @PathParam("id")String id,
        @PathParam("w")String w
    ){
        User u = new User();
		int pagesize =10;
		int pi=1;
        String word = "";
		if(p==null) p="1";
		if(s!=null||s=="") pagesize = Integer.parseInt(s);
        if(w==null) word="%%"; else word="%"+w+"%";
		
		pi = Integer.parseInt(p);
        List<User> ls =	usermapper.pageByName((pi-1)*pagesize, pagesize,word);
        int count = usermapper.countByName(word);
        Map<String,Object> mp = new HashMap<String,Object>();
        mp.put("users", ls);
        mp.put("page", pi);
        mp.put("s", s);
        mp.put("w", w);
        mp.put("path", path);
        mp.put("count",count/pagesize+(count%pagesize==0?0:1));
        //---
        if(id != null && id.length() > 0){
            u = usermapper.findUserById(id);
        }
        mp.put("obj",u);
        return freemarkerUtil.getString("user.html", mp);

    }
    @GetMapping("/delete")
    public Object delete(@PathParam("id")String id,
        HttpServletResponse response) throws IOException{
        usermapper.delete(id);
        response.sendRedirect("/user");
        return null;//freemarkerUtil.getString("/user/add.html", mp);
    }
    @GetMapping("/add")
    public Object add(@PathParam("id")String id){
        User u = new User();
        Map<String,Object> mp = new HashMap<String,Object>();
        if(id != null && id.length() > 0){
            u = usermapper.findUserById(id);
        }
        mp.put("obj",u);
        mp.put("path", path);
        return freemarkerUtil.getString("user/add.html",mp);
    }

	@PostMapping("/add")
    public Object add(
        @PathParam("name")String name,
        @PathParam("password")String password,
        @PathParam("id")String id,
        HttpServletResponse response
    )throws IOException { 
        if(id==null || id.length() == 0)
            usermapper.insert(name,password);
        else
            usermapper.update(name,password,id);
        response.sendRedirect("/user");
        return null;//freemarkerUtil.getString("/user/add.html", mp);
    }
}

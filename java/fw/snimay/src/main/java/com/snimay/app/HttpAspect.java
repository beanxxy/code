package com.snimay.app;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.gson.Gson;
import com.snimay.app.dto.UserLogin;
import com.snimay.app.vo.Appdb;
import com.snimay.app.vo.Clazz;
import com.snimay.app.vo.Field;
import com.snimay.app.vo.Log;
import com.snimay.app.vo.Menu;
import com.snimay.app.vo.Role;
import com.snimay.app.vo.User;
import com.snimay.app.vo.UserApp;
import com.snimay.app.vo.UserField;
import com.snimay.app.vo.UserMenu;
import com.snimay.app.vo.UserPermission;
import com.snimay.app.vo.UserRole;
import com.snimay.common.Ip;
import com.snimay.common.MD5;
import com.snimay.common.Status;
import com.snimay.common.ToWeb;
import com.snimay.compiler.compiler.JavaFile;
import com.snimay.compiler.compiler.MyClassloader;
import com.snimay.freemarker.FreemarkerUtil;
import com.snimay.hibernate.dao.ItemsRepository;

/**   
 * : 用于权限拦截 
 * @title      : HttpAspect.java
 * @package    : com.snimay.app
 * @author     : xxy
 * @date       : 2018年6月11日 09:07:25
 * @version    : V1.0   
 */
@Aspect
@Component
@ConfigurationProperties(prefix = "myYml")
public class HttpAspect {
	/**
	 * 属性
	 * @author     : xxy
	 */
	private Map<String, String> mapProps = new HashMap<>(); //接收prop1里面的属性值
	/**
	 * 用户会话
	 * @author     : xxy
	 */
	@Autowired
	private HttpSession session;
	//private Map<String, UserPermission> processurl;
	/**
	 * 项操作
	 * @author     : xxy
	 */
	@Autowired
	ItemsRepository itemsRepository;
	/**
	 * 编译工具
	 * @author     : xxy
	 */
	@Autowired
	FreemarkerUtil freemarkerUtil;
	/**
	 * 全局读表会话
	 * @author     : xxy
	 */
	@Autowired
	private SessionFactory sessionFactory;//全局系统读表连接
 
	//private SessionFactory usersessionFactory;//个人带权限读表连接
	//private User user;
	//private int i=0;
	/**
	 * 拦截点
	 * @author     : xxy
	 * @throws
	 */
	@Pointcut("execution(* com.snimay.app..*(..)) and @annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void permisson() {}
 
	
	
	/**
	 * : 登录拦截
	 * @author     : xxy
	 * @param pjp
	 * @return
	 * @throws Throwable
	 * @throws
	 */
	@Around("permisson()")
	public Object Interceptor(ProceedingJoinPoint pjp) throws Throwable{
		User tempUser	=	new User();
		SessionFactory usersessionFactory			=	(SessionFactory) session.getAttribute("usersessionFactory");
		Map<String, UserPermission> processurl		=	(Map<String, UserPermission>) session.getAttribute("processurl");
		ServletRequestAttributes requestAttributes 	= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request 					= requestAttributes.getRequest();
		String	path								= request.getServletPath();
		String	method								= request.getMethod();
		String packages								= (String) session.getAttribute("packages");
		if(session.getAttribute("user")==null) {
			tempUser.username="游客";
			tempUser.id		 =(long) 0;
		}else {
			tempUser	=	(User) session.getAttribute("user");
		}
		ToWeb 	toweb = new ToWeb();
		Object	obj									= null;
		Log log	=	new Log();
		log.method	=	method;
		log.time	=	new Date();
		log.url		=	path;
		log.in_		=	"";
		log.out_		=	"";
		log.user_	=	tempUser.username+"("+tempUser.id+")";
		log.ip	=	Ip.toString(request);
		log.mac =Ip.getRequestSystemInfo(request)+","+Ip.getRequestBrowserInfo(request)+","+ Ip.getHostName(log.ip);
		
		if(path.equals("/login/")) {
			Object[] objs 	= pjp.getArgs();
			UserLogin 	ul	= (UserLogin) objs[0];	
			User admin	  	= sys_administrator(ul.username,ul.password);
			if(admin!=null) {
				toweb.setObjData(admin);
				obj	=	toweb;
			}else {
				obj	=	pjp.proceed(pjp.getArgs());
				this.login(obj,processurl,usersessionFactory);
			}
			//System.out.println(mapProps.get("admin"));
			
		}else {
			Method mt 				= pjp.getTarget().getClass().getMethod("setSeesionFactory", SessionFactory.class);
			Method mt1 				= pjp.getTarget().getClass().getMethod("setPackages", String.class);
			
			if(mt!=null) {
				if(path.equals("/app/1")||path.equals("/app/")) {
					mt.invoke(pjp.getTarget(), this.sessionFactory);
					mt1.invoke(pjp.getTarget(), "com.snimay.app.vo");
					obj	=	pjp.proceed(pjp.getArgs());
				}else if(usersessionFactory==null) {
					toweb.setMsg("没有登录");
					toweb.setStatus(Status.NO_LOGIN); 
					return new Gson().toJson(toweb);
				}else {
					mt.invoke(pjp.getTarget(), usersessionFactory);
					mt1.invoke(pjp.getTarget(), packages);
					path=method+" "+path;
					for(String str:processurl.keySet()) {
						//System.out.println(str +":" + path +" "+path.indexOf(str));
						if(path.indexOf(str)==0) {
							UserPermission up	=	processurl.get(str);
							if(up.starttime.getTime()<new Date().getTime()&&new Date().getTime()<up.overtime.getTime()) {
								obj	=	pjp.proceed(pjp.getArgs());
								break;
							}
						}
					}
					
				}
			}else {
				toweb.setMsg("当前系统方法错误，因为没有继承Controller");
				toweb.setStatus(Status.NO_LOGIN); 
				return new Gson().toJson(toweb);
			}
			
		}
		if(obj==null) {
			toweb.setMsg("当前用户没有权限:"+path);
			toweb.setStatus(Status.NO_PRIVILEGE); 
			return new Gson().toJson(toweb);
		}
		//log.out	=	obj.toString();
		itemsRepository.save(sessionFactory, log);
		return obj;  
 	} 
	

	/**
	 * 登录授权
	 * @param obj
	 * @param processurl
	 * @param usersessionFactory
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public Object login(Object obj,Map<String, UserPermission> processurl	,SessionFactory usersessionFactory	) throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		Gson gson				=	new Gson();
		processurl				=	new HashMap<String,UserPermission>();	
		ToWeb toweb				=	gson.fromJson(obj.toString(), ToWeb.class);	
		String				str =	gson.toJson(toweb.getData().get("obj")); 	
		if(str!=null&&str.length()>0) {
			User u	=	gson.fromJson(str, User.class);
			if(u!=null/*&&u.permission!=null*/) {
				List<Menu> menus	  	=	itemsRepository.seach(sessionFactory, new Menu(),"1=1");
				List<Appdb> apps	=	itemsRepository.seach(sessionFactory, new Appdb(),"1=1");
				Map<String,Menu>	mmap	=	new HashMap();
				Map<String,Appdb>	amap	=	new HashMap();
				for(Menu r: menus) {
					mmap.put(r.id+"", r);
				}
				for(Appdb r: apps) {
					amap.put(r.id+"", r);
				}
				Set<UserMenu> mset 	=	new HashSet();
				for(Object obje : u.menu) {
					UserMenu r = (UserMenu) obje;
					r.data	   = mmap.get(r.db);
					//r.starttime
					if(r.starttime.getTime()<new Date().getTime()&&new Date().getTime()<r.overtime.getTime()) {
						mset.add(r);
					}
				}
				u.menu	=	mset; 
				//-===========================
				Set<UserApp> aset 	=	new HashSet();
				for(Object obje : u.apps) {
					UserApp ap	=	(UserApp) obje;
					ap.data		=	amap.get(ap.db);
					if(ap.starttime.getTime()<new Date().getTime()&&new Date().getTime()<ap.overtime.getTime()) {
						aset.add(ap);
					}
				
				}
				u.apps	=	aset;
				//==============================
				UserPermission			up	=	new UserPermission();
				up.starttime				=	new Date(999);
				up.overtime					=	new Date(new Date().getTime()*10);
				processurl.put("GET"	, up);
				processurl.put("POST"	, up);
				processurl.put("DELETE"	, up);
				processurl.put("PUT"	, up);
				usersessionFactory =	this.sessionFactory;
				session.setAttribute("packages","com.snimay.app.vo");
				session.setAttribute("usersessionFactory",usersessionFactory);
				session.setAttribute("processurl",processurl);
				session.setAttribute("user",u);
			}
		}
		return null;			
	}
	/**
	 *	获取数据配置
	 * @author     : xxy
	 * @return
	 * @throws
	 */
	public Configuration getConfiguration() {
		Configuration cfge = new Configuration().configure();
		Configuration cfg = new Configuration();
		cfg.setProperty("connection.driver_class", cfge.getProperty("connection.driver_class"));
		cfg.setProperty("connection.url", cfge.getProperty("connection.url"));
		cfg.setProperty("connection.useUnicode", cfge.getProperty("connection.useUnicode"));
		cfg.setProperty("connection.characterEncoding", cfge.getProperty("connection.characterEncoding"));
		cfg.setProperty("connection.username", cfge.getProperty("connection.username"));
		cfg.setProperty("connection.password", cfge.getProperty("connection.password"));
		cfg.setProperty("connection.autocommit", cfge.getProperty("connection.autocommit"));
		cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		return cfg;
	}/**/
	
	/**
	 * 登录授权
	 * @author     : xxy
	 * @param u
	 * @return
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws
	 */
	public SessionFactory userSessionFactory(User u) throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		if(u.temp!=null&&u.temp.length()>0) {
			deleteDir(new File(HttpAspect.class.getClassLoader().getResource("").getPath()
			 +"/com/snimay/app/vo"+u.temp));
		}
		Gson gs	=	new Gson();
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		MetadataSources sources = new MetadataSources( serviceRegistry );
		SessionFactory  usessionFactory  = (SessionFactory) session.getAttribute("usersessionFactory");
		if(usessionFactory!=null) {
			usessionFactory.close();
		} 
		List<Clazz> cls	  =	itemsRepository.seach(sessionFactory, new Clazz(),"1=1");
		JavaFile jf	=	new JavaFile();
		Map<Long,Object> mapfiled = new HashMap<Long,Object>();
		Metadata metadatae = sources.getMetadataBuilder().build();
		for(UserField f:u.field) {
			if(f.starttime.getTime()<new Date().getTime()&&new Date().getTime()<f.overtime.getTime()) {
				mapfiled.put(f.data.id, f.data);
			}
		}
		String temp		   = u.id+"a"+new Date().getTime();
		String packagename = "com.snimay.app.vo"+temp;
		session.setAttribute("packages",packagename);
		
		
		
		for (Clazz clazz : cls) {
			//clazz.fields= new HashSet<Field>();
			Map<String,Object> mp   = 	gs.fromJson(gs.toJson(clazz),Map.class);
			mp.put("packagename",packagename);
			String s =freemarkerUtil.getString("Entity2.java", mp);
		//	System.out.println(s);
			String path = jf.setFile(s);
			//String clazzname = packagename+"."+clazz.name ;
			
		}
		
		
		for (Clazz clazz : cls) {
			Set<Field> fds  = clazz.fields;
			Set<Field> userfideld = new HashSet<Field>();
			int k=0;
			for(Field f:fds) {
				if(mapfiled.get(f.id)!=null) {
					userfideld.add(f);
					k=1;
				}
			}
			if(k==0) {
				String clazzname = packagename+"."+clazz.name ;
				sources.addAnnotatedClass(Class.forName(clazzname));
			}else {
				clazz.fields			=	userfideld;
				Map<String,Object> mp   = 	gs.fromJson(gs.toJson(clazz),Map.class);
				mp.put("packagename",packagename);
				String s =freemarkerUtil.getString("Entity.java", mp);
				String path = jf.setFile(s);
				String clazzname = packagename+"."+clazz.name ;
				MyClassloader cl = new MyClassloader(path,new String[] {clazzname});  
				Class ce = cl.loadClass(clazzname);
				sources.addAnnotatedClass(ce);
			}
		}
		u.temp = temp;
		if(u.id!=null) {
			itemsRepository.update(sessionFactory, u);
		}
		Metadata metadata = sources.getMetadataBuilder().build();/*.applyImplicitNamingStrategy( ImplicitNamingStrategyJpaCompliantImpl.INSTANCE )*/
        return 	metadata.getSessionFactoryBuilder().build();
	}
	
	/**
	 * 超级管理员授权
	 * @author     : xxy
	 * @param user
	 * @param pw
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 * @throws
	 */
	public User sys_administrator(String user,String pw) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		User u = new User();
		//System.out.println(user);
		//System.out.println(pw);
		pw	=	MD5.toString(pw);
		if(user.equals(mapProps.get("admin"))&&pw.equals(mapProps.get("pw"))) {
			u.username="超级管理员";
			u.id	  =-99999L;
			Map processurl				=	new HashMap<String,UserPermission>();	
			UserPermission			up	=	new UserPermission();
			up.starttime				=	new Date(999);
			up.overtime					=	new Date(new Date().getTime()*10);
			processurl.put("GET", up);
			processurl.put("POST", up);
			processurl.put("DELETE", up);
			processurl.put("PUT", up);
			session.setAttribute("usersessionFactory",sessionFactory);
			session.setAttribute("processurl",processurl);
		
			
			///====================================================================================
			List<Menu> menus	  	=	itemsRepository.seach(sessionFactory, new Menu(),"1=1");
			List<Appdb> apps	=	itemsRepository.seach(sessionFactory, new Appdb(),"1=1");
			Set<UserMenu> mset 	=	new HashSet();
			Set<UserApp> aset 	=	new HashSet();
			for(Menu r: menus) {
				UserMenu um=new UserMenu();
				um.data = r;
				um.db	=	r.id+"";
				mset.add(um);
			}
			for(Appdb r: apps) {
				UserApp ua = new UserApp();
				ua.data=r;
				ua.db=r.id+"";
				aset.add(ua);
			}
			u.apps=aset;
			u.menu=mset;
			//===================================================================================
			session.setAttribute("user",u);
			session.setAttribute("packages","com.snimay.app.vo");
			return u;
		}
		return null;
	}
	
	
	 /**
	  * 删除目录
	 * @author     : xxy
	 * @param dir
	 * @return
	 * @throws
	 */
	private static boolean deleteDir(File dir) {
        if (!dir.exists()) return false;
        if (dir.isDirectory()) {
            String[] childrens = dir.list();
            // 递归删除目录中的子目录下
            for (String child : childrens) {
                boolean success = deleteDir(new File(dir, child));
                if (!success) return false;
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }
	
	
	/**
	 * 获取数据
	 * @author     : xxy
	 * @return
	 * @throws
	 */
	public Map<String, String> getMapProps() {
		return mapProps;
	}
	/**
	 * 设置数据
	 * @author     : xxy
	 * @param mapProps
	 * @throws
	 */
	public void setMapProps(Map<String, String> mapProps) {
		this.mapProps = mapProps;
	}

	
	
	
	
	
	
}

package com.snimay.common.exception;

 
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.snimay.app.vo.SysLog;
import com.snimay.app.vo.User;
import com.snimay.common.Ip;
import com.snimay.common.Status;
import com.snimay.common.ToWeb;
import com.snimay.hibernate.dao.ItemsRepository;

 

/**   
 * : 全局异常处理，捕获所有Controller中抛出的异常。 
 * @title      : GlobalExceptionHandler.java
 * @package    : com.snimay.util.exception
 * @author     : xxy
 * @date       : 2018年4月27日 下午12:03:58
 * @version    : V1.0   
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	@Autowired
	private SessionFactory sessionFactory;//全局系统读表连接
	@Autowired
	private HttpSession session;
	@Autowired
	ItemsRepository itemsRepository;
	
	/**
	 * : 处理自定义的异常
	 * @author     : xxy
	 * @param e
	 * @return
	 * @throws
	 */
	@ExceptionHandler(BaseException.class)
	@ResponseBody
	public Object customHandler(BaseException e){
//		e.printStackTrace();
		
		return ToWeb.buildResult().status(e.getCode()).msg(e.getMessage());
	}
	
	/**
	 * : 其他未处理的异常
	 * @author     : xxy
	 * @param e
	 * @return
	 * @throws
	 */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Object exceptionHandler(Exception e){
		e.printStackTrace();
		ServletRequestAttributes requestAttributes 	= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request 					= requestAttributes.getRequest();
		String	path								= request.getServletPath();
		String	method								= request.getMethod();
		SysLog  log	=	new SysLog();
		User tempUser	=	new User();
		if(session.getAttribute("user")==null) {
			tempUser.username="游客";
			tempUser.id		 =(long) 0;
		}else {
			tempUser	=	(User) session.getAttribute("user");
		}
		log.user_	=	tempUser.username+"("+tempUser.id+")";
		log.url	=	path;
		log.method=	method;
		log.time=new Date();
		log.event_=e.getMessage();
		log.ip	=	Ip.toString(request);
		log.mac =Ip.getRequestSystemInfo(request)+","+Ip.getRequestBrowserInfo(request)+","+ Ip.getHostName(log.ip);
		itemsRepository.save(sessionFactory, log);
		return ToWeb.buildResult().status(Status.FAIL).msg("系统错误");
	}
	  
}

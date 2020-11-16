package com.snimay.common.exception;

/**   
 * : 自定义异常 
 * @title      : BaseException.java
 * @package    : com.snimay.util.exception
 * @author     : xxy
 * @date       : 2018年4月27日 下午12:03:15
 * @version    : V1.0   
 */
public class BaseException extends RuntimeException{
	
    /**
     * : 状态码 
     * @author     : xxy
     */
    private String code; 
    
    
    /**
     * 初始化
     * : TODO
     * @author     : xxy
     * @param message
     * @param code
     * @throws
     */
    public BaseException(String message, String code) {
        super(message);
        this.code = code;
    }

    /**
     * 获取状态吗
     * @author     : xxy
     * @return
     * @throws
     */
    public String getCode() {
        return code;
    }
}

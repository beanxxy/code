package org.activiti;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

/**   
 * @title      : GenericResponseWrapper.java
 * @package    : org.activiti
 * : TODO 
 * @author     : xxy
 * @date       : 2018年8月7日 上午10:17:52
 * @version    : V1.0   
 */
public class GenericResponseWrapper extends HttpServletResponseWrapper {
    private ByteArrayOutputStream output;
    private int contentLength;
    private String contentType;

    public GenericResponseWrapper(HttpServletResponse response) {
        super(response);
        output = new ByteArrayOutputStream();
    }

    public byte[] getData() {
        return output.toByteArray();
    }

    @Override
	public ServletOutputStream getOutputStream() {
        return new FilterServletOutputStream(output);
    }

    @Override
	public PrintWriter getWriter() {
        return new PrintWriter(getOutputStream(), true);
    }

    @Override
	public void setContentLength(int length) {
        this.contentLength = length;
        super.setContentLength(length);
    }

    public int getContentLength() {
        return contentLength;
    }

    @Override
	public void setContentType(String type) {
        this.contentType = type;
        super.setContentType(type);
    }

    @Override
	public String getContentType() {
        return contentType;
    }
} 

package com.snimay.compiler.compiler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

import javax.tools.SimpleJavaFileObject;

/**   
 * : 编译类配置 
 * @title      : MyJavaFileObject.java
 * @package    : com.snimay.compiler.compiler
 * @author     : xxy
 * @date       : 2018年8月7日 上午10:16:10
 * @version    : V1.0   
 */
public class MyJavaFileObject extends SimpleJavaFileObject {
    private String source;
    private ByteArrayOutputStream outPutStream;


    /**
     * 初始化
     * @author     : xxy
     * @param name
     * @param source
     * @throws
     */
    public MyJavaFileObject(String name, String source) {
        super(URI.create("String:///" + name + Kind.SOURCE.extension), Kind.SOURCE);
        this.source = source;
    }

    public MyJavaFileObject(String name, Kind kind){
        super(URI.create("String:///" + name + kind.extension), kind);
        source = null;
    }

    /**
     * 获取
     * @author     : xxy
     * @param ignoreEncodingErrors
     * @return
     * @throws
     */
    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors){
        if(source == null){
            throw new IllegalArgumentException("source == null");
        }
        return source;
    }

    @Override
    public OutputStream openOutputStream() throws IOException {
        outPutStream = new ByteArrayOutputStream();
        return outPutStream;
    }

    public byte[] getCompiledBytes(){
        return outPutStream.toByteArray();
    }
}
package com.snimay.compiler.compiler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;


/**   
 * : 热更新 
 * @title      : MyClassloader.java
 * @package    : com.snimay.compiler.compiler
 * @author     : xxy
 * @date       : 2018年8月7日 上午10:16:01
 * @version    : V1.0   
 */
public class MyClassloader extends ClassLoader {  
	  
    private String basedir; // 需要该类加载器直接加载的类文件的基目录  
    private HashSet dynaclazns; // 需要由该类加载器直接加载的类名  
  
    public MyClassloader(String basedir, String[] clazns) {  
        super(null); // 指定父类加载器为 null  
        this.basedir = basedir;  
        dynaclazns = new HashSet();  
        loadClassByMe(clazns);  
    }  
  
    /**
     * 加载
     * @author     : xxy
     * @param clazns
     * @throws
     */
    private void loadClassByMe(String[] clazns) {  
        for (int i = 0; i < clazns.length; i++) {  
            loadDirectly(clazns[i]);  
            dynaclazns.add(clazns[i]);  
        }  
    }  
  
    /**
     * 加载包
     * @author     : xxy
     * @param name
     * @return
     * @throws
     */
    private Class loadDirectly(String name) {  
        Class cls = null;  
        StringBuffer sb = new StringBuffer(basedir);  
        String classname = name.replace('.', File.separatorChar) + ".class";  
        sb.append(File.separator + classname);  
        File classF = new File(sb.toString()); 
        try {  
            cls = instantiateClass(name, new FileInputStream(classF),  
                    classF.length());  
        } catch (FileNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return cls;  
    }  
  
    /**
     * 读取
     * @author     : xxy
     * @param name
     * @param fin
     * @param len
     * @return
     * @throws
     */
    private Class instantiateClass(String name, InputStream fin, long len) {  
        byte[] raw = new byte[(int) len];  
        try {  
            fin.read(raw);  
            fin.close();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
  
        return defineClass(name, raw, 0, raw.length);  
    }  
  
    /**
     * 加载类
     * @author     : xxy
     * @param name
     * @param resolve
     * @return
     * @throws ClassNotFoundException
     * @throws
     */
    protected Class loadClass(String name, boolean resolve)  
            throws ClassNotFoundException {  
        Class cls = null;  
        cls = findLoadedClass(name);  
        if (!this.dynaclazns.contains(name) && cls == null)  
            cls = getSystemClassLoader().loadClass(name);  
        if (cls == null)  
            throw new ClassNotFoundException(name);  
        if (resolve)  
            resolveClass(cls);  
        return cls;  
    }  
}  

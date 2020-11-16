package com.snimay.compiler.compiler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.tools.DiagnosticCollector;
import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;

 

/**   
 * : 新建java 的*.class 
 * @title      : JavaFile.java
 * @package    : com.snimay.javacompiler.compiler
 * @author     : xxy
 * @date       : 2018年5月28日 下午4:53:32
 * @version    : V1.0   
 */
public class JavaFile {
	public static void main( String[] args ) {
		JavaFile jf	=	new JavaFile();
		String code = 
			"package com.snimay.app.vo;\r\n" + 
			"import com.snimay.hibernate.Annotation.*;\r\n" + 
			"public class te {\r\n" + 
			"	public void hello(){\r\n" + 
			"		\r\n" + 
			"	}\r\n" + 
			"}\r\n" + 
			"";
		
		 Class clazz = new JavaFile().compiler(code);
		 System.out.println(clazz.getName());
	}
	private static Map<String, JavaFileObject> fileObjects = new ConcurrentHashMap<>();
	/**
     * 无保存生成类
     * @param code
     * @return
     */
    public Class compiler(String code) {
    	 JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
         DiagnosticCollector<JavaFileObject> collector = new DiagnosticCollector<>();
         JavaFileManager javaFileManager = new MyJavaFileManager(compiler.getStandardFileManager(collector, null, null));
         List<String> options = new ArrayList<>();
         //options.add("-cp");
       //  options.add("C:/hibannotation.jar");
         options.add("-target");
         options.add("1.8");
         options.addAll(Arrays.asList("-d",JavaFile.class.getClassLoader().getResource("").getPath()));  
         Pattern CLASS_PATTERN = Pattern.compile("class\\s+([$_a-zA-Z][$_a-zA-Z0-9]*)\\s*");
         Matcher matcher = CLASS_PATTERN.matcher(code);
         String cls;
         if(matcher.find()){
             cls = matcher.group(1);
         } else{
             throw new IllegalArgumentException("No such class name in " + code);
         }

         JavaFileObject javaFileObject = new MyJavaFileObject(cls, code);
         Boolean result = compiler.getTask(null, javaFileManager, collector, options, null, Arrays.asList(javaFileObject)).call();
         
         Class<?> clazz = null;
         ClassLoader classloader = new MyClassLoader();
         try {
             clazz  = classloader.loadClass("com.snimay.app.vo."+cls);
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }
         return clazz;
    }
    public static class MyClassLoader extends ClassLoader {

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            JavaFileObject fileObject = fileObjects.get(name);
            if(fileObject != null){
                byte[] bytes = ((MyJavaFileObject)fileObject).getCompiledBytes();
                return defineClass(name, bytes, 0, bytes.length);
            }
            try{
                return ClassLoader.getSystemClassLoader().loadClass(name);
            } catch (Exception e){
                return super.findClass(name);
            }
        }
    }
    public static class MyJavaFileManager extends ForwardingJavaFileManager<JavaFileManager> {
        protected MyJavaFileManager(JavaFileManager fileManager) {
            super(fileManager);
        }

        @Override
        public JavaFileObject getJavaFileForInput(Location location, String className, JavaFileObject.Kind kind) throws IOException {
            JavaFileObject javaFileObject = fileObjects.get(className);
            if(javaFileObject == null){
                super.getJavaFileForInput(location, className, kind);
            }
            return javaFileObject;
        }

        @Override
        public JavaFileObject getJavaFileForOutput(Location location, String qualifiedClassName, JavaFileObject.Kind kind, FileObject sibling) throws IOException {
            JavaFileObject javaFileObject = new MyJavaFileObject(qualifiedClassName, kind);
            fileObjects.put(qualifiedClassName, javaFileObject);
            return javaFileObject;
        }
    }
	/**
	 * : TODO
	 * @author     : 设置代码有保存生成类
	 * @param code
	 * @return
	 * @throws
	 */
	public String setFile(String code) {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
       // DiagnosticCollector<JavaFileObject> collector = new DiagnosticCollector<>();
        List<String> options = new ArrayList<>();
        String classPath = JavaFile.class.getClassLoader().getResource("").getPath();
        options.addAll(Arrays.asList("-g","-d",classPath));  
       // System.out.println(App.class.getClassLoader().getResource("").getPath());
        Pattern CLASS_PATTERN = Pattern.compile("class\\s+([$_a-zA-Z][$_a-zA-Z0-9]*)\\s*");
        Matcher matcher = CLASS_PATTERN.matcher(code);
        String cls;
        if(matcher.find()){
            cls = matcher.group(1);
        } else{
            throw new IllegalArgumentException("No such class name in " + code);
        }
        JavaFileObject javaFileObject = new MyJavaFileObject(cls, code);
        if(compiler!=null)
        compiler.getTask(null, null, null/*collector*/, options, null, Arrays.asList(javaFileObject)).call();
        //System.out.println(result);
        return classPath;
	}
}

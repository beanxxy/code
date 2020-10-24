package alarm.app.engine;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date currentTime = dfs.parse(dfs.format(new Date()));
		//2020-05-18 05:04:52
		Date begin 	= dfs.parse("2020-05-18 05:04:52") ;
		Date end 	= currentTime;//现在系统当前时间 
		System.out.println(begin.getTime());
		System.out.println(end.getTime());
    	long l = (end.getTime() - begin.getTime())  ;
    	long day = l / (24 * 60 * 60 * 1000);
        long hour = (l / (60 * 60 * 1000) - day * 24);
        long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
    	
    	System.out.println(s);
	}
}

package alarm.app.engine;

import java.text.ParseException;

public class Start extends Thread{
    public void run(){
        while(true){
            //System.out.println("%ddddfdfdf");
            Scan s = new Scan();
            s.start();
            try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
}

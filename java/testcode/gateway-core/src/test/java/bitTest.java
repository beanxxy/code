
public class bitTest {
	public static int setInt(int index,int num,int value) {
		int tmp = 1 << index;
		if(value==0) {
			return ~tmp & num;
		}else {
			return tmp | num;
		} 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		int t = 65535;
		System.out.println(Short.parseShort("49160"));
		//System.out.println(t=setInt(15,0,1));
		//int tmp = 0;
		//for(int i=0;i<16;i++) {
			//System.out.println(t=setInt(i,t,0));
		//}
		
	 
	}

}

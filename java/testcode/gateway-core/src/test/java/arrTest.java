
public class arrTest {
	public static void main(String[] arg) {
		byte[] bts = new byte[100];
		for(int i=0;i<100;i++) {
			bts[i] = (byte) i;
		}
		
		byte[] bt = new byte[20];
		byte[] bts1000 = new byte[1000];
		System.arraycopy(bts, 9, bts1000, 0, 20);
		System.arraycopy(bts, 1, bts1000, 20, 30);
		for(int i=0;i<50;i++) {
			 System.out.println(bts1000[i]);
		}
	}
}

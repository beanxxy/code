import gateway.core.util.CRC16;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class Testbuffer {
	public static void main(String[] args) {
		ByteBuf dat = Unpooled.buffer(20);
		ByteBuf src = Unpooled.buffer(1);
		src.writeByte(15);
		System.out.println(CRC16.bytesToHex(dat.array()));
		System.out.println(CRC16.bytesToHex(src.array()));
		
		System.out.println(src.array().length);
		dat.writeBytes(src,0,src.array().length);
		dat.writeBytes(src,0,1);
		dat.writeBytes(src,0,1);
		//dat.writeBytes(src,0,2);
		//dat.writeBytes(src,0,2);
		System.out.println(CRC16.bytesToHex(dat.array()));
	}
}

package gateway.core; 
import java.util.concurrent.CompletableFuture;

import gateway.core.config.Ioinfo;  
/**
 * @author bean
 * 2020��10��15��
 */
public interface Client {
	/**
	 * �����ͻ���
	 * 
	 * @param address
	 * @return
	 */
	public static Client create(Ioinfo address) {
		return null;
	}
	
	/**
     * ������ȡ
     *
     * @param address ��Ԫ����ַ
     * @return ���Future
     */
    CompletableFuture<String> batchRead(Ioinfo address);

    /**
     * ����д��
     *
     * @param address ��Ԫ����ַ
     * @param data    д������
     * ByteBuf data
     * @return ���Future
     */
    CompletableFuture<Void> batchWrite(Ioinfo address, String data);
}

package gateway.core; 
import java.util.concurrent.CompletableFuture;

import gateway.core.config.AddressConfig;  
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
	public static Client create(AddressConfig address) {
		return null;
	}
	
	/**
     * ������ȡ
     *
     * @param address ��Ԫ����ַ
     * @return ���Future
     */
    CompletableFuture<String> batchRead(AddressConfig address);

    /**
     * ����д��
     *
     * @param address ��Ԫ����ַ
     * @param data    д������
     * ByteBuf data
     * @return ���Future
     */
    CompletableFuture<Void> batchWrite(AddressConfig address, String data);
}

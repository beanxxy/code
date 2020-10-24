package alarm.app.engine;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

public class SendMsg extends Thread{
	
	/*String phone;
	String name;
	String stand;
	String val;
	String model;
	public void set (
		String phone,
		String name,
		String stand,
		String val,
		String model) { 
		this.phone  = phone;
		this.name	= name;
		this.stand  = stand;
		this.val	= val;
		this.model	= model;
	}
	public void run() {
		DefaultProfile profile 	= DefaultProfile.getProfile("cn-hangzhou", "LTAI4G5Nqxw3FWDkVRi6NEzD", "ZkCiB9kCdKzG1HqE92yndpChO03y1J");
        IAcsClient client 		= new DefaultAcsClient(profile); 
        CommonRequest request 	= new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "丹冶内部短信"); 
        request.putQueryParameter("TemplateCode", model);
        request.putQueryParameter("TemplateParam", "{\"name\":\""
    		+name+ "\",\"value\":\""
    		+stand+ "\",\"val\":\""
    		+val+ "\"}");
        try {
            CommonResponse response = client.getCommonResponse(request); 
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        } 
	}
	
	public void text() {
		DefaultProfile profile 	= DefaultProfile.getProfile("cn-hangzhou", "LTAI4G5Nqxw3FWDkVRi6NEzD", "ZkCiB9kCdKzG1HqE92yndpChO03y1J");
        
		IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", "13553666941");
        request.putQueryParameter("SignName", "丹冶内部数据");
        request.putQueryParameter("TemplateCode", "SMS_192300085");
        request.putQueryParameter("TemplateParam", "{\"name\":\"12\",\"value\":\"23\",\"val\":\"23\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
	}*/
	public static int set(
		String phone,
		String name,
		String stand,
		String val,
		String model,
		String time) { 
		DefaultProfile profile 	= DefaultProfile.getProfile("cn-hangzhou", "LTAI4G5Nqxw3FWDkVRi6NEzD", "ZkCiB9kCdKzG1HqE92yndpChO03y1J");
        IAcsClient client 		= new DefaultAcsClient(profile); 
        CommonRequest request 	= new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "丹冶内部短信"); 
        request.putQueryParameter("TemplateCode", model);
        request.putQueryParameter("TemplateParam", "{\"name\":\""
    		+name+ "\",\"value\":\""
    		+stand+ "\",\"val\":\""
    		+val+ "\",\"time\":\""
    	  +time	+ "\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            
            return 0;
            //System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return 1;
	}
}

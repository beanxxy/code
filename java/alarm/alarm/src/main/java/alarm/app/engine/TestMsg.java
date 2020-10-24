package alarm.app.engine;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
/*
pom.xml
<dependency>
  <groupId>com.aliyun</groupId>
  <artifactId>aliyun-java-sdk-core</artifactId>
  <version>4.5.0</version>
</dependency>
*/
public class TestMsg {
    public static void main(String[] args) {
        DefaultProfile profile 	= DefaultProfile.getProfile("cn-hangzhou", "LTAI4G5Nqxw3FWDkVRi6NEzD", "ZkCiB9kCdKzG1HqE92yndpChO03y1J");
        IAcsClient client 		= new DefaultAcsClient(profile);

        CommonRequest request 	= new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", "13553666941");
        request.putQueryParameter("SignName", "丹冶内部短信"); 
        request.putQueryParameter("TemplateCode", "SMS_190272610");
        request.putQueryParameter("TemplateParam", "{\"name\":\"钴\",\"value\":\"1212.12\",\"val\":\"09.23\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}

package com.snimay.swagger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

 
/**   
 * :  Swagger2 配置
 * @title      : Swagger2.java
 * @package    : com.snimay.swagger
 * @author     : xxy
 * @date       : 2018年8月7日 上午10:18:47
 * @version    : V1.0   
 */
@Configuration
public class Swagger2 {

	/**
	 * 配置
	 * @author     : xxy
	 * @return
	 * @throws
	 */
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.snimay.app"))
				.paths(PathSelectors.any())
				.build();
	}
	
	/**
	 * 设置
	 * @author     : xxy
	 * @return  
	 * @throws
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("mes")
				.description("当前后台接口")
				.termsOfServiceUrl("哈哈")
				.version("1.0")
				.build();
	}
}
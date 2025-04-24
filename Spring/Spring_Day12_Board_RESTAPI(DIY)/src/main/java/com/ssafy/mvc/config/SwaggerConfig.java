package com.ssafy.mvc.config;

//Swagger(OpenAPI 3)를 설정하기 위한 Configuration 클래스
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//Swagger(OpenAPI) 라이브러리에서 사용하는 클래스
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration  // Spring 설정 클래스임을 명시
public class SwaggerConfig {
	 @Bean  // Swagger 문서에서 사용할 OpenAPI 객체를 Bean으로 등록함
	  public OpenAPI springBoardOpenAPI() {
	      return new OpenAPI()  // OpenAPI 객체 생성 + Info 객체 설정
	              .info(new Info().title("SpringBoard API")  // API 문서 제목 설정
	              .description("Spring Boot Board REST API")  // API 문서 설명
	              .version("v0.0.1")  // 버전 설정
	              .license(new License().name("SSAFY").url("https://www.ssafy.com")));  // 라이선스 설정
	  }
}

package com.ssafy.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
// 최상위 폴더 위치 강력 권장
@SpringBootApplication  // 요안에 component-scan이 있음
public class Spring04HelloBootApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Spring04HelloBootApplication.class, args);
		
//		// SpringApplication에 있는 bean 출력
//		for(String bean : context.getBeanDefinitionNames()) {
//			System.out.println(bean);
//		}
		
	}

}

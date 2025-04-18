package com.ssafy.mvc.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ssafy.mvc.model.dao")  // MyBatis에서 사용하는 DAO 인터페이스들을 자동으로 스캔해서 빈으로 등록해줌
public class DBConfig {

}

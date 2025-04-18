package com.ssafy.board.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConfig {
	private static SqlSessionFactory factory;

	static {  // factory 채우기 (초기가 null임)
		// factory 건설하면
		String resource = "mybatis-config.xml";  // xml파일이 자원임
		try (InputStream inputStream = Resources.getResourceAsStream(resource)) {
			factory = new SqlSessionFactoryBuilder().build(inputStream);
			System.out.println("공장 건설 완료");
		} catch (IOException e) {
			System.out.println("공장 건설 실패");
		}
	}

	public static SqlSessionFactory getFactory() {
		return factory;
	}
}

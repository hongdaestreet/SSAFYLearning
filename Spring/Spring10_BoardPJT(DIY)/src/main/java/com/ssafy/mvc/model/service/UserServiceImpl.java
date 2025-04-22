package com.ssafy.mvc.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.mvc.model.dao.UserDao;
import com.ssafy.mvc.model.dto.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired  // UserDAO 의존성 주입
	private UserDao userDao;
	
	@Override  // 적성자 리스트 출력
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return userDao.selectAll();
	}

	@Override  // 회원 가입
	public void signup(User user) {
		userDao.insertUser(user);  // 유저 추가
	}

	@Override  // 로그인 - 유저의 id,pw 반환
	public User login(String id, String password) {
		Map<String,String> info = new HashMap<>();
		info.put("id",id);
		info.put("password",password);  
		// 비밀번호 확인 : SQL을 이용하여 DB에서 맞는 데이터를 들고 올수도 있지만 
		// 일단 ID로 객체 들고와서 비밀번호인지 판단할 수 있음
		User tmp = userDao.selectOne(info);
		System.out.println(tmp);
		return tmp;
	}

}

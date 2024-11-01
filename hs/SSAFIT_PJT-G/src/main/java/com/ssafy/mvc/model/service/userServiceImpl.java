package com.ssafy.mvc.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.mvc.model.dao.userDao;
import com.ssafy.mvc.model.dto.User;

@Service
public class userServiceImpl implements userService{
	
	//dao에 대한 의존성 부여
	private final userDao dao;
	public userServiceImpl(userDao dao) {
		this.dao = dao;
	}

	// 회원가입 -> 가입이 완료가 되었으면 1이 맞다 -> 건드린 데이터의 갯수
	@Override
	public boolean regist(User user) {
		int result = dao.insertUser(user);
		return result ==1;
		
	}

	// 회원인지 확인 : 정보를 가져와서 컨트롤러에서 매칭, 여기서는 데이터를 가져오는 것만
	@Override
	public User read(User user) {
		User checkUser = dao.selectOne(user);
		return checkUser;
	}

}

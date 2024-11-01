package com.ssafy.mvc.model.service;

import com.ssafy.mvc.model.dto.User;

public interface userService {
	
	//회원가입, 회원가입이 잘 됐으면 1 반환
	public boolean regist(User user);
	//회원정보 확인
	public User read(User user);
}

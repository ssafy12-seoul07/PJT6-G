package com.ssafy.mvc.model.dao;

import com.ssafy.mvc.model.dto.User;

public interface userDao {
	//회원가입(insert)과 로그인(selectOne)
	//회원 가입 : 아이디 비밀번호 등록 -> insert
	//아이디 확인 후, 회원만 서비스 사용, 비회원은 계속 로그인에 머물기 
	//-> select id를 해서 입력받은 값과 확인 -> Read
	
	//회원가입을 위한 id, pw 등록
	//등록이 되었으면 1 출력
	public int insertUser(User user);
	
	//회원 비회원을 판단하기위한 회원정보 확인
	public User selectOne(User user);
	
	
	

}

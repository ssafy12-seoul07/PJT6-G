package com.ssafy.mvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.model.dto.User;
import com.ssafy.mvc.model.service.userService;

@RestController
@RequestMapping("/api-user")
@CrossOrigin("*")
public class userController {
	//service에 대한 의존성 부여, 어노테이션 자동 할당
	private final userService userService;

	public userController(userService userService) {
		this.userService = userService;
	}
	
	//기능 구현 시작
	
	//1. 회원 가입 : form으로 입력 	받는다고 가정 -> post method
	//User의 형태로 form을 보냈음
	@PostMapping("/regist")
	public ResponseEntity<?> regist(@ModelAttribute  User user){
		System.out.println(user);
		User check = userService.read(user);
		if(check == null) {
			//새로운 정보일 경우에만 등록
			//제대로 가입이 되었을 경우
			if(userService.regist(user)) return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		//제대로 회원 가입이 안되었을 경우, 
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("이미 존재하는 회원정보입니다. 다시 시도하세요.");
		
	}
	
	//기존의 등록된 회원 정보를 읽어옴// form
	@PostMapping("/check")
	public ResponseEntity<?> check(@ModelAttribute  User user){
		System.out.println(user);
		User tmp = userService.read(user);
		System.out.println(tmp);
		if(tmp == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("없는 회원정보입니다.");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body("로그인 성공");
		
	}
	
	@GetMapping("")
	public ResponseEntity<?> main(){
		return ResponseEntity.status(HttpStatus.OK).body("로그인 하세요.");
		
	}

}

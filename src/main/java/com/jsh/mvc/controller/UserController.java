package com.jsh.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsh.mvc.memberDto.MemberDto;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/register")
	public String register(MemberDto memberDto) {
		//회원가입
		
		//암호화 후 저장
		
		return "";
	}
	
	@RequestMapping("/login")
	public String loginTest(MemberDto memberDto) {
		//로그인
		
		//입력된 pw암호화 후 DB값과 비교
		
		//세션 처리 해주기
		
		return "";
	}
}

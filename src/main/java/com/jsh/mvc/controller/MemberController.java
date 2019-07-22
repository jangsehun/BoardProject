package com.jsh.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsh.mvc.memberDto.MemberDto;
import com.jsh.mvc.memberService.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/register")
	public String register(MemberDto memberDto) throws Exception {
		System.out.println(memberDto.getMember_no());
		System.out.println(memberDto.getMember_id());
		System.out.println(memberDto.getMember_pw());
		System.out.println(memberDto.getMember_email());
		System.out.println(memberDto.getMember_nickName());
		System.out.println(memberDto.getMember_authKey());
		System.out.println(memberDto.getMember_authStatus());
		
		
		//service 단에서 처리 해야할것들
		memberService.insertMember(memberDto);
		//임시키(암호화 키) 생성
		
		//email(암호화 키) 발송
		
		//DB에 암호화 후(pw) insert(회원가입)
		
		//이메일 발송 됬다는 페이지로 이동
		return "memberPage/register";
	}
	
	@RequestMapping("/login")
	public String loginTest(MemberDto memberDto) {
		//로그인
		
		//입력된 pw암호화 후 DB값과 비교
		
		//세션 처리 해주기
		
		return "";
	}
}

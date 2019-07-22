package com.jsh.mvc.memberService;

import com.jsh.mvc.memberDto.MemberDto;

public interface MemberService {
	
	//회원가입 관련
	public void insertMember(MemberDto memberDto) throws Exception;
	
	//로그인 관련
	public MemberDto login(MemberDto memberDto);
	
	//이메일 인증 관련 
	public void updateAuthStatus(MemberDto memberDto);
	
	//public int updateMember(MemberDto memberDto);
	
	//public int deleteMember(int member_no);
}

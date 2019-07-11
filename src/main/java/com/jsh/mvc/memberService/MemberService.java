package com.jsh.mvc.memberService;

import com.jsh.mvc.memberDto.MemberDto;

public interface MemberService {
	
	public void insertMember(MemberDto memberDto);
	
	public MemberDto login(MemberDto memberDto);
	
	//public int updateMember(MemberDto memberDto);
	
	//public int deleteMember(int member_no);
}

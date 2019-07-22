package com.jsh.mvc.memberDao;

import com.jsh.mvc.memberDto.MemberDto;

public interface MemberDao {
	
	String MEMBER = "member.";
	
	public int insert(MemberDto memberDto);
	
	public MemberDto login(MemberDto memberDto);
}

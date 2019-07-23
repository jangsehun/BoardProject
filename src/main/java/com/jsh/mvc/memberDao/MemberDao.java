package com.jsh.mvc.memberDao;

import java.util.Map;

import com.jsh.mvc.memberDto.MemberDto;

public interface MemberDao {
	
	String MEMBER = "member.";
	
	public int insert(MemberDto memberDto);
	
	public int updateAuthKey(Map<String, String> paramMap);
	
	public int updateAuthStutus(Map<String, String> paramMap);
	
	public MemberDto login(MemberDto memberDto);
}

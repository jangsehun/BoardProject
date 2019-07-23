package com.jsh.mvc.memberDao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsh.mvc.memberDto.MemberDto;

@Repository
public class MemberDao_impl implements MemberDao{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(MemberDto memberDto) {
		System.out.println(memberDto.getMember_no());
		System.out.println(memberDto.getMember_id());
		System.out.println(memberDto.getMember_pw());
		System.out.println(memberDto.getMember_email());
		System.out.println(memberDto.getMember_nickName());
		System.out.println(memberDto.getMember_authKey());
		System.out.println(memberDto.getMember_authStatus());
		memberDto.setMember_authKey("0");
		memberDto.setMember_authStatus("0");
		System.out.println(memberDto.getMember_authKey());
		System.out.println(memberDto.getMember_authStatus());
		return sqlSession.insert(MEMBER+"insert", memberDto);
	}
	
	@Override
	public int updateAuthKey(Map<String, String> paramMap) {
		return sqlSession.update(MEMBER+"updateAuthKey", paramMap);
	}

	@Override
	public int updateAuthStutus(Map<String, String> paramMap) {
		return sqlSession.update(MEMBER+"updateAuthStatus", paramMap);
	}

	@Override
	public MemberDto login(MemberDto memberDto) {
		return sqlSession.selectOne(MEMBER+"login", memberDto);
	}

	

}

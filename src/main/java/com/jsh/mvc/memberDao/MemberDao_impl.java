package com.jsh.mvc.memberDao;

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
		return sqlSession.insert(MEMBER+"insert", memberDto);
	}

	@Override
	public MemberDto login(MemberDto memberDto) {
		return sqlSession.selectOne(MEMBER+"login", memberDto);
	}

}

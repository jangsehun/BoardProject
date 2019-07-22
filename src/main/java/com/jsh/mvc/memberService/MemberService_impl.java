package com.jsh.mvc.memberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsh.mvc.memberDao.MemberDao;
import com.jsh.mvc.memberDto.MemberDto;
import com.jsh.mvc.util.LoginSecurityUtil;
import com.jsh.mvc.util.TempKey;

@Service
public class MemberService_impl implements MemberService{
	
	@Autowired
	private MemberDao memberDao;

	@Transactional
	@Override
	public void insertMember(MemberDto memberDto) throws Exception{
		/* 정리
		 * --회원가입--
		 * 1. 비밀번호 암호화 
		 * 2. 회원가입(insert)
		 * 3. 인증키 생성
		 * 4. 인증키 해당회원 DB에 저장
		 * 5. 인증 이메일 발송
		 * 6. 이메일인증을 해달라는 페이지로 이동
		*/
		//1. 비밀번호 암호화 
		memberDto.setMember_pw(new LoginSecurityUtil().encryptPassword(memberDto.getMember_pw()));
		//2. 회원가입(insert)
		//memberDao.insert(memberDto);
		//3. 인증키 생성
		String tempKey = new TempKey().getKey(64, false);
		//4. 인증키 해당회원 DB에 저장
		memberDto.setMember_authKey(tempKey);
		//memberDao.updateAuthKey(memberDto);
		//5. 인증이메일 발송
		
		//6. 이메일인증을 해달라는 페이지로 이동
		
		
		/*
		 * --인증 이메일 발송 후--
		 * 1. 이메일 내 링크 클릭
		 * 2. 이메일/인증키를 매개변수로 받아 이메일인증 함수로 이동
		 * 3. 이메일/인증키를 이용하여 DB내에 해당 member의 인증상태를 업데이트(1)
		 * 4. 이메일 인증이 완료되었다는 알림 또는 페이지를 보여준다.(또는 alert을 통해 [이메일 인증 성공] 후 로그인페이지로 이동)
		*/
		
		
		/*
		 * --인증 이메일 재발송--
		 * 1. 이메일 인증이 안된 member login
		 * 2. 이메일 인증 여부 확인
		 * 3. 재발송 시 인증키 재생성
		 * 4. 해당 member의 DB에 인증키 재삽입
		 * 5. 인증 이메일 재발송
		 * 6. 이메일인증을 해달라는 페이지로 이동
		 */
	}

	@Override
	public MemberDto login(MemberDto memberDto) {
		return null;
	}

	@Override
	public void updateAuthStatus(MemberDto memberDto) {
		
	}

}

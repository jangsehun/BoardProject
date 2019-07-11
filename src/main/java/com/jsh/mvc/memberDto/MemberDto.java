package com.jsh.mvc.memberDto;

import java.sql.Date;

public class MemberDto {

	private int member_no;
	private String member_id;
	private String member_pw;
	private String member_email;
	private String member_nickName;
	private String member_authKey;
	private String member_authStatus;
	private Date member_regDate;
	
	public MemberDto() {
		
	}
	
	public MemberDto(int member_no, String member_id, String member_pw, String member_email, String member_nickName, String member_authKey, String member_authStatus, Date member_regDate) {
		this.member_no = member_no;
		this.member_id = member_id;
		this.member_pw = member_pw;
		this.member_email = member_email;
		this.member_nickName = member_nickName;
		this.member_authKey = member_authKey;
		this.member_authStatus = member_authStatus;
		this.member_regDate = member_regDate;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pw() {
		return member_pw;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public String getMember_nickName() {
		return member_nickName;
	}

	public void setMember_nickName(String member_nickName) {
		this.member_nickName = member_nickName;
	}

	public String getMember_authKey() {
		return member_authKey;
	}

	public void setMember_authKey(String member_authKey) {
		this.member_authKey = member_authKey;
	}

	public String getMember_authStatus() {
		return member_authStatus;
	}

	public void setMember_authStatus(String member_authStatus) {
		this.member_authStatus = member_authStatus;
	}

	public Date getMember_regDate() {
		return member_regDate;
	}

	public void setMember_regDate(Date member_regDate) {
		this.member_regDate = member_regDate;
	}
	
}

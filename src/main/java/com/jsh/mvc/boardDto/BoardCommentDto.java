package com.jsh.mvc.boardDto;

import java.sql.Date;

public class BoardCommentDto {
	private int board_comment_no;
	private int board_no;
	private int board_comment_group;
	private String user_id;
	private String board_comment_content;
	private Date board_comment_regDate;
	
	public BoardCommentDto() {
		
	}
	
	public BoardCommentDto(int board_comment_no, int board_no, int board_comment_group, String user_id, String board_comment_content, Date board_comment_regDate) {
		this.board_comment_no = board_comment_no;
		this.board_no = board_no;
		this.board_comment_group = board_comment_group;
		this.user_id = user_id;
		this.board_comment_content = board_comment_content;
		this.board_comment_regDate = board_comment_regDate;
	}
	
	public int getBoard_comment_no() {
		return board_comment_no;
	}

	public void setBoard_comment_no(int board_comment_no) {
		this.board_comment_no = board_comment_no;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public int getBoard_comment_group() {
		return board_comment_group;
	}

	public void setBoard_comment_group(int board_comment_group) {
		this.board_comment_group = board_comment_group;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getBoard_comment_content() {
		return board_comment_content;
	}

	public void setBoard_comment_content(String board_comment_content) {
		this.board_comment_content = board_comment_content;
	}

	public Date getBoard_comment_regDate() {
		return board_comment_regDate;
	}

	public void setBoard_comment_regDate(Date board_comment_regDate) {
		this.board_comment_regDate = board_comment_regDate;
	}

}

package com.jsh.mvc.boardDto;

import java.sql.Date;

public class BoardDto {
	private int board_no;
	private String board_category;
	private String board_writer;
	private String board_title;
	private String board_content;
	private int board_views;
	private Date board_regDate;
	
	
	public BoardDto() {
		
	}
	
	public BoardDto(int board_no, String board_category, String board_writer, String board_title, String board_content,int board_views, Date board_regDate) {
		this.board_no = board_no;
		this.board_category = board_category;
		this.board_writer = board_writer;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_views = board_views;
		this.board_regDate = board_regDate;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	
	public String getBoard_category() {
		return board_category;
	}
	
	public void setBoard_category(String board_category) {
		this.board_category = board_category;
	}
	
	public String getBoard_writer() {
		return board_writer;
	}

	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	
	public int getBoard_views() {
		return board_views;
	}
	
	public void setBoard_views(int board_views) {
		this.board_views = board_views;
	}
	
	public Date getBoard_regDate() {
		return board_regDate;
	}
	
	public void setBoard_regDate(Date board_regDate) {
		this.board_regDate = board_regDate;
	}

}

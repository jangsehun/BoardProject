package com.jsh.mvc.dao;

import java.util.List;
import java.util.Map;

import com.jsh.mvc.dto.BoardDto;

public interface BoardDao {
	
	String BOARD = "board.";
	
	public int totalCount();
	
	public int viewCount(int board_no);
	
	//public List<BoardDto> list(int page, int countList, String category);
	
	public List<BoardDto> list(Map<String, Object> paramMap);
	
	public BoardDto detail(int board_no);
	
	public int insert(BoardDto boardDto);
	
	public int update(BoardDto boardDto);
	
	public int delete(int board_no);
	
}

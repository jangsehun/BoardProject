package com.jsh.mvc.boardService;

import java.util.List;

import com.jsh.mvc.boardDto.BoardCommentDto;
import com.jsh.mvc.boardDto.BoardDto;

public interface BoardService {
	//pagination에 필요한 totalcount
	public int getBoardTotalCount(String category);
	
	//게시판 관련
	public List<BoardDto> getBoardList(int page, int countList, String category);
	
	public BoardDto getBoardDetail(int board_no);
	
	public int boardInsert(BoardDto boardDto);
	
	public int boardUpdate(BoardDto boardDto);
	
	public boolean boardDelete(int board_no);
	
	//댓글 관련 
	public List<BoardCommentDto> getBoardCommentList(int board_no);
	
	public BoardCommentDto getBoardCommentDetail(int board_comment_no);
	
	public int boardCommentInsert(BoardCommentDto boardCommentDto);
	
	public int boardCommentUpdate(BoardCommentDto boardCommentDto);
	
	public boolean boardCommentDelete(int board_comment_no);
}

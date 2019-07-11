package com.jsh.mvc.boardDao;

import java.util.List;

import com.jsh.mvc.boardDto.BoardCommentDto;

public interface CommentDao {
		String COMMENT = "comment.";
		
		public int totalCount(int board_no);
		
		public List<BoardCommentDto> list(int board_no);
		
		public BoardCommentDto detail(int board_comment_no);
			
		public int insert(BoardCommentDto boardCommentDto);
			
		public int update(BoardCommentDto boardCommentDto);
			
		public int delete(int board_comment_no);
		
		public int deleteList(int board_no);

}

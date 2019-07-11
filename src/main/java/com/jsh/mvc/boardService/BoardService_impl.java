package com.jsh.mvc.boardService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsh.mvc.boardDao.BoardDao;
import com.jsh.mvc.boardDao.CommentDao;
import com.jsh.mvc.boardDto.BoardCommentDto;
import com.jsh.mvc.boardDto.BoardDto;

@Service
public class BoardService_impl implements BoardService{
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private CommentDao commentDao;
	
	@Override
	public int getBoardTotalCount(String category) {
		return boardDao.totalCount(category);
	}

	@Override
	public List<BoardDto> getBoardList(int page, int countList, String category) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("page", page);
		paramMap.put("countList", countList);
		paramMap.put("category", category);
		return boardDao.list(paramMap);
	}
	
	@Override
	public BoardDto getBoardDetail(int board_no) {
		boardDao.viewCount(board_no);
		return boardDao.detail(board_no);
	}

	@Transactional
	@Override
	public int boardInsert(BoardDto boardDto) {
		return boardDao.insert(boardDto);
	}

	@Transactional
	@Override
	public int boardUpdate(BoardDto boardDto) {
		return boardDao.update(boardDto);
	}

	@Transactional
	@Override
	public boolean boardDelete(int board_no) {
		//해당 글을 지우기전 해당글의 댓글 개수 확인
		int commentTotalCount = commentDao.totalCount(board_no);
		//해당 글에 댓글이 있다면
		if(commentTotalCount > 0) {
			//댓글들을 지워준다.
			commentDao.deleteList(board_no);
		}
		
		int resultDelete = boardDao.delete(board_no);
		
		if(resultDelete > 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public List<BoardCommentDto> getBoardCommentList(int board_no) {
		return commentDao.list(board_no);
	}
	
	@Override
	public BoardCommentDto getBoardCommentDetail(int board_comment_no) {
		return commentDao.detail(board_comment_no);
	}

	@Transactional
	@Override
	public int boardCommentInsert(BoardCommentDto boardCommentDto) {
		return commentDao.insert(boardCommentDto);
	}

	@Transactional
	@Override
	public int boardCommentUpdate(BoardCommentDto boardCommentDto) {
		return commentDao.update(boardCommentDto);
	}

	@Transactional
	@Override
	public boolean boardCommentDelete(int board_comment_no) {
		int resultCommentDelete = commentDao.delete(board_comment_no);
		if(resultCommentDelete > 0) {
			return true;
		}
		return false;
	}

	

}

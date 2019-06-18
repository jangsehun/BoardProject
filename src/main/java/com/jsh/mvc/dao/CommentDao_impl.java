package com.jsh.mvc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsh.mvc.dto.BoardCommentDto;

@Repository
public class CommentDao_impl implements CommentDao{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int totalCount(int board_no) {
		return sqlSession.selectOne(COMMENT+"totalCount", board_no);
	}
	
	@Override
	public List<BoardCommentDto> list(int board_no) {
		return sqlSession.selectList(COMMENT+"list", board_no);
	}
	
	@Override
	public BoardCommentDto detail(int board_comment_no) {
		return sqlSession.selectOne(COMMENT+"detail", board_comment_no);
	}

	@Override
	public int insert(BoardCommentDto boardCommentDto) {
		if(sqlSession.insert(COMMENT+"insert", boardCommentDto) > 0) {
			return boardCommentDto.getBoard_comment_no();
		}
		return 0;
	}

	@Override
	public int update(BoardCommentDto boardCommentDto) {
		if(sqlSession.insert(COMMENT+"update", boardCommentDto) > 0) {
			return boardCommentDto.getBoard_comment_no();
		}
		return 0;
	}

	@Override
	public int delete(int board_comment_no) {
		return sqlSession.insert(COMMENT+"delete", board_comment_no);
	}

	@Override
	public int deleteList(int board_no) {
		return sqlSession.delete(COMMENT+"deleteList", board_no);
	}

}

package com.jsh.mvc.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsh.mvc.dto.BoardDto;

@Repository
public class BoardDao_impl implements BoardDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int totalCount(String category) {
		return sqlSession.selectOne(BOARD+"totalCount", category);
	}
	
	@Override
	public int viewCount(int board_no) {
		return sqlSession.update(BOARD+"viewCount", board_no);
	}

	@Override
	public List<BoardDto> list(Map<String, Object> paramMap) {
		return sqlSession.selectList(BOARD+"list", paramMap);
	}
	
	@Override
	public BoardDto detail(int board_no) {
		return sqlSession.selectOne(BOARD+"detail", board_no);
	}

	@Override
	public int insert(BoardDto boardDto) {
		if(sqlSession.insert(BOARD+"insert", boardDto) > 0) {
			return boardDto.getBoard_no();
		}
		return 0;
	}

	@Override
	public int update(BoardDto boardDto) {
		if(sqlSession.update(BOARD+"update", boardDto) > 0) {
			return boardDto.getBoard_no();
		}
		return 0;
	}

	@Override
	public int delete(int board_no) {
		return sqlSession.delete(BOARD+"delete", board_no);
	}

	

	

	

	

	

}

package com.jsh.mvc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsh.mvc.dto.BoardCommentDto;
import com.jsh.mvc.dto.BoardDto;
import com.jsh.mvc.service.BoardService;
import com.jsh.mvc.util.Pagination;

@Controller
@RequestMapping("/board")
public class BoardContoller {
	
	@Autowired
	private BoardService boardService;

	//게시판 관련
	@RequestMapping("/{category}")
	public String board_list(Model model, @PathVariable("category") String category, @RequestParam(defaultValue="1")int page ) {
		int totalCount = boardService.getBoardTotalCount(category);
		Pagination pagination = new Pagination(totalCount, page);
		int countList = pagination.getCountList();
		
		model.addAttribute("category",category);
		model.addAttribute("pagination",pagination);
		model.addAttribute("board_list",boardService.getBoardList(page,countList,category));
		return "boardPage/board_list";
	}
	
	@RequestMapping("/{category}/{board_no}")
	public String board_detail(Model model, @PathVariable("category") String category ,@PathVariable("board_no") int board_no) {
		model.addAttribute("category", category);
		model.addAttribute("boardDto", boardService.getBoardDetail(board_no));
		model.addAttribute("boardComment_list", boardService.getBoardCommentList(board_no));
		return "boardPage/board_detail";
	}
	
	@RequestMapping("/{category}/insert")
	public String board_insertForm(Model model, @PathVariable("category") String category) {
		model.addAttribute("category", category);
		return "boardPage/board_insert";
	}
	
	@RequestMapping("/insert")
	public String board_insert(Model model, BoardDto boardDto) {
		int board_no = boardService.boardInsert(boardDto);
		 
		if(board_no != 0) {
			return "redirect:/board/"+boardDto.getBoard_category()+"/"+board_no;
		}
		//에러 페이지로 보내주자
		return "boardPage/board_insert";
	}
	
	@RequestMapping("/{category}/update/{board_no}")
	public String board_updateForm(Model model, @PathVariable("category") String category ,@PathVariable("board_no") int board_no) {
		model.addAttribute("category", category);
		model.addAttribute("boardDto",boardService.getBoardDetail(board_no));
		return "boardPage/board_update";
	}
	
	@RequestMapping("/update")
	public String board_update(Model model, String category, BoardDto boardDto) {
		int board_no = boardService.boardUpdate(boardDto);
		
		if(board_no != 0) {
			return "redirect:/board/"+category+"/"+board_no;
		}
		//에러 페이지로 보내주자
		return "boardPage/board_update";
	}
	
	@RequestMapping("/{category}/delete/{board_no}")
	public String board_delete(Model model, @PathVariable("category") String category, @PathVariable("board_no") int board_no) {
		if(boardService.boardDelete(board_no)) {
			return "redirect:/board/"+category;
		}
		return "redirect:/board/"+category+"/"+board_no;
	}
	
	//댓글 관련
	@RequestMapping("/comment/insert")
	public @ResponseBody BoardCommentDto comment_insert(BoardCommentDto boardCommentDto) {
		return boardService.getBoardCommentDetail(boardService.boardCommentInsert(boardCommentDto));
	}
	
	@RequestMapping("/comment/list")
	public @ResponseBody Object comment_list(int board_no){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("commentList",  boardService.getBoardCommentList(board_no));
		return resultMap;
	}
}

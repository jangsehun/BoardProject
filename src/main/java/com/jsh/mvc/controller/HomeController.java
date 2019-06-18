package com.jsh.mvc.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsh.mvc.biz.BoardBiz;
import com.jsh.mvc.dto.BoardCommentDto;
import com.jsh.mvc.dto.BoardDto;
import com.jsh.mvc.util.Pagination;

@Controller
public class HomeController {
	@Autowired
	private BoardBiz boardBiz;
	
	@RequestMapping("/")
	public String home(Locale locale, Model model) {
		return "index";
	}
	
	@RequestMapping("/board/{category}")
	public String board_list(Model model, @PathVariable String category , @RequestParam(defaultValue="1")int page ) {
		int totalCount = boardBiz.getBoardTotalCount();
		Pagination pagination = new Pagination(totalCount, page);
		int countList = pagination.getCountList();
		
		model.addAttribute("category",category);
		model.addAttribute("pagination",pagination);
		model.addAttribute("board_list",boardBiz.getBoardList(page,countList,category));
		return "board_list";
	}
	
	@RequestMapping("/board/{category}/{board_no}")
	public String board_detail(Model model, @PathVariable String category ,@PathVariable int board_no) {
		model.addAttribute("category", category);
		model.addAttribute("boardDto", boardBiz.getBoardDetail(board_no));
		model.addAttribute("boardComment_list", boardBiz.getBoardCommentList(board_no));
		return "board_detail";
	}
	
	@RequestMapping("/board/{category}/insert")
	public String board_insertForm(Model model, @PathVariable String category) {
		model.addAttribute("category", category);
		return "board_insert";
	}
	
	@RequestMapping("/board/insert")
	public String board_insert(Model model, BoardDto boardDto) {
		int board_no = boardBiz.boardInsert(boardDto);
		 
		if(board_no != 0) {
			return "redirect:/board/"+boardDto.getBoard_category()+"/"+board_no;
		}
		//에러 페이지로 보내주자
		return "board_insert";
	}
	
	@RequestMapping("/board/{category}/update/{board_no}")
	public String board_updateForm(Model model, @PathVariable String category ,@PathVariable int board_no) {
		model.addAttribute("category", category);
		model.addAttribute("boardDto",boardBiz.getBoardDetail(board_no));
		return "board_update";
	}
	
	@RequestMapping("/board/update")
	public String board_update(Model model, String category, BoardDto boardDto) {
		int board_no = boardBiz.boardUpdate(boardDto);
		
		if(board_no != 0) {
			return "redirect:/board/"+category+"/"+board_no;
		}
		
		return "board_update";
	}
	
	@RequestMapping("/board/{category}/delete/{board_no}")
	public String board_delete(Model model, @PathVariable String category, @PathVariable int board_no) {
		System.out.println(board_no);
		if(boardBiz.boardDelete(board_no)) {
			return "redirect:/board/"+category;
		}
		return "redirect:/board/"+category+"/"+board_no;
	}
	
	@RequestMapping("/board_comment_insert")
	public @ResponseBody BoardCommentDto comment_insert(BoardCommentDto boardCommentDto) {
		return boardBiz.getBoardCommentDetail(boardBiz.boardCommentInsert(boardCommentDto));
	}
	
}

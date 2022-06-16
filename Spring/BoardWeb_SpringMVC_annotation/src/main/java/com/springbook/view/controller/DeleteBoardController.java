package com.springbook.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class DeleteBoardController{

	@RequestMapping
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 삭제 처리 - Spring MVC Annotation 호출 - Controller 분리");
		
		boardDAO.deleteBoard(vo);
		
		return "redirect:getBoardList.do";
		//return "getBoardList.do";		//Forward로 이동
	}

}

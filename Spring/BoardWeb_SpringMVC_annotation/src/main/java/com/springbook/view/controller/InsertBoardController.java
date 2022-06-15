package com.springbook.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class InsertBoardController{
	
	@RequestMapping(value="/insertBoard.do")	//클라이언트 요청
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 등록 처리 - Spring MVC 어노테이션 작동 ");
		
		/* 값 확인을 위한 출력문
		System.out.println(vo.getTitle());
		System.out.println(vo.getWriter());
		System.out.println(vo.getContent());
		
		*/
		
		boardDAO.insertBoard(vo);
		
		return "getBoardList.do";		//forward 방식으로 넘어감
		
	}
}

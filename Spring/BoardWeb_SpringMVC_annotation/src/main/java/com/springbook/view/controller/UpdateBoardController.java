package com.springbook.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import org.springframework.stereotype.Controller;

@Controller
public class UpdateBoardController {

	@RequestMapping("updateBoard.do")
	public String handleRequest(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�� ���� ó�� - Spring MVC annotationȣ�� - Controller �и�");
		
		System.out.println(vo.getTitle());
		System.out.println(vo.getContent());
		System.out.println(vo.getSeq());
		
		boardDAO.updateBoard(vo);
		
		// 3. ȭ�� �׺���̼�
		return "redirect:getBoardList.do";
	}

}

package com.springbook.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class InsertBoardController{
	
	@RequestMapping(value="/insertBoard.do")	//Ŭ���̾�Ʈ ��û
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�� ��� ó�� - Spring MVC ������̼� �۵� ");
		
		/* �� Ȯ���� ���� ��¹�
		System.out.println(vo.getTitle());
		System.out.println(vo.getWriter());
		System.out.println(vo.getContent());
		
		*/
		
		boardDAO.insertBoard(vo);
		
		return "getBoardList.do";		//forward ������� �Ѿ
		
	}
}

package com.springbook.view.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class BoardController {

	
	//��ɺ��� Controller�� ����:
	
	
	
	//3. �۵��
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
	
	//4. �� ����
	@RequestMapping("/updateBoard.do")
	public String handleRequest(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�� ���� ó�� - Spring MVC annotationȣ�� - Controller ����");
		
		System.out.println(vo.getTitle());
		System.out.println(vo.getContent());
		System.out.println(vo.getSeq());
		
		boardDAO.updateBoard(vo);
		
		return "redirect:getBoardList.do";
	}
	
	//5.�� ����
	@RequestMapping("/deletBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�� ���� ó�� - Spring MVC Annotation ȣ�� - Controller �и�");
		
		boardDAO.deleteBoard(vo);
		
		return "redirect:getBoardList.do";
		//return "getBoardList.do";		//Forward�� �̵�
	}
	
	//�˻� ���� ��� ����
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		
		Map<String, String> conditionMap = new HashMap<string, String>();
		
		conditionMap.put("����","TITLE");
		conditionMap.put("����", "Content");
		conditionMap.put("�̸�", "NAME");
		conditionMap.put("��¥", "REGDATE");
		
		return conditionMap;
	}
	
	//searchConditionMap() �޼ҵ�� @ModelAttribute ������̼��� ���� �Ǿ��ֱ� ������
	// getBoardList()���� ���� ����ȴ�.
	
	//6. �� �� �˻�
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("�� �� ��ȸ ó��");
		
		System.out.println("VO�� �ڵ����� �Ѿ���� ��" + vo.getSeq());
		
		model.addAttribute("board",boardDAO.getBoard(vo));
		return "getBoard.jsp"; 	 // View ���� ����
		
		//ModelAndView : Model + View(�� �������� ����)
		//Model			: Model (�� �������� ������ ���� �ѱ涧)
	}
	
	//7. �� ��� �˻�
	@RequestMapping("/getBoardList.do")
	public String getBoardList(@RequestParam(value="searchCondition",defaultValue="TITLE",required=false)
	String condition, @RequestParam(value="searchKeyword", defaultValue="", required=false) String keyword, BoardVO vo, BoardDAO boardDAO,
	Model model, HttpServletRequest req) {
		System.out.println("�� ��� �˻� ó�� -- Spring MVC ������̼� �۵� Controller����");
		
		System.out.println("�˻� ���� "+ condition);
		System.out.println("�˻� �ܾ� "+ keyword);
		
		String condition2 = req.getParameter("searchCondition");
		String keyword2 = req.getParameter("searchKeyword");
		
		System.out.println("�˻� ���� "+ condition2);
		System.out.println("�˻� �ܾ� "+ keyword2);
		
		
		model.addAttribute("boardList",boardDAO.getBoardList(vo));
		
		return "getBoardList.jsp";
		
	}
	/*
	 	@ModelAttribute
	 1. Command ��ü�� ���۵Ǵ� ��ü�̸��� �ٸ� �̸����� �����ؼ� ����Ҷ� 
	 2. View���� ����� �����͸� �����ϴ� �뵵�� ����.
	 		@ModelAttribute�� ������ �޼ҵ�� @RequestMapping ������̼��� ������ �޼ҵ�� ���� ȣ���.
	 		@ModelAttribute �޼ҵ� ���� ����� ���ϵǴ� ��ü�� �ڵ����� Model�� �����̵ȴ�.
	 		@ModelAttribute �޼ҵ� ���� �ܷΰ��� View ���������� ����� �� ����.
	 		
	 	
	  
	 */

}

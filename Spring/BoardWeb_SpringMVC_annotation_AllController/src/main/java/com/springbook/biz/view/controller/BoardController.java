package com.springbook.biz.view.controller;

import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class BoardController {

	 //��ɺ��� Controller�� ���� : 
	
	@Autowired
	private BoardService boardService;	//�������̽��� DAO�� ȣ��
	
	//1. �۵�� 
	@RequestMapping(value="/insertBoard.do")   // Ŭ���̾�Ʈ ��û 
	public String insertBoard(BoardVO vo, BoardDAO boardDAO)  {
		System.out.println("�� ��� ó��- Spring MVC ������̼� �۵� ");
		
		boardDAO.insertBoard(vo);
		
		return "getBoardList.do";   //Forward ������� �� ������ ���� 
		 
	}
	
	//2.�� ���� 
	
	@RequestMapping ("/updateBoard.do")
	public String updateBoard(BoardVO vo , BoardDAO boardDAO) {
		System.out.println("�� ���� ó�� - Spring MVC ȣ�� - Controller �и�");
		
		System.out.println(vo.getTitle());
		System.out.println(vo.getContent());
		System.out.println(vo.getSeq());
		
		boardDAO.updateBoard(vo);     
		
		// 3. ȭ�� �׺���̼�
		
		return "redirect:getBoardList.do"; 	
	}
	
	//3. �ۻ���
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo , BoardDAO boardDAO) {
		System.out.println("�� ���� ó��- Spring MVC ������̼� - Controller ����");
		
		boardDAO.deleteBoard(vo);
		return "redirect:getBoardList.do";  //redirect �� �̵� 
		//return "getBoardList.do"; 		//Forward �� �̵�
	}
	
	//�˻� ���� ��� ���� 
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>(); 
		conditionMap.put("����", "TITLE"); 
		conditionMap.put("����", "CONTENT"); 
		conditionMap.put("�̸�", "NAME"); 
		conditionMap.put("��¥", "REGDATE"); 
		
		return conditionMap; 
	}
	
		//searchConditionMap() �޼ҵ�� @ModelAttribute ������̼��� ����Ǿ� �ֱ� ������ 
		// getBoardList() ���� ���� ���� �ȴ�.  
	
	//4. �� �� �˻�
	@RequestMapping ("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("�� �� ��ȸ ó��- Spring MVC ȣ�� - Controller ����");		
				 		 
		 model.addAttribute("board", boardDAO.getBoard(vo)); 
		
		 return "getBoard.jsp"; 
		 
		//ModelAndView : Model (���������� ������ ���� �ѱ涧) + View (���������� ����)
		//Model        : Model (���������� ������ ���� �ѱ涧)
		 
		 
		 
	}
	
	//5. �� ��� �˻� 
	@RequestMapping("/getBoardList.do")
	public String getBoardList(@RequestParam (value="searchCondition", defaultValue="TITLE", required=false)
			String condition, @RequestParam (value="searchKeyword", defaultValue="", required=false) String keyword,
			BoardVO vo, BoardDAO boardDAO, Model model, HttpServletRequest req) {
		System.out.println("�� ��� �˻� ó�� -- Spring MVC ������̼� �۵�  Controller ���� ");
		
		System.out.println("�˻� ���� : " + condition);
		System.out.println("�˻� �ܾ� : " + keyword);
		
		String condition2 = req.getParameter("searchCondition"); 
		String keyword2 = req.getParameter("searchKeyword"); 
		
		System.out.println("�˻� ���� : " + condition2);
		System.out.println("�˻� �ܾ� : " + keyword2);

		
		model.addAttribute("boardList", boardDAO.getBoardList(vo)); 
		
		return "getBoardList.jsp";	 
	}
	
	/* @ModelAttibute : 
	 	1. Command ��ü�� ���۵Ǵ� ��ü�̸��� �ٸ��̸����� �����ؼ� ��� �Ҷ� 
	 	2. View���� ����� �����͸� �����ϴ� �뵵�� ����. 
	 		@ModelAttribute �� ������ �޼ҵ�� @RequestMapping ������̼��� ������ �޼ҵ� ���� ���� ȣ���. 
	 		@ModelAttribute �޼ҵ� ���� ����� ���ϵǴ� ��ü�� �ڵ����� Model�� �����̵ȴ�. 
	 		@ModelAttribute �޼ҵ� ���� ����� ������ ��ü�� View  ���������� ��� �� �� ����. 
	 	
	*/
	
}

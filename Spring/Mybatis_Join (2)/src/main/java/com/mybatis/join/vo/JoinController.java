package com.mybatis.join.vo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JoinController {
	
	@Autowired
	private MybatisDAO mybatisDAO; 
	
	@RequestMapping ("/joinList.do")
	public String selectList (JoinVO vo , Model model) {
		System.out.println("��Ʈ�ѷ� ȣ�� ���� : /joinList.do");
		List<JoinVO> joinList = mybatisDAO.selectListJoin(vo); 		
		System.out.println("���̹�Ƽ���� ���� List��ü ���� ���� ");
		
		
		JoinVO joinVO =   joinList.get(0); 
		JoinVO joinVO1 = joinList.get(1);
		JoinVO joinVO2 = joinList.get(2);
		
		System.out.println(joinVO.toString());
		System.out.println(joinVO1.toString());
		System.out.println(joinVO2.toString());
				
		
		model.addAttribute("joinList", joinList); 
		
		return "joinList1.jsp"; 
	}
	
	@RequestMapping ("/joinList2.do")
	public String selectList2 (EnD_VO vo , Model model) {
		System.out.println("��Ʈ�ѷ� ȣ�� ���� : /joinList2.do");
		List<EnD_VO> joinList = mybatisDAO.selectListJoin2(vo); 		
		System.out.println("���̹�Ƽ���� ���� List2��ü ���� ����:resultType  ");
		
		
		EnD_VO joinVO =   joinList.get(0); 
		EnD_VO joinVO1 = joinList.get(1);
		EnD_VO joinVO2 = joinList.get(2);
		
		System.out.println(joinVO.toString());
		System.out.println(joinVO1.toString());
		System.out.println(joinVO2.toString());
				
		
		model.addAttribute("joinList", joinList); 
		
		return "joinList.jsp"; 
	}
	
	

}

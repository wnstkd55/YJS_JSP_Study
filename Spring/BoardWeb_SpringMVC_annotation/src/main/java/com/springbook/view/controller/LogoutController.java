package com.springbook.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

@Controller
public class LogoutController{

	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		System.out.println("�α� �ƿ� ó�� - Spring MVC - Controller ȣ��");
		
		session.invalidate();
		
		return "redirect:login.jsp";
	}

}

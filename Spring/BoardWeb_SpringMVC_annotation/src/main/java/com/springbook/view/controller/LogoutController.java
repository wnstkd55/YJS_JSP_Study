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
		System.out.println("로그 아웃 처리 - Spring MVC - Controller 호출");
		
		session.invalidate();
		
		return "redirect:login.jsp";
	}

}

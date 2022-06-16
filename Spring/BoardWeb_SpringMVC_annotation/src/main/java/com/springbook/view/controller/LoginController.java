package com.springbook.view.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController{

	@RequestMapping
	public String login(UserVO vo, UserDAO userDAO) {
		System.out.println("로그인 처리 - Spring MVC호출 - Controller 분리");
		
		System.out.println("id : "+vo.getId());
		System.out.println("password: "+vo.getPassword());
		
		
		if(userDAO.getUser(vo) != null) {
			return "redirect:getBoardList.do";
		}else {
			return "redirect:login.jsp";
		}
	
	}

}

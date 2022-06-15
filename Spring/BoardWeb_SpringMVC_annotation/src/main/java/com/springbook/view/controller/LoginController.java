package com.springbook.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		System.out.println("�α��� ó�� - Spring MVCȣ�� - Controller �и�");
		
		// 1. ����� �Է� ���� ����
					String id = request.getParameter("id");
					String password = request.getParameter("password");

					// 2. DB ���� ó��
					UserVO vo = new UserVO();
					vo.setId(id);
					vo.setPassword(password);

					UserDAO userDAO = new UserDAO();
					UserVO user = userDAO.getUser(vo);

					// 3. ȭ�� �׺���̼�  (�� �������� ������ )
					ModelAndView mav = new ModelAndView();
					if (user != null) {
						mav.setViewName("redirect:getBoardList.do"); 
								//redirect : viewResolver ������ �����ϰ� �����̷�Ʈ�Ѵ�.
								//redirect : viewResolver�� prefix, suffix�� ������� �ʵ��� �Ѵ�.
						
								//�⺻���ΰ��� Controller�� View�������� ������ ����� Forward����̴�.
									//Ŭ���̾�Ʈ�� url�� �ٲ��� �ʴ´�.
									//viewResolver�� �۵��� �ȴ�. prefix, suffix�� ����
								//redirect: �������� ������ ������
						return mav;
					} else {
						mav.setViewName("redirect:login.jsp");   // ViewResolver ���������� ���������� �ϼ���. 
						return mav;
					}
					
		
	
	}

}

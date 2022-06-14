package com.springbook.biz.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;


//DispatcherServlet �� MVC M2�� ����.
   //�ϳ��� Controller���� Client�� ��� ��û�� ó���ϰ� �ִ�. 
	//���̺��� �þ�ų� , Controller�� ���ϰ� ������ ���� �߻� 
    //������ ������ ������� ������ ����. �ش� �޼ҵ带 ã�⵵ ���� 

//Controller�� ���ϸ� �л� ó�� �ϴ°��� : MVC �����ӿ�ũ, Spring MVC 




//@WebServlet(name = "action", urlPatterns = { "*.do" })
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HandlerMapping handerMapping; //��ü ���� ���� 
	private ViewResolver viewResolver;    //��ü ���� ���� 
	
	//HttpServlet Ŭ������ init() �޼ҵ� ������ : ���ϼ����� ����ɶ� init �޼ҵ尡 ȣ��� 
		//init() �޼ҵ�� �ʱⰪ�� ������ �ϴ� �޼ҵ�
	
	@Override
	public void init() throws ServletException {
		System.out.println("��Ĺ ���� ���۽� ȣ�� -  init()");
		handerMapping = new HandlerMapping(); 
		viewResolver = new ViewResolver(); 
		
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp"); 	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Ŭ���̾�Ʈ���� Get ������� ������ ��� ��û�� process �޼ҵ忡�� ó���ϵ��� ������
		process (request,response); 
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Ŭ���̾�Ʈ���� Post ������� ������ ��� ��û�� process �޼ҵ忡�� ó���ϵ��� ������
		request.setCharacterEncoding("EUC-KR");
		process (request,response); 
	}
	
	private void process (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//1. Ŭ���̾�Ʈ�� ��û path ������ ���� 
		String uri = request.getRequestURI(); 
		String path = uri.substring(uri.lastIndexOf("/"));   
				//path : Ŭ���̾�Ʈ ��û (*.do), login.do, logout.do, insertBoard.do...
		System.out.println(path);      
		
		//2. HandlerMapping�� ���ؼ� path �� �ش��ϴ� Controller�� �˻� ��
			//ctrl �� Ŭ���̾�Ʈ ��û ������ ���� Controller ��ü�� ���� �޾ƿ� 
		Controller ctrl = handerMapping.getController(path); 
		
		//3. �˻��� Controller�� ���� �Ѵ�. ���� ������ ���������� ���� �޾ƿ´�. 
			//viewName : view �������� ��� �ִ�. 
		String viewName = ctrl.handlerRequest(request, response); 
			
		//4. �� ������ �̸��� �ϼ� �ؼ� ó�� 
		String view = null; 
		if (!viewName.contains(".do")) {
			view = viewResolver.getView(viewName); 
		}else {
			view = viewName ;    //login.do , logout.do
		}
			
		//5. �˻��� ���������� �̵� 
		response.sendRedirect(view); 
		
		
		}
		
		
	}
	



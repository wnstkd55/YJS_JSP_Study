package com.springbook.biz.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	
	//�޼ҵ� ���� : ������ ��� Controller�� HandlerRequest �޼ҵ带 ������ 
	 String handlerRequest(HttpServletRequest request, HttpServletResponse response);

}

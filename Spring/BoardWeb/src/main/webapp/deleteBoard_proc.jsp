<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="com.springbook.biz.impl.BoardDAO" %> 
<%@page import="com.springbook.biz.BoardVO" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% 
		// 1. ����� �Է� ���� ����  
		request.setCharacterEncoding("UTF-8"); 
		String seq = request.getParameter("seq"); 
		// 2. DB ���� ó�� 
		BoardVO vo = new BoardVO(); 
		vo.setSeq(Integer.parseInt(seq)); 
		BoardDAO boardDAO = new BoardDAO(); 
		boardDAO.deleteBoard(vo); 
		// 3. ȭ�� �׺���̼� 
		response.sendRedirect("getBoardList.jsp"); 
	%>  
</body>
</html>
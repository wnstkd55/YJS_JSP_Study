<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% 

	// 1. �������� ����� ���� ��ü�� ���� �����Ѵ�.   
	session.invalidate(); 
	// 2. ���� ���� ��, ���� ȭ������ �̵��Ѵ�.    
	response.sendRedirect("login.jsp"); 
	
	%> 
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ������</title>
</head>
<body>
<center>
	<h3> ȸ�� ����</h3>
	<hr>
	
	<form action="insertUser.do" method = "post">
		���̵� : <input type = "text" name = "id">
		<p> �н����� : <input type = "password" name="password">
		<p> �̸�: <input type = "text" name = "name">
		<p> ���� : <input type = "text" name ="role">
		<p> <input type="submit" value="ȸ������">
	
	</form>
</center>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%> 
<%@page import="java.util.List"%> 
<%@page import="com.springbook.biz.impl.BoardDAO"%> 
<%@page import="com.springbook.biz.BoardVO"%> 
<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 
<title>로그인</title> 
</head> 
<body>
<% 

	List<BoardVO> boardList = (List)session.getAttribute("boardList");
	BoardVO board = (BoardVO)session.getAttribute("board"); 

%> 
	<center> 
		<h1>글 상세</h1> 
				<a href="logout.do">Log-out</a> 
				<hr> 
				<form action="updateBoard.do" method="post"> 
					<table border="1" cellpadding="0" cellspacing="0"> 
				<tr> 
					<td bgcolor="orange" width="70">제목</td> 
					<td align="left"><input name="title" type="text" /></td> 
				</tr> 
				<tr> 
					<td bgcolor="orange">아이디</td> 
					<td><input type="text" name="id"></td> 
				</tr> 
				<tr> 
					<td bgcolor="orange">비밀번호</td> 
					<td><input type="password" name="password"></td> 
				</tr> 
				<tr> 
					<td colspan="2" align="center"> 
					<input type="submit" value="로그인" /> 
					</td> 
				</tr>	 
			</table> 
		</form>
		<hr> 
		<a href="insertBoard.jsp">글 등록</a>&nbsp;&nbsp;&nbsp;  
		<a href="deleteBoard.do?seq=<%= board.getSeq() %>">글 삭제</a>  
		<a href="getBoardList.do">글 목록</a>&nbsp;&nbsp;&nbsp; 
	</center> 
</body> 
</html> 
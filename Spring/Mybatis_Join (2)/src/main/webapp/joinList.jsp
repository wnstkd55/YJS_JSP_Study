<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri = "http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>조인(Join) 정보 출력</title>
</head>
<body>

<center> 
	<h2>조인(Join) 정보 출력 </h2>
	<hr> 
	
	<table border = "1" width = "700" cellspacing="0" cellpadding="0">
		<tr> 
			<td>ENO</td>
			<td>ENAME </td>
			<td>JOB</td>
			<td>MANAGER </td>
			<td>HIREDATE</td>
			<td>SALARY </td>
			<td>COMMISSION </td>
			<td>DNO </td>
			<td>DNAME </td>
			<td>LOC </td>		
		</tr>
		
		<!-- Loop 시작  -->
		<c:forEach items ="${joinList}" var="join">
		<tr> 
			<td> ${join.eno }</td>
			<td>${join.ename } </td>
			<td> ${join.job }</td>
			<td>${join.manager } </td>
			<td> ${join.hiredate }</td>
			<td>${join.salary } </td>
			<td>${join.commission } </td>
			<td>${join.dno } </td>
			<td>${join.dname } </td>		
			<td>${join.loc} </td>		
		</tr>
		</c:forEach>
	
	</table>

</center>


</body>
</html>
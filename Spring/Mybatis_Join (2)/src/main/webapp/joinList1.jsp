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
			<td> ${join.empJ.eno }</td>
			<td>${join.empJ.ename } </td>
			<td> ${join.empJ.job }</td>
			<td>${join.empJ.manager } </td>
			<td> ${join.empJ.hiredate }</td>
			<td>${join.empJ.salary } </td>
			<td>${join.empJ.commission } </td>
			<td>${join.deptJ.dno } </td>
			<td>${join.deptJ.dname } </td>		
			<td>${join.deptJ.loc} </td>		
		</tr>
		</c:forEach>
	
	</table>

</center>


</body>
</html>
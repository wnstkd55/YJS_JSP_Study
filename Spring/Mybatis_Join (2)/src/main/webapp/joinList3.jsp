<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
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
			<td> ${join.empJ.employe_id }</td>
			<td>${join.empJ.first_name } </td>
			<td> ${join.empJ.last_name }</td>
			<td>${join.empJ.email } </td>
			<td> ${join.empJ.phone_number }</td>
			<td>${join.empJ.hire_date } </td>
			<td>${join.empJ.job_id } </td>
			<td>${join.empJ.salary } </td>
			<td>${join.empJ.commission_pct } </td>
			<td>${join.empJ.manager_id } </td>
			<td>${join.empJ.department_id } </td>
			<td>${join.deptJ.department_id } </td>
			<td>${join.deptJ.department_name } </td>		
			<td>${join.deptJ.manager_id} </td>
			<td>${join.deptJ.location_id} </td>		
		</tr>
		</c:forEach>
	
	</table>

</center>
</body>
</html>
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
			<td>EMPLOYEE_ID</td>
			<td>FIRST_NAME </td>
			<td>LAST_NAME</td>
			<td>EMAIL </td>
			<td>PHONE_NUMBER</td>
			<td>HIRE_DATE </td>
			<td>JOB_ID </td>
			<td>SALARY </td>
			<td>COMMISSION_PCT </td>
			<td>MANAGER_ID </td>
			<td>DEPARTMENT_ID </td>
			<td>DEPARTMENT_ID </td>
			<td>DEPARTMENT_NAME </td>
			<td>MANAGER_ID </td>
			<td>LOCATION_ID </td>
			<td>LOCATION_ID </td>
			<td>STREET_ADDRESS </td>
			<td>POSTAL_CODE </td>
			<td>CITY </td>
			<td>STATE_PROVINCE </td>
			<td>CONTRY_ID </td>
			<td>EMPOYEE_ID </td>
			<td>START_DATE </td>
			<td>END_DATE </td>
			<td>JOB_ID </td>
			<td>DEPARTMENT_ID </td>
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
			<td>${join.locJ.location_id} </td>
			<td>${join.locJ.street_address} </td>
			<td>${join.locJ.postal_code} </td>
			<td>${join.locJ.city} </td>
			<td>${join.locJ.state_province} </td>
			<td>${join.locJ.country_id} </td>
			<td>${join.jobhJ.employee_id} </td>
			<td>${join.jobhJ.start_date} </td>
			<td>${join.jobhJ.end_date} </td>
			<td>${join.jobhJ.job_id} </td>
			<td>${join.jobhJ.department_id} </td>		
		</tr>
		</c:forEach>
	
	</table>

</center>
</body>
</html>
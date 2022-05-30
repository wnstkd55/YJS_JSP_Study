<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ page import = "java.sql.*" %>

<%

	Connection conn = null;
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";	// MSSQL 드라이버 
	String url1 = "jdbc:sqlserver://localhost:1433;DatabaseName=shoppingmall";
	
	Class.forName(driver);
	conn = DriverManager.getConnection (url1, "sa", "1234");

%>
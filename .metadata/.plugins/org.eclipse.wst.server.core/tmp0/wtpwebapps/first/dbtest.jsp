<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

Class.forName("org.mariadb.jdbc.Driver"); 
Connection connection = DriverManager.getConnection( "jdbc:mariadb://localhost:3306/scott", "root", "root1234");


		
 System.out.println("연결성공");
 %>
</body>
</html>
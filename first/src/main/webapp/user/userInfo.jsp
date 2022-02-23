<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
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
<ul>
<li>
<a href="/user/login.html">로그인 홈페이지</a></li>
<li><a href="/user/join.html">회원가입 홈페이지</a></li>
<li><a href="/user/userInfo.jsp">회원정보 홈페이지</a></li> 
<li><a href="/post/list.html">글목록 홈페이지</a></li>
</ul>

<%

//request는 BufferedReader로 읽은 모든 정보를 자바 오브젝트로 바꾼 결정체(톰켓이 해줌)
//getParameter 쿼리스트링 파싱해주는 메서드
int id = Integer.parseInt(request.getParameter("id"));
System.out.println("id:"+id);

Class.forName("org.mariadb.jdbc.Driver"); 
Connection conn = DriverManager.getConnection( "jdbc:mariadb://localhost:3306/scott", "root", "root1234");
 System.out.println("연결성공");
 
 String sql = "SELECT id, name, phone FROM userInfo WHERE id =?";
 PreparedStatement pstmt = conn.prepareStatement(sql);
 pstmt.setInt(1,id);
 
 ResultSet rs = pstmt.executeQuery();
 String name = null;
 String phone = null;

while(rs.next()){
	name = rs.getString("name");
	phone = rs.getString("phone");
} 
	

%>

<h1>회원정보 페이지입니다.</h1>
<h3>ID:<%=id %>이름:<%=name%> 전화번호:<%=phone%> </h3>
<hr/>
</body>
</html>
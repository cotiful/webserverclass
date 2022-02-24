package site.metacoding.servletproject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//http 프로토콜 최초 버전(get)
//http 1.0 프로토콜 (get.post)
//http 1.1 프로토콜(get(주소요청), Post(폼태그),delete(자바스크립트), Put(자바스크립트))

//http://localhost:80/front
@WebServlet("/front")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public FrontController() {
    System.out.println("나메모리에떳어:frontController"); //요청할때 마다 새로운 사람으로 인식해서 계속 요청을 해도 한 번만 뜸.
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("front컨트롤러로 요청들어옴.");
		
		//1.라우터 만들기
		String path = request.getParameter("path");
		System.out.println("path:"+path);
		
		if(path.equals("login")) {
			//로그인페이지를응
			response.sendRedirect("/login.jsp"); //redirect 해주는 메서드.
//		PrintWriter out = response.getWriter();
//		out.println("<!DOCTYPE html>");
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<meta charset=\"UTF-8\">");
//		out.println("		<title>Insert title here</title>");
//		out.println("	</head>");
//		out.println("<body>");
//		out.println("	<h1>loginPage</h1>");
//		out.println("<body>");
//		out.println("</html>");
		
		}else if(path.equals("join"));
		response.sendRedirect("join.jsp");
		//조인페이지
//		PrintWriter out = response.getWriter();
//		out.println("<!DOCTYPE html>");
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<meta charset=\"UTF-8\">");
//		out.println("		<title>Insert title here</title>");
//		out.println("	</head>");
//		out.println("<body>");
//		out.println("	<h1>joinPage</h1>");
//		out.println("<body>");
//		out.println("</html>");
	}


}

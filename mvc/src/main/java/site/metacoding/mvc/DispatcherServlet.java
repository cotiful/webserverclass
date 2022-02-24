package site.metacoding.mvc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.metacoding.mvc.config.DBConn;
import site.metacoding.mvc.web.MyUserController;

//http://localhost:8000/
//http://localhost:8000/mypost=>mypostController로 보냄
//http://localhost:8000/hello
//http://localhost:8000/myuser =>myuserController로 보냄

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String domain= request.getRequestURI();
System.out.println("domain:"+domain
		);
//String domain2 = request.getRequestURL().toString();
//
//System.out.println("유알아이"+domain1);
//System.out.println("유알엘"+ domain2);

if(domain.equals("/myuser")){
	MyUserController controller = new MyUserController(request, response); //앞단에서 받아서 메서드만 호출해주면됨. request. response를 넣어줘야함.
	
	String idStr = request.getParameter("id");
	
	if(idStr == null){
		controller.getAll(); //쿼리스트링이 없다는 것을 의미
	}else {
		int id = Integer.parseInt(idStr); 
		controller.getOne(id);
	}
}
	} //Dispatcher 스레드가 종료 (1.클라이언트에게 연결된 Response 선 짤림, 2. Request 메모리 영역 삭제, DB Connection반납)
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}

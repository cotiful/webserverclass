package site.metacoding.mvc.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.metacoding.mvc.domain.MyUser;
import site.metacoding.mvc.domain.MyUserRepository;

//회원 관련 요청만 컨트롤함.
public class MyUserController {
private HttpServletRequest request;  //response와 Request를 Servle로부터 받을려
private HttpServletResponse response;
	
	private MyUserRepository repo;
	
	public MyUserController(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		repo = new MyUserRepository(); //controller는 Repository를 찾아줌.
	}
	
//GET:http://localhost:8000/myuser
public void getAll() {
	System.out.println("getAll호출됨");
	
	
}
//GET:http://localhost:8000/myuser?id=1 ->string parsing 해줘야함. 프레임워크는 다 있음 하지만 하고 가봐야 느낌
public void getOne(int id) {
	System.out.println("getOne 호출됨");
	MyUser myUser = repo.selectById(id); //받아줘야한다네~
request.setAttribute("myUser", myUser); //object로 받아줘야 다 받을 수 있다.
try {
	//response.sendRedirect("/userInfo.jsp"); //I/O가 하고 있음
	RequestDispatcher dis = request.getRequestDispatcher("/userInfo.jsp"); //redirect 하면 Request가 바로 사라지나,requestdispatcher는 내부에서 재요청함.
	//그래서 request가 사라지지 않고 덮어 쓰게 만듦, request 안에 데이터가 남아있게 됨.
	dis.forward(request, response);
} catch (Exception e) {
	e.printStackTrace();
}
}

}

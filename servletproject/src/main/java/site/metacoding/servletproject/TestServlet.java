package site.metacoding.servletproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:80/index.jsp (URL)
// http://localhost:80/hello (URI 식별자 요청) URI 사용하려면 어노테이션 필요
@WebServlet("/test")
public class TestServlet extends HttpServlet { // 상속

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    // /hello 요청을 받으면
    // 사용자에게 받은 http body, http header 정보를 HttpServletRequest req에 담고
    // 그 친구한테 응답될 빈 객체 HttpServletResponse resp를 만들어서
    // 주소창에 엔터를 치면 아파치/톰캣이 doGet(req, resp); 담아서 메서드 호출
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get요청됨");

        String name = "Seunghyun";

        // printWriter에는 \n, flush 까지 내부에 적용되어 있음
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Hello EveryOne " + name + "</h1>");
        out.println("</body>");
        out.println("</html>");

        // 원형
//        BufferedWriter writer = new BufferedWriter(
//                new OutputStreamWriter(resp.getOutputStream()));
//        writer.write("\n");
//        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
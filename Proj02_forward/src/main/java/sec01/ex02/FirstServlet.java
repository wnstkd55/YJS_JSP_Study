package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet ("/first02")
public class FirstServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("요청 확인됨.");
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		//resp.sendRedirect("second");	//서블릿 요청했을때
		
		//resp.sendRedirect("index.jsp");		//JSP페이지로 이동
		
		//resp.addHeader("Refresh","5;url=second02");
		resp.addHeader("Refresh", "5;url=index.jsp");
	}
	
}

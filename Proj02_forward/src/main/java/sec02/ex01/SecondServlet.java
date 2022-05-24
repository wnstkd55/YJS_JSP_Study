package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet ("/second001")
public class SecondServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		
		out.print("<html><body>");
		out.print("sendReirect�� �̿��� redirect �ǽ��Դϴ�.<br><br>");
		out.print("�̸��� : " + name +"<br><br>");
		out.print("�н����� : "+pwd+"<br><br>");
		out.print("</body></html>");
	}
	
}

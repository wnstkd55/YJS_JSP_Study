package sec02.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet ("/first002")
public class FirstServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("��û Ȯ�ε�.");
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		//resp.sendRedirect("second");	//���� ��û������
		
		//resp.sendRedirect("index.jsp");		//JSP�������� �̵�
		
		resp.addHeader("Refresh","5;url=second002?name=hong&pwd=1234");
		//resp.addHeader("Refresh", "5;url=index.jsp");
	}
	
}

<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@page import="com.springbook.biz.board.BoardVO_"%>
<%@page contentType="text/html; charset=EUC-KR"%>

<%
// 1. ����� �Է� ���� ����
	request.setCharacterEncoding("EUC-KR");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String seq = request.getParameter("seq");

	// 2. DB ���� ó��
	BoardVO_ vo = new BoardVO_();
	vo.setTitle(title);
	vo.setContent(content);
	vo.setSeq(Integer.parseInt(seq));
	BoardDAO boardDAO = new BoardDAO();
	boardDAO.updateBoard(vo);

	// 3. ȭ�� �׺���̼�
	response.sendRedirect("getBoardList.jsp");
%>
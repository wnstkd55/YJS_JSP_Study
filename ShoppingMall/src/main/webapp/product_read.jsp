<%@ page contentType="text/html; charset=euc-kr" %> 
<%@ page language="java" import="java.sql.*" %>
<HTML>
<HEAD><TITLE>��ǰ ����(�̹���) ����</TITLE>
<SCRIPT language="javascript">
 function view(temp) {
  filename = "http://localhost:9191/ShoppingMall/image/" + temp;
  i = window.open(filename, "win", "height=350,width=450,toolbar=0,menubar=0,scrollbars=1,resizable=1,status=0");
 }
</SCRIPT>
</HEAD>
<BODY>

<!-- DB ���� ���� --> 
<%@ include file = "dbconn_mysql.jsp" %>


<%

 String ca="";
 String pn="";
 
 if (request.getParameter("cat") != null) 
  if( !(request.getParameter("cat").equals("")) )
   ca=request.getParameter("cat");
 if (request.getParameter("pname") != null)
  if ( !(request.getParameter("pname").equals("")) )
   pn=request.getParameter("pname");
  
 //pn = new String(pn.getBytes("ISO-8859-1"),"euc-kr");
 out.println(pn);

 String sql=null;
 //Connection con= null;
 Statement st =null;
 ResultSet rs =null;
 
 long id = Long.parseLong(request.getParameter("id"));
 
 String url = "http://localhost:9191/ShoppingMall/image/";
 String small=null;
 
 out.print("[<A href=\"product_list.jsp?go="+ request.getParameter("go"));
 out.print("&cat="+ ca +"&pname="+pn+"\">��ǰ �������</A>]");
 

 try {
  st = conn.createStatement();
  sql = "select * from product where id="+id;
  rs = st.executeQuery(sql);
  if (!(rs.next()))  {
   out.println("�ش� ������ �����ϴ�");
  } else {
   small=url+rs.getString("small");
   
   // out.println(small);
   //if (true) return;
   
   out.println("<TABLE width=500 border=0 >");
   out.println("<TR><TH rowspan=3>");
 
   out.println("<A href=JavaScript:view(\""+rs.getString("large")+"\")>"); 
   out.println("<IMG width=100 height=100 src="+small+">");
   out.println("<BR>Ȯ��</A></TH>");
   out.println("<TH bgcolor=#003399>");
   out.println("<FONT face=���� color=white>");
   out.println(rs.getString("pname")+"("+rs.getLong("id")+")");
   out.println("---�ۼ���:"+rs.getString("wname"));
   out.println("</FONT></TH></TR>");  
   out.println("<TR>");
   out.println("<TD>");
   out.println("<U>�� ���� :</U><BR>");
   out.println(rs.getString("description") );
   out.println("</TD></TR>"); 
   out.println("<TR><TD align=right>");   
   out.println("����(����)��:"+rs.getString("sname")+"<BR>");
   out.println("���߰�:<STRIKE>"+rs.getString("price")+"</STRIKE>��");
   out.println("�ǸŰ�:"+rs.getString("downprice")+"��");
   out.println("</TD></TR>");  
   out.println("</TABLE>");
  }
  rs.close();
  st.close();
  conn.close();
 } catch (SQLException e) {
  out.println(e);
 } 
%>
</BODY>
</HTML>
<%@ page contentType="text/html; charset=EUC-KR" %> 
<%@ page language="java" import="java.sql.*,java.text.*" %> 
<% request.setCharacterEncoding("euc-kr"); %>
<HTML>
<HEAD><TITLE>���� ��� </TITLE>
<SCRIPT language="javascript">
 function setvalue(f) {
  f.quantity.value=0;
  f.submit();
 }
</SCRIPT>
</HEAD>
<BODY>

<!-- DB ���� ���� --> 
<%@ include file = "dbconn_mysql.jsp" %>


<P align=center>
 <FONT color=#0000ff face=���� size=+1>
  <STRONG> ���� ��� </STRONG>
 </FONT>
</P> 
<CENTER>
<TABLE border=0 width=600 cellpadding=4 cellspacing=4 style="font-size:10pt">
 <TR>
  <TH width=5% bgcolor=#003399>
   <FONT color=black face=����><NOBR>��ȣ</NOBR></FONT>
  </TH>
  <TH width=20% bgcolor=#003399>
   <FONT color=black face=����><NOBR>��ǰ��</NOBR></FONT>
  </TH>
  <TH width=20% bgcolor=#003399>
   <FONT color=black face=����><NOBR>������</NOBR></FONT>
  </TH>
  <TH width=25% bgcolor=#003399>
   <FONT color=black face=����><NOBR>�ֹ� ����</NOBR></FONT>
  </TH>
  <TH width=10% bgcolor=#003399>
   <FONT color=black face=����><NOBR>�ǸŰ�(��)</NOBR></FONT>
  </TH>
  <TH width=15% bgcolor=#003399>
   <FONT color=black face=����><NOBR>�հ�(����*�ǸŰ�)</NOBR></FONT>
  </TH>
 </TR>
<%
 long id=0;
 
 session = request.getSession();
 
 String[] a = session.getValueNames();
 
 String where="1";

 String ca="";
 String pn="";
 int qty=0;
 int count=0;
 
 if (request.getParameter("go") != null)
  if(!(request.getParameter("go").equals("")) )
   where = request.getParameter("go");
 
 if (request.getParameter("cat") != null) 
  if( !(request.getParameter("cat").equals("")) )
   ca=request.getParameter("cat");
 
 if (request.getParameter("pname") != null) 
  if ( !(request.getParameter("pname").equals("")) ) 
   pn=request.getParameter("pname");
 
 NumberFormat nf= NumberFormat.getNumberInstance();

 String pricestr="";
 String hap="";
 int price=0;
 long total=0;
 
 //Connection con= null;
 Statement st =null;
 ResultSet rs =null;
 String sql=null;
 
 
 try {
 
  st = conn.createStatement();
 
  for (int i=0; i< a.length ;i++) {
   id =Long.parseLong(a[i].trim());
   qty = ((Integer)session.getValue(a[i])).intValue();
   sql = "select * from product where id="+id; 
   rs = st.executeQuery(sql);
 
   if (rs.next()) { 
    count= count+1;
    price=rs.getInt("downprice");
    pricestr=nf.format(price); 
    hap=nf.format(price*qty); 
    total=total+(price*qty);
    out.println("<FORM method=post action=\'sale_upd.jsp\'>");   
    out.println("<TR>");
    out.println("<TH width=5%  bgcolor=#eeeeee>");
    out.println(i+1+"</TH>");
    out.println("<TD width=20% bgcolor=#eeeeee>");
    out.println(rs.getString("pname")+ "</TD>");
    out.println("<TD width=15% bgcolor=#eeeeee>");
    out.println(rs.getString("sname")+ "</TD>");
    out.println("<TD width=30% bgcolor=#eeeeee>");
    out.println("<INPUT type=text name=quantity size=2 value="+qty+">��<br/>");
    out.println("<INPUT type=hidden name=id value="+id+">");
    out.println("<INPUT type=hidden name=go value="+where+">");
    out.println("<INPUT type=hidden name=cat value="+ca+">");
    out.println("<INPUT type=hidden name=pname value="+pn+">");
    out.println("<INPUT type=submit value=����>");
    out.println("<INPUT type=button value=���� onClick=\"setvalue(this.form);\">");
    out.println("</TD>");
    out.println("<TD width=10% bgcolor=#eeeeee align=right>");
    out.println(pricestr+ "</TD>");
    out.println("<TD width=10% bgcolor=#eeeeee align=right>");
    out.println(hap+ "</TD>");
    out.println("</TR></FORM>"); 
   }
  }   
 
  out.println("<TR>");
  out.println("<TD width=10% align=right colspan=6>");
  out.println("�ֹ� ��ǰ :"+count+ "ǰ��&nbsp;&nbsp;");  
  out.println("�ֹ� �� �հ� �ݾ� :"+nf.format(total)+ "��</TD>");     
  out.println("</TR>");   
  out.println("</TABLE>");
  st.close();
  conn.close();
 
  out.print("[<A href=\"shop_list.jsp?go="+ where);
  out.print("&cat="+ ca +"&pname="+pn+"\">��� �����ϱ�</A>]");
 
  out.println("[<A href=\"order.jsp?total="+total+"&count="+count+"\">�ֹ��ϱ�</A>]");
 } catch (SQLException e) {
  out.println(e);
 }
%> 
</BODY>
</HTML>
<%@ page contentType="text/html; charset=EUC-KR" %> 
<%@ page language="java" import="java.sql.*,java.util.*,java.text.*" %> 
<% request.setCharacterEncoding("euc-kr"); %>

<!-- DB ���� ���� --> 
<%@ include file = "dbconn_mysql.jsp" %>


<%
 session = request.getSession();
 
 String[] a = session.getValueNames();
 
 String cardno="";
 String wname = request.getParameter("wname");
 String addr = request.getParameter("addr");
 String tel = request.getParameter("tel");
 String pay = request.getParameter("pay");

 if (pay.equals("card"))  
  cardno=request.getParameter("number");

 int count = Integer.parseInt(request.getParameter("count"));
 long total = Long.parseLong(request.getParameter("total"));

 long id = 0;
 int num= 0;
 int qty= 0;
 String pname= ""; 

 java.util.Date yymmdd = new java.util.Date() ;
 SimpleDateFormat myformat = new SimpleDateFormat("yy-MM-d h:mm a");
 String ymd=myformat.format(yymmdd);
 String sql=null;

 //Connection con=null;
 Statement st=null; 
 ResultSet rs=null;  

 int cnt=0; 
 int cnt2=0; 
 int price=0; 
 
 try {
  
  st = conn.createStatement();
 
  sql = "select max(id) from saleorder";
  rs = st.executeQuery(sql);

  if (rs.next()) 
   id= rs.getLong(1) + 1 ;
  else 
   id=1;

  sql= "insert into saleorder(id,name,orderdate,addr,tel," ;
  sql= sql + "pay,cardno,prodcount,total)" ; 
  sql= sql + " values("+id+",'"+wname+"','"+ymd+"','"+addr+"','"+tel  ;
  sql= sql + "','" + pay + "','" + cardno + "',"+count+","+total+")" ;
  cnt = st.executeUpdate(sql);
 
  if (cnt >0) {
   for (int i=0; i< a.length ;i++) {
    long pid =Long.parseLong(a[i].trim());
    qty = ((Integer)session.getValue(a[i])).intValue();
    num=i+1;
    sql = "select pname,downprice from product where id="+pid; 
    rs = st.executeQuery(sql);
    rs.next();
    pname=rs.getString(1);
    price=rs.getInt(2);
    sql = "insert into item(orderid,mynum,prodid,pname,quantity,price)" ;
    sql = sql + " values("+id+","+num+","+pid+",'"+pname+"',"+qty+","+ price+")" ;
    cnt2 = cnt2+st.executeUpdate(sql);
   }

   if (cnt2==count) {
    out.println("�ֹ��� ���������� ó���Ǿ����ϴ�.");
    session.invalidate();
    out.println("[<A href=\"order_list.jsp?id="+id+"\">�ֹ�������</A>]");
   } else {
    out.println("��ǰ�� ���� �ֹ��� ó������ ���߽��ϴ�.");
     out.println("[<A href=\"shop_list.jsp\">��ǰ �������</A>]");
   }  
  }         
  st.close();
  conn.close();
 } catch (SQLException e) {
  out.println(e.getMessage());
 }
%>
<%@ page contentType="text/html;charset=EUC-KR" %>  
<%@ page language="java" import="java.text.*" %> 
<% request.setCharacterEncoding("euc-kr"); %> 
<% 

 int total=Integer.parseInt(request.getParameter("total"));
 int count=Integer.parseInt(request.getParameter("count"));
 
 NumberFormat nf= NumberFormat.getNumberInstance();
 String totalstr =  nf.format(total);   

%>
<HTML>
<HEAD>
<SCRIPT language="javascript">
 function check(f) {
  blank=false;
  for (i=0; i<f.elements.length;i++) {
   if (f.elements[i].value=="") {
    if (f.elements[i].name != "number") 
     blank=true ;
    if ((f.elements[i].name == "number") && (f.pay.value == "card"))
     blank=true ;
   }
  }

  if (blank==true) 
   alert("��� �׸��� �Է��ϼž� �մϴ�.");
  else
   f.submit();
 }
</SCRIPT> 
</HEAD>
<BODY>
<P>
[<A href= "sale_list.jsp">��ٱ��� �ٽ� ����</A>] 
<FORM method=post action="order_save.jsp">
<TABLE border=0 width=400 >
 <TR>
  <TH bgcolor=#003399 colspan=2>
   <FONT size=+1 color=white> �ֹ��� �ۼ��ϱ�</FONT>
  </TH>
 </TR>
 <TR>
  <TH width=30% bgcolor=#0033cc>
   <FONT size=-1 color=white>�̸�</FONT>
  </TH>
  <TD bgcolor=#eeeeee>
   <INPUT type=text name=wname size=30>
  </TD>
 </TR>
 <TR>
  <TH width=30% bgcolor=#0033cc>
   <FONT size=-1 color=white>���� ����</FONT>
  </TH>
  <TD bgcolor=#eeeeee>
   <FONT size=-1>
    <INPUT type=radio name=pay value="card">ī��
    <INPUT type=radio name=pay value="cash">�¶��� �Ա�
   </FONT>
  </TD>
 </TR>
 <TR>
  <TH width=30% bgcolor=#0033cc>
   <FONT size=-1 color=white>ī�� ��ȣ</FONT>
  </TH>
  <TD bgcolor=#eeeeee>
   <INPUT type=text name=number size=30>
  </TD>
 </TR>
 <TR>
  <TH width=30% bgcolor=#0033cc>
   <FONT size=-1 color=white>��� �ּ�</FONT>
  </TH>
  <TD bgcolor=#eeeeee>
   <INPUT type=text name=addr size=30>
  </TD>
 </TR>
 <TR>
  <TH width=30% bgcolor=#0033cc>
   <FONT size=-1 color=white>��ȭ��ȣ</FONT>
  </TH>
  <TD bgcolor=#eeeeee>
   <INPUT type=text name=tel size=30>
  </TD>
 </TR>
 <TR>
  <TH width=30% bgcolor=#0033cc>
   <FONT size=-1 color=white>�ֹ� �� �ݾ�</FONT>
  </TH>
  <TD bgcolor=#eeeeee>
   <%=totalstr%>��
  </TD>
 </TR>
 <TR>
  <TD colspan=2>
   <INPUT type=hidden name=total value=<%=total%>>
   <INPUT type=hidden name=count value=<%=count%>>
   <INPUT type=button value=" Ȯ�� " onClick="check(this.form)" >
   <INPUT type=reset value=" �ٽþ��� " >
  </TD>
 </TR>
</TABLE>
</CENTER>
</FORM>
</BODY>
</HTML>
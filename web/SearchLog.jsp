<jsp:include page="ManagerMenu.jsp" flush="true"/>
<jsp:include page="Logo.jsp" flush="true"/>
<jsp:include page="SecurityCheck.jsp" flush="true"/>
<jsp:include page="MainMenu.jsp" flush="true"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>The Log table</title>
</head>

<body>
<table width="134%" height="292" border="0">
  <tr>
    <td>
        <table width="100%" border="1">
            <p style="color:red"><%=request.getAttribute("errorMsg") != null ? request.getAttribute("errorMsg") : ""%></p>
            <p style="color:green"><%=request.getAttribute("successMsg") != null ? request.getAttribute("successMsg") : ""%></p>
            <tr><th width="14%">Log ID</th><th width="14%">User First Name</th><th width="14%">User Last Name</th><th width="14%">User Category</th><th width="14%">Log Time</th>
            <th width="14%">Request Made</th>
          
        </tr>
         <%
         String cat=request.getParameter("user_category");
         
        dataaccess.DAO dataAccess=new dataaccess.DAO();
        java.sql.ResultSet  rst=dataAccess.ShowLog(cat);
        while(rst.next()){
		
        %>
        <tr align="left">
            <td><%=rst.getString("log_id")%></td>
            <td><%=rst.getString("firstname")%></td>
            <td><%=rst.getString("lastname")%></td>
             <td><%=rst.getString("user_category")%></td>
            <td><%=rst.getString("log_time")%></td>
            <td><%=rst.getString("request")%></td>
         </tr>
        <%}
        dataAccess.closeConn();
        %>
          
        </table>
    </td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
<p align="center">&nbsp;</p>
</body>
</html>

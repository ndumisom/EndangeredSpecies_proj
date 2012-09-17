<jsp:include page="Logo.jsp" flush="true"/>
<jsp:include page="SecurityCheck.jsp" flush="true"/>
<jsp:include page="MainMenu.jsp" flush="true"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Species Page</title>
</head>

<body>
        <h2>Species List</h2>
        <p style="color:red"><%=request.getAttribute("errorMsg") != null ? request.getAttribute("errorMsg") : ""%></p>
        <p style="color:green"><%=request.getAttribute("successMsg") != null ? request.getAttribute("successMsg") : ""%></p>
        <table width="50%" border="1">
            <tr align="left"><th>Species kind</th><th>Species Category</th>
           
          
        </tr>
        <%
        dataaccess.DAO dataAccess=new dataaccess.DAO();
        java.sql.ResultSet  rst=dataAccess.listSpecies();
        while(rst.next()){
		String species=rst.getString("kind");
        %>
        <tr align="left"><td><%=species%></td><td><%=rst.getString("category")%></td>
        <%}
        dataAccess.closeConn();
        %>
        </table>
        
               
    </body>
</html>

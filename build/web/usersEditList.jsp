<%-- 
    Document   : usersList
    Created on : Oct 6, 2009, 1:03:21 AM
    Author     : user
--%>
<jsp:include page="AdminSecurity.jsp" flush="true"/>
<jsp:include page="Logo.jsp" flush="true"/>
<jsp:include page="MainMenu.jsp" flush="true"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%=request.getAttribute("SuccessMsg")!=null? request.getAttribute("SuccessMsg"):""%>
<%=request.getAttribute("ErrorMsg")!=null? request.getAttribute("ErrorMsg"):""%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users List</title>
    </head>
    <body>
        <h2>Users List For Editing</h2>
        <p style="color:red"><%=request.getAttribute("errorMsg") != null ? request.getAttribute("errorMsg") : ""%></p>
 <p style="color:green"><%=request.getAttribute("successMsg") != null ? request.getAttribute("successMsg") : ""%></p>
        <table width="50%" border="1">
            <tr align="left"><th>First name</th><th>Surname</th>
           <th>Location</th><th>E-Mail Address</th><th>Username</th><th>Password</th>
           <th>User category</th>
          <th></th>
          <th></th>
        </tr>
        <%
        
        dataaccess.DAO dataAccess=new dataaccess.DAO();
        java.sql.ResultSet  rst=dataAccess.listUsers();
        while(rst.next()){
		String firstname=rst.getString("firstname");
        %>
        <tr align="left"><td><%=firstname%></td><td><%=rst.getString("surname")%></td><td><%=rst.getString("location")%></td><td><%=rst.getString("email_address")%></td><td><%=rst.getString("username")%></td><td><%=rst.getString("password")%></td>
          <td><%=rst.getString("user_category")%></td>
         
        <td>
              <form action="/EndangeredSpecies_Proj/Relay" method="post">
              <input type="hidden" name="command" value="EditUser"/>
              <input type="hidden" name="username" value="<%=rst.getString("username")%>"/>
              <input type="submit" value="Edit"/>
               </form>
        </td>
         <td><form action="/EndangeredSpecies_Proj/Relay" method="post">
              <input type="hidden" name="command" value="DeleteUser"/>
              <input type="hidden" name="username" value="<%=rst.getString("username")%>"/>
              <input type="submit" value="Delete"/> </form></td>
        <%}
        dataAccess.closeConn();
        %>
        </table>
        
               
    </body>
</html>

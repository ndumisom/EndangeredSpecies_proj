<%-- 
    Document   : AddUserForm
    Created on : Oct 6, 2009, 10:56:07 AM
    Author     : bq8222
--%>
<jsp:include page="AdminSecurity.jsp" flush="true"/>
<jsp:include page="Logo.jsp" flush="true"/>
<jsp:include page="SecurityCheck.jsp" flush="true"/>
<jsp:include page="MainMenu.jsp" flush="true"/>
<%=request.getAttribute("SuccessMsg")!=null? request.getAttribute("SuccessMsg"):""%>
<%=request.getAttribute("ErrorMsg")!=null? request.getAttribute("ErrorMsg"):""%>
<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>
</head>

<body>
<p>Editing Users</p>
<hr />
<%
 String username=request.getParameter("username"); //get username from the request
 if(username!=null){ //check if username is specified
     
   dataaccess.DAO dataAccess=new dataaccess.DAO();
        java.sql.ResultSet  rst=dataAccess.getUser(username);
        if(rst.next()){ //we use if since there is only one record
		String user=rst.getString("username");
 
 %>
 <form action="/EndangeredSpecies_Proj/Relay" method="post">
<h2 align ="center">Edit User Form </h2>
<table width="50%" border="0.">
  <tr>
    <td width="20%">&nbsp;</td>
    <td width="80%">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>* Name </td>
    <td>
      <label>
        <input type="text" name="firstname" value="<%=rst.getString("firstname")%>" />
        </label>
     </td>
  </tr>
  <tr>
    <td>* Surname </td>
    <td>
      <label>
        <input type="text" name="surname" value="<%=rst.getString("surname")%>" />
        </label>
    </td>
  </tr>
  
    <tr>
    <td>* Location </td>
    <td>
      <select name="location">
              <%
        
                 dataaccess.DAO dataAcess=new dataaccess.DAO();
                 java.sql.ResultSet  rslt=dataAcess.listLocations();
                 while(rslt.next()){
		//String id=rst.getString("sight_id");
             %>
             <option selected="selected"><%=rst.getString("location")%></option>
             <option><%=rslt.getString("location")%></option>
               <%
               
               }
                 dataAcess.closeConn();
               %>
          </select>
    </td>
  </tr>
  <tr>
      <tr>
    <td>* E-Mail Address </td>
    <td>
        <label>
        <input type="text" name="email_address" value="<%=rst.getString("email_address")%>"/>
        </label>
      </td>
  </tr>
  <tr>
    <td>* User name </td>
    <td>
      <label>
        <input type="text" name="username" value="<%=rst.getString("username")%>"/>
        </label>
    </td>
  </tr>
  <tr>
    <td>* Password </td>
    <td>
      <label>
        <input type="password" name="password" value="<%=rst.getString("password")%>" />
        </label>
   </td>
  </tr>
  <tr>
    <td>User Category </td>
    <td>
      <label></label>
      <label>
      <select name="user_category">
          <option selected="selected"><%=rst.getString("user_category")%></option>
          <option>Administrator</option>
          <option>Manager</option>
          <option>Subscriber</option>
          </select>
      </label>
    </td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>
        <input type="submit" name="adduser" value="Submit" />
        <input type="hidden" name="command" value="EditUserServ"/>
    </td>
  </tr>
  </table></form>
  <%}}%>
</body>
</html>

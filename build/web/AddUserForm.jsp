<%-- 
    Document   : AddUserForm
    Created on : Oct 6, 2009, 10:56:07 AM
    Author     : bq8222
--%>
<jsp:include page="AdminSecurity.jsp" flush="true"/>
<jsp:include page="Logo.jsp" flush="true"/>
<jsp:include page="SecurityCheck.jsp" flush="true"/>
<jsp:include page="MainMenu.jsp" flush="true"/>
<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>
</head>

<body>
  
<p>Adding Users</p>
<hr />

<p style="color:red"><%=request.getAttribute("errorMsg") != null ? request.getAttribute("errorMsg") : ""%></p>
 <p style="color:green"><%=request.getAttribute("successMsg") != null ? request.getAttribute("successMsg") : ""%></p>
 <form action="/EndangeredSpecies_Proj/Relay" method="post">
<h2 align ="center">Add User Form </h2>
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
        <input type="text" name="firstname" />
        </label>
     </td>
  </tr>
  <tr>
    <td>* Surname </td>
    <td>
      <label>
        <input type="text" name="surname" />
        </label>
    </td>
  </tr>
  
  <tr>
  </tr>
  <tr>
    <td>* Location </td>
    <td>
      <label>
         <select name="location">
              <%
        
                 dataaccess.DAO dataAccess=new dataaccess.DAO();
                 java.sql.ResultSet  rst=dataAccess.listLocations();
                 while(rst.next()){
		//String id=rst.getString("sight_id");
             %>
               <option value="<%=rst.getString("location")%>"> <%=rst.getString("location")%></option>
               <%
               
               }
                 dataAccess.closeConn();
               %>
          </select>
        </label>
    </td>
  </tr>
  <tr>
      <tr>
    <td>* E-Mail Address </td>
    <td>
        <label>
        <input type="text" name="emailaddress" />
        </label>
      </td>
  </tr>
  <tr>
    <td>* User name </td>
    <td>
      <label>
        <input type="text" name="username" />
        </label>
    </td>
  </tr>
  <tr>
    <td>* Password </td>
    <td>
      <label>
        <input type="password" name="password" />
        </label>
   </td>
  </tr>
  <tr>
    <td>User Category </td>
    <td>
      <label></label>
      <label>
      <select name="usercategory">
        <option>Subscriber</option>
        <option>Administrator</option>
        <option>Manager</option>
      </select>
      </label>
    </td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>
        <input type="submit" name="adduser" value="Submit" />
        <input type="hidden" name="command" value="AddUser"/>
    </td>
  </tr>
  </table></form>
</body>
</html>

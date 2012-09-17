<%@ page language="java" import="java.sql.*"%>
<%
response.setHeader("Cache-Control","no-store");
response.setDateHeader("Expires", 0); //causes the proxy cache to see the page as "stale"
String dispatch="index.jsp";
String sesh=(String)session.getAttribute("user_category");

if (!sesh.equalsIgnoreCase("Manager")) { //checking if the session is null.
	request.setAttribute("errorMsg", "You are not allowed to view this page, it's for manager only!");
  	RequestDispatcher dispatcher = request.getRequestDispatcher(dispatch) ; 
    dispatcher.forward(request, response) ;//take the user to login page.
}
%>
<jsp:include page="ManagerMenu.jsp" flush="true"/>
<jsp:include page="Logo.jsp" flush="true"/>
<jsp:include page="SecurityCheck.jsp" flush="true"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Manager Home Page</title>
</head>

<body>

<table width="134%" border="0">
  <tr>
    <td>Your currently logged in as : <%=session.getAttribute("firstname")%> <%=session.getAttribute("surname")%><br>Level: <%=session.getAttribute("user_category")%> <br></td>
   
    <td width="72%"><h2 align="center">This is the manager home page!</h2></td>
    <td width="14%"><img src="pics/Mavuyi-0062.jpg" width="120" height="110" /></td>
  </tr>
 </table>
 <table><tr height="10%"></tr><tr><td width="50%"></td><td>
<form action="/EndangeredSpecies_Proj/Relay" method="POST">
    Choose User Category:
    <select name="user_category">
        <option>Administrator</option>
        <option>Manager</option>
        <option>Subscriber</option>
    </select><br>

    <input type="submit" value="Search" />
    <input type="hidden" name="command" value="SearchLog.jsp" />
</form></td><td></td></tr></table>
<p align="center">&nbsp;</p>
</body>
</html>

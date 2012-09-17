<%@ page language="java" import="java.sql.*"%>
<%
response.setHeader("Cache-Control","no-store");
response.setDateHeader("Expires", 0); //causes the proxy cache to see the page as "stale"
String dispatch="index.jsp";

if ( session.getAttribute("username")== null) { //checking if the session is null.
	request.setAttribute("errorMsg", "Session has ended.  Please login.");
  	RequestDispatcher dispatcher = request.getRequestDispatcher(dispatch) ; 
    dispatcher.forward(request, response) ;//take the user to login page.
}
%>
<%@ page language="java" import="java.sql.*"%>
<%
response.setHeader("Cache-Control","no-store");
response.setDateHeader("Expires", 0); //causes the proxy cache to see the page as "stale"
String dispatch="index.jsp";
String sesh=(String)session.getAttribute("user_category");
if(sesh.equalsIgnoreCase("subscriber")){
    dispatch="SubscriberHome.jsp";
}
else if(sesh.equalsIgnoreCase("Manager")){
    dispatch="ManagerHome.jsp";
}

if (!sesh.equalsIgnoreCase("Administrator")) { //checking if the session is null.
	request.setAttribute("errorMsg", "You are not allowed to view this page, it's for administrators only!");
  	RequestDispatcher dispatcher = request.getRequestDispatcher(dispatch) ; 
    dispatcher.forward(request, response) ;//take the user to login page.
}
%>
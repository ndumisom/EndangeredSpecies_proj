<jsp:include page="Logo.jsp" flush="true"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
    </head>
    <body>  
        <%
          request.getSession().invalidate();
          String home="index.jsp";
          RequestDispatcher rd =request.getRequestDispatcher(home);
          rd.forward(request, response); 
       %>
        
    </body>
</html>

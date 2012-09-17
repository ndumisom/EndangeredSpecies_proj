<%-- 
    Document   : AddSpeciesForm
    Created on : Nov 5, 2009, 4:24:03 PM
    Author     : bq8222
--%>
<jsp:include page="AdminSecurity.jsp" flush="true"/>
<jsp:include page="Logo.jsp" flush="true"/>
<jsp:include page="MainMenu.jsp" flush="true"/>
<jsp:include page="SecurityCheck.jsp" flush="true"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Species Form</title>
    </head>
    <body bgcolor="#HEHJRH">
        

 <form action="/EndangeredSpecies_Proj/Relay" method="POST">
     <%=request.getAttribute("SuccessMsg")!=null? request.getAttribute("SuccessMsg"):""%>
     <%=request.getAttribute("ErrorMsg")!=null? request.getAttribute("ErrorMsg"):""%>

    <p> Species Kind: <input type="text" name="kind" value="" /></p>
    <p>Species Category: <input type="text" name="category" value="" /></p>
    <p> <input type="submit" name="submit" /></p>
    <p> <input type="hidden" name="command" value="AddSpeciesServ" /></p>
    
</form>
    </body>
</html>

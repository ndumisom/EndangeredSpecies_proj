<%
String sesh=(String)session.getAttribute("user_category");
if(sesh !=null && sesh.equalsIgnoreCase("administrator"))
    {%>
        <jsp:include page="AdminMenu.jsp" flush="true"/>
    }
    <%}
else if(sesh.equalsIgnoreCase("subscriber"))
    {%>
        <jsp:include page="SubsMenu.jsp" flush="true" />
     <%}%>
     <body background="pics/Sleeping_Polar_Bear.jpg"></body>
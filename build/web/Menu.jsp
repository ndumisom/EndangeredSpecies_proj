<%
String sesh=(String)session.getAttribute("user_category");
if(sesh !=null && sesh.equalsIgnoreCase("manager"))
    {%>
        <jsp:include page="ManagerMenu.jsp" flush="true"/>
  }
 <%} %>
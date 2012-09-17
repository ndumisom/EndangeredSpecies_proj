<jsp:include page="Logo.jsp" flush="true"/>
<jsp:include page="SecurityCheck.jsp" flush="true"/>
<jsp:include page="MainMenu.jsp" flush="true"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Species Information Page</title>
</head>

<body>
        <h2>Sightings</h2>
        <p style="color:red"><%=request.getAttribute("errorMsg") != null ? request.getAttribute("errorMsg") : ""%></p>
 <p style="color:green"><%=request.getAttribute("successMsg") != null ? request.getAttribute("successMsg") : ""%></p>
        <table width="50%" border="1">
            <tr align="left"><th>Sighting Number</th><th>Species Name</th><th>Location</th><th>Number Sighted</th><th>Date Sighted</th>
           <th>User Name</th>
          
        </tr>
        <%
        
        dataaccess.DAO dataAccess=new dataaccess.DAO();
        java.sql.ResultSet  rst=dataAccess.listSightings();
        while(rst.next()){
		String id=rst.getString("sight_id");
        %>
        <tr align="left"><td><%=rst.getString("sight_id")%></td><td><%=rst.getString("spec_name")%></td><td><%=rst.getString("location")%></td><td><%=rst.getString("number_sighted")%></td><td><%=rst.getString("date_sighted")%></td><td><%=rst.getString("user_name")%></td>
       
          <%String sesh=(String)session.getAttribute("user_category");
                if(sesh !=null && sesh.equalsIgnoreCase("administrator")){%>
          <td><form action="/EndangeredSpecies_Proj/Relay" method="post">
              <input type="hidden" name="command" value="DeleteSpeciesServ"/>
              <input type="hidden" name="id" value="<%=rst.getString("sight_id")%>"/>
              <input type="submit" value="Delete"/> </form></td>
              <td>
                    <form action="/EndangeredSpecies_Proj/Relay" method="post">
                    <input type="hidden" name="command" value="EditSpeciesServlet"/>
                    <input type="hidden" name="id" value="<%=rst.getString("sight_id")%>"/>
                    <input type="submit" value="Edit"/>
               </form>
              </td>
        <%}}
        dataAccess.closeConn();
        %>
        </table>
        
               
    </body>
</html>

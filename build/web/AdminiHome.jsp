<jsp:include page="AdminSecurity.jsp" flush="true"/>
<jsp:include page="Logo.jsp" flush="true"/>
<jsp:include page="SecurityCheck.jsp" flush="true"/>
<jsp:include page="MainMenu.jsp" flush="true"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

<title>Administrator Home Page</title>
</head>

<body>
<table width="134%" border="0">
  <tr >
    <td width="14%">
        
        <p>Your currently logged in as : <%=session.getAttribute("firstname")%> <%=session.getAttribute("surname")%><br>Level: <%=session.getAttribute("user_category")%></td>
    <td width="72%"><h2 align="center">This is the administrator home page!</h2></td>
    <td width="14%"><img src="pics/Jigga-0003.jpg" width="120" height="100"/></td>
  </tr>
  <tr>      
   <table width="100%" border="1">
            <p style="color:red"><%=request.getAttribute("errorMsg") != null ? request.getAttribute("errorMsg") : ""%></p>
            <p style="color:green"><%=request.getAttribute("successMsg") != null ? request.getAttribute("successMsg") : ""%></p>
            <tr><th width="14%">Sighting Number</th><th width="14%">Species Name</th><th width="14%">Location</th><th width="14%">Number Sighted</th><th width="14%">Date Sighted</th>
            <th width="14%">User Name</th>
          
        </tr>
        <%
        
        dataaccess.DAO dataAccess=new dataaccess.DAO();
        java.sql.ResultSet  rst=dataAccess.listReports();
        while(rst.next()){
		String loc=rst.getString("location");
                java.sql.ResultSet  rslt=dataAccess.listCountries(loc);
        %>
        <tr align="left"><td><%=rst.getString("sight_id")%></td><td><%=rst.getString("spec_name")%></td><td><%=rst.getString("location")%></td><td><%=rst.getString("number_sighted")%></td><td><%=rst.getString("date_sighted")%></td><td><%=rst.getString("user_name")%></td>
       
          <td><form action="/EndangeredSpecies_Proj/Relay" method="post">
              <input type="hidden" name="command" value="RejectReportServ"/>
              <input type="hidden" name="id" value="<%=rst.getString("sight_id")%>"/>
              <input type="submit" value="Reject"/> </form></td>
              <td>
                    <form action="/EndangeredSpecies_Proj/Relay" method="post">
                    <input type="hidden" name="command" value="ApproveReportServ"/>
                    <input type="hidden" name="id" value="<%=rst.getString("sight_id")%>"/>
                    <input type="submit" value="Approve"/>
               </form>
              </td>
          </tr>
        <%}
        dataAccess.closeConn();
        %>
          
        </table>
     
     </tr>
  
</table>
<p align="center">&nbsp;</p>
</body>
</html>

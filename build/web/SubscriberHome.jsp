<jsp:include page="Logo.jsp" flush="true"/>
<jsp:include page="SecurityCheck.jsp" flush="true"/>
<jsp:include page="MainMenu.jsp" flush="true"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Subscriber Home Page</title>
<style type="text/css">
</style></head>
<body>

<table width="134%" border="3">
  <tr>
     <td>Your currently logged in as : <%=session.getAttribute("firstname")%> <%=session.getAttribute("surname")%><br>Level: <%=session.getAttribute("user_category")%></td>
   </tr>
  <tr>
      <table width="100%" border="1">
            <p style="color:red"><%=request.getAttribute("errorMsg") != null ? request.getAttribute("errorMsg") : ""%></p>
            <p style="color:green"><%=request.getAttribute("successMsg") != null ? request.getAttribute("successMsg") : ""%></p>
            <tr><th width="14%">Sighting Number</th><th width="14%">Species Name</th><th width="14%">Location</th><th width="14%">Number Sighted</th><th width="14%">Date Sighted</th>
            <th width="14%">User name</th>          
        </tr>
        <%
        String name=(String)session.getAttribute("username");
        System.out.println(name);
        dataaccess.DAO dataAccess=new dataaccess.DAO();
        java.sql.ResultSet  rst=dataAccess.showReports(name);
        while(rst.next()){
		
        %>
       <tr align="left">
           <td><%=rst.getString("sight_id")%></td>
           <td><%=rst.getString("spec_name")%></td>
           <td><%=rst.getString("location")%></td>
           <td><%=rst.getString("number_sighted")%></td>
           <td><%=rst.getString("date_sighted")%></td>
           <td><%=rst.getString("user_name")%></td>       
         
              <td>
                   <form action="/EndangeredSpecies_Proj/EditSpeciesForm.jsp" method="post">
                     <input type="hidden" name="command" value="EditSpeciesForm.jsp"/>
                    <input type="hidden" name="id" value="<%=rst.getString("sight_id")%>"/>
                    <input type="submit" value="update" name="submit" />
                    </form>
              </td>
          </tr>
        <%
        }
        dataAccess.closeConn();
        %>
          
        </table>
        
  </tr>
</table>
<p align="center">&nbsp;</p>
</body>
</html>

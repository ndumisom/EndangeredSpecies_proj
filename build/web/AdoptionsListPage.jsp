<jsp:include page="Logo.jsp" flush="true"/>
<jsp:include page="SecurityCheck.jsp" flush="true"/>
<jsp:include page="MainMenu.jsp" flush="true"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Species Adoption Page</title>
</head>

<body>
<table width="134%" height="292" border="0">
  <tr>
    <td><table width="100%" border="1">
            <p style="color:red"><%=request.getAttribute("errorMsg") != null ? request.getAttribute("errorMsg") : ""%></p>
            <p style="color:green"><%=request.getAttribute("successMsg") != null ?request.getAttribute("successMsg") : ""%></p>
            <tr>
                <th>Adoption Number</th><th>Species Name</th>
                <th>First name</th><th>Surname</th>
                <th>Card Type</th><th>Card Number</th>
                <th>Expiry Date</th><th>CVC</th><th>Amount Per Month</th>
          
            </tr>
        <%
            String sesh=(String)session.getAttribute("user_category");
            dataaccess.DAO dataAccess=new dataaccess.DAO();
            if(sesh.equalsIgnoreCase("administrator")){
                java.sql.ResultSet  rst=dataAccess.listAdoptions();
                while(rst.next()){
		
        %>
        <tr align="left">
            <td><%=rst.getString("adoption_id")%></td>
            <td><%=rst.getString("species_name")%></td>
            <td><%=rst.getString("first_name")%></td>
            <td><%=rst.getString("last_name")%></td>
            <td><%=rst.getString("card_type")%></td>
            <td><%=rst.getString("card_number")%></td>
            <td><%=rst.getString("exp_date")%></td>
            <td><%=rst.getString("cvc")%></td>
            <td>R <%=rst.getString("amount")%></td>
          
          <td><form action="/EndangeredSpecies_Proj/Relay" method="post">
              <input type="hidden" name="command" value="RemoveAdoptServ"/>
              <input type="hidden" name="id" value="<%=rst.getString("adoption_id")%>"/>
              <input type="submit" value="Remove"/> </form></td>
              <%}%>
          </tr>
        <%}
            else{
                String name=(String)session.getAttribute("firstname");
                java.sql.ResultSet  rst=dataAccess.showAdoptions(name);
                while(rst.next()){
		
        %>
        <tr align="left">
            <td><%=rst.getString("adoption_id")%></td>
            <td><%=rst.getString("species_name")%></td>
            <td><%=rst.getString("first_name")%></td>
            <td><%=rst.getString("last_name")%></td>
            <td><%=rst.getString("card_type")%></td>
            <td><%=rst.getString("card_number")%></td>
            <td><%=rst.getString("exp_date")%></td>
            <td><%=rst.getString("cvc")%></td>
            <td>R <%=rst.getString("amount")%></td>
            
            <td><form action="/EndangeredSpecies_Proj/Relay" method="post">
              <input type="hidden" name="command" value="RemoveAdoptServ"/>
              <input type="hidden" name="id" value="<%=rst.getString("adoption_id")%>"/>
              <input type="submit" value="Remove"/> </form></td>
          <%  }}
        dataAccess.closeConn();
        %>
          
        </table></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
<p align="center">&nbsp;</p>
</body>
</html>

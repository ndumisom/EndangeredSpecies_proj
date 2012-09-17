<jsp:include page="Logo.jsp" flush="true"/>
<jsp:include page="SecurityCheck.jsp" flush="true"/>
<jsp:include page="MainMenu.jsp" flush="true"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Sighting Report Submition</title>
<script type="text/JavaScript">
<!--
function MM_jumpMenu(targ,selObj,restore){ //v3.0
  eval(targ+".location='"+selObj.options[selObj.selectedIndex].value+"'");
  if (restore) selObj.selectedIndex=0;
}
//-->
</script>
<style type="text/css">
<!--
body {
	background-color: #FFFFFF;
}
-->
</style></head>

<body
    <h1>Enter sighted species information</h1>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p style="color:red"><%=request.getAttribute("errorMsg") != null ? request.getAttribute("errorMsg") : ""%></p>
<p style="color:green"><%=request.getAttribute("successMsg") != null ? request.getAttribute("successMsg") : ""%></p>

 <form id="form1" name="form1" method="post" action="/EndangeredSpecies_Proj/Relay">
  <table width="50%" border="0.">
    
     <tr>
      <td>Species Name</td>
      <td><select name="name">
              <%
        
                 dataaccess.DAO dataAccess=new dataaccess.DAO();
                 java.sql.ResultSet  rst=dataAccess.listSpecCat();
                 while(rst.next()){
		
             %>
               <option value="<%=rst.getString("spec_name")%>"> <%=rst.getString("spec_name")%></option>
               <%
               
               }
                 dataAccess.closeConn();
               %>
          </select></td>
    </tr>
    <tr>
      <td>Location</td>
      <td><select name="loc">
              <%
        
                 dataaccess.DAO dataAcess=new dataaccess.DAO();
                 java.sql.ResultSet  rslt=dataAcess.listLocations();
                 while(rslt.next()){
		//String id=rst.getString("sight_id");
             %>
               <option value="<%=rslt.getString("location")%>"> <%=rslt.getString("location")%></option>
               <%
               
               }
                 dataAcess.closeConn();
               %>
          </select></td>
    </tr>
     
    <tr>
      <td>Number sighted </td>
      <td><label>
        <input type="text" name="number" />
</label></tr>
    
    
    <tr>
      <td>Date Sighted</td>
      <td><label>
        <input type="text" name="date" />
      </label></td>
    </tr>
    <tr>
      <td>
        <input name="fname" type="hidden" value="<%=session.getAttribute("username")%>">
      </td>
    </tr>

    <tr>
      <td><input type="submit" value="Submit" name="submit"/>
      <input type="hidden" name="command" value="ReportSightingServlet"></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
  </table>
</form>
<p>&nbsp;</p>
</body>
</html>

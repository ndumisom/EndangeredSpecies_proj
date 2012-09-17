<%-- 
    Document   : AddSightingForm
    Created on : Oct 6, 2009, 10:56:07 AM
    Author     : bq8222
--%>
<jsp:include page="AdminSecurity.jsp" flush="true"/>
<jsp:include page="Logo.jsp" flush="true"/>
<jsp:include page="SecurityCheck.jsp" flush="true"/>
<jsp:include page="MainMenu.jsp" flush="true"/>
<%=request.getAttribute("SuccessMsg")!=null? request.getAttribute("SuccessMsg"):""%>
<%=request.getAttribute("ErrorMsg")!=null? request.getAttribute("ErrorMsg"):""%>
<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Edit Sighting</title>
</head>

<body>
<p>Editing sighting</p>
<hr />

<p style="color:red"><%=request.getAttribute("errorMsg") != null ? request.getAttribute("errorMsg") : ""%></p>
 <p style="color:green"><%=request.getAttribute("successMsg") != null ? request.getAttribute("successMsg") : ""%></p>
 
 <%
 String sight_id=request.getParameter("id");
 
 if(sight_id!=null){     
   dataaccess.DAO dataAccess=new dataaccess.DAO();
   java.sql.ResultSet  rst=dataAccess.getSighting(sight_id);
   if(rst.next()){ 
         
%>
 <form action="/EndangeredSpecies_Proj/Relay" method="post">
<h2 align ="center">Edit Sighting Form </h2>
<table width="50%" border="0.">
  <tr>
    <td width="20%">&nbsp;</td>
    <td width="80%">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>* Sight_id :</td>
    <td>
      <label>
          <%=rst.getString("sight_id")%>
        <input type="hidden" name="sight_id" value="<%=rst.getString("sight_id")%>" />
        </label>
     </td>
  </tr>
  <tr>
    <td>Species Name:</td>
      <td><select name="name">
              <%
                 dataaccess.DAO datAccess=new dataaccess.DAO();
                 java.sql.ResultSet  Rst=datAccess.listSpecCat();
                %> <option  selected="selected" ><%=rst.getString("spec_name")%></option>
               <%  while(Rst.next()){
		
             %>
               <option> <%=Rst.getString("spec_name")%></option>
               <%
               
               }
                 datAccess.closeConn();
              %>
          </select></td>
  </tr>
  <tr>
    <td>* Species Location :</td>
    <td>
      <select name="location">
              <%
        
                 dataaccess.DAO dataAcess=new dataaccess.DAO();
                 java.sql.ResultSet  rslt=dataAcess.listLocations();%>
                 <option selected="selected"><%=rst.getString("location")%></option>
             <%    while(rslt.next()){
		
             %>
             
             <option><%=rslt.getString("location")%></option>
               <%
               
               }
                 dataAcess.closeConn();
               %>
          </select>
    </td>
  </tr>
    <tr>
    <td>* Number Sighted :</td>
    <td>
      
        <input type="text" name="number_sighted" value="<%=rst.getString("number_sighted")%>">
        
    </td>
  </tr>
  <tr>
      <td> Date Sighted:</td>
      <td>
          <input type="text" name="date_sighted" value="<%=rst.getString("date_sighted")%>">
          <i>yyyy-mm-dd</i>
      </td>
  </tr>
   
  <tr>
    <td>
      <label>
        <input type="hidden" name="user_name" value="<%=rst.getString("user_name")%>">
        </label>
    </td>
  </tr>
  
  <tr>
    <td>&nbsp;</td>
    <td>
        <input type="submit" name="adduser" value="Submit" />
        <input type="hidden" name="command" value="EditSpeciesServlet"/>
    </td>
  </tr>
  </table></form>
  <%}
 dataAccess.closeConn();}
 %>
    <h3>demo</h3>
    
</body>
</html>

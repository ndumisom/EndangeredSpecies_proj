<jsp:include page="Logo.jsp" flush="true"/>
<jsp:include page="SecurityCheck.jsp" flush="true"/>
<jsp:include page="MainMenu.jsp" flush="true"/>
<p style="color:red"><%=request.getAttribute("errorMsg") != null ? request.getAttribute("errorMsg") : ""%></p>
<p style="color:green"><%=request.getAttribute("successMsg") != null ? request.getAttribute("successMsg") : ""%></p>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Adoption Form</title>
</head>

<body>
<h3 align="center">
Your Credit Card Information</h3>
<form id="form1" name="form1" method="post" action="/EndangeredSpecies_Proj/Relay">
  <table width="100%" height="154" border="0">
    <tr>
      <td width="91%">&nbsp;</td>
      <td width="1%">&nbsp;</td>
      <td width="8%"><label></label></td>
    </tr>
    <tr>
      <td>
        <tr>
          <td><label></label></td>
        </tr>
        <tr>
          <td><label></label></td>
        </tr>
        <tr>
          <td><label></label></td>
        </tr>
        <tr>
          <td><label></label></td>
        </tr>
        <tr>
            
          <td><label></label></td>
        </tr>
        <tr>
          <td><label></label></td>
        </tr>
      </td>
      <td><table width="99%" border="0.">
        <tr>
          <td width="13%">Card Type </td>
          <td width="43%"><label>
            <select name="card_type">
              <option>Visa</option>
              <option>MasterCard</option>
              <option>LifeStart</option>
              <option>Mzansi</option>
            </select>
          </label></td>
          <td width="9%">Card Number</td>
          <td width="35%"><input type="text" name="card_number" /></td>
          <td width="35%">Species Name </td>
          <td width="35%"><label>
            <select name="names">
              <%
        
                 dataaccess.DAO dataAccess=new dataaccess.DAO();
                 java.sql.ResultSet  rst=dataAccess.showSpecs();
                 while(rst.next()){
		
             %>
               <option> <%=rst.getString("spec_name")%></option>
               <%
               
               }
                 dataAccess.closeConn();
               %>
          </select>
          </label></td>
        </tr>
        <tr>
          <td>Expiry Date </td>
          <td>
            <input name="exp_date" type="text" />
            <i>yyyy-mm-dd</i>          </td>
          <td>CVC</td>
          <td><input type="text" name="cvc" maxlength="3"/></td>
          <td>Amount To Pay A Month </td>
          <td><label>
            <input type="text" name="amount" />
          </label></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><img src="pics/d_s.gif" width="28" height="35" /></td>
          <td>&nbsp;</td>
          <td><img src="pics/d_s.gif" width="28" height="35" /></td>
          <td>&nbsp;</td>
          <td><input type="submit" name="submit" value="Submit" />
            <input type="hidden" name="fname" value="<%=session.getAttribute("firstname")%>" />
            <input type="hidden" name="lname" value="<%=session.getAttribute("surname")%>" />
            <input type="hidden" name="command" value="AdoptionServ" /></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><img src="pics/visa_expire_info.gif" width="147" height="93" /></td>
          <td>&nbsp;</td>
          <td><img src="pics/visa_cvc_info.gif" width="147" height="93" /></td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td>Expiry date <br />
            The expiry date is on the front of your card. It consists of 2  numbers with two digits each separated by a slash or a dot, for example  12/12. The first 2 digits specify the month and the last 2 specify the  year when your card expires.</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>CVC/ Card Verification Code. <br />
            For security reasons we also ask you to supply your card's CVC  code. It is the last three digits situated in the signature field on  the back of your credit card.</td>
        </tr>
      </table></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
  </table>
  <p>&nbsp;</p>
</form>
</body>
</html>

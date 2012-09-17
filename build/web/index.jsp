<%-- 
    Document   : LoginForm
    Created on : Oct 6, 2009, 10:40:03 AM
    Author     : bq8222
--%>
<jsp:include page="Logo.jsp" flush="true"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Group D Project</title>
<script type="text/JavaScript">
<!--
function MM_goToURL() { //v3.0
  var i, args=MM_goToURL.arguments; document.MM_returnValue = false;
  for (i=0; i<(args.length-1); i+=2) eval(args[i]+".location='"+args[i+1]+"'");
}
-->
</script>
</head>

<body>
<h2 align="center">Welcome to Group D Project!</h2>
<p style="color:red"><%=request.getAttribute("errorMsg") != null ? request.getAttribute("errorMsg") : ""%></p>
<form id="form1" name="form1" method="post" action="/EndangeredSpecies_Proj/Relay">
  <table width="100%" border="0.">
    
    <tr>
      <td width="21%"><p>This is the one and the only site where you can simply view to play around and find new friends! </p>
      <p>Feel free to join us now, and enjoy the fantacy of being with the animals you like. </p></td>
      <td width="48%"><img src="pics/images3.jpg" width="81" height="120" /> <img src="pics/images6.jpg" width="92" height="119" /> <img src="pics/images5.jpg" width="87" height="119" /></td>
      <td width="31%">You have all unto you, but remember, tell us about who you are in the login part or, consult the system administrator to subscribe. </td>
    </tr>
    
    
    <tr>
      <td><img src="pics/images2.jpg" width="224" height="162" /></td>
      <td><table width="98%" border="0.">
        <tr>
          <td width="33%">username</td>
          <td width="67%"><label>
            <input type="text" name="username"/>
          </label></td>
        </tr>
        <tr>
          <td>password</td>
          <td><label>
            <input type="password" name="password" />
          </label></td>
        </tr>
        <tr>
          <td><label>
          <input type="image" name="login" src="pics/lion-login.jpg" />
          <input name="command" type="hidden" value="LoginServlet"/>
          </label></td>
          
        </tr>
      </table>
   
        <p>&nbsp;</p></td>
      <td><img src="pics/images.jpg" width="223" height="163" /></td>
    </tr>
  </table>
</form>
</body>
</html>

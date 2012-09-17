package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.apache.jasper.runtime.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Logo.jsp", out, true);
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\n");
      out.write("<title>Group D Project</title>\n");
      out.write("<script type=\"text/JavaScript\">\n");
      out.write("<!--\n");
      out.write("function MM_goToURL() { //v3.0\n");
      out.write("  var i, args=MM_goToURL.arguments; document.MM_returnValue = false;\n");
      out.write("  for (i=0; i<(args.length-1); i+=2) eval(args[i]+\".location='\"+args[i+1]+\"'\");\n");
      out.write("}\n");
      out.write("-->\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("<h2 align=\"center\">Welcome to Group D Project!</h2>\n");
      out.write("<p style=\"color:red\">");
      out.print(request.getAttribute("errorMsg") != null ? request.getAttribute("errorMsg") : "");
      out.write("</p>\n");
      out.write("<form id=\"form1\" name=\"form1\" method=\"post\" action=\"/EndangeredSpecies_Proj/Relay\">\n");
      out.write("  <table width=\"100%\" border=\"0.\">\n");
      out.write("    \n");
      out.write("    <tr>\n");
      out.write("      <td width=\"21%\"><p>This is the one and the only site where you can simply view to play around and find new friends! </p>\n");
      out.write("      <p>Feel free to join us now, and enjoy the fantacy of being with the animals you like. </p></td>\n");
      out.write("      <td width=\"48%\"><img src=\"pics/images3.jpg\" width=\"81\" height=\"120\" /> <img src=\"pics/images6.jpg\" width=\"92\" height=\"119\" /> <img src=\"pics/images5.jpg\" width=\"87\" height=\"119\" /></td>\n");
      out.write("      <td width=\"31%\">You have all unto you, but remember, tell us about who you are in the login part or, consult the system administrator to subscribe. </td>\n");
      out.write("    </tr>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <tr>\n");
      out.write("      <td><img src=\"pics/images2.jpg\" width=\"224\" height=\"162\" /></td>\n");
      out.write("      <td><table width=\"98%\" border=\"0.\">\n");
      out.write("        <tr>\n");
      out.write("          <td width=\"33%\">username</td>\n");
      out.write("          <td width=\"67%\"><label>\n");
      out.write("            <input type=\"text\" name=\"username\"/>\n");
      out.write("          </label></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("          <td>password</td>\n");
      out.write("          <td><label>\n");
      out.write("            <input type=\"password\" name=\"password\" />\n");
      out.write("          </label></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("          <td><label>\n");
      out.write("          <input type=\"image\" name=\"login\" src=\"pics/lion-login.jpg\" />\n");
      out.write("          <input name=\"command\" type=\"hidden\" value=\"LoginServlet\"/>\n");
      out.write("          </label></td>\n");
      out.write("          \n");
      out.write("        </tr>\n");
      out.write("      </table>\n");
      out.write("   \n");
      out.write("        <p>&nbsp;</p></td>\n");
      out.write("      <td><img src=\"pics/images.jpg\" width=\"223\" height=\"163\" /></td>\n");
      out.write("    </tr>\n");
      out.write("  </table>\n");
      out.write("</form>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

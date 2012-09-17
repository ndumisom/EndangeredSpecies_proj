package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class ManagerHome_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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

      out.write('\r');
      out.write('\n');

response.setHeader("Cache-Control","no-store");
response.setDateHeader("Expires", 0); //causes the proxy cache to see the page as "stale"
String dispatch="index.jsp";
String sesh=(String)session.getAttribute("user_category");

if (!sesh.equalsIgnoreCase("Manager")) { //checking if the session is null.
	request.setAttribute("errorMsg", "You are not allowed to view this page, it's for manager only!");
  	RequestDispatcher dispatcher = request.getRequestDispatcher(dispatch) ; 
    dispatcher.forward(request, response) ;//take the user to login page.
}

      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Logo.jsp", out, true);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "SecurityCheck.jsp", out, true);
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\r\n");
      out.write("<title>Manager Home Page</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<table width=\"134%\" border=\"0\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>Your currently logged in as : ");
      out.print(session.getAttribute("firstname"));
      out.write(' ');
      out.print(session.getAttribute("surname"));
      out.write("<br>Level: ");
      out.print(session.getAttribute("user_category"));
      out.write(" <br><a href=\"logout.jsp\">Logout</a> |</td>\r\n");
      out.write("   \r\n");
      out.write("    <td width=\"72%\"><h2 align=\"center\">This is the manager home page!</h2></td>\r\n");
      out.write("    <td width=\"14%\"><img src=\"pics/Mavuyi-0062.jpg\" width=\"120\" height=\"110\" /></td>\r\n");
      out.write("  </tr>\r\n");
      out.write(" </table>\r\n");
      out.write(" <table><tr height=\"10%\"></tr><tr><td width=\"50%\"></td><td>\r\n");
      out.write("<form action=\"/EndangeredSpecies_Proj/Relay\" method=\"POST\">\r\n");
      out.write("    Choose User Category:\r\n");
      out.write("    <select name=\"user_category\">\r\n");
      out.write("        <option>Administrator</option>\r\n");
      out.write("        <option>Manager</option>\r\n");
      out.write("        <option>Subscriber</option>\r\n");
      out.write("    </select><br>\r\n");
      out.write("\r\n");
      out.write("    <input type=\"submit\" value=\"Search\" />\r\n");
      out.write("    <input type=\"hidden\" name=\"command\" value=\"SearchLog.jsp\" />\r\n");
      out.write("</form></td><td></td></tr></table>\r\n");
      out.write("<p align=\"center\">&nbsp;</p>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

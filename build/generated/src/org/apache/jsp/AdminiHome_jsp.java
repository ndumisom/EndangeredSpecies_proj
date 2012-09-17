package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AdminiHome_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "SecurityCheck.jsp", out, true);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "MainMenu.jsp", out, true);
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\r\n");
      out.write("\r\n");
      out.write("<title>Administrator Home Page</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<table width=\"134%\" border=\"0\">\r\n");
      out.write("  <tr >\r\n");
      out.write("    <td width=\"14%\">\r\n");
      out.write("        \r\n");
      out.write("        <p>Your currently logged in as : ");
      out.print(session.getAttribute("firstname"));
      out.write(' ');
      out.print(session.getAttribute("surname"));
      out.write("<br>Level: ");
      out.print(session.getAttribute("user_category"));
      out.write("</td>\r\n");
      out.write("    <td width=\"72%\"><h2 align=\"center\">This is the administrator home page!</h2></td>\r\n");
      out.write("    <td width=\"14%\"><img src=\"pics/Jigga-0003.jpg\" width=\"120\" height=\"100\"/></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>      \r\n");
      out.write("   <table width=\"100%\" border=\"1\">\r\n");
      out.write("            <p style=\"color:red\">");
      out.print(request.getAttribute("errorMsg") != null ? request.getAttribute("errorMsg") : "");
      out.write("</p>\r\n");
      out.write("            <p style=\"color:green\">");
      out.print(request.getAttribute("successMsg") != null ? request.getAttribute("successMsg") : "");
      out.write("</p>\r\n");
      out.write("            <tr><th width=\"14%\">Sighting Number</th><th width=\"14%\">Species Name</th><th width=\"14%\">Country</th><th width=\"14%\">Location</th><th width=\"14%\">Number Sighted</th><th width=\"14%\">Date Sighted</th>\r\n");
      out.write("            <th width=\"14%\">User Name</th>\r\n");
      out.write("          \r\n");
      out.write("        </tr>\r\n");
      out.write("        ");

        
        dataaccess.DAO dataAccess=new dataaccess.DAO();
        java.sql.ResultSet  rst=dataAccess.listReports();
        while(rst.next()){
		String loc=rst.getString("location");
                java.sql.ResultSet  rslt=dataAccess.listCountries(loc);
        
      out.write("\r\n");
      out.write("        <tr align=\"left\"><td>");
      out.print(rst.getString("sight_id"));
      out.write("</td><td>");
      out.print(rst.getString("spec_name"));
      out.write("</td><td>");
//=rslt.getString("country")
      out.write("</td><td>");
      out.print(rst.getString("location"));
      out.write("</td><td>");
      out.print(rst.getString("number_sighted"));
      out.write("</td><td>");
      out.print(rst.getString("date_sighted"));
      out.write("</td><td>");
      out.print(rst.getString("user_name"));
      out.write("</td>\r\n");
      out.write("       \r\n");
      out.write("          <td><form action=\"/EndangeredSpecies_Proj/Relay\" method=\"post\">\r\n");
      out.write("              <input type=\"hidden\" name=\"command\" value=\"RejectReportServ\"/>\r\n");
      out.write("              <input type=\"hidden\" name=\"id\" value=\"");
      out.print(rst.getString("sight_id"));
      out.write("\"/>\r\n");
      out.write("              <input type=\"submit\" value=\"Reject\"/> </form></td>\r\n");
      out.write("              <td>\r\n");
      out.write("                    <form action=\"/EndangeredSpecies_Proj/Relay\" method=\"post\">\r\n");
      out.write("                    <input type=\"hidden\" name=\"command\" value=\"ApproveReportServ\"/>\r\n");
      out.write("                    <input type=\"hidden\" name=\"id\" value=\"");
      out.print(rst.getString("sight_id"));
      out.write("\"/>\r\n");
      out.write("                    <input type=\"submit\" value=\"Approve\"/>\r\n");
      out.write("               </form>\r\n");
      out.write("              </td>\r\n");
      out.write("          </tr>\r\n");
      out.write("        ");
}
        dataAccess.closeConn();
        
      out.write("\r\n");
      out.write("          \r\n");
      out.write("        </table>\r\n");
      out.write("     \r\n");
      out.write("     </tr>\r\n");
      out.write("  \r\n");
      out.write("</table>\r\n");
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

package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class SearchLog_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Logo.jsp", out, true);
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "SecurityCheck.jsp", out, true);
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "MainMenu.jsp", out, true);
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\n");
      out.write("<title>The Log table</title>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("<table width=\"134%\" height=\"292\" border=\"0\">\n");
      out.write("  <tr>\n");
      out.write("    <td>\n");
      out.write("        <table width=\"100%\" border=\"1\">\n");
      out.write("            <p style=\"color:red\">");
      out.print(request.getAttribute("errorMsg") != null ? request.getAttribute("errorMsg") : "");
      out.write("</p>\n");
      out.write("            <p style=\"color:green\">");
      out.print(request.getAttribute("successMsg") != null ? request.getAttribute("successMsg") : "");
      out.write("</p>\n");
      out.write("            <tr><th width=\"14%\">Log ID</th><th width=\"14%\">User First Name</th><th width=\"14%\">User Last Name</th><th width=\"14%\">User Category</th><th width=\"14%\">Log Time</th>\n");
      out.write("            <th width=\"14%\">Request Made</th>\n");
      out.write("          \n");
      out.write("        </tr>\n");
      out.write("         ");

         String cat="Subscriber";//request.getParameter("usercategory");
         String reqs="*";//request.getParameter("reqs");
        dataaccess.DAO dataAccess=new dataaccess.DAO();
        java.sql.ResultSet  rst=dataAccess.ShowLog(cat,reqs);
        while(rst.next()){
		
        
      out.write("\n");
      out.write("        <tr align=\"left\">\n");
      out.write("            <td>");
      out.print(rst.getString("log_id"));
      out.write("</td>\n");
      out.write("            <td>");
      out.print(rst.getString("firstname"));
      out.write("</td>\n");
      out.write("            <td>");
      out.print(rst.getString("lastname"));
      out.write("</td>\n");
      out.write("             <td>");
      out.print(rst.getString("user_category"));
      out.write("</td>\n");
      out.write("            <td>");
      out.print(rst.getString("log_time"));
      out.write("</td>\n");
      out.write("            <td>");
      out.print(rst.getString("request"));
      out.write("</td>\n");
      out.write("         </tr>\n");
      out.write("        ");
}
        dataAccess.closeConn();
        
      out.write("\n");
      out.write("          \n");
      out.write("        </table>\n");
      out.write("    </td>\n");
      out.write("    <td>&nbsp;</td>\n");
      out.write("    <td>&nbsp;</td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td>&nbsp;</td>\n");
      out.write("    <td>&nbsp;</td>\n");
      out.write("    <td>&nbsp;</td>\n");
      out.write("  </tr>\n");
      out.write("</table>\n");
      out.write("<p align=\"center\">&nbsp;</p>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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

package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ReportSighting_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\r\n");
      out.write("<title>Sighting Report Submition</title>\r\n");
      out.write("<script type=\"text/JavaScript\">\r\n");
      out.write("<!--\r\n");
      out.write("function MM_jumpMenu(targ,selObj,restore){ //v3.0\r\n");
      out.write("  eval(targ+\".location='\"+selObj.options[selObj.selectedIndex].value+\"'\");\r\n");
      out.write("  if (restore) selObj.selectedIndex=0;\r\n");
      out.write("}\r\n");
      out.write("//-->\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("<!--\r\n");
      out.write("body {\r\n");
      out.write("\tbackground-color: #FFFFFF;\r\n");
      out.write("}\r\n");
      out.write("-->\r\n");
      out.write("</style></head>\r\n");
      out.write("\r\n");
      out.write("<body\r\n");
      out.write("    <h1>Enter sighted species information</h1>\r\n");
      out.write("<p>&nbsp;</p>\r\n");
      out.write("<p>&nbsp;</p>\r\n");
      out.write("<p style=\"color:red\">");
      out.print(request.getAttribute("errorMsg") != null ? request.getAttribute("errorMsg") : "");
      out.write("</p>\r\n");
      out.write("<p style=\"color:green\">");
      out.print(request.getAttribute("successMsg") != null ? request.getAttribute("successMsg") : "");
      out.write("</p>\r\n");
      out.write("\r\n");
      out.write(" <form id=\"form1\" name=\"form1\" method=\"post\" action=\"/EndangeredSpecies_Proj/Relay\">\r\n");
      out.write("  <table width=\"50%\" border=\"0.\">\r\n");
      out.write("    \r\n");
      out.write("     <tr>\r\n");
      out.write("      <td>Species Name</td>\r\n");
      out.write("      <td><select name=\"name\">\r\n");
      out.write("              ");

        
                 dataaccess.DAO dataAccess=new dataaccess.DAO();
                 java.sql.ResultSet  rst=dataAccess.listSpecCat();
                 while(rst.next()){
		
             
      out.write("\r\n");
      out.write("               <option value=\"");
      out.print(rst.getString("spec_name"));
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print(rst.getString("spec_name"));
      out.write("</option>\r\n");
      out.write("               ");

               
               }
                 dataAccess.closeConn();
               
      out.write("\r\n");
      out.write("          </select></td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("      <td>Location</td>\r\n");
      out.write("      <td><select name=\"loc\">\r\n");
      out.write("              ");

        
                 dataaccess.DAO dataAcess=new dataaccess.DAO();
                 java.sql.ResultSet  rslt=dataAcess.listLocations();
                 while(rslt.next()){
		//String id=rst.getString("sight_id");
             
      out.write("\r\n");
      out.write("               <option value=\"");
      out.print(rslt.getString("location"));
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print(rslt.getString("location"));
      out.write("</option>\r\n");
      out.write("               ");

               
               }
                 dataAcess.closeConn();
               
      out.write("\r\n");
      out.write("          </select></td>\r\n");
      out.write("    </tr>\r\n");
      out.write("     \r\n");
      out.write("    <tr>\r\n");
      out.write("      <td>Number sighted </td>\r\n");
      out.write("      <td><label>\r\n");
      out.write("        <input type=\"text\" name=\"number\" />\r\n");
      out.write("</label></tr>\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    <tr>\r\n");
      out.write("      <td>Date Sighted</td>\r\n");
      out.write("      <td><label>\r\n");
      out.write("        <input type=\"text\" name=\"date\" />\r\n");
      out.write("      </label></td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("      <td>\r\n");
      out.write("        <input name=\"fname\" type=\"hidden\" value=\"");
      out.print(session.getAttribute("username"));
      out.write("\">\r\n");
      out.write("      </td>\r\n");
      out.write("    </tr>\r\n");
      out.write("\r\n");
      out.write("    <tr>\r\n");
      out.write("      <td><input type=\"submit\" value=\"Submit\" name=\"submit\"/>\r\n");
      out.write("      <input type=\"hidden\" name=\"command\" value=\"ReportSightingServlet\"></td>\r\n");
      out.write("      <td>&nbsp;</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("      <td>&nbsp;</td>\r\n");
      out.write("      <td>&nbsp;</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("  </table>\r\n");
      out.write("</form>\r\n");
      out.write("<p>&nbsp;</p>\r\n");
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

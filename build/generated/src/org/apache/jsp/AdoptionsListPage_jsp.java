package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AdoptionsListPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "AdminMenu.jsp", out, true);
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\r\n");
      out.write("<title>Species Adoption Page</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<table width=\"134%\" height=\"292\" border=\"0\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td width=\"14%\" height=\"45\">&nbsp;</td>\r\n");
      out.write("    <td width=\"72%\"><h2 align=\"center\">This is the list of all the adoptions we have!</h2></td>\r\n");
      out.write("    <td width=\"14%\">&nbsp;</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td><table width=\"100%\" border=\"1\">\r\n");
      out.write("            <p style=\"color:red\">");
      out.print(request.getAttribute("errorMsg") != null ? request.getAttribute("errorMsg") : "");
      out.write("</p>\r\n");
      out.write("            <p style=\"color:green\">");
      out.print(request.getAttribute("successMsg") != null ? request.getAttribute("successMsg") : "");
      out.write("</p>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th>adoption_id</th><th>sighting_id</th>\r\n");
      out.write("                <th>user_fname</th><th>user_lname</th>\r\n");
      out.write("                <th>card_type</th><th>card_number</th>\r\n");
      out.write("                <th>exp_date</th><th>cvc</th><th>amount</th>\r\n");
      out.write("          \r\n");
      out.write("            </tr>\r\n");
      out.write("        ");

        
        dataaccess.DAO dataAccess=new dataaccess.DAO();
        java.sql.ResultSet  rst=dataAccess.listSpecies();
        while(rst.next()){
		String id=rst.getString("adoption_id");
        
      out.write("\r\n");
      out.write("        <tr align=\"left\"><td>");
      out.print(id);
      out.write("</td><td>");
      out.print(rst.getString("sighting_id"));
      out.write("</td><td>");
      out.print(rst.getString("user_name"));
      out.write("</td><td>");
      out.print(rst.getString("card_type"));
      out.write("</td><td>");
      out.print(rst.getString("card_number"));
      out.write("</td><td>");
      out.print(rst.getString("exp_date"));
      out.write("</td>\r\n");
      out.write("       <td>");
      out.print(rst.getString("cvc"));
      out.write("</td><td>");
      out.print(rst.getString("amount"));
      out.write("</td>\r\n");
      out.write("          <td><form action=\"/EndangeredSpecies_Proj/Relay\" method=\"post\">\r\n");
      out.write("              <input type=\"hidden\" name=\"command\" value=\"RemoveAdoptServ\"/>\r\n");
      out.write("              <input type=\"hidden\" name=\"id\" value=\"");
      out.print(rst.getString("sight_id"));
      out.write("\"/>\r\n");
      out.write("              <input type=\"submit\" value=\"Remove\"/> </form></td>\r\n");
      out.write("              \r\n");
      out.write("          </tr>\r\n");
      out.write("        ");
}
        dataAccess.closeConn();
        
      out.write("\r\n");
      out.write("          \r\n");
      out.write("        </table></td>\r\n");
      out.write("    <td>&nbsp;</td>\r\n");
      out.write("    <td>&nbsp;</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>&nbsp;</td>\r\n");
      out.write("    <td>&nbsp;</td>\r\n");
      out.write("    <td>&nbsp;</td>\r\n");
      out.write("  </tr>\r\n");
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

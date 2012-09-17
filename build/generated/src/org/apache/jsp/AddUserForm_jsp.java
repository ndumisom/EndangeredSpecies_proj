package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class AddUserForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=iso-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "SecurityCheck.jsp", out, true);
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\n");
      out.write("<title>Untitled Document</title>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("  \n");
      out.write("<p>Adding Users</p>\n");
      out.write("<hr />\n");
      out.write("\n");
      out.write("<p style=\"color:red\">");
      out.print(request.getAttribute("errorMsg") != null ? request.getAttribute("errorMsg") : "");
      out.write("</p>\n");
      out.write(" <p style=\"color:green\">");
      out.print(request.getAttribute("successMsg") != null ? request.getAttribute("successMsg") : "");
      out.write("</p>\n");
      out.write(" <form action=\"/EndangeredSpecies_Proj/Relay\" method=\"post\">\n");
      out.write("<h2 align =\"center\">Add User Form </h2>\n");
      out.write("<table width=\"50%\" border=\"0.\">\n");
      out.write("  <tr>\n");
      out.write("    <td width=\"20%\">&nbsp;</td>\n");
      out.write("    <td width=\"80%\">&nbsp;</td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td>&nbsp;</td>\n");
      out.write("    <td>&nbsp;</td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td>&nbsp;</td>\n");
      out.write("    <td>&nbsp;</td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td>* Name </td>\n");
      out.write("    <td>\n");
      out.write("      <label>\n");
      out.write("        <input type=\"text\" name=\"firstname\" />\n");
      out.write("        </label>\n");
      out.write("     </td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td>* Surname </td>\n");
      out.write("    <td>\n");
      out.write("      <label>\n");
      out.write("        <input type=\"text\" name=\"surname\" />\n");
      out.write("        </label>\n");
      out.write("    </td>\n");
      out.write("  </tr>\n");
      out.write("  \n");
      out.write("  <tr>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td>* Location </td>\n");
      out.write("    <td>\n");
      out.write("      <label>\n");
      out.write("         <select name=\"location\">\n");
      out.write("              ");

        
                 dataaccess.DAO dataAccess=new dataaccess.DAO();
                 java.sql.ResultSet  rst=dataAccess.listLocations();
                 while(rst.next()){
		//String id=rst.getString("sight_id");
             
      out.write("\n");
      out.write("               <option value=\"");
      out.print(rst.getString("location"));
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print(rst.getString("location"));
      out.write("</option>\n");
      out.write("               ");

               
               }
                 dataAccess.closeConn();
               
      out.write("\n");
      out.write("          </select>\n");
      out.write("        </label>\n");
      out.write("    </td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("      <tr>\n");
      out.write("    <td>* E-Mail Address </td>\n");
      out.write("    <td>\n");
      out.write("        <label>\n");
      out.write("        <input type=\"text\" name=\"emailaddress\" />\n");
      out.write("        </label>\n");
      out.write("      </td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td>* User name </td>\n");
      out.write("    <td>\n");
      out.write("      <label>\n");
      out.write("        <input type=\"text\" name=\"username\" />\n");
      out.write("        </label>\n");
      out.write("    </td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td>* Password </td>\n");
      out.write("    <td>\n");
      out.write("      <label>\n");
      out.write("        <input type=\"password\" name=\"password\" />\n");
      out.write("        </label>\n");
      out.write("   </td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td>User Category </td>\n");
      out.write("    <td>\n");
      out.write("      <label></label>\n");
      out.write("      <label>\n");
      out.write("      <select name=\"usercategory\">\n");
      out.write("        <option>Subscriber</option>\n");
      out.write("        <option>Administrator</option>\n");
      out.write("        <option>Manager</option>\n");
      out.write("      </select>\n");
      out.write("      </label>\n");
      out.write("    </td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td>&nbsp;</td>\n");
      out.write("    <td>\n");
      out.write("        <input type=\"submit\" name=\"adduser\" value=\"Submit\" />\n");
      out.write("        <input type=\"hidden\" name=\"command\" value=\"AddUser\"/>\n");
      out.write("    </td>\n");
      out.write("  </tr>\n");
      out.write("  </table></form>\n");
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

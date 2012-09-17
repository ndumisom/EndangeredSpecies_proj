package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class usersEditList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "MainMenu.jsp", out, true);
      out.write("\r\n");
      out.write("\r\n");
      out.print(request.getAttribute("SuccessMsg")!=null? request.getAttribute("SuccessMsg"):"");
      out.write('\r');
      out.write('\n');
      out.print(request.getAttribute("ErrorMsg")!=null? request.getAttribute("ErrorMsg"):"");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\r\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Users List</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <h2>Users List For Editing</h2>\r\n");
      out.write("        <p style=\"color:red\">");
      out.print(request.getAttribute("errorMsg") != null ? request.getAttribute("errorMsg") : "");
      out.write("</p>\r\n");
      out.write(" <p style=\"color:green\">");
      out.print(request.getAttribute("successMsg") != null ? request.getAttribute("successMsg") : "");
      out.write("</p>\r\n");
      out.write("        <table width=\"50%\" border=\"1\">\r\n");
      out.write("            <tr align=\"left\"><th>First name</th><th>Surname</th>\r\n");
      out.write("           <th>Location</th><th>E-Mail Address</th><th>Username</th><th>Password</th>\r\n");
      out.write("           <th>User category</th>\r\n");
      out.write("          <th></th>\r\n");
      out.write("          <th></th>\r\n");
      out.write("        </tr>\r\n");
      out.write("        ");

        
        dataaccess.DAO dataAccess=new dataaccess.DAO();
        java.sql.ResultSet  rst=dataAccess.listUsers();
        while(rst.next()){
		String firstname=rst.getString("firstname");
        
      out.write("\r\n");
      out.write("        <tr align=\"left\"><td>");
      out.print(firstname);
      out.write("</td><td>");
      out.print(rst.getString("surname"));
      out.write("</td><td>");
      out.print(rst.getString("location"));
      out.write("</td><td>");
      out.print(rst.getString("email_address"));
      out.write("</td><td>");
      out.print(rst.getString("username"));
      out.write("</td><td>");
      out.print(rst.getString("password"));
      out.write("</td>\r\n");
      out.write("          <td>");
      out.print(rst.getString("user_category"));
      out.write("</td>\r\n");
      out.write("         \r\n");
      out.write("        <td>\r\n");
      out.write("              <form action=\"/EndangeredSpecies_Proj/Relay\" method=\"post\">\r\n");
      out.write("              <input type=\"hidden\" name=\"command\" value=\"EditUser\"/>\r\n");
      out.write("              <input type=\"hidden\" name=\"username\" value=\"");
      out.print(rst.getString("username"));
      out.write("\"/>\r\n");
      out.write("              <input type=\"submit\" value=\"Edit\"/>\r\n");
      out.write("               </form>\r\n");
      out.write("        </td>\r\n");
      out.write("         <td><form action=\"/EndangeredSpecies_Proj/Relay\" method=\"post\">\r\n");
      out.write("              <input type=\"hidden\" name=\"command\" value=\"DeleteUser\"/>\r\n");
      out.write("              <input type=\"hidden\" name=\"username\" value=\"");
      out.print(rst.getString("username"));
      out.write("\"/>\r\n");
      out.write("              <input type=\"submit\" value=\"Delete\"/> </form></td>\r\n");
      out.write("        ");
}
        dataAccess.closeConn();
        
      out.write("\r\n");
      out.write("        </table>\r\n");
      out.write("        \r\n");
      out.write("               \r\n");
      out.write("    </body>\r\n");
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

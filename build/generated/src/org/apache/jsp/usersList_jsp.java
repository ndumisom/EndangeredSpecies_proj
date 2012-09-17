package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class usersList_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Users List</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h2>Users List</h2>\n");
      out.write("        <p style=\"color:red\">");
      out.print(request.getAttribute("errorMsg") != null ? request.getAttribute("errorMsg") : "");
      out.write("</p>\n");
      out.write(" <p style=\"color:green\">");
      out.print(request.getAttribute("successMsg") != null ? request.getAttribute("successMsg") : "");
      out.write("</p>\n");
      out.write("        <table width=\"50%\" border=\"1\">\n");
      out.write("            <tr align=\"left\"><th>First name</th><th>Surname</th>\n");
      out.write("           <th>Location</th><th>E-Mail Address</th><th>Username</th><th>Password</th>\n");
      out.write("           <th>User category</th>\n");
      out.write("          \n");
      out.write("        </tr>\n");
      out.write("        ");

        
        dataaccess.DAO dataAccess=new dataaccess.DAO();
        java.sql.ResultSet  rst=dataAccess.listUsers();
        while(rst.next()){
		String firstname=rst.getString("firstname");
        
      out.write("\n");
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
      out.write("</td>\n");
      out.write("          <td>");
      out.print(rst.getString("user_category"));
      out.write("</td>\n");
      out.write("         \n");
      out.write("        ");
}
        dataAccess.closeConn();
        
      out.write("\n");
      out.write("        </table>\n");
      out.write("        \n");
      out.write("               \n");
      out.write("    </body>\n");
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

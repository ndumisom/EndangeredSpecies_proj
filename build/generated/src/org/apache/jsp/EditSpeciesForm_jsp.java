package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class EditSpeciesForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=iso-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.apache.jasper.runtime.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "AdminSecurity.jsp", out, true);
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Logo.jsp", out, true);
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "SecurityCheck.jsp", out, true);
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "MainMenu.jsp", out, true);
      out.write('\n');
      out.print(request.getAttribute("SuccessMsg")!=null? request.getAttribute("SuccessMsg"):"");
      out.write('\n');
      out.print(request.getAttribute("ErrorMsg")!=null? request.getAttribute("ErrorMsg"):"");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\n");
      out.write("<title>Edit Sighting</title>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("<p>Editing sighting</p>\n");
      out.write("<hr />\n");
      out.write("\n");
      out.write("<p style=\"color:red\">");
      out.print(request.getAttribute("errorMsg") != null ? request.getAttribute("errorMsg") : "");
      out.write("</p>\n");
      out.write(" <p style=\"color:green\">");
      out.print(request.getAttribute("successMsg") != null ? request.getAttribute("successMsg") : "");
      out.write("</p>\n");
      out.write(" \n");
      out.write(" ");

 String sight_id=request.getParameter("id");
 
 if(sight_id!=null){     
   dataaccess.DAO dataAccess=new dataaccess.DAO();
   java.sql.ResultSet  rst=dataAccess.getSighting(sight_id);
   if(rst.next()){ 
         

      out.write("\n");
      out.write(" <form action=\"/EndangeredSpecies_Proj/Relay\" method=\"post\">\n");
      out.write("<h2 align =\"center\">Edit Sighting Form </h2>\n");
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
      out.write("    <td>* Sight_id :</td>\n");
      out.write("    <td>\n");
      out.write("      <label>\n");
      out.write("          ");
      out.print(rst.getString("sight_id"));
      out.write("\n");
      out.write("        <input type=\"hidden\" name=\"sight_id\" value=\"");
      out.print(rst.getString("sight_id"));
      out.write("\" />\n");
      out.write("        </label>\n");
      out.write("     </td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td>Species Name:</td>\n");
      out.write("      <td><select name=\"name\">\n");
      out.write("              ");

                 dataaccess.DAO datAccess=new dataaccess.DAO();
                 java.sql.ResultSet  Rst=datAccess.listSpecCat();
                
      out.write(" <option  selected=\"selected\" >");
      out.print(rst.getString("spec_name"));
      out.write("</option>\n");
      out.write("               ");
  while(Rst.next()){
		
             
      out.write("\n");
      out.write("               <option> ");
      out.print(Rst.getString("spec_name"));
      out.write("</option>\n");
      out.write("               ");

               
               }
                 datAccess.closeConn();
              
      out.write("\n");
      out.write("          </select></td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td>* Species Location :</td>\n");
      out.write("    <td>\n");
      out.write("      <select name=\"location\">\n");
      out.write("              ");

        
                 dataaccess.DAO dataAcess=new dataaccess.DAO();
                 java.sql.ResultSet  rslt=dataAcess.listLocations();
      out.write("\n");
      out.write("                 <option selected=\"selected\">");
      out.print(rst.getString("location"));
      out.write("</option>\n");
      out.write("             ");
    while(rslt.next()){
		
             
      out.write("\n");
      out.write("             \n");
      out.write("             <option>");
      out.print(rslt.getString("location"));
      out.write("</option>\n");
      out.write("               ");

               
               }
                 dataAcess.closeConn();
               
      out.write("\n");
      out.write("          </select>\n");
      out.write("    </td>\n");
      out.write("  </tr>\n");
      out.write("    <tr>\n");
      out.write("    <td>* Number Sighted :</td>\n");
      out.write("    <td>\n");
      out.write("      \n");
      out.write("        <input type=\"text\" name=\"number_sighted\" value=\"");
      out.print(rst.getString("number_sighted"));
      out.write("\">\n");
      out.write("        \n");
      out.write("    </td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("      <td> Date Sighted:</td>\n");
      out.write("      <td>\n");
      out.write("          <input type=\"text\" name=\"date_sighted\" value=\"");
      out.print(rst.getString("date_sighted"));
      out.write("\">\n");
      out.write("          <i>yyyy-mm-dd</i>\n");
      out.write("      </td>\n");
      out.write("  </tr>\n");
      out.write("   \n");
      out.write("  <tr>\n");
      out.write("    <td>\n");
      out.write("      <label>\n");
      out.write("        <input type=\"hidden\" name=\"user_name\" value=\"");
      out.print(rst.getString("user_name"));
      out.write("\">\n");
      out.write("        </label>\n");
      out.write("    </td>\n");
      out.write("  </tr>\n");
      out.write("  \n");
      out.write("  <tr>\n");
      out.write("    <td>&nbsp;</td>\n");
      out.write("    <td>\n");
      out.write("        <input type=\"submit\" name=\"adduser\" value=\"Submit\" />\n");
      out.write("        <input type=\"hidden\" name=\"command\" value=\"EditSpeciesServlet\"/>\n");
      out.write("    </td>\n");
      out.write("  </tr>\n");
      out.write("  </table></form>\n");
      out.write("  ");
}
 dataAccess.closeConn();}
 
      out.write("\n");
      out.write("    <h3>demo</h3>\n");
      out.write("    \n");
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

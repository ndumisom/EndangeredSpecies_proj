package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AdoptionForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>Adoption Form</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<h3 align=\"center\">\r\n");
      out.write("Your Credit Card Information</h3>\r\n");
      out.write("<form id=\"form1\" name=\"form1\" method=\"post\" action=\"/EndangeredSpecies_Proj/Relay\">\r\n");
      out.write("  <table width=\"100%\" height=\"154\" border=\"0\">\r\n");
      out.write("    <tr>\r\n");
      out.write("      <td width=\"16%\"><input type=\"submit\" name=\"home\" value=\"Home\" /></td>\r\n");
      out.write("      <td width=\"68%\">&nbsp;</td>\r\n");
      out.write("      <td width=\"16%\"><label>\r\n");
      out.write("        <input type=\"submit\" name=\"submit\" value=\"Submit\" />\r\n");
      out.write("        <input type=\"hidden\" name=\"username\" value=\"");
      out.print(session.getAttribute("username"));
      out.write("\">\r\n");
      out.write("       <input type=\"hidden\" name=\"command\" value=\"AdoptionServ\" />\r\n");
      out.write("      </label></td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("      <td><table width=\"96%\" height=\"203\" border=\"0\">\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td><label></label></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td><label></label></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td><label></label></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td><label></label></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            \r\n");
      out.write("          <td><label>Sighting ID</label>\r\n");
      out.write("          <select name=\"sight_id\">\r\n");
      out.write("              ");

        
                 dataaccess.DAO dataAccess=new dataaccess.DAO();
                 java.sql.ResultSet  rst=dataAccess.listSightings();
                 while(rst.next()){
		//String id=rst.getString("sight_id");
             
      out.write("\r\n");
      out.write("               <option value=\"");
      out.print(rst.getString("sight_id"));
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print(rst.getString("sight_id"));
      out.write("</option>\r\n");
      out.write("               ");

               
               }
                 dataAccess.closeConn();
               
      out.write("\r\n");
      out.write("          </select>\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td><label>Amount Per Month</label>\r\n");
      out.write("           <input type=\"text\" name=\"amount\" />\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("      </table></td>\r\n");
      out.write("      <td><table width=\"86%\" border=\"0.\">\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td width=\"13%\">Card Type </td>\r\n");
      out.write("          <td width=\"43%\"><label>\r\n");
      out.write("            <select name=\"card_type\">\r\n");
      out.write("              <option>Visa</option>\r\n");
      out.write("              <option>MasterCard</option>\r\n");
      out.write("              <option>LifeStart</option>\r\n");
      out.write("              <option>Mzansi</option>\r\n");
      out.write("            </select>\r\n");
      out.write("          </label></td>\r\n");
      out.write("          <td width=\"9%\">Card Number </td>\r\n");
      out.write("          <td width=\"35%\"><label>\r\n");
      out.write("            <input type=\"text\" name=\"card_number\" />\r\n");
      out.write("          </label></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td>Expiry Date </td>\r\n");
      out.write("          <td>\r\n");
      out.write("            <input name=\"exp_date\" type=\"text\" />\r\n");
      out.write("            <i>yyyy-mm-dd</i>\r\n");
      out.write("          </td>\r\n");
      out.write("          <td>CVC</td>\r\n");
      out.write("          <td><label>\r\n");
      out.write("            <input type=\"text\" name=\"cvc\" />\r\n");
      out.write("          </label></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td>&nbsp;</td>\r\n");
      out.write("          <td><img src=\"pics/d_s.gif\" width=\"28\" height=\"35\" /></td>\r\n");
      out.write("          <td>&nbsp;</td>\r\n");
      out.write("          <td><img src=\"pics/d_s.gif\" width=\"28\" height=\"35\" /></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td>&nbsp;</td>\r\n");
      out.write("          <td><img src=\"pics/visa_expire_info.gif\" width=\"147\" height=\"93\" /></td>\r\n");
      out.write("          <td>&nbsp;</td>\r\n");
      out.write("          <td><img src=\"pics/visa_cvc_info.gif\" width=\"147\" height=\"93\" /></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td>&nbsp;</td>\r\n");
      out.write("          <td>Expiry date <br />\r\n");
      out.write("            The expiry date is on the front of your card. It consists of 2  numbers with two digits each separated by a slash or a dot, for example  12/12. The first 2 digits specify the month and the last 2 specify the  year when your card expires.</td>\r\n");
      out.write("          <td>&nbsp;</td>\r\n");
      out.write("          <td>CVC/ Card Verification Code. <br />\r\n");
      out.write("            For security reasons we also ask you to supply your card's CVC  code. It is the last three digits situated in the signature field on  the back of your credit card.</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("      </table></td>\r\n");
      out.write("      <td>&nbsp;</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("      <td>&nbsp;</td>\r\n");
      out.write("      <td>&nbsp;</td>\r\n");
      out.write("      <td>&nbsp;</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("  </table>\r\n");
      out.write("  <p>&nbsp;</p>\r\n");
      out.write("</form>\r\n");
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

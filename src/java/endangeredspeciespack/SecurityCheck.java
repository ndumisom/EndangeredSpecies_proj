/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package endangeredspeciespack;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
public class SecurityCheck {
    
 //method to check in servlets   
public void checkSecurity(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
 response.setHeader("Cache-Control","no-store");
response.setDateHeader("Expires", 0); //causes the proxy cache to see the page as "stale"
String dispatch="index.jsp";

if ( session.getAttribute("username")== null) { //checking if the session is null.
	request.setAttribute("errorMsg", "Session has ended.  Please login.");
  	RequestDispatcher dispatcher = request.getRequestDispatcher(dispatch) ; 
    dispatcher.forward(request, response) ;//take the user to login page.
}
}

}

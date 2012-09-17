/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package endangeredspeciespack;

import dataaccess.DAO;
import java.io.*;

import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author bm7920
 */
public class EditUserServ extends HttpServlet {
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String firstname=request.getParameter("firstname"); //get username
          String surname=request.getParameter("surname");
          String location=request.getParameter("location");
          String email_address=request.getParameter("email_address");
          String username=request.getParameter("username");
          String password=request.getParameter("password");
         String user_category=request.getParameter("user_category"); //get user category
         String homePage="usersEditList.jsp";
         try{
          DAO dataAccess =new DAO();
          boolean isUserUpdated= dataAccess.updateUser(firstname,surname,location,email_address,username, password,user_category);
          if(isUserUpdated){
              request.setAttribute("successMsg", "User is Updated successfully");
            }   else
            request.setAttribute("errorMsg","Failed update user information");  
         }  catch(SQLException sqle){
             request.setAttribute("errorMsg", "Database Error:"+sqle.getMessage());                    sqle.printStackTrace();
         }
         catch(Exception ex){
             request.setAttribute("errorMsg", ex.getMessage()); //put errors in the request
             ex.printStackTrace();
         }
    	RequestDispatcher rd =request.getRequestDispatcher(homePage);
	rd.forward(request, response); 

        
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
    * Handles the HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
    * Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
    * Returns a short description of the servlet.
    */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package endangeredspeciespack;

import java.io.*;
import java.net.*;

import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author user
 */
public class Relay extends HttpServlet {
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        // declare and initialise command string, passed as the "command" parameter
String command = request.getParameter("command"); //read hidden field
     
        
// do the forwarding
RequestDispatcher rd =request.getRequestDispatcher(command);
rd.forward(request, response);

HttpSession session= request.getSession(false);

String fName=(String)session.getAttribute("firstname");
String lName=(String)session.getAttribute("surname");
String category=(String)session.getAttribute("user_category");
try{
             //do some data validation here
         //create an instance of the Data access object
          dataaccess.DAO dataAccess =new dataaccess.DAO();
         //use the dataAccess object to invoke the insertUser method to add a user to the database
          boolean isInserted= dataAccess.insertLog(fName,lName,category,command);
          //check if records are available
            if(isInserted){
               //record is inserted
                request.setAttribute("successMsg", "Done");
            } 
            else
              //user not inserted
              request.setAttribute("errorMsg","Failed");  
         }  catch(SQLException sqle){
             request.setAttribute("errorMsg", "Database Error:"+sqle.getMessage());                  
             sqle.printStackTrace();
         }
         catch(Exception ex){
             request.setAttribute("errorMsg", ex.getMessage()); //put errors in the request
             ex.printStackTrace();
         }

       System.out.println("Request forwarded to " + command + " servlet");

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

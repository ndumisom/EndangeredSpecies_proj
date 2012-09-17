/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package endangeredspeciespack;

import dataaccess.DAO;
import java.io.*;
import java.net.*;

import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author bq8222
 */
public class EditSpeciesServlet extends HttpServlet {
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String sight_id=request.getParameter("sight_id"); //get username
          String spec_name=request.getParameter("name");
          String location=request.getParameter("location");
          String number_sighted=request.getParameter("number_sighted");
          String date_sighted=request.getParameter("date_sighted");
          String user_name=request.getParameter("user_name");
                 
         String homePage="SubscriberHome.jsp"; //home page for the login user
         try{
             //do some data validation here
         //create an instance of the Data access object
          DAO dataAccess =new DAO();
         //use the dataAccess object to invoke the insertUser method to add a user to the database
          boolean isReportUpdated= dataAccess.updateSighting(sight_id,spec_name,location,number_sighted,date_sighted,user_name);
          //check if records are available
            if(isReportUpdated){
                request.setAttribute("successMsg", "Sighting Report is Updated successfully");
            }   else
              
              request.setAttribute("errorMsg","Failed to Update the sightings report");  
         }  catch(SQLException sqle){
             request.setAttribute("errorMsg", "Database Error:"+sqle.getMessage());                    sqle.printStackTrace();
         }
         catch(Exception ex){
             request.setAttribute("errorMsg", ex.getMessage()); //put errors in the request
             ex.printStackTrace();
         }
     //forward to jsp for presentation
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

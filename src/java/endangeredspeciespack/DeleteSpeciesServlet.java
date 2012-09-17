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
 * @author bq8222
 */
public class DeleteSpeciesServlet extends HttpServlet {
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
         String homePage="SpeciesInformatonPage.jsp"; //home page for the login user
         try{
                DAO dataAccess =new DAO();
                java.sql.ResultSet  rst=dataAccess.listSightings();
               String name=request.getParameter("endng_spec_name");
           
                
           
             
         
        
          boolean isDeleted= dataAccess.deleteUser(name);
     
            if(isDeleted){
             
                request.setAttribute("successMsg", "Species is deleted successfully");
            }   else
              //user not inserted
              request.setAttribute("errorMsg","Failed to delete data from the database");  
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

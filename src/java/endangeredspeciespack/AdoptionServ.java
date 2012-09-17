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
public class AdoptionServ extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String spec_name=request.getParameter("names"); 
        String fname=request.getParameter("fname");
         String lname=request.getParameter("lname");
        String card_type=request.getParameter("card_type");
        String card_number=request.getParameter("card_number");
        String exp_date=request.getParameter("exp_date");
        String cvc=request.getParameter("cvc");
        String amount=request.getParameter("amount"); 
        String homePage="AdoptionForm.jsp";
        
        try{
             //do some data validation here
         //create an instance of the Data access object
          DAO dataAccess =new DAO();
         //use the dataAccess object to invoke the insertUser method to add a user to the database
          boolean isAdopted= dataAccess.AdoptSpecies(spec_name,fname,lname,card_type,card_number,exp_date,cvc,amount);         //check if records are available
          if(isAdopted){
               request.setAttribute("successMsg","Done");
            }   else
              //user not inserted
              request.setAttribute("errorMsg","Failed to insert data into the database");  
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

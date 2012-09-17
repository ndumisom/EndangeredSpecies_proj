/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package endangeredspeciespack;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import dataaccess.DAO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class LoginServlet extends HttpServlet {
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
         String username=request.getParameter("username");
         String password=request.getParameter("password");
         String homePage="index.jsp"; //home page for the login user
         try{
         //create an instance of the Data access object
          DAO dataAccess =new DAO();
         //use the dataAccess object to call the checkUserCredentials method to authenticate a user
          ResultSet rst= dataAccess.checkCredentials(username, password);
         //check if records are available
        if(rst.next()){
             ResultSet rslt= dataAccess.getUser(username);
            //create a session object and get user session since the user is valid
            HttpSession session =request.getSession(true);
            //load the username from the database
            String userName=rst.getString("username");
            String passWord=rst.getString("password");
            String fName=rst.getString("firstname");
            String lName=rst.getString("surname");
            String user_cat=rst.getString("user_category");
            //get the user type
            String usertype= rst.getString("user_category");
            //put username and user type into the session object
            //these are for tracking purposes
            session.setAttribute("username", userName);
            session.setAttribute("password", passWord);
            session.setAttribute("firstname", fName);
            session.setAttribute("surname", lName);
            session.setAttribute("user_category", user_cat);
            //checking user type so that we direct them to the right home page
            //here we are checking if the user category is administrator
            if(usertype !=null && usertype.equalsIgnoreCase("administrator"))
            
            {
               //put the user category in session so that we can know the user category
                session.setAttribute("user_category",usertype);
                //sets the page which the administrator will see
                homePage="/AdminiHome.jsp";
            }
            //checking if the user is the subscribe
            else if(usertype !=null && usertype.equalsIgnoreCase("subscriber")){
                //put the type into the session object so that we can remember the user
                session.setAttribute("usertype",usertype);
                //sets the page which the subscribers will see.
               homePage="/SubscriberHome.jsp"; 
            }
            else if(usertype !=null && usertype.equalsIgnoreCase("manager")){
                //put the type into the session object so that we can remember the user
                session.setAttribute("usertype",usertype);
                //sets the page which the subscribers will see.
               homePage="/ManagerHome.jsp"; 
            }
            else{
               //set the error since user has no category assigned
               request.setAttribute("errorMsg", username+"  has no Role assigned contact the Administrator.");
               //take the user back to the login page
               homePage="/index.jsp";
            }      
         }
          //otherwise the user does not exist in the database
          else{
              //tell the user the username or password is wrong by putting the message in the request object
              request.setAttribute("errorMsg","Invalid Username or Password.");
              //This will take the user back to the login page 
              homePage="/index.jsp";
          }
          rst.close();//close the  and resultset
         dataAccess.closeConn();//close the database connection
         }
          catch(IllegalArgumentException iae){
             request.setAttribute("errorMsg", iae.getMessage()); //put the error in the request
             iae.printStackTrace(); //print the error stack to the command line
         }
         catch(SQLException sqle){
             request.setAttribute("errorMsg", "Database Error:"+sqle.getMessage()); //put the error in the request
              //print the error stack to the command line for debbugging info
             sqle.printStackTrace();
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

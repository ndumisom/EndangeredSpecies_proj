/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dataaccess;

/**
 *
 * @author user
 */
import java.sql.*;

/**
 *
 * @author Administrator
 */
//DAO class
public class DAO{
 //JDBC driver name and database URL
String driver ="com.mysql.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/proj_speciesdb";
String username = "root";
String password = "ayabonga";
//loads the Access database driver
//A no argument constructor
public DAO () throws ClassNotFoundException{
               //load database driver class
		Class.forName(driver);

}
public ResultSet listUsers() throws Exception{
   ResultSet result=null;
    //manages connection
  Connection conn=null;
  //Use prepared statement
  Statement statement=null;
  //set the insert query. question marks represent unknown values
     String query ="SELECT * FROM users ORDER BY firstname";
     conn=getConnection();//make a connection to the database
    statement =conn.createStatement();
    result=statement.executeQuery(query); //execute the query 
    return result;
}

//GET THE DATABASE CONNECTION
Connection getConnection() throws Exception{
//establish connection to the database	
Connection connection =DriverManager.getConnection(this.url,this.username, this.password);
 
 return connection;
}
 
//CLOSE THE DATABASE CONNECTION
public void closeConn() throws Exception{
	getConnection().close();
}

/**
 *This method allows a user to be authenticated by checking the supplied username
 * and password are compared with the ones in the database.
 *If the user is valid,then the method returns true otherwise it returns false
 *@params userID
 *@param password
 */
//parameters are passed to the addlogs method
public ResultSet checkCredentials(String username, String password) throws Exception{
   //This ensures that null or empty userID are not allowed
    if (username == null || username.length()==0)
    {
        //If the userID is blank an exception will be thrown
      throw new IllegalArgumentException("UserID cannot be null or blank.");
    }
    //Don't allow blank passwords
    if (password == null || password.length()==0)
    {
        //exception will be thrown if its null or zero
      throw new IllegalArgumentException("password cannot be null or blank.");
    }
  ResultSet resultSet=null;
  //manages connection
  Connection conn=null;
  //query statement
  PreparedStatement statement=null;
   String query ="SELECT * FROM users where username=? AND password=?";
    conn=getConnection();
    //Creates statement for querying database
    statement =conn.prepareStatement(query);
    statement.setString(1, username);
    statement.setString(2, password);
   
    //query database
    //specify query and excute it
    resultSet =statement.executeQuery();
    
    return resultSet;
}
/**
 *This method allows a users to be added to the database
 *If the user is entered into the database, return true otherwise false.
 *@params username
 *@param password
 * @param  usercategory
 */
//parameters are passed to the addlogs method
public boolean insertUser(String firstname,String surname,String province,String location,String emailaddress,String username,String password,String usercategory) throws Exception{
   //This ensures that null or empty values are not allowed
    if (firstname == null || firstname.length()==0)
    {
      throw new IllegalArgumentException("Enter first name");
    }
    if (surname == null || surname.length()==0)
    {
      throw new IllegalArgumentException("Enter surname");
    }
   if (location == null || location.length()==0)
    {
      throw new IllegalArgumentException("Location please!");
    }
    if (emailaddress == null || emailaddress.length()==0)
    {
      throw new IllegalArgumentException("Enter E-mail address");
    }
    if (username == null || username.length()==0)
    {
      throw new IllegalArgumentException("Username cannot be null or blank.");
    }
    if (password == null || password.length()==0)
    {
      throw new IllegalArgumentException("Password field cannot be null or blank.");
    }
   boolean isInserted=false;
  //manages connection
  Connection conn=null;
  //Use prepared statement
  PreparedStatement statement=null;
  //set the insert query. question marks represent unknown values
     String query ="INSERT INTO  users(firstname, surname, location, email_address, username, password, user_category) VALUES(?,?,?,?,?,?,?)";
     conn=getConnection();//make a connection to the database
 
    statement =conn.prepareStatement(query);//send the query to the database
   //set up the values to insert into the database
    statement.setString(1, firstname);
    statement.setString(2, surname);
    statement.setString(3, location);
    statement.setString(4, emailaddress);
    statement.setString(5, username);
    statement.setString(6, password);
    statement.setString(7, usercategory);
     
    if(statement.executeUpdate()>0){ // check if the data is inserted
        isInserted=true;
    }
    statement.close();
    closeConn();
    return isInserted;
}
/**
 * Listing of users
 */
public ResultSet listUsers1() throws Exception{
   ResultSet result=null;
    //manages connection
  Connection conn=null;
  //Use prepared statement
  Statement statement=null;
  //set the insert query. question marks represent unknown values
     String query ="SELECT * FROM users";
     conn=getConnection();//make a connection to the database
 
    statement =conn.createStatement();
    result=statement.executeQuery(query); //execute the query 
    return result;
}
/**
 * Listing of user by username
 */
public ResultSet getUser(String name) throws Exception{
      //This ensures that null or empty userID are not allowed
        
   ResultSet result=null;
    //manages connection
  Connection conn=null;
  //Use prepared statement
  PreparedStatement statement=null;
  //set the select query. question marks represent unknown values
     String query ="SELECT * FROM users WHERE username=?";
     conn=getConnection();//make a connection to the database
 
    statement =conn.prepareStatement(query); //send to the database
    statement.setString(1, name); //set the value to select
    
    result=statement.executeQuery(); //execute the query 
    return result;
}  
//Function for updating users
public boolean updateUser(String firstname,String surname,String location,String email_address,String username, String password,String user_category) throws Exception{

   boolean isUpdated=false;
  //manages connection
  Connection conn=null;
  //Use prepared statement
  PreparedStatement statement=null;
  //set the insert query. question marks represent unknown values
     String query ="UPDATE users SET firstname=?,surname=?,location=?,email_address=?,username=?,password=?,user_category=? WHERE username=?";
     conn=getConnection();//make a connection to the database
 
    statement =conn.prepareStatement(query);//send the query to the database
   //set up the values to insert into the database
    statement.setString(1, firstname);
    statement.setString(2, surname);
    statement.setString(3, location);
    statement.setString(4, email_address);
    statement.setString(5, username);
    statement.setString(6, password);
    statement.setString(7, user_category);
      statement.setString(8, username);
    if(statement.executeUpdate()>0){
        isUpdated=true;
    }
    statement.close();
    closeConn();
    return isUpdated;
    
}
//Function for Deleting
public boolean deleteUser(String username) throws Exception{
  
  
   boolean isDeleted=false;
  //manages connection
  Connection conn=null;
  //Use prepared statement
  PreparedStatement statement=null;
  //set the insert query. question marks represent unknown values
     String query ="DELETE from users WHERE username=?";
     conn=getConnection();//make a connection to the database
 
    statement =conn.prepareStatement(query);//send the query to the database
   //set up the values to insert into the database
    statement.setString(1, username);
     
    if(statement.executeUpdate()>0){ // check if the data is inserted
        isDeleted=true;
    }
    statement.close();
    closeConn();
    return isDeleted;
    
}
public boolean insertSpecies(String SpeciesName,String Location,String DateSighted,String Number,String username) throws Exception{
   
   boolean isInserted=false;
  //manages connection
  Connection conn=null;
  //Use prepared statement
  PreparedStatement statement=null;
  //set the insert query. question marks represent unknown values
     String query ="INSERT INTO reports(spec_name, location, date_sighted, number_sighted, user_name) VALUES(?,?,?,?,?)";
     conn=getConnection();//make a connection to the database
 
    statement =conn.prepareStatement(query);//send the query to the database
   //set up the values to insert into the database
    statement.setString(1, SpeciesName);
    statement.setString(2, Location);
    statement.setString(3, DateSighted);
    statement.setString(4, Number);
    statement.setString(5, username);
     
    if(statement.executeUpdate()>0){ // check if the data is inserted
        isInserted=true;
    }
    statement.close();
    closeConn();
    return isInserted;
}
public ResultSet listSightings() throws Exception{
   ResultSet result=null;
    //manages connection
  Connection conn=null;
  //Use prepared statement
  Statement statement=null;
  //set the insert query. question marks represent unknown values
     String query ="SELECT * FROM sightings ORDER BY date_sighted DESC";
     conn=getConnection();//make a connection to the database
 
    statement =conn.createStatement();
    result=statement.executeQuery(query); //execute the query 
    return result;
}
public boolean deleteSighting(String name) throws Exception{
     boolean isDeleted=false;
  //manages connection
  Connection conn=null;
  //Use prepared statement
  PreparedStatement statement=null;
  //set the insert query. question marks represent unknown values
     String query ="DELETE from sightings WHERE sight_id=?";
     conn=getConnection();//make a connection to the database
 
    statement =conn.prepareStatement(query);//send the query to the database
   //set up the values to insert into the database
    statement.setString(1, name);
     
    if(statement.executeUpdate()>0){ // check if the data is inserted
        isDeleted=true;
    }
    statement.close();
    closeConn();
    return isDeleted;
    
}
public boolean updateSighting(String sight_id,String spec_name,String location,String number_sighted,String date_sighted,String user_name) throws Exception{

   boolean isUpdated=false;
  //manages connection
  Connection conn=null;
  //Use prepared statement
  PreparedStatement statement=null;
  //set the insert query. question marks represent unknown values
     String query ="UPDATE reports SET spec_name=?,location=?,number_sighted=?,date_sighted=?,user_name=? WHERE sight_id=?";
     conn=getConnection();//make a connection to the database
 
    statement =conn.prepareStatement(query);//send the query to the database
   //set up the values to insert into the database
    statement.setString(6, sight_id);
    statement.setString(1, spec_name);
    statement.setString(2, location);
    statement.setString(3, number_sighted);
    statement.setString(4, date_sighted);
    statement.setString(5, user_name);
      
    if(statement.executeUpdate()>0){ // check if the data is inserted
        isUpdated=true;
    }
    statement.close();
    closeConn();
    return isUpdated;
    
}
public ResultSet listCountries(String location) throws Exception{
   ResultSet result=null;
    //manages connection
  Connection conn=null;
  //Use prepared statement
  Statement statement=null;
  //set the insert query. question marks represent unknown values
     String query ="SELECT * FROM place where location=('"+location+"')";
     conn=getConnection();//make a connection to the database
 
    statement =conn.createStatement();
    result=statement.executeQuery(query); //execute the query 
    return result;
}
public ResultSet getSighting(String id) throws Exception{
    
   ResultSet result=null;
    //manages connection
  Connection conn=null;
  //Use prepared statement
  PreparedStatement statement=null;
  //set the select query. question marks represent unknown values
     String query ="SELECT * FROM reports WHERE sight_id=?";
     conn=getConnection();//make a connection to the database
 
    statement =conn.prepareStatement(query); //send to the database
    statement.setString(1, id); //set the value to select
    
    result=statement.executeQuery(); //execute the query 
    return result;
} 
public ResultSet listReports() throws Exception{
   ResultSet result=null;
    //manages connection
  Connection conn=null;
  //Use prepared statement
  Statement statement=null;
  //set the insert query. question marks represent unknown values
     String query ="SELECT * FROM reports ORDER BY date_sighted";
     conn=getConnection();//make a connection to the database
 
    statement =conn.createStatement();
    result=statement.executeQuery(query); //execute the query 
    return result;
}
public boolean rejectReport(String name) throws Exception{
     boolean isDeleted=false;
  //manages connection
  Connection conn=null;
  //Use prepared statement
  PreparedStatement statement=null;
  //set the insert query. question marks represent unknown values
     String query ="DELETE from reports WHERE sight_id=?";
     conn=getConnection();//make a connection to the database
 
    statement =conn.prepareStatement(query);//send the query to the database
   //set up the values to insert into the database
    statement.setString(1, name);
     
    if(statement.executeUpdate()>0){ // check if the data is inserted
        isDeleted=true;
    }
    statement.close();
    closeConn();
    return isDeleted;
    
}
public ResultSet getReport(String id) throws Exception{
    
   ResultSet result=null;
    //manages connection
  Connection conn=null;
  //Use prepared statement
  PreparedStatement statement=null;
  //set the select query. question marks represent unknown values
     String query ="SELECT * FROM reports WHERE sight_id=?";
     conn=getConnection();//make a connection to the database
 
    statement =conn.prepareStatement(query); //send to the database
    statement.setString(1, id); //set the value to select
    
    result=statement.executeQuery(); //execute the query 
    return result;
} 
public boolean approveReport(String id) throws Exception{
     boolean isDeleted=false;
  //manages connection
  Connection conn=null;
  //Use prepared statement
  PreparedStatement statement=null;
  //set the insert query. question marks represent unknown values
     String query ="INSERT INTO sightings SELECT * FROM  reports WHERE sight_id=?";
     conn=getConnection();//make a connection to the database
 
    statement =conn.prepareStatement(query);//send the query to the database
   //set up the values to insert into the database
    statement.setString(1, id);
     
    if(statement.executeUpdate()>0){ // check if the data is inserted
        isDeleted=true;
    }
    statement.close();
    closeConn();
    return isDeleted;
    
}
public boolean addSpecies(String kind,String category) throws Exception{
   
   boolean isInserted=false;
  //manages connection
  Connection conn=null;
  //Use prepared statement
  PreparedStatement statement=null;
  //set the insert query. question marks represent unknown values
     String query ="INSERT INTO species(kind, category) VALUES(?,?)";
     conn=getConnection();//make a connection to the database
 
    statement =conn.prepareStatement(query);//send the query to the database
   //set up the values to insert into the database
    statement.setString(1, kind);
    statement.setString(2, category);
   
    
    if(statement.executeUpdate()>0){ // check if the data is inserted
        isInserted=true;
    }
    statement.close();
    closeConn();
    return isInserted;
}
public ResultSet listSpecies() throws Exception{
   ResultSet result=null;
    //manages connection
  Connection conn=null;
  //Use prepared statement
  Statement statement=null;
  //set the insert query. question marks represent unknown values
     String query ="SELECT * FROM species ORDER BY kind";
     conn=getConnection();//make a connection to the database
 
    statement =conn.createStatement();
    result=statement.executeQuery(query); //execute the query 
    return result;
}
public ResultSet listAdoptions() throws Exception{
   ResultSet result=null;
    //manages connection
  Connection conn=null;
  //Use prepared statement
  Statement statement=null;
  //set the insert query. question marks represent unknown values
     String query ="SELECT * FROM adoptions";
     conn=getConnection();//make a connection to the database
 
    statement =conn.createStatement();
    result=statement.executeQuery(query); //execute the query 
    return result;
}
public boolean AdoptSpecies(String sight_id,String fname,String lname,String card_type,String card_number,String exp_date,String cvc, String amount) throws Exception{
   
   boolean isInserted=false;
  //manages connection
  Connection conn=null;
  //Use prepared statement
  PreparedStatement statement=null;
  //set the insert query. question marks represent unknown values
     String query ="INSERT INTO adoptions(species_name,first_name,last_name, card_type, card_number, exp_date, cvc, amount) VALUES(?,?,?,?,?,?,?,?)";
     conn=getConnection();//make a connection to the database
 
    statement =conn.prepareStatement(query);//send the query to the database
   //set up the values to insert into the database
    statement.setString(1, sight_id);
    statement.setString(2, fname);
    statement.setString(3, lname);
    statement.setString(4, card_type);
    statement.setString(5, card_number);
    statement.setString(6, exp_date);
    statement.setString(7, cvc);    
    statement.setString(8, amount);
 
    if(statement.executeUpdate()>0){ // check if the data is inserted
        isInserted=true;
    }
    statement.close();
    closeConn();
    return isInserted;
}
public ResultSet showReports(String name) throws Exception{
   ResultSet result=null;
    //manages connection
  Connection conn=null;
  //Use prepared statement
  Statement statement=null;
  //set the insert query. question marks represent unknown values
     String query ="SELECT * FROM reports WHERE user_name=('"+name+"')";
     conn=getConnection();//make a connection to the database
 
    statement =conn.createStatement();
    result=statement.executeQuery(query); //execute the query 
    return result;
}
public ResultSet listLocations() throws Exception{
   ResultSet result=null;
    //manages connection
  Connection conn=null;
  //Use prepared statement
  Statement statement=null;
  //set the insert query. question marks represent unknown values
     String query ="SELECT location FROM place";
     conn=getConnection();//make a connection to the database
 
    statement =conn.createStatement();
    result=statement.executeQuery(query); //execute the query 
    return result;
}
public ResultSet listSpecCat() throws Exception{
   ResultSet result=null;
    //manages connection
  Connection conn=null;
  //Use prepared statement
  Statement statement=null;
  //set the insert query. question marks represent unknown values
     String query ="SELECT * FROM spec_category ORDER BY spec_name";
     conn=getConnection();//make a connection to the database
 
    statement =conn.createStatement();
    result=statement.executeQuery(query); //execute the query 
    return result;
}public ResultSet ShowLog(String category) throws Exception{
   ResultSet result=null;
    //manages connection
  Connection conn=null;
  //Use prepared statement
  Statement statement=null;
  //set the insert query. question marks represent unknown values
     String query ="SELECT * FROM log_table WHERE user_category=('"+category+"')";   conn=getConnection();//make a connection to the database
 
    statement =conn.createStatement();
    result=statement.executeQuery(query); //execute the query 
    return result;
}
public boolean insertLog(String firstname,String lastname,String usercategory,String request) throws Exception{
   
   boolean isInserted=false;
  //manages connection
  Connection conn=null;
  //Use prepared statement
  PreparedStatement statement=null;
  //set the insert query. question marks represent unknown values
     String query ="INSERT INTO log_table(firstname,lastname,user_category,request) VALUES(?,?,?,?)";
     conn=getConnection();//make a connection to the database
 
    statement =conn.prepareStatement(query);//send the query to the database
   //set up the values to insert into the database
    statement.setString(1, firstname);
    statement.setString(2, lastname);
    statement.setString(3, usercategory);
    statement.setString(4, request);
    
    if(statement.executeUpdate()>0){ // check if the data is inserted
        isInserted=true;
    }
    statement.close();
    closeConn();
    return isInserted;
}
public ResultSet showAdoptions(String name) throws Exception{
   ResultSet result=null;
    //manages connection
  Connection conn=null;
  //Use prepared statement
  Statement statement=null;
  //set the insert query. question marks represent unknown values
     String query ="SELECT * FROM adoptions WHERE first_name=('"+name+"')";
     conn=getConnection();//make a connection to the database
 
    statement =conn.createStatement();
    result=statement.executeQuery(query); //execute the query 
    return result;
}
public boolean removeAdoption(String id) throws Exception{
     boolean isDeleted=false;
  //manages connection
  Connection conn=null;
  //Use prepared statement
  PreparedStatement statement=null;
  //set the insert query. question marks represent unknown values
     String query ="DELETE from adoptions WHERE adoption_id=?";
     conn=getConnection();//make a connection to the database
 
    statement =conn.prepareStatement(query);//send the query to the database
   //set up the values to insert into the database
    statement.setString(1, id);
     
    if(statement.executeUpdate()>0){ // check if the data is inserted
        isDeleted=true;
    }
    statement.close();
    closeConn();
    return isDeleted;
    
}
public ResultSet showSpecs() throws Exception{
   ResultSet result=null;
    //manages connection
  Connection conn=null;
  //Use prepared statement
  Statement statement=null;
  //set the insert query. question marks represent unknown values
     String query ="SELECT spec_name FROM sightings";
     conn=getConnection();//make a connection to the database
 
    statement =conn.createStatement();
    result=statement.executeQuery(query); //execute the query 
    return result;
}
public ResultSet ShowLogs() throws Exception{
   ResultSet result=null;
    //manages connection
  Connection conn=null;
  //Use prepared statement
  Statement statement=null;
  //set the insert query. question marks represent unknown values
     String query ="SELECT * FROM log_table";
 
    statement =conn.createStatement();
    result=statement.executeQuery(query); //execute the query 
    return result;
}
}
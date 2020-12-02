/** import the sql library */
import java.sql.*;

public class updateCustomer extends Customer{
	 
	/** create a constructor to inherit all the customers information */
	public  updateCustomer() {
  	  super();
	}
	/** create a method that will update some of the customers information if any of the specified information changes */
      public void update() {
    	  
    	  try {
    		  Connection connection = DriverManager.getConnection(
    	                 "jdbc:sqlserver://localhost;database=library_db","example_us","Chanell082");
    		  Class.forName("com.mysql.jdbc.Driver");
    	                 /** Create a direct line to the database for running queries */
    	                 Statement statement = connection.createStatement();
    	                 int rowsAffected;
    	                 ResultSet rs;
     	                
    	                 /** the only things that the customer can change are the customers number,address or email address.
    	                 create an option for these and match them to what the customer has inserted if the customer already exists in the database */
    	                 String query[] = {
    	                         "SELECT * FROM customer where custname= "+ customer, 
    	                         "select cust_cell from customer where cust_name like '" +customer+"'", 
    	                         "select cust_add from customer where cust_name like '" +customer+"'",
    	                         "select cust_email from customer where cust_name like '" +customer+"'",
    	                      };
    	                 
    	                
    	                 String temp = String.valueOf(cust_cell); /** cast customers cell number into a string */
    	                 
    	                 if(query[1] != temp) {
    	                	/** update the customers information */
     	                    rowsAffected = statement.executeUpdate("UPDATE customer SET cust_cell="+temp+"WHERE order_num = " + order_num);
     	                    System.out.println("Query complete, "+ rowsAffected +" rowsupdated.");
     	                    printAllFromTable(statement);
    	                 }
    	                 
    	                 if(query[2] != Address) {
    	                	/** update the customers information */
      	                    rowsAffected = statement.executeUpdate("UPDATE customer SET cust_add="+Address+"WHERE order_num = " + order_num);
      	                    System.out.println("Query complete, "+ rowsAffected +" rowsupdated.");
      	                    printAllFromTable(statement);
    	                 }
    	                 
    	                 if(query[3] != myEmail) {
     	                	/** update the customers information */
       	                    rowsAffected = statement.executeUpdate("UPDATE customer SET cust_email="+myEmail+"WHERE order_num = " + order_num);
       	                    System.out.println("Query complete, "+ rowsAffected +" rowsupdated.");
       	                    printAllFromTable(statement);
     	                 }
    	                 
    	                 /** add each query  */
    	                 for(String q : query) {
    	                    rs = statement.executeQuery(q);
    	                   /** Loop over the results, printing them all. */
     	                    while(rs.next()) {
     	                         System.out.println(rs.getInt("order_num") +", " + rs.getString("customer") +", "+ rs.getString("Address") +", "+ rs.getInt("cust_Location")+ ", "+ rs.getString("myEmail"));
     	    					
     	                      }
    	               }
    	                 
    	              /** display everything */
    	              printAllFromTable(statement);
    	              // close
    	               
    	                 statement.close();
    	                 connection.close();
    	                
    	   }catch(Exception ex) {
    	   		 ex.printStackTrace();
    	   	 }
      }
      
      /** create a print All method that will print out all the information about the customer
  	 * 
  	 * @param statement to handle query statements
  	 * @throws SQLException to resolve exceptions
  	 */
 	
 	public static void printAllFromTable (Statement statement) throws SQLException{
 	       ResultSet results = statement.executeQuery("SELECT Oder_num,cust_name,cust_add, cust_loc, cust_Email FROM customer");
 	       while(results.next()) {
 	    	  System.out.println(results.getInt("order_num") +", " + results.getString("customer") +", "+ results.getString("Address") +", "+ results.getInt("cust_Location")+ ", "+ results.getString("myEmail"));
				
 			}
 	     }
 	
}

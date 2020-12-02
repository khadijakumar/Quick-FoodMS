import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;


public class InsertCustomer extends Customer {
	
	/** create a constructor to inherit all the customer information */
	public InsertCustomer() {
		super();
	}
	
/** create a method that will insert values in to the database using the customers input */
   public void Insert() {
		
	try {
		 Connection connection = DriverManager.getConnection(
                 "jdbc:sqlserver://localhost;database=library_db","example_us","Chanell082");
		          Class.forName("com.mysql.jdbc.Driver");
                  /** Create a direct line to the database for running our queries */
                  Statement statement = connection.createStatement();
                  ResultSet results;
                 int rowsAffected;
                 
                 /** executeQuery: run a SELECT statement */
                 results = statement.executeQuery("SELECT cust_name, order_num FROM customer");
                 /** Loop over the results, printing them all.*/
                 while(results.next()) {
                	 System.out.println(results.getInt("order_num") +", " + results.getString("customer") +", "+ results.getString("Address") +", "+ results.getInt("cust_Location")+ ", "+ results.getString("myEmail"));
 					
                 }
                

                
                 /** Add new customers information using the commands below: */
                 rowsAffected = statement.executeUpdate("INSERT INTO customer VALUES ("+toString()+")"); 

                 System.out.println("Query complete, "+ rowsAffected +" rows added.");
                 printAllFromTable(statement);
                 
                 // close
                 results.close();
                 statement.close();
                 connection.close();
                 
   	
   	 }catch(Exception ex) {
   		 ex.printStackTrace();
   	 }
	}
	/** create a toString method that groups in all the customers information according to the format as appears in the database */
	public String toString(){
	   	 String input = order_num + ", '" +customer+ ", '"+cust_cell+ ", '"+Address+ ", '"+cust_Location+ ", '" +myEmail;
	   	 return input;
	   }
	/** create a print All method that will print out all the information about the customer
	 * 
	 * @param statement to handle query statements
	 * @throws java.sql.SQLException to throw exceptions
	 */
	public static void printAllFromTable (Statement statement) throws SQLException{
	       ResultSet results = statement.executeQuery("SELECT Oder_num,cust_name,cust_add, cust_loc, cust_Email FROM customer");
	       while(results.next()) {
	            System.out.println(results.getInt("order_num") +", " + results.getString("customer") +", "+ results.getString("Address") +", "+ results.getInt("cust_Location")+ ", "+ results.getString("myEmail"));
					
			}
	     }
	
}

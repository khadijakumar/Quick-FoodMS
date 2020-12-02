import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;


public class insertRestaurant extends restaurant {
	/** create a class constructor to inherit all the customers information */
	insertRestaurant() {
		super();
		
	}
	
  /** create a method that will add all of the restaurant details to the database */
  public void insertRes() {
		
		
	try {
		 Connection connection = DriverManager.getConnection(
                 "jdbc:sqlserver://localhost;database=library_db","example_us","Chanell082");
		          Class.forName("com.mysql.jdbc.Driver");
                  /** Create a direct line to the database for running your queries */
                  Statement statement = connection.createStatement();
                  ResultSet results;
                 int rowsAffected;
                
                 /** runs  SELECT statement */
                 results = statement.executeQuery("SELECT rest_name, total FROM restaurant");
                 /** Loop over the results, printing them all.*/
                 while(results.next()) {
                	 System.out.println(results.getInt("rest_name") +", " + results.getString("location") +", "+ results.getString("Phone_num") +", "+ results.getInt("meals_num")+ ", "+ results.getInt("list_of_meals")+ ", "+ results.getInt("comments")+ ", "+ results.getInt("total_amount"));
 					
                 }
                

                
                 /** Add information about the restaurant using the commands below: */
                 rowsAffected = statement.executeUpdate("INSERT INTO restaurant VALUES ("+toStringRes()+")"); 

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
	/** create a toString method that will format all the information about the restaurant as appears on the database 
	 *@return a <code>toString</code>
	 * */
	public String toStringRes(){
	   	 String input = order_num+", '" +rest_name+ ", '" +location+ ", '"+Phone_num+ ", '"+meals_num+ ", '"+list_of_meals+ ", '" +comments+ ", '" + total_amount;
	   	 return input;
	   }
	/**
	 * @throws SQLException   to handle exceptions
	 * @param statement to handle query statements
	 * */
	public static void printAllFromTable (Statement statement) throws SQLException{
	       ResultSet results = statement.executeQuery("SELECT rest_name,rest_loc,rest_num ,meal_num, meal_List, comments,total FROM restaurant");
	       while(results.next()) {
	            System.out.println(results.getInt("rest_name") +", " + results.getString("location") +", "+ results.getString("Phone_num") +", "+ results.getInt("meals_num")+ ", "+ results.getInt("list_of_meals")+ ", "+ results.getInt("comments")+ ", "+ results.getInt("total_amount"));
					
			}
	     }
	
}

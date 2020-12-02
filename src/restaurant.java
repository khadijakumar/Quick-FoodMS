 
import java.text.SimpleDateFormat;
import java.util.*;

/** @author khadija kumar*/
public class restaurant{
	
	/** declare the necessary variables needed for the restaurants information */
	    String rest_name;
	    String rest_email;
	    long Phone_num;
		String location;
		int meals_num;
		int total_amount;
		int list_of_meals;
		String driver;
		long order_num;
		public String comments;
		
/** create a restaurant constructor for some of the class variables that can be initialized in advance */
		public restaurant(){
			 this.rest_name = "Tashas";
			this.rest_email = "Tasha@gmail.com";
			this.Phone_num = 342546674;
			this.location = "Melrose";
			this.driver = "Jonny";
			this.order_num = (long) Math.random();
			
		}
		/** create a comments method for the restaurant that will be called in the customers ui
		 * /** @return 
			 * comments
			 * @return a <code>String</code>
		 */
		public String  myComments() {
			Scanner com = new Scanner(System.in);
			System.out.println("Please add any extra instructions for your convinience:");
			String mycomment = com.nextLine();
			comments = mycomment;
			System.out.println("\nYour requirements are as follows \n"+comments);
			
			System.out.println("\n Ausum. We will get to it.");
			
			return comments;
		}
		
		/** create a method that will generate a date for each customer*/
		public void currentDate() {
			 Date date = new Date();
			/** create the dates format as it will be the built in  Date class.*/
			SimpleDateFormat myformat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			System.out.println(myformat.format(date));
		}
		
		
}
	
	


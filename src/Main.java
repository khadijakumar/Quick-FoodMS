
public class Main {
	

	public static void main(String[] args){
    /** welcome massgae for customer */
	System.out.println("Welcome to Quick FoodMS, we will be delivery your order from Tashas Melrose Arch.\nPlease dive in to their lovely online menu.\n");
	
	/** Create instance objects to call the class methods for the tasks that the user wants perform */
    Customer customer = new Customer();
    
  
     
   
    
    /** start creating user interaction to get the customers details so you can generate an invoice and update the database */
    customer.setCustomer();
    customer.setAddress();
    customer.myLoc();
    customer.MY_EMAIL();
    customer.cell();
    customer.Order();
    customer.myComments();
    
    /** return with the customers invoice by printing out all the information about the customer the restaurant */
    System.out.println(customer.toString());
    
    /** finalize the oder by returning the final statement and the date of the order */
    if(customer.finalized() == true) {
    	System.out.println("\n\nyour order is finalized!. Enjoy!");
    	customer.currentDate();
    }
     
     
}
}

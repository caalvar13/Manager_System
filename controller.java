// import OrderManager;
import java.util.*;

public class controller {

    static List<Store> stores = new ArrayList<Store>();
    //static OrderManager aOrderManager;

    
    private String city;
    private String zipCode;
    private List<Manager> management;
    private String deliveryHours;
    private String deliveryRules;

    public static void main(String[] args) {
    	String str = "";
    	boolean exit = false;
        List<Store> stores = createStores();
        List<Object> employeesData = stores.get(0).getEmployees();
        List<Order> orders = stores.get(0).getOrders();
//        System.out.println(Arrays.toString(employeesData.toArray()));
        System.out.println("Please enter credentials to access Manager page");
        Scanner credentials = new Scanner(System.in);
        System.out.println("Enter your username.");
        String username = credentials.nextLine();
        System.out.println("Enter your password.");
        String password1 = credentials.nextLine();
        System.out.println(username);
        System.out.println(password1);
        if(username.equalsIgnoreCase("juan") || password1.equalsIgnoreCase("manager")){
        	System.out.println("Login Successful, what can I do for you, today.");
	  }
	  else {
		  System.out.println("Wrong Password, terminated.");
		  try {
		  credentials.close();
		  }
		  catch(IllegalStateException e) {
			  System.out.println("Wrong Password, terminated.");
		  }
//		  break;
	  }
//        credentials.close();
//        List<Object> employeesData = stores.get(0).getEmployees();
//        System.out.println(employeesData);
//        	String input1 = users.next:ine()
        	while (exit == false){
        		System.out.println();
        		System.out.println("Type exit to finish otherwise continue with other commands");
        		System.out.println("Type employees to see all employees");
        		System.out.println("Type orders to see all orders");
        		System.out.println("Type store to see info of this store.");
        		
        		str = credentials.nextLine();
//        	        	boolean exit = false;
//        	        	Scanner keyboard = new Scanner(System.in);
        	     if(str.equalsIgnoreCase("exit") || str.equalsIgnoreCase("e")){
        	       exit = true; 
        	       System.out.println("System exited");
        	     }
//        		Scanner users = new Scanner(System.in);
        		
        		if(str.equalsIgnoreCase("employees")){
        			System.out.println(employeesData);
        		}
        		if(str.equalsIgnoreCase("orders")){
        			System.out.println(orders);
        		}
        		if(str.equalsIgnoreCase("store")){
        			System.out.println("City Located: "+stores.get(0).getCity());
        			System.out.println("zip code: "+stores.get(0).getZipCode());
        			System.out.println("Delivery Rules: "+stores.get(0).getDeliveryRules());
        			System.out.println("Hours of operation: "+stores.get(0).getDeliveryHours());
        			
        			
        		}
//        		if(users.nextLine().equals("exit")) {
//        			break;
//        		}
        	}
        }
//        else {
//        	System.out.println("Wrong Password, terminated.");
//        }
//    }

    public static List<Store> createStores(){
        stores.add(new Store("79936"));
        stores.add(new Store("79935"));
        stores.add(new Store("79912"));
        return stores;
    }
    
}

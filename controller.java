// import OrderManager;
import java.util.*;


public class controller {

    static List<Store> stores = new ArrayList<Store>();
    static List<Manager> managers = new ArrayList<Manager>();
    //static OrderManager aOrderManager;
    private String city;
    private String zipCode;
    private List<Manager> management;
    private String deliveryHours;
    private String deliveryRules;

    public static void main(String[] args) {

        Scanner credentials = new Scanner(System.in);

        createStores();
        getManagers();

        System.out.println("Please enter credentials to access Manager page");
        System.out.print("Enter your username: ");
        String username = credentials.nextLine();
        System.out.print("Enter your password: ");
        String password1 = credentials.nextLine();

        boolean wrong = true;
        Manager manager;
        while(wrong){
            for(Manager mg: managers){
                if(username.equalsIgnoreCase(manager.getUsername()) && password1.equals(manager.getPassword())){
                    System.out.println("Login Successful! Welcome " + mg.name);
                    wrong = false;
                    manager = mg;
                    break;
                }
            }
            if(wrong){
                System.out.println("Wrong credentials. Try again");
                System.out.print("Enter your username: ");
                username = credentials.nextLine();
                System.out.print("Enter your password: ");
                password1 = credentials.nextLine();
            }
        }



        while(true){
            System.out.println("Select action by typing number");
            System.out.println("(1) See all employees");
            System.out.println("(2) Ssee all orders");
            System.out.println("(3) See store revenue");
            System.out.println("(4) See store cost");

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
        
        
    }

    public static void createStores(){
        stores.add(new Store("79936"));
        stores.add(new Store("79935"));
        stores.add(new Store("79912"));
    }

    public static void getManagers(){
        for(Store store: stores){
            managers.addAll(store.getManagers());
        }
    }
    
}

import java.util.*;
import java.util.Scanner;
// import OrderManager;


public class controller {

    static List<Store> stores = new ArrayList<Store>();
    //static OrderManager aOrderManager;
    private String city;
    private String zipCode;
    private List<Manager> management;
    private String deliveryHours;
    private String deliveryRules;

    public static void main(String[] args) {
        createStores();
        for(int i = 0;i<3;i++)
            System.out.println(String.join("\n", stores.get(i).getCity()));
    }

    public static void createStores(){
        stores.add(new Store("79936"));
        stores.add(new Store("79935"));
        stores.add(new Store("79912"));
    }
    
}

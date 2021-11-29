/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/


import java.util.*;

// line 2 "model.ump"
// line 140 "model.ump"
public class Store
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Store Attributes
  private String state;
  private String city;
  private String zipCode;
  private String workHours;
  private String deliveryHours;
  private String deliveryRules;
  private List<Object> employees = new ArrayList<Object>();
  private List<Order> orders = new ArrayList<Order>();
  private double revenue;
  private double cost;

  //Store Associations
  

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Store(String zipcode)
  {
    state = "Texas";
    city = "El Paso";
    zipCode = zipcode;
    deliveryHours = "10-10";
    deliveryRules = "No more than 5 mile radius";
    employees();
    orders();
  }

  //------------------------
  // INTERFACE
  //------------------------
  private void employees(){
    employees.add(new Manager("Juan", 14.5, 35));
    employees.add(new Driver("Gabe", 8.5, 34));
    employees.add(new Maintenance("John", 8.5, 33));
    employees.add(new Cook("Luis", 8.5, 32));
    employees.add(new Cashier("Johnny", 8.5, 32));
  }

  private List<Object> getEmployees()
  {
    return employees;
  }

  private void orders(){
    orders.add(new Order("delivery", new Pizza(3), 6.50, true, "good service"));
    orders.add(new Order("delivery", new Pizza(2), 4.50, false, ""));
    orders.add(new Order("delivery", new Pizza(4), 8.50, true, "service is great!"));
    orders.add(new Order("delivery", new Pizza(1), 2.50, false, ""));
    orders.add(new Order("delivery", new Pizza(5), 10.50, true, "fast service"));
  }
  

  public void setCity(String aCity)
  {
    city = aCity;
  }

  public void setZipCode(String aZipCode)
  {
    zipCode = aZipCode;
  }

  public void setDeliveryHours(String aDeliveryHours)
  {
    deliveryHours = aDeliveryHours;
  }

  public void setDeliveryRules(String aDeliveryRules)
  {
    deliveryRules = aDeliveryRules;
  }

  public String getState()
  {
    return state;
  }

  public String getCity()
  {
    return city;
  }

  public String getZipCode()
  {
    return zipCode;
  }

  public String getDeliveryHours()
  {
    return deliveryHours;
  }

  public String getDeliveryRules()
  {
    return deliveryRules;
  }

  
  // /* Code from template association_GetOne */
  // public OrderManager getOrderManager()
  // {
    
  // }
  // /* Code from template association_GetMany */
  // public Order getOrder(int index)
  // {
    
  // }

  public List<Order> getOrders()
  {
    return orders;
  }

  // line 12 "model.ump"
   private double getCost(){
     cost = 0;
     for(Object emp: employees){
       if(emp.getClass() == Manager.class){
         Manager employee = (Manager)emp;
         cost+= employee.hoursWorked * employee.salary;
       }else if(emp.getClass() == Cashier.class){
        Cashier employee = (Cashier)emp;
        cost+= employee.hoursWorked * employee.salary;
       }else if(emp.getClass() == Cook.class){
        Cook employee = (Cook)emp;
        cost+= employee.hoursWorked * employee.salary;
       }else if(emp.getClass() == Maintenance.class){
        Maintenance employee = (Maintenance)emp;
        cost+= employee.hoursWorked * employee.salary;
       }else if(emp.getClass() == Driver.class){
        Driver employee = (Driver)emp;
        cost+= employee.hoursWorked * employee.salary;
       }
     }
    return cost;
  }

  // line 15 "model.ump"
  private double getRevenue(){
    revenue = 0;
    for(Order order: orders){
      revenue += order.getCost();
    }
   return revenue;
 }

 public List<Manager> getManagers(){
  List<Manager> managers = new ArrayList<Manager>();
  for(Object employee: employees){
    if(employee.getClass() == Manager.class)
      managers.add((Manager) employee);
  }
  return managers;
}
  
}
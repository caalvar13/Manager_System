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
  // private OrderManager orderManager;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Store(String zipcode)
  {
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
  /* Code from template attribute_SetMany */
  public void addManagement(Manager aManagement)
  {

  }

  public void removeManagement(Manager aManagement)
  {
    
  }

  public void setDeliveryHours(String aDeliveryHours)
  {
    deliveryHours = aDeliveryHours;
  }

  public void setDeliveryRules(String aDeliveryRules)
  {
    deliveryRules = aDeliveryRules;
  }

  public String getCity()
  {
    return city;
  }

  public String getZipCode()
  {
    return zipCode;
  }
  // /* Code from template attribute_GetMany */
  // public Manager getManager(int index)
  // {
    
  // }

  // public Manager[] getManagement()
  // {
   
  // }

  public String getDeliveryHours()
  {
    return deliveryHours;
  }

  public String getDeliveryRules()
  {
    return deliveryRules;
  }
  /* Code from template association_GetMany */
  // public Employee getEmployee(int index)
  // {

  // }

  // public List<Employee> getEmployees()
  // {
    
  // }

  // public int numberOfEmployees()
  // {
    
  // }

  
  // /* Code from template association_GetOne */
  // public OrderManager getOrderManager()
  // {
    
  // }
  // /* Code from template association_GetMany */
  // public Order getOrder(int index)
  // {
    
  // }

  // public List<Order> getOrders()
  // {
    
  // }

  
  // /* Code from template association_AddManyToOne */
  // public Employee addEmployee(String aName, double aSalary, Employee aEmployee)
  // {
    
  // }

  // public boolean removeEmployee(Employee aEmployee)
  // {
    
  // }

  // line 12 "model.ump"
   private double manageCost(){
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
  private double manageRevenue(){
    revenue = 0;
    for(Order order: orders){
      revenue += order.getCost();
    }
   return revenue;
 }
  
}
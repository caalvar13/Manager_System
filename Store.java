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
  private OrderManager orderManager;

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
  /* Code from template attribute_GetMany */
  public Manager getManager(int index)
  {
    Manager aManagement = management.get(index);
    return aManagement;
  }

  public Manager[] getManagement()
  {
    Manager[] newManagement = management.toArray(new Manager[management.size()]);
    return newManagement;
  }

  public int numberOfManagement()
  {
    int number = management.size();
    return number;
  }

  public boolean hasManagement()
  {
    boolean has = management.size() > 0;
    return has;
  }

  public int indexOfManagement(Manager aManagement)
  {
    int index = management.indexOf(aManagement);
    return index;
  }

  public String getDeliveryHours()
  {
    return deliveryHours;
  }

  public String getDeliveryRules()
  {
    return deliveryRules;
  }
  /* Code from template association_GetMany */
  public Employee getEmployee(int index)
  {
    Employee aEmployee = employees.get(index);
    return aEmployee;
  }

  public List<Employee> getEmployees()
  {
    List<Employee> newEmployees = Collections.unmodifiableList(employees);
    return newEmployees;
  }

  public int numberOfEmployees()
  {
    int number = employees.size();
    return number;
  }

  public boolean hasEmployees()
  {
    boolean has = employees.size() > 0;
    return has;
  }

  public int indexOfEmployee(Employee aEmployee)
  {
    int index = employees.indexOf(aEmployee);
    return index;
  }
  /* Code from template association_GetOne */
  public OrderManager getOrderManager()
  {
    return orderManager;
  }
  /* Code from template association_GetMany */
  public Order getOrder(int index)
  {
    Order aOrder = orders.get(index);
    return aOrder;
  }

  public List<Order> getOrders()
  {
    List<Order> newOrders = Collections.unmodifiableList(orders);
    return newOrders;
  }

  public int numberOfOrders()
  {
    int number = orders.size();
    return number;
  }

  public boolean hasOrders()
  {
    boolean has = orders.size() > 0;
    return has;
  }

  public int indexOfOrder(Order aOrder)
  {
    int index = orders.indexOf(aOrder);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfEmployees()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Employee addEmployee(String aName, double aSalary, Employee aEmployee)
  {
    return new Employee(aName, aSalary, aEmployee);
  }

  public boolean addEmployee(Employee aEmployee)
  {
    boolean wasAdded = false;
    if (employees.contains(aEmployee)) { return false; }
    Store existingStore = aEmployee.getStore();
    boolean isNewStore = existingStore != null && !this.equals(existingStore);
    if (isNewStore)
    {
      aEmployee.setStore(this);
    }
    else
    {
      employees.add(aEmployee);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeEmployee(Employee aEmployee)
  {
    boolean wasRemoved = false;
    //Unable to remove aEmployee, as it must always have a store
    if (!this.equals(aEmployee.getStore()))
    {
      employees.remove(aEmployee);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addEmployeeAt(Employee aEmployee, int index)
  {  
    boolean wasAdded = false;
    if(addEmployee(aEmployee))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEmployees()) { index = numberOfEmployees() - 1; }
      employees.remove(aEmployee);
      employees.add(index, aEmployee);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveEmployeeAt(Employee aEmployee, int index)
  {
    boolean wasAdded = false;
    if(employees.contains(aEmployee))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEmployees()) { index = numberOfEmployees() - 1; }
      employees.remove(aEmployee);
      employees.add(index, aEmployee);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addEmployeeAt(aEmployee, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToMany */
  public boolean setOrderManager(OrderManager aOrderManager)
  {
    boolean wasSet = false;
    if (aOrderManager == null)
    {
      return wasSet;
    }

    OrderManager existingOrderManager = orderManager;
    orderManager = aOrderManager;
    if (existingOrderManager != null && !existingOrderManager.equals(aOrderManager))
    {
      existingOrderManager.removeStore(this);
    }
    orderManager.addStore(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfOrders()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Order addOrder(String aDelivery, OrderManager aOrderManager)
  {
    return new Order(aDelivery, this, aOrderManager);
  }

  public boolean addOrder(Order aOrder)
  {
    boolean wasAdded = false;
    if (orders.contains(aOrder)) { return false; }
    Store existingStore = aOrder.getStore();
    boolean isNewStore = existingStore != null && !this.equals(existingStore);
    if (isNewStore)
    {
      aOrder.setStore(this);
    }
    else
    {
      orders.add(aOrder);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOrder(Order aOrder)
  {
    boolean wasRemoved = false;
    //Unable to remove aOrder, as it must always have a store
    if (!this.equals(aOrder.getStore()))
    {
      orders.remove(aOrder);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addOrderAt(Order aOrder, int index)
  {  
    boolean wasAdded = false;
    if(addOrder(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOrderAt(Order aOrder, int index)
  {
    boolean wasAdded = false;
    if(orders.contains(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOrderAt(aOrder, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=employees.size(); i > 0; i--)
    {
      Employee aEmployee = employees.get(i - 1);
      aEmployee.delete();
    }
    OrderManager placeholderOrderManager = orderManager;
    this.orderManager = null;
    if(placeholderOrderManager != null)
    {
      placeholderOrderManager.removeStore(this);
    }
    for(int i=orders.size(); i > 0; i--)
    {
      Order aOrder = orders.get(i - 1);
      aOrder.delete();
    }
  }

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

  // line 18 "model.ump"
   private void prepareOrder(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "city" + ":" + getCity()+ "," +
            "zipCode" + ":" + getZipCode()+ "," +
            "deliveryHours" + ":" + getDeliveryHours()+ "," +
            "deliveryRules" + ":" + getDeliveryRules()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "orderManager = "+(getOrderManager()!=null?Integer.toHexString(System.identityHashCode(getOrderManager())):"null");
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 4 "model.ump"
  private String state ;

  
}
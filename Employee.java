/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/



// line 21 "model.ump"
// line 145 "model.ump"
public class Employee
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Employee Attributes
  private String name;
  private double salary;

  //Employee Associations
  private Store store;
  private EmployeeManager employeeManager;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Employee(String aName, double aSalary, Store aStore, EmployeeManager aEmployeeManager)
  {
    name = aName;
    salary = aSalary;
    boolean didAddStore = setStore(aStore);
    if (!didAddStore)
    {
      throw new RuntimeException("Unable to create employee due to store. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddEmployeeManager = setEmployeeManager(aEmployeeManager);
    if (!didAddEmployeeManager)
    {
      throw new RuntimeException("Unable to create employee due to employeeManager. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setSalary(double aSalary)
  {
    boolean wasSet = false;
    salary = aSalary;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public double getSalary()
  {
    return salary;
  }
  /* Code from template association_GetOne */
  public Store getStore()
  {
    return store;
  }
  /* Code from template association_GetOne */
  public EmployeeManager getEmployeeManager()
  {
    return employeeManager;
  }
  /* Code from template association_SetOneToMany */
  public boolean setStore(Store aStore)
  {
    boolean wasSet = false;
    if (aStore == null)
    {
      return wasSet;
    }

    Store existingStore = store;
    store = aStore;
    if (existingStore != null && !existingStore.equals(aStore))
    {
      existingStore.removeEmployee(this);
    }
    store.addEmployee(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setEmployeeManager(EmployeeManager aEmployeeManager)
  {
    boolean wasSet = false;
    if (aEmployeeManager == null)
    {
      return wasSet;
    }

    EmployeeManager existingEmployeeManager = employeeManager;
    employeeManager = aEmployeeManager;
    if (existingEmployeeManager != null && !existingEmployeeManager.equals(aEmployeeManager))
    {
      existingEmployeeManager.removeEmployee(this);
    }
    employeeManager.addEmployee(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Store placeholderStore = store;
    this.store = null;
    if(placeholderStore != null)
    {
      placeholderStore.removeEmployee(this);
    }
    EmployeeManager placeholderEmployeeManager = employeeManager;
    this.employeeManager = null;
    if(placeholderEmployeeManager != null)
    {
      placeholderEmployeeManager.removeEmployee(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "salary" + ":" + getSalary()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "store = "+(getStore()!=null?Integer.toHexString(System.identityHashCode(getStore())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "employeeManager = "+(getEmployeeManager()!=null?Integer.toHexString(System.identityHashCode(getEmployeeManager())):"null");
  }
}
// /*PLEASE DO NOT EDIT THIS CODE*/
// /*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/


// import java.util.*;

// // line 29 "model.ump"
// // line 152 "model.ump"
// public class EmployeeManager
// {

//   //------------------------
//   // MEMBER VARIABLES
//   //------------------------

//   //EmployeeManager Associations
//   private List<Employee> employees;

//   //------------------------
//   // CONSTRUCTOR
//   //------------------------

//   public EmployeeManager()
//   {
//     employees = new ArrayList<Employee>();
//   }

//   //------------------------
//   // INTERFACE
//   //------------------------
//   /* Code from template association_GetMany */
//   public Employee getEmployee(int index)
//   {
//     Employee aEmployee = employees.get(index);
//     return aEmployee;
//   }

//   public List<Employee> getEmployees()
//   {
//     List<Employee> newEmployees = Collections.unmodifiableList(employees);
//     return newEmployees;
//   }

//   public int numberOfEmployees()
//   {
//     int number = employees.size();
//     return number;
//   }

//   public boolean hasEmployees()
//   {
//     boolean has = employees.size() > 0;
//     return has;
//   }

//   public int indexOfEmployee(Employee aEmployee)
//   {
//     int index = employees.indexOf(aEmployee);
//     return index;
//   }
//   /* Code from template association_MinimumNumberOfMethod */
//   public static int minimumNumberOfEmployees()
//   {
//     return 0;
//   }
//   /* Code from template association_AddManyToOne */
//   public Employee addEmployee(String aName, double aSalary, Store aStore)
//   {
//     return new Employee(aName, aSalary, aStore, this);
//   }

//   public boolean addEmployee(Employee aEmployee)
//   {
//     boolean wasAdded = false;
//     if (employees.contains(aEmployee)) { return false; }
//     EmployeeManager existingEmployeeManager = aEmployee.getEmployeeManager();
//     boolean isNewEmployeeManager = existingEmployeeManager != null && !this.equals(existingEmployeeManager);
//     if (isNewEmployeeManager)
//     {
//       aEmployee.setEmployeeManager(this);
//     }
//     else
//     {
//       employees.add(aEmployee);
//     }
//     wasAdded = true;
//     return wasAdded;
//   }

//   public boolean removeEmployee(Employee aEmployee)
//   {
//     boolean wasRemoved = false;
//     //Unable to remove aEmployee, as it must always have a employeeManager
//     if (!this.equals(aEmployee.getEmployeeManager()))
//     {
//       employees.remove(aEmployee);
//       wasRemoved = true;
//     }
//     return wasRemoved;
//   }
//   /* Code from template association_AddIndexControlFunctions */
//   public boolean addEmployeeAt(Employee aEmployee, int index)
//   {  
//     boolean wasAdded = false;
//     if(addEmployee(aEmployee))
//     {
//       if(index < 0 ) { index = 0; }
//       if(index > numberOfEmployees()) { index = numberOfEmployees() - 1; }
//       employees.remove(aEmployee);
//       employees.add(index, aEmployee);
//       wasAdded = true;
//     }
//     return wasAdded;
//   }

//   public boolean addOrMoveEmployeeAt(Employee aEmployee, int index)
//   {
//     boolean wasAdded = false;
//     if(employees.contains(aEmployee))
//     {
//       if(index < 0 ) { index = 0; }
//       if(index > numberOfEmployees()) { index = numberOfEmployees() - 1; }
//       employees.remove(aEmployee);
//       employees.add(index, aEmployee);
//       wasAdded = true;
//     } 
//     else 
//     {
//       wasAdded = addEmployeeAt(aEmployee, index);
//     }
//     return wasAdded;
//   }

//   public void delete()
//   {
//     for(int i=employees.size(); i > 0; i--)
//     {
//       Employee aEmployee = employees.get(i - 1);
//       aEmployee.delete();
//     }
//   }

//   // line 33 "model.ump"
//    private void trackSalaries(){
    
//   }

//   // line 36 "model.ump"
//    private void manageTimeSchedule(){
    
//   }

//   // line 39 "model.ump"
//    private void trackHoursWorked(){
    
//   }

// }
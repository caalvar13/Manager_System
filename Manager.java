/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/

import java.util.*;

// line 74 "model.ump"
// line 177 "model.ump"
public class Manager extends Employee
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------



  public Manager(String aName, double aSalary, double aHoursWorked)
  {
    name = aName;
    salary = aSalary;
    hoursWorked = aHoursWorked;
    isManager =true;
  }

  //------------------------
  // INTERFACE
  //------------------------

  private void addEmployee(Object employee, List<Object> employees){
    if(!employees.contains(employee)){
      employees.add(employee);
    } else {
      System.out.println("Employee already in Database");
    }
  }

  private void removeEmployee(Object employee, List<Object> employees){
    if(employees.contains(employee)){
      employees.remove(employee);
    } else {
      System.out.println("Employee not in Database");
    }
  }

  private void addTopping(Pizza pizza, String topping){
    if(!Pizza.toppinngs.contains(topping))
      pizza.ingredients.add(topping);
    else
      System.out.println("Topping already exist in list");
  }

  private void removeTopping(Pizza pizza, String topping){
    if(!Pizza.toppinngs.isEmpty() && Pizza.toppinngs.contains(topping))
      Pizza.toppinngs.remove(new String(topping));
    else 
      System.out.print("No ingredient found to remove");
  }

}
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
  protected String name;
  protected double salary;
  protected double hoursWorked;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Employee()
  {
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void setName(String aName)
  {
    name = aName;
  }

  public void setSalary(double aSalary)
  {
    salary = aSalary;
  }

  public String getName()
  {
    return name;
  }

  public double getSalary()
  {
    return salary;
  }
  
  public String toString() {
      return "Employee Info:"+"name string: " + this.name + "\n" +" salary double: " + this.salary +  "\n" + " hours worked double: " + this.hoursWorked + "\n" + "\n";
  }
  
  
  
}
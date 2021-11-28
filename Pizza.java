/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/



// line 122 "model.ump"
// line 202 "model.ump"
public class Pizza
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Pizza Attributes
  private String pepperoni;
  private String cheese;
  private String tomatoe;
  private String pineapple;
  private String mushrooms;

  //Pizza Associations
  private Order order;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Pizza(String aPepperoni, String aCheese, String aTomatoe, String aPineapple, String aMushrooms, Order aOrder)
  {
    pepperoni = aPepperoni;
    cheese = aCheese;
    tomatoe = aTomatoe;
    pineapple = aPineapple;
    mushrooms = aMushrooms;
    boolean didAddOrder = setOrder(aOrder);
    if (!didAddOrder)
    {
      throw new RuntimeException("Unable to create pizza due to order. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPepperoni(String aPepperoni)
  {
    boolean wasSet = false;
    pepperoni = aPepperoni;
    wasSet = true;
    return wasSet;
  }

  public boolean setCheese(String aCheese)
  {
    boolean wasSet = false;
    cheese = aCheese;
    wasSet = true;
    return wasSet;
  }

  public boolean setTomatoe(String aTomatoe)
  {
    boolean wasSet = false;
    tomatoe = aTomatoe;
    wasSet = true;
    return wasSet;
  }

  public boolean setPineapple(String aPineapple)
  {
    boolean wasSet = false;
    pineapple = aPineapple;
    wasSet = true;
    return wasSet;
  }

  public boolean setMushrooms(String aMushrooms)
  {
    boolean wasSet = false;
    mushrooms = aMushrooms;
    wasSet = true;
    return wasSet;
  }

  public String getPepperoni()
  {
    return pepperoni;
  }

  public String getCheese()
  {
    return cheese;
  }

  public String getTomatoe()
  {
    return tomatoe;
  }

  public String getPineapple()
  {
    return pineapple;
  }

  public String getMushrooms()
  {
    return mushrooms;
  }
  /* Code from template association_GetOne */
  public Order getOrder()
  {
    return order;
  }
  /* Code from template association_SetOneToMany */
  public boolean setOrder(Order aOrder)
  {
    boolean wasSet = false;
    if (aOrder == null)
    {
      return wasSet;
    }

    Order existingOrder = order;
    order = aOrder;
    if (existingOrder != null && !existingOrder.equals(aOrder))
    {
      existingOrder.removePizza(this);
    }
    order.addPizza(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Order placeholderOrder = order;
    this.order = null;
    if(placeholderOrder != null)
    {
      placeholderOrder.removePizza(this);
    }
  }

  // line 132 "model.ump"
   private void addIngredients(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "pepperoni" + ":" + getPepperoni()+ "," +
            "cheese" + ":" + getCheese()+ "," +
            "tomatoe" + ":" + getTomatoe()+ "," +
            "pineapple" + ":" + getPineapple()+ "," +
            "mushrooms" + ":" + getMushrooms()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "order = "+(getOrder()!=null?Integer.toHexString(System.identityHashCode(getOrder())):"null");
  }
}
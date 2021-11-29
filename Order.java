/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/


import java.util.*;

// line 66 "model.ump"
// line 169 "model.ump"
public class Order
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Order Attributes
  private String delivery;
  private double cost;
  private boolean fb;
  private String feedback;

  //Order Associations
  private List<Pizza> pizzas = new ArrayList<Pizza>();

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Order(String aDelivery, Pizza pizza, double aCost, boolean b, String aFeedback)
  {
    delivery = aDelivery;
    pizzas.add(pizza);
    cost = aCost;
    fb = b;
    feedback = aFeedback;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void setDelivery(String aDelivery)
  {
    delivery = aDelivery;
  }

  public String getDelivery()
  {
    return delivery;
  }

  public double getCost()
  {
    return cost;
  }

}
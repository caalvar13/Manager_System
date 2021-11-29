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

  public Order(String aDelivery, Pizza pizza, double aCost, double aFb, String aFeedback)
  {
    delivery = aDelivery;
    pizzas.add(pizza);
    cost = aCost;
    fb = aFb;
    feedback = aFeedback;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDelivery(String aDelivery)
  {
    boolean wasSet = false;
    delivery = aDelivery;
    wasSet = true;
    return wasSet;
  }

  public String getDelivery()
  {
    return delivery;
  }

  public double getCost()
  {
    return cost;
  }

  /* Code from template association_GetOne */
  public Store getStore()
  {
    return store;
  }
  /* Code from template association_GetOne */
  public OrderManager getOrderManager()
  {
    return orderManager;
  }
  /* Code from template association_GetMany */
  public Pizza getPizza(int index)
  {
    Pizza aPizza = pizzas.get(index);
    return aPizza;
  }

  public List<Pizza> getPizzas()
  {
    List<Pizza> newPizzas = Collections.unmodifiableList(pizzas);
    return newPizzas;
  }

  public int numberOfPizzas()
  {
    int number = pizzas.size();
    return number;
  }

  public boolean hasPizzas()
  {
    boolean has = pizzas.size() > 0;
    return has;
  }

  public int indexOfPizza(Pizza aPizza)
  {
    int index = pizzas.indexOf(aPizza);
    return index;
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
      existingStore.removeOrder(this);
    }
    store.addOrder(this);
    wasSet = true;
    return wasSet;
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
      existingOrderManager.removeOrder(this);
    }
    orderManager.addOrder(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPizzas()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Pizza addPizza(String aPepperoni, String aCheese, String aTomatoe, String aPineapple, String aMushrooms)
  {
    return new Pizza(aPepperoni, aCheese, aTomatoe, aPineapple, aMushrooms, this);
  }

  public boolean addPizza(Pizza aPizza)
  {
    boolean wasAdded = false;
    if (pizzas.contains(aPizza)) { return false; }
    Order existingOrder = aPizza.getOrder();
    boolean isNewOrder = existingOrder != null && !this.equals(existingOrder);
    if (isNewOrder)
    {
      aPizza.setOrder(this);
    }
    else
    {
      pizzas.add(aPizza);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePizza(Pizza aPizza)
  {
    boolean wasRemoved = false;
    //Unable to remove aPizza, as it must always have a order
    if (!this.equals(aPizza.getOrder()))
    {
      pizzas.remove(aPizza);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPizzaAt(Pizza aPizza, int index)
  {  
    boolean wasAdded = false;
    if(addPizza(aPizza))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPizzas()) { index = numberOfPizzas() - 1; }
      pizzas.remove(aPizza);
      pizzas.add(index, aPizza);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePizzaAt(Pizza aPizza, int index)
  {
    boolean wasAdded = false;
    if(pizzas.contains(aPizza))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPizzas()) { index = numberOfPizzas() - 1; }
      pizzas.remove(aPizza);
      pizzas.add(index, aPizza);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPizzaAt(aPizza, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    Store placeholderStore = store;
    this.store = null;
    if(placeholderStore != null)
    {
      placeholderStore.removeOrder(this);
    }
    OrderManager placeholderOrderManager = orderManager;
    this.orderManager = null;
    if(placeholderOrderManager != null)
    {
      placeholderOrderManager.removeOrder(this);
    }
    for(int i=pizzas.size(); i > 0; i--)
    {
      Pizza aPizza = pizzas.get(i - 1);
      aPizza.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "delivery" + ":" + getDelivery()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "store = "+(getStore()!=null?Integer.toHexString(System.identityHashCode(getStore())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "orderManager = "+(getOrderManager()!=null?Integer.toHexString(System.identityHashCode(getOrderManager())):"null");
  }
}
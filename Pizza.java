import java.util.*;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/



// line 122 "model.ump"
// line 202 "model.ump"
public class Pizza
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  List<String> ingredients = new ArrayList<String>(){};
  String[] toppinngs = {
    "pepperoni","cheese", "tomatoe", "pineapple", "mushrooms"
  };

  //Pizza Associations
  private Order order;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Pizza(int t)
  {
    if(t == toppinngs.length){
      ingredients.addAll(Arrays.asList(toppinngs));

    }else{
      Random rand = new Random();
      List<Integer> l = new ArrayList<Integer>();
      int n = rand.nextInt(5);
      for (int i = 0; i< t;i++){
        if(!l.contains(n) || l.isEmpty()){
          l.add(n);
          ingredients.add(toppinngs[n]);
        }
        n = rand.nextInt(5);
      }
    }
  }

  public Pizza(String[] toppings)
  {
    for(String ingredient: toppings)
      ingredients.add(ingredient);
  }

  public Pizza(String topping)
  {
    ingredients.add(topping);
  }

  //------------------------
  // INTERFACE
  //------------------------
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
  
   
  private void addIngredients(String ingredient){
    ingredients.add(ingredient);
  }

  private void removeIngredients(String ingredient){
    if(!ingredients.isEmpty() && ingredient.contains(ingredient))
      ingredients.remove(new String(ingredient));
    else 
      System.out.print("No ingredient found to remove");
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
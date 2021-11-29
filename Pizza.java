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
  static List<String> toppinngs = new ArrayList<String>(){
    add("pepperoni");
    add("cheese");
    add("tomatoe");
    add("pineapple");
    add("mushrooms");
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
}
// /*PLEASE DO NOT EDIT THIS CODE*/
// /*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/


// import java.util.*;

// // line 43 "model.ump"
// // line 157 "model.ump"
// public class OrderManager
// {

//   //------------------------
//   // MEMBER VARIABLES
//   //------------------------

//   //OrderManager Associations
//   private List<Store> stores;
//   private FeedbackManager feedbackManager;
//   private List<Order> orders;

//   //------------------------
//   // CONSTRUCTOR
//   //------------------------

//   public OrderManager(FeedbackManager aFeedbackManager)
//   {
//     stores = new ArrayList<Store>();
//     if (aFeedbackManager == null || aFeedbackManager.getOrderManager() != null)
//     {
//       throw new RuntimeException("Unable to create OrderManager due to aFeedbackManager. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
//     }
//     feedbackManager = aFeedbackManager;
//     orders = new ArrayList<Order>();
//   }

//   public OrderManager(String aFeedbackForFeedbackManager)
//   {
//     stores = new ArrayList<Store>();
//     feedbackManager = new FeedbackManager(aFeedbackForFeedbackManager, this);
//     orders = new ArrayList<Order>();
//   }

//   //------------------------
//   // INTERFACE
//   //------------------------
//   /* Code from template association_GetMany */
//   public Store getStore(int index)
//   {
//     Store aStore = stores.get(index);
//     return aStore;
//   }

//   public List<Store> getStores()
//   {
//     List<Store> newStores = Collections.unmodifiableList(stores);
//     return newStores;
//   }

//   public int numberOfStores()
//   {
//     int number = stores.size();
//     return number;
//   }

//   public boolean hasStores()
//   {
//     boolean has = stores.size() > 0;
//     return has;
//   }

//   public int indexOfStore(Store aStore)
//   {
//     int index = stores.indexOf(aStore);
//     return index;
//   }
//   /* Code from template association_GetOne */
//   public FeedbackManager getFeedbackManager()
//   {
//     return feedbackManager;
//   }
//   /* Code from template association_GetMany */
//   public Order getOrder(int index)
//   {
//     Order aOrder = orders.get(index);
//     return aOrder;
//   }

//   public List<Order> getOrders()
//   {
//     List<Order> newOrders = Collections.unmodifiableList(orders);
//     return newOrders;
//   }

//   public int numberOfOrders()
//   {
//     int number = orders.size();
//     return number;
//   }

//   public boolean hasOrders()
//   {
//     boolean has = orders.size() > 0;
//     return has;
//   }

//   public int indexOfOrder(Order aOrder)
//   {
//     int index = orders.indexOf(aOrder);
//     return index;
//   }
//   /* Code from template association_MinimumNumberOfMethod */
//   public static int minimumNumberOfStores()
//   {
//     return 0;
//   }
//   /* Code from template association_AddManyToOne */
//   public Store addStore(String aCity, String aZipCode, String aDeliveryHours, String aDeliveryRules)
//   {
//     return new Store(aCity, aZipCode, aDeliveryHours, aDeliveryRules, this);
//   }

//   public boolean addStore(Store aStore)
//   {
//     boolean wasAdded = false;
//     if (stores.contains(aStore)) { return false; }
//     OrderManager existingOrderManager = aStore.getOrderManager();
//     boolean isNewOrderManager = existingOrderManager != null && !this.equals(existingOrderManager);
//     if (isNewOrderManager)
//     {
//       aStore.setOrderManager(this);
//     }
//     else
//     {
//       stores.add(aStore);
//     }
//     wasAdded = true;
//     return wasAdded;
//   }

//   public boolean removeStore(Store aStore)
//   {
//     boolean wasRemoved = false;
//     //Unable to remove aStore, as it must always have a orderManager
//     if (!this.equals(aStore.getOrderManager()))
//     {
//       stores.remove(aStore);
//       wasRemoved = true;
//     }
//     return wasRemoved;
//   }
//   /* Code from template association_AddIndexControlFunctions */
//   public boolean addStoreAt(Store aStore, int index)
//   {  
//     boolean wasAdded = false;
//     if(addStore(aStore))
//     {
//       if(index < 0 ) { index = 0; }
//       if(index > numberOfStores()) { index = numberOfStores() - 1; }
//       stores.remove(aStore);
//       stores.add(index, aStore);
//       wasAdded = true;
//     }
//     return wasAdded;
//   }

//   public boolean addOrMoveStoreAt(Store aStore, int index)
//   {
//     boolean wasAdded = false;
//     if(stores.contains(aStore))
//     {
//       if(index < 0 ) { index = 0; }
//       if(index > numberOfStores()) { index = numberOfStores() - 1; }
//       stores.remove(aStore);
//       stores.add(index, aStore);
//       wasAdded = true;
//     } 
//     else 
//     {
//       wasAdded = addStoreAt(aStore, index);
//     }
//     return wasAdded;
//   }
//   /* Code from template association_MinimumNumberOfMethod */
//   public static int minimumNumberOfOrders()
//   {
//     return 0;
//   }
//   /* Code from template association_AddManyToOne */
//   public Order addOrder(String aDelivery, Store aStore)
//   {
//     return new Order(aDelivery, aStore, this);
//   }

//   public boolean addOrder(Order aOrder)
//   {
//     boolean wasAdded = false;
//     if (orders.contains(aOrder)) { return false; }
//     OrderManager existingOrderManager = aOrder.getOrderManager();
//     boolean isNewOrderManager = existingOrderManager != null && !this.equals(existingOrderManager);
//     if (isNewOrderManager)
//     {
//       aOrder.setOrderManager(this);
//     }
//     else
//     {
//       orders.add(aOrder);
//     }
//     wasAdded = true;
//     return wasAdded;
//   }

//   public boolean removeOrder(Order aOrder)
//   {
//     boolean wasRemoved = false;
//     //Unable to remove aOrder, as it must always have a orderManager
//     if (!this.equals(aOrder.getOrderManager()))
//     {
//       orders.remove(aOrder);
//       wasRemoved = true;
//     }
//     return wasRemoved;
//   }
//   /* Code from template association_AddIndexControlFunctions */
//   public boolean addOrderAt(Order aOrder, int index)
//   {  
//     boolean wasAdded = false;
//     if(addOrder(aOrder))
//     {
//       if(index < 0 ) { index = 0; }
//       if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
//       orders.remove(aOrder);
//       orders.add(index, aOrder);
//       wasAdded = true;
//     }
//     return wasAdded;
//   }

//   public boolean addOrMoveOrderAt(Order aOrder, int index)
//   {
//     boolean wasAdded = false;
//     if(orders.contains(aOrder))
//     {
//       if(index < 0 ) { index = 0; }
//       if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
//       orders.remove(aOrder);
//       orders.add(index, aOrder);
//       wasAdded = true;
//     } 
//     else 
//     {
//       wasAdded = addOrderAt(aOrder, index);
//     }
//     return wasAdded;
//   }

//   public void delete()
//   {
//     for(int i=stores.size(); i > 0; i--)
//     {
//       Store aStore = stores.get(i - 1);
//       aStore.delete();
//     }
//     FeedbackManager existingFeedbackManager = feedbackManager;
//     feedbackManager = null;
//     if (existingFeedbackManager != null)
//     {
//       existingFeedbackManager.delete();
//     }
//     for(int i=orders.size(); i > 0; i--)
//     {
//       Order aOrder = orders.get(i - 1);
//       aOrder.delete();
//     }
//   }

//   // line 47 "model.ump"
//    private void sendOrder(){
    
//   }

//   // line 50 "model.ump"
//    private void processOrder(){
    
//   }

//   // line 53 "model.ump"
//    private void askForFeedback(){
    
//   }

// }
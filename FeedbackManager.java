// /*PLEASE DO NOT EDIT THIS CODE*/
// /*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/



// // line 57 "model.ump"
// // line 163 "model.ump"
// public class FeedbackManager
// {

//   //------------------------
//   // MEMBER VARIABLES
//   //------------------------

//   //FeedbackManager Attributes
//   private String feedback;

//   //FeedbackManager Associations
//   private OrderManager orderManager;

//   //------------------------
//   // CONSTRUCTOR
//   //------------------------

//   public FeedbackManager(String aFeedback, OrderManager aOrderManager)
//   {
//     feedback = aFeedback;
//     if (aOrderManager == null || aOrderManager.getFeedbackManager() != null)
//     {
//       throw new RuntimeException("Unable to create FeedbackManager due to aOrderManager. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
//     }
//     orderManager = aOrderManager;
//   }

//   public FeedbackManager(String aFeedback)
//   {
//     feedback = aFeedback;
//     orderManager = new OrderManager(this);
//   }

//   //------------------------
//   // INTERFACE
//   //------------------------

//   public boolean setFeedback(String aFeedback)
//   {
//     boolean wasSet = false;
//     feedback = aFeedback;
//     wasSet = true;
//     return wasSet;
//   }

//   public String getFeedback()
//   {
//     return feedback;
//   }
//   /* Code from template association_GetOne */
//   public OrderManager getOrderManager()
//   {
//     return orderManager;
//   }

//   public void delete()
//   {
//     OrderManager existingOrderManager = orderManager;
//     orderManager = null;
//     if (existingOrderManager != null)
//     {
//       existingOrderManager.delete();
//     }
//   }

//   // line 62 "model.ump"
//    private void storeFeedback(){
    
//   }


//   public String toString()
//   {
//     return super.toString() + "["+
//             "feedback" + ":" + getFeedback()+ "]" + System.getProperties().getProperty("line.separator") +
//             "  " + "orderManager = "+(getOrderManager()!=null?Integer.toHexString(System.identityHashCode(getOrderManager())):"null");
//   }
// }
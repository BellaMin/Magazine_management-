package ict373assignmentone;

import java.util.*;

public class MESSAGEREPLY 
{
     private MAGAZINE []magazine; //to store magazine array from MAGAZINE CLASS   
     private int sizeOFmagazine;//number of magazine already stored in array 
     private ArrayList<Customer> customerCopy;//to store customer arraylist from Customer 
     private ArrayList<SUPPLEMENT> supplementCopy;//to store supplement array for each customer 
     
     //default constructor 
     public MESSAGEREPLY()
     {
         //do nothing 
     }
     
     //number of magazine already store in magazine array from MAGAZINE CLASS 
     public void setSizeOFmagazine(int n)
     {
         this.sizeOFmagazine = n;
     }
     
     //a new magazine array to copy the magazine array from MAGAZINE 
     public void setMagazineCopy()
     {
        magazine = new MAGAZINE[100]; 
     }
     
     //to copy magazine from Magazine class into local magazine array 
     public void gettMagazineCopy(MAGAZINE []magazine)
     {
         for(int i=0; i< magazine.length ; i++)
         {
             this.magazine[i] = magazine[i];
         }
    }
     
     //to set a new customer arraylis t
     public void setCustomerCopy()
     {
         customerCopy = new ArrayList<Customer>();
     }
     
     //to copy customer arraylist from customer class
     public void copyCustomerCopy(ArrayList<Customer> c)
     {
         this.customerCopy.addAll(c);
     }
     
     //to reset customer array copie 
     public void clearCustomerCopy()
     {
         this.customerCopy.clear();
     }
     
     //to get a new supplement array 
     public void setSupplemetCopy()
     {
         supplementCopy = new ArrayList<SUPPLEMENT>();
     }
     
     //to copy supplement array for each customer 
     public void copySupplementCopy(ArrayList<SUPPLEMENT> s)
     {
         this.supplementCopy.addAll(s);
     }
     
     //reset supplementCopy array 
     public void clearSupplementCopy()
     {
         this.supplementCopy.clear();
     }
     
     //display monthly emails for each paying  customer 
     public void displayMonthlyMessage()
     {
         String name;
         String id;
         String magazineName;
         String supplement;
         String supplementone;
         String supplementtwo;
         String supplementthree;
         String supplementFour;
         String sponserName;
         String sponserID;
         String totalmessage = "";
         String ms = "Your supplements are \n";
         int total = 0;
         int price = 0;
         totalmessage += ms;
         for(int i = 0; i < customerCopy.size();i++)
         {
             
               if(customerCopy.get(i).getClass() == PAYINGCUSTOMER.class )
                {
                   PAYINGCUSTOMER payingcustomer = (PAYINGCUSTOMER) customerCopy.get(i);
                   name = payingcustomer.getName();
                   id = payingcustomer.getID();
                   copySupplementCopy(payingcustomer.getSupplementList());
                   for(int count = 0; count < supplementCopy.size();count++)
                   {
                      supplement = supplementCopy.get(count).getName();
                       for(int counter = 0; counter < sizeOFmagazine ; counter++)
                       {
                            supplementone = magazine[counter].getSupplementNameOne();
                            supplementtwo = magazine[counter].getSupplementNameTwo();
                            supplementthree = magazine[counter].getSupplementNameThree();
                            supplementFour = magazine[counter].getSupplementNameFour();
                            if(supplement.equalsIgnoreCase(supplementone))
                            {
                                magazineName = magazine[counter].getName();
                                price = magazine[counter].getSupplementCostOne();
                                String m = supplement +" from " + magazineName + " which cost " + price +" $ \n";
                                totalmessage += m;
                                total = total + price;
                            }
                            if(supplement.equalsIgnoreCase(supplementtwo))
                            {
                                magazineName = magazine[counter].getName();
                                price = magazine[counter].getSupplementCostTwo();
                                String m = supplement +" from " + magazineName + " which cost " + price +" $ \n"; 
                                total = total + price;
                                totalmessage += m;
                            }
                            if(supplement.equalsIgnoreCase(supplementthree))
                            {
                                magazineName = magazine[counter].getName();
                                price = magazine[counter].getSupplementCostThree();
                                String m  = supplement +" from " + magazineName + " which cost " + price +" $ \n";
                                totalmessage += m; 
                                total = total + price;
                            }
                            if(supplement.equalsIgnoreCase(supplementFour))
                            {
                                magazineName = magazine[counter].getName();
                                price = magazine[counter].getSupplementCostFour();
                                 String m = supplement +" from " + magazineName + " which cost " + price +" $ \n";
                                 totalmessage += m;
                                 total = total + price;
                            }
                       }
                   }
                 
                   String message = "**************************************************"+"\n"+"Dear "+ name + ",\n" + "Your ID is " + id + "\n" + totalmessage + "\n" +"For this month your total would be" + total+" $ \n"+"Thank you \nRegards\n"+"**************************************************";
                   System.out.println(message);
                   total = 0;
                   clearSupplementCopy();
                   totalmessage = " ";
                   totalmessage += ms;
                }
                
             
         }
     }
     
     //to display four weeks worth texts for each customer 
     public void printFourWeeks()
     {
         System.out.println("-------------------------------------------------------------");
         System.out.println("------------------ FOR THE FIRST WEEK -----------------------");
         printFirst();//for first week
         System.out.println("------------------------------------------------------------- \n");
         System.out.println("-------------------------------------------------------------");
         System.out.println("------------------ FOR THE SECOND WEEK -----------------------");
         printSecond();//for second week 
         System.out.println("------------------------------------------------------------- \n");
         System.out.println("-------------------------------------------------------------");
         System.out.println("------------------ FOR THE THIRD WEEK -----------------------");         
         printThird();//for third week 
         System.out.println("------------------------------------------------------------- \n");
         System.out.println("-------------------------------------------------------------");
         System.out.println("------------------ FOR THE FOURTH WEEK -----------------------"); 
         printFourth();//for fourth week 
         System.out.println("------------------------------------------------------------- \n");
     }
     
     //to display text for first week of the month 
     public void printFirst()
     {
         
         String name;
         String id;
         String magazineName;
         String supplement;
         String supplementone;
         String supplementtwo;
         String supplementthree;
         String supplementFour;
         String sponserName;
         String sponserID;
         String totalmessage = "";
         for(int i = 0; i < customerCopy.size();i++)
         {
             
               if(customerCopy.get(i).getClass() == PAYINGCUSTOMER.class )
                {
                   PAYINGCUSTOMER payingcustomer = (PAYINGCUSTOMER) customerCopy.get(i);
                   name = payingcustomer.getName();
                   id = payingcustomer.getID();
                   copySupplementCopy(payingcustomer.getSupplementList());
                   for(int count = 0; count < supplementCopy.size();count++)
                   {
                      supplement = supplementCopy.get(count).getName();
                       for(int counter = 0; counter < sizeOFmagazine ; counter++)
                       {
                            supplementone = magazine[counter].getSupplementNameOne();
                            supplementtwo = magazine[counter].getSupplementNameTwo();
                            supplementthree = magazine[counter].getSupplementNameThree();
                            supplementFour = magazine[counter].getSupplementNameFour();
                            if(supplement.equalsIgnoreCase(supplementone))
                            {
                                magazineName = magazine[counter].getName();
                                String m = supplement +" from " + magazineName +"\n";
                                totalmessage += m;
                            }
                            if(supplement.equalsIgnoreCase(supplementtwo))
                            {
                                magazineName = magazine[counter].getName();
                                String m = supplement +" from " + magazineName + "\n"; 
                                totalmessage += m;
                            }
                            if(supplement.equalsIgnoreCase(supplementthree))
                            {
                                magazineName = magazine[counter].getName();
                                String m  = supplement +" from " + magazineName + "\n";
                                totalmessage += m; 
                            }
                            if(supplement.equalsIgnoreCase(supplementFour))
                            {
                                magazineName = magazine[counter].getName();
                                 String m = supplement +" from " + magazineName + "\n";
                                 totalmessage += m;
                            }
                       }
                   }
                 
                   String message = "**************************************************"+"\n"+"Dear "+ name + "\n" + "Your ID is " + id + "\n" + totalmessage + "are ready to view for the first week of this month\n" +"Thank you \nRegards\n"+"**************************************************";
                   System.out.println(message);
                   clearSupplementCopy();
                   totalmessage = " ";
                }
                if(customerCopy.get(i).getClass() == ASSOCIATECUSTOMER.class)
                {
                   ASSOCIATECUSTOMER associatecustomer = (ASSOCIATECUSTOMER) customerCopy.get(i);
                   name = associatecustomer.getName();
                   id = associatecustomer.getID();
                   sponserName = associatecustomer.getPayingCustomer();
                   sponserID = associatecustomer.getPayingCustomerID();
                   copySupplementCopy(associatecustomer.getSupplementList());
                   for(int count = 0; count < supplementCopy.size();count++)
                   {
                      supplement = supplementCopy.get(count).getName();
                          for(int counter = 0; counter < sizeOFmagazine ; counter++)
                       {
                            supplementone = magazine[counter].getSupplementNameOne();
                            supplementtwo = magazine[counter].getSupplementNameTwo();
                            supplementthree = magazine[counter].getSupplementNameThree();
                            supplementFour = magazine[counter].getSupplementNameFour();
                            if(supplement.equalsIgnoreCase(supplementone))
                            {
                                magazineName = magazine[counter].getName();
                                String m =  supplement +" from " + magazineName +" \n";
                                totalmessage += m;
                            }
                            if(supplement.equalsIgnoreCase(supplementtwo))
                            {
                                magazineName = magazine[counter].getName();
                                String m =  supplement +" from " + magazineName +" \n"; 
                                totalmessage += m;
                            }
                            if(supplement.equalsIgnoreCase(supplementthree))
                            {
                                magazineName = magazine[counter].getName();
                                String m =  supplement +" from " + magazineName +" \n";
                                totalmessage += m;
                            }
                            if(supplement.equalsIgnoreCase(supplementFour))
                            {
                                magazineName = magazine[counter].getName();
                                String m =  supplement +" from " + magazineName +" \n";
                                totalmessage += m;
                            }
                       }
                   }
                 
                   String message = "**************************************************"+"\n"+"Dear "+ name + "\n" + "Your ID is " + id + " and you are sponser by "+sponserName +" ( " +sponserID+" ) "+ "\n" + totalmessage + "\n" +" are ready to view for the firt week of this month" + "\n"+"Thank you \nRegards\n"+"**************************************************";
                   System.out.println(message);
                   clearSupplementCopy();
                   totalmessage = " ";
                     
                }
             
         }
     }

     //to display text for second week of the month 
     public void printSecond()
     {
                  
         String name;
         String id;
         String magazineName;
         String supplement;
         String supplementone;
         String supplementtwo;
         String supplementthree;
         String supplementFour;
         String sponserName;
         String sponserID;
         String totalmessage = "";

         for(int i = 0; i < customerCopy.size();i++)
         {
             
               if(customerCopy.get(i).getClass() == PAYINGCUSTOMER.class )
                {
                   PAYINGCUSTOMER payingcustomer = (PAYINGCUSTOMER) customerCopy.get(i);
                   name = payingcustomer.getName();
                   id = payingcustomer.getID();
                   copySupplementCopy(payingcustomer.getSupplementList());
                   for(int count = 0; count < supplementCopy.size();count++)
                   {
                      supplement = supplementCopy.get(count).getName();
                       for(int counter = 0; counter < sizeOFmagazine ; counter++)
                       {
                            supplementone = magazine[counter].getSupplementNameOne();
                            supplementtwo = magazine[counter].getSupplementNameTwo();
                            supplementthree = magazine[counter].getSupplementNameThree();
                            supplementFour = magazine[counter].getSupplementNameFour();
                            if(supplement.equalsIgnoreCase(supplementone))
                            {
                                magazineName = magazine[counter].getName();
                                String m = supplement +" from " + magazineName +"\n";
                                totalmessage += m;
                            }
                            if(supplement.equalsIgnoreCase(supplementtwo))
                            {
                                magazineName = magazine[counter].getName();
                                String m =  supplement +" from " + magazineName + "\n"; 
                                totalmessage += m;
                            }
                            if(supplement.equalsIgnoreCase(supplementthree))
                            {
                                magazineName = magazine[counter].getName();
                                String m  = supplement +" from " + magazineName + "\n";
                                totalmessage += m; 
                            }
                            if(supplement.equalsIgnoreCase(supplementFour))
                            {
                                magazineName = magazine[counter].getName();
                                 String m =  supplement +" from " + magazineName + "\n";
                                 totalmessage += m;
                            }
                       }
                   }
                 
                   String message = "**************************************************"+"\n"+"Dear "+ name + "\n" + "Your ID is " + id + "\n" + totalmessage + "are ready to view for the second week of this month\n" +"Thank you \nRegards\n"+"**************************************************";
                   System.out.println(message);
                   clearSupplementCopy();
                   totalmessage = " ";
                }
                if(customerCopy.get(i).getClass() == ASSOCIATECUSTOMER.class)
                {
                   ASSOCIATECUSTOMER associatecustomer = (ASSOCIATECUSTOMER) customerCopy.get(i);
                   name = associatecustomer.getName();
                   id = associatecustomer.getID();
                   sponserName = associatecustomer.getPayingCustomer();
                   sponserID = associatecustomer.getPayingCustomerID();
                   copySupplementCopy(associatecustomer.getSupplementList());
                   for(int count = 0; count < supplementCopy.size();count++)
                   {
                      supplement = supplementCopy.get(count).getName();
                          for(int counter = 0; counter < sizeOFmagazine ; counter++)
                       {
                            supplementone = magazine[counter].getSupplementNameOne();
                            supplementtwo = magazine[counter].getSupplementNameTwo();
                            supplementthree = magazine[counter].getSupplementNameThree();
                            supplementFour = magazine[counter].getSupplementNameFour();
                            if(supplement.equalsIgnoreCase(supplementone))
                            {
                                magazineName = magazine[counter].getName();
                                String m = supplement +" from " + magazineName +" \n";
                                totalmessage += m;
                            }
                            if(supplement.equalsIgnoreCase(supplementtwo))
                            {
                                magazineName = magazine[counter].getName();
                                String m =  supplement +" from " + magazineName +" \n"; 
                                totalmessage += m;
                            }
                            if(supplement.equalsIgnoreCase(supplementthree))
                            {
                                magazineName = magazine[counter].getName();
                                String m =  supplement +" from " + magazineName +" \n";
                                totalmessage += m;
                            }
                            if(supplement.equalsIgnoreCase(supplementFour))
                            {
                                magazineName = magazine[counter].getName();
                                String m =  supplement +" from " + magazineName +" \n";
                                totalmessage += m;
                            }
                       }
                   }
                 
                   String message = "**************************************************"+"\n"+"Dear "+ name + "\n" + "Your ID is " + id + " and you are sponser by "+sponserName +" ( " +sponserID+" ) "+ "\n" + totalmessage + "\n" +" are ready to view for the second week of this month" + "\n"+"Thank you \nRegards\n"+"**************************************************";
                   System.out.println(message);
                   clearSupplementCopy();
                   totalmessage = " ";
                     
                }
             
         }
     }
     
     //to display text for third week of the month 
     public void printThird()
     {
                  
         String name;
         String id;
         String magazineName;
         String supplement;
         String supplementone;
         String supplementtwo;
         String supplementthree;
         String supplementFour;
         String sponserName;
         String sponserID;
         String totalmessage = "";

         for(int i = 0; i < customerCopy.size();i++)
         {
             
               if(customerCopy.get(i).getClass() == PAYINGCUSTOMER.class )
                {
                   PAYINGCUSTOMER payingcustomer = (PAYINGCUSTOMER) customerCopy.get(i);
                   name = payingcustomer.getName();
                   id = payingcustomer.getID();
                   copySupplementCopy(payingcustomer.getSupplementList());
                   for(int count = 0; count < supplementCopy.size();count++)
                   {
                      supplement = supplementCopy.get(count).getName();
                       for(int counter = 0; counter < sizeOFmagazine ; counter++)
                       {
                            supplementone = magazine[counter].getSupplementNameOne();
                            supplementtwo = magazine[counter].getSupplementNameTwo();
                            supplementthree = magazine[counter].getSupplementNameThree();
                            supplementFour = magazine[counter].getSupplementNameFour();
                            if(supplement.equalsIgnoreCase(supplementone))
                            {
                                magazineName = magazine[counter].getName();
                                String m = supplement +" from " + magazineName +"\n";
                                totalmessage += m;
                            }
                            if(supplement.equalsIgnoreCase(supplementtwo))
                            {
                                magazineName = magazine[counter].getName();
                                String m =  supplement +" from " + magazineName + "\n"; 
                                totalmessage += m;
                            }
                            if(supplement.equalsIgnoreCase(supplementthree))
                            {
                                magazineName = magazine[counter].getName();
                                String m  =  supplement +" from " + magazineName + "\n";
                                totalmessage += m; 
                            }
                            if(supplement.equalsIgnoreCase(supplementFour))
                            {
                                magazineName = magazine[counter].getName();
                                 String m =  supplement +" from " + magazineName + "\n";
                                 totalmessage += m;
                            }
                       }
                   }
                 
                   String message = "**************************************************"+"\n"+"Dear "+ name + "\n" + "Your ID is " + id + "\n" + totalmessage + "are ready to view for the third week of this month\n" +"Thank you \nRegards\n"+"**************************************************";
                   System.out.println(message);
                   clearSupplementCopy();
                   totalmessage = " ";
                }
                if(customerCopy.get(i).getClass() == ASSOCIATECUSTOMER.class)
                {
                   ASSOCIATECUSTOMER associatecustomer = (ASSOCIATECUSTOMER) customerCopy.get(i);
                   name = associatecustomer.getName();
                   id = associatecustomer.getID();
                   sponserName = associatecustomer.getPayingCustomer();
                   sponserID = associatecustomer.getPayingCustomerID();
                   copySupplementCopy(associatecustomer.getSupplementList());
                   for(int count = 0; count < supplementCopy.size();count++)
                   {
                      supplement = supplementCopy.get(count).getName();
                          for(int counter = 0; counter < sizeOFmagazine ; counter++)
                       {
                            supplementone = magazine[counter].getSupplementNameOne();
                            supplementtwo = magazine[counter].getSupplementNameTwo();
                            supplementthree = magazine[counter].getSupplementNameThree();
                            supplementFour = magazine[counter].getSupplementNameFour();
                            if(supplement.equalsIgnoreCase(supplementone))
                            {
                                magazineName = magazine[counter].getName();
                                String m =  supplement +" from " + magazineName +" \n";
                                totalmessage += m;
                            }
                            if(supplement.equalsIgnoreCase(supplementtwo))
                            {
                                magazineName = magazine[counter].getName();
                                String m =  supplement +" from " + magazineName +" \n"; 
                                totalmessage += m;
                            }
                            if(supplement.equalsIgnoreCase(supplementthree))
                            {
                                magazineName = magazine[counter].getName();
                                String m = supplement +" from " + magazineName +" \n";
                                totalmessage += m;
                            }
                            if(supplement.equalsIgnoreCase(supplementFour))
                            {
                                magazineName = magazine[counter].getName();
                                String m =  supplement +" from " + magazineName +" \n";
                                totalmessage += m;
                            }
                       }
                   }
                 
                   String message = "**************************************************"+"\n"+"Dear "+ name + "\n" + "Your ID is " + id + " and you are sponser by "+sponserName +" ( " +sponserID+" ) "+ "\n" + totalmessage + "\n" +" are ready to view for the third week of this month" + "\n"+"Thank you \nRegards\n"+"**************************************************";
                   System.out.println(message);
                   clearSupplementCopy();
                   totalmessage = " ";
                     
                }
             
         }
     }
     
     //to display text for fourth week of the month 
     public void printFourth()
     {
                  
         String name;
         String id;
         String magazineName;
         String supplement;
         String supplementone;
         String supplementtwo;
         String supplementthree;
         String supplementFour;
         String sponserName;
         String sponserID;
         String totalmessage = "";

         for(int i = 0; i < customerCopy.size();i++)
         {
             
               if(customerCopy.get(i).getClass() == PAYINGCUSTOMER.class )
                {
                   PAYINGCUSTOMER payingcustomer = (PAYINGCUSTOMER) customerCopy.get(i);
                   name = payingcustomer.getName();
                   id = payingcustomer.getID();
                   copySupplementCopy(payingcustomer.getSupplementList());
                   for(int count = 0; count < supplementCopy.size();count++)
                   {
                      supplement = supplementCopy.get(count).getName();
                       for(int counter = 0; counter < sizeOFmagazine ; counter++)
                       {
                            supplementone = magazine[counter].getSupplementNameOne();
                            supplementtwo = magazine[counter].getSupplementNameTwo();
                            supplementthree = magazine[counter].getSupplementNameThree();
                            supplementFour = magazine[counter].getSupplementNameFour();
                            if(supplement.equalsIgnoreCase(supplementone))
                            {
                                magazineName = magazine[counter].getName();
                                String m = supplement +" from " + magazineName +"\n";
                                totalmessage += m;
                            }
                            if(supplement.equalsIgnoreCase(supplementtwo))
                            {
                                magazineName = magazine[counter].getName();
                                String m =  supplement +" from " + magazineName + "\n"; 
                                totalmessage += m;
                            }
                            if(supplement.equalsIgnoreCase(supplementthree))
                            {
                                magazineName = magazine[counter].getName();
                                String m  =  supplement +" from " + magazineName + "\n";
                                totalmessage += m; 
                            }
                            if(supplement.equalsIgnoreCase(supplementFour))
                            {
                                magazineName = magazine[counter].getName();
                                 String m =  supplement +" from " + magazineName + "\n";
                                 totalmessage += m;
                            }
                       }
                   }
                 
                   String message = "**************************************************"+"\n"+"Dear "+ name + "\n" + "Your ID is " + id + "\n" + totalmessage + "are ready to view for the fourth or last week of  this month\n" +"Thank you \nRegards\n"+"**************************************************";
                   System.out.println(message);
                   clearSupplementCopy();
                   totalmessage = " ";
                }
                if(customerCopy.get(i).getClass() == ASSOCIATECUSTOMER.class)
                {
                   ASSOCIATECUSTOMER associatecustomer = (ASSOCIATECUSTOMER) customerCopy.get(i);
                   name = associatecustomer.getName();
                   id = associatecustomer.getID();
                   sponserName = associatecustomer.getPayingCustomer();
                   sponserID = associatecustomer.getPayingCustomerID();
                   copySupplementCopy(associatecustomer.getSupplementList());
                   for(int count = 0; count < supplementCopy.size();count++)
                   {
                      supplement = supplementCopy.get(count).getName();
                          for(int counter = 0; counter < sizeOFmagazine ; counter++)
                       {
                            supplementone = magazine[counter].getSupplementNameOne();
                            supplementtwo = magazine[counter].getSupplementNameTwo();
                            supplementthree = magazine[counter].getSupplementNameThree();
                            supplementFour = magazine[counter].getSupplementNameFour();
                            if(supplement.equalsIgnoreCase(supplementone))
                            {
                                magazineName = magazine[counter].getName();
                                String m = supplement +" from " + magazineName +" \n";
                                totalmessage += m;
                            }
                            if(supplement.equalsIgnoreCase(supplementtwo))
                            {
                                magazineName = magazine[counter].getName();
                                String m =  supplement +" from " + magazineName +" \n"; 
                                totalmessage += m;
                            }
                            if(supplement.equalsIgnoreCase(supplementthree))
                            {
                                magazineName = magazine[counter].getName();
                                String m = supplement +" from " + magazineName +" \n";
                                totalmessage += m;
                            }
                            if(supplement.equalsIgnoreCase(supplementFour))
                            {
                                magazineName = magazine[counter].getName();
                                String m =  supplement +" from " + magazineName +" \n";
                                totalmessage += m;
                            }
                       }
                   }
                 
                   String message = "**************************************************"+"\n"+"Dear "+ name + "\n" + "Your ID is " + id + " and you are sponser by "+sponserName +" ( " +sponserID+" ) "+ "\n" + totalmessage + "\n" +" are ready to view for the fourth or last week of this month" + "\n"+"Thank you \nRegards\n"+"**************************************************";
                   System.out.println(message);
                   clearSupplementCopy();
                   totalmessage = " ";
                     
                }
             
         }
     }
}

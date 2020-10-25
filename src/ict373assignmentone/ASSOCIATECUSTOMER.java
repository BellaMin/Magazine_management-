package ict373assignmentone;

import java.util.*;

public class ASSOCIATECUSTOMER extends Customer 
{
      //member variables 
       private String payingCustomer;//sponser 
       private String payingCustomerID;//sponser's id 
       private ArrayList<String> PAYCOPY;//copy of all paying customer's ids 
       private Scanner key = new Scanner(System.in);
       
       //default constructor 
       //initiated all member variables 
       public ASSOCIATECUSTOMER()
       {
           payingCustomer = "notavailable";
           payingCustomerID = "notavaliable";
       }
       
       //constructor
       //initiated all member variables with user's inputs
       //constructor for adding a new associated customer into customer array 
       public ASSOCIATECUSTOMER(ArrayList<SUPPLEMENT> supplements,String name,String email,String id,int age,String gender,String payingCustomer,String payingCustomerID)
       {
          setNewsupplement();
          addAllSupplementList(supplements);
          setName(name);
          setEmail(email);
          setGender(gender);
          setAge(age);
          setID(id);
          this.payingCustomer = payingCustomer;
          this.payingCustomerID = payingCustomerID;
       }
       
       //set method for ASSOCIATECUSTOMER CLASS 
       
       //to set sponser's name (payingCustomer)
       public void setPayingCustomer(String payingCustomer)
       {
          this.payingCustomer = payingCustomer;           
       }
       
       //to set sponser's id (payingCustomerID)
       public void setPayingCustomerID(String payingCustomerID)
       {
          this.payingCustomerID = payingCustomerID;          
       }
       
       //to copy pay arraylist from payingcustomer into PAYCOPY arraylist
        public void setPayCopy(ArrayList<String> pay)
       {
           PAYCOPY = new ArrayList<String>();// declare a new arraylist
           PAYCOPY.addAll(pay);//to copy arraylist 
       }
       
       //get method for ASSOCIATECUSTOMER CLASS 
       
       //to get sponser's name (payingCustomer)
       public String getPayingCustomer()
       {
           return payingCustomer;
       }
       
       //tp get sponser's id (payingCustomeID)
       public String getPayingCustomerID()
       {
           return payingCustomerID;
       }
       
       //to get paycopy arraylist 
       public ArrayList<String> getPayCopy()
       {
           return PAYCOPY;
       }
       
       //to confirm sponser's id is valid and already existed in the system 
       public Boolean confirmPayCustomer(String id)
       {
           if(this.PAYCOPY.contains(id) == true )//if already existed 
           {
               return true;
           }
           else //if not 
           {
               return false;
           }
       }
       
       //to clear everything from PAYCOPY //reset PAYCOPY 
       public void clearPay()
       {
           PAYCOPY.clear();
       }
       
       //prompt for ASSOCIATECUSTOMER 
       
       //prompt for sponser's name and id 
       public void promptForPayCustomer()
       {
           String sponser;//name of sponser
           String sponserid;//id of sponser
           Boolean exist;//exist or not 

               System.out.println("Please Enter your sponser's name");
               sponser = key.nextLine();
               System.out.println("Please Enter your sponser's ID");
               sponserid = key.nextLine();
               exist = confirmPayCustomer(sponserid);//to confirm sponser's id existed in the system and valid
               while(exist == false)//if not 
               {
                   if(PAYCOPY.size() < 1)
                    {
                       System.out.println("No associate customer allowed in the moment");//alert user 
                    }
                  System.out.println("INVALID   Please Enter your sponser's ID");//alert user 
                  sponserid = key.nextLine();//ask again 
                  exist = confirmPayCustomer(sponserid);//check again to confirm               
               }
               setPayingCustomer(sponser);//to set payingCustomer 
               setPayingCustomerID(sponserid);//to set payingCustomerID
           
       }       


}

package ict373assignmentone;
import java.util.*;


public class PAYINGCUSTOMER extends Customer 
{
    //variables 
    private String payingmethod;//payment method for subscripton 
    private Scanner keyboard = new Scanner(System.in);
    private ArrayList<String> PAY ;//an arraylist of paying customers' names 
    
    //default constructor 
    //initiated all member variables 
    public PAYINGCUSTOMER()
    {
          setName("MrorMissExample");
          setEmail("example@gmail.com");
          setID("0000000");
          payingmethod = "unavailable";
    }
    
    //constructor 
    //initiated member variables with user's input 
    //constructor is used for add paying customer into customer array 
    public PAYINGCUSTOMER(ArrayList<SUPPLEMENT> supplements, String name, String email, String id, int age, String gender, String payingmethod)
    {
          setNewsupplement();
          addAllSupplementList(supplements);
          setName(name);
          setEmail(email);
          setID(id);
          setAge(age);
          setGender(gender);
          this.payingmethod = payingmethod;
    }
    
    //constructor 
    //initiated member variables with user's input 
    //constructor is used for adding paying customers' id
    public PAYINGCUSTOMER(String name,String id)
    {
        setName(name);
        setID(id);
    }
    
    //set method for PAYINGCUSTOMER class 

    //to set payment method 
    public void setPaymentMethod(String payingmethod)
    {
        this.payingmethod = payingmethod;
    }
    
    //to set a new  pay arraylist 
     public void setPayArray()
    {
        PAY = new ArrayList<String>();
    }
    
     //get method for PAYINGCUSTOMER Class 
     
    //to get payment method 
    public String getPaymentMethod()
    {
        return payingmethod;
    }
    
    //to get pay arraylist (id of all paying customers)
    public ArrayList<String> getPayArray()
    {
        return PAY;
    }
    
    //to remove id of a paying customer 
    public void removePayID(String id)
    {
        String IDs;
        Boolean removed = false;
        id = id.replaceAll("\\s", ""); 
        for(int i = 0; i< PAY.size() ;i++)
        {
            IDs = PAY.get(i);//id from arraylist 
            IDs = IDs.replaceAll("\\s", ""); 
            if(id.equalsIgnoreCase(IDs))//if matched with id of paying customer who is soon to be removed 
            {
                PAY.remove(i);//remove id 
                removed = true;//already removed 
            }
        }
        
        if(removed == true)//already removed 
        {
          System.out.println("Customer ID"+ id + "remove from ID storage");//notify user 
        }
        else //if it can not removed //id is not in the system 
        {
           System.out.println("Customer ID"+ id + " is not stored in ID storage");//notify user 
        }
    }
    
    //to print all id 
    public void printID()
    {
        for(int i=0; i< PAY.size();i++)
        {
            System.out.println("ID - " +PAY.get(i));
        }
    }
    
    //to add id of paying customer 
    public void addPay(String id)
    {
        PAY.add(id);//id is add into array of paying customers' ids 
    }
    
    //to prompt for payment method
    public void promptForPaymentMethod()
    {
        String method;//payment method 
        String bank;//name of bank 
        System.out.println("Please Enter payment method");
        method = keyboard.nextLine();
        String m = method.replaceAll("\\s", ""); 
        while(!m.equalsIgnoreCase("debit") && !m.equalsIgnoreCase("creditcard"))//only allow credit card or debit 
        {
           System.out.println("Please Enter payment method");
           method = keyboard.nextLine(); 
           m = method.replaceAll("\\s", ""); 
        }
        if(m.equalsIgnoreCase("debit"))//if it is debit user need to enter the name of the bank 
        {
            System.out.println("Please Enter customer's bank");
            bank = keyboard.nextLine();
            bank = bank.replaceAll("\\s", ""); 
            while(!bank.equalsIgnoreCase("DBS") && !bank.equalsIgnoreCase("OCBC") && !bank.equalsIgnoreCase("POSB"))//the system only allowed these specified banks 
            {
                System.out.println("Only BANKS SUCH AS DBS, OCBC AND POSB are accepted in this payment ");
                bank = keyboard.nextLine();
                bank = bank.replaceAll("\\s", ""); 
            }
            method = method + " from " + bank;//paymethod in final 
        }
        setPaymentMethod(method);//set payment 
    }


    
}

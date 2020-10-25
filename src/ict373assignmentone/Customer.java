package ict373assignmentone;
import java.util.*;

public class Customer 
{
     //private member variables of customer class 
      private String name;//customer's name
      private String email;//customer's email
      private String id;//customer's id
      private int age;//customer's age 
      private String gender;//customer's gender 
      private ArrayList<String> ID;//to store all customers' id in the system 
      private ArrayList<SUPPLEMENT> supplements;//to store supplement of user's choices of supplement  for each user 
      private ArrayList<Customer> customer;//to store customer and other information (both associative and paying customer)
      private Scanner keyboard = new Scanner(System.in);
      
      //default constructor 
      //initiated all member variables 
      public Customer()
      {
          ID  = new ArrayList<String>();
          name = "MrorMissExample";
          email = "example@gmail.com";
          id = "0000000";
      }
      
      //constructor 
      //initiated all member variables with user's inputs 
      public Customer(ArrayList<SUPPLEMENT> supplements,String name,String email,String id,int age,String gender)
      {
          this.supplements = new ArrayList<SUPPLEMENT>();
          this.ID = new ArrayList<String>();
          this.supplements.addAll(supplements);
          this.name = name;
          this.email = email;
          this.gender = gender;
          this.age = age;
          this.id = id;
      }
      
     //set method for customer class 
      
      //to set name of customer 
      public void setName(String name)
      {
          this.name = name;
      }
      
      //to set email of customer 
      public void setEmail(String email)
      {
          this.email = email;
      }
      
      //to set id of customer 
      public void setID(String id)
      {
          this.id = id;
      }
      
      //to set a new customer arrayList
      public void setCustomer()
      {
          this.customer  = new ArrayList<Customer>();
      }
      
      //to set a new id arraylist 
      public void setIDARRAY(String id)
      {
          this.ID.add(id);
      }
      
      //to set age of customer 
      public void setAge(int age)
      {
          this.age = age;
      }
      
      //to set gender of customer 
      public void setGender(String gender)
      {
          this.gender = gender;
      }
      
       //to set a new supplement arraylist 
       public void setNewsupplement()
       {
           this.supplements = new ArrayList<SUPPLEMENT>();
       }
      
      //to set the list of supplements of each customer 
      public void setSupplementList(ArrayList<SUPPLEMENT> supplements)
      {
          this.supplements = supplements;
      }
      
      //get method for customer class 
      
      //to get name of customer 
      public String getName()
      {
          return name;
      }
      
       //to get customer arraylist's size (number of customer)
       public int getCustomerSize()
      {
          return this.customer.size();
      }
      
       //to get email of customer 
      public String getEmail()
      {
          return email;
      }
      
      //to get id of customer 
      public String getID()
      {
          return id;
      }
      
      //to get arrays of all customers' id 
      public ArrayList<String> getIDArray()
      {
          return this.ID;
      }
      
      //to get age of customer 
      public int getAge()
      {
          return age;
      }
      
      //to get gender of customer 
      public String getGender()
      {
          return this.gender;
      }
      
      //to get the list of supplement (supplement arraylist) of each customer 
       public ArrayList<SUPPLEMENT> getSupplementList() 
      {
            return supplements;
      }
      
       //to get customer arraylist 
      public ArrayList<Customer> getCustomer() 
      {
            return customer;
      }
       
      //functions for arraylists in Customer class 
      
       //to delete supplements in supplement arraylist 
       public void clearSupplementList()
       {
            supplements.clear();//to clear everything in supplements 
       }
       
       //to copy all supplements 
       public void addAllSupplementList(ArrayList<SUPPLEMENT> supplements)
       {
           this.supplements.addAll(supplements);
       }
       
       //to print all supplements 
       public void printSupplements(ArrayList<SUPPLEMENT> supplements)
       {
              for(SUPPLEMENT str: supplements)//to print all supplements 
              {
                 System.out.println("Supplement's name  -   " +str.getName());//to print name of supplement 
                 //System.out.println(str.getWeeklyCost());//to print cost of supplements 
              }
         
       }

       //prompt for Customer class 
       
       //prompt for customer name
        public void promptForCustomerName()
        {
            String firstname;//given name of customer
            String surname;//surname of customer 
            String name;//given name + surname 
            System.out.println("Please Enter customer's firstname");
            firstname = keyboard.nextLine();
            while(firstname.length() < 1)//given name can not be null or empty 
            {
               System.out.println("INVALID\n\nPlease Enter customer's firstname again");//notify user 
               firstname = keyboard.nextLine();//ask again    
            }
            System.out.println("Please Enter customer's surname ");
            surname = keyboard.nextLine();
            while(surname.length() < 1)//surname can not be nulled or empty 
            {
                    System.out.println("INVALID\n\nPlease Enter customer's surname again");//notify user 
                    surname = keyboard.nextLine();//ask again           
            }
            name = firstname + " " + surname;//name of customer 
            setName(name);//set name 
        }
        
        //prompt for email of customer 
        public void promptForEmail()
        {
            String email;//email of customer 
            String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";//to validate 
            System.out.println("Please Enter customer's email");
            email = keyboard.nextLine();
            while(!email.matches(regex))//validate email 
            {
               System.out.println("INVALID\n\nPlease Enter customer's email again");//if email isn't validate //notify user 
               email = keyboard.nextLine();//ask again             
            }
            setEmail(email);//set email 
        }
        
        //prompt for id of customer 
        public void promptForID()
        {
            String id;//id of customer 
            String regex = "[a-zA-Z0-9]*";//to validate id of customer //no special characters are allowed 
            Boolean exist = false;
            System.out.println("Please Enter ID(Minimum 7 and maximum 14 characters or number or both)");
            id= keyboard.nextLine();
            String idd = id.replaceAll("\\s", ""); 
            if(ID.size() > 0)//if id isn't the first id 
            {
              exist = confirmationOfID(idd);//to check if id already existed in the system or not // id can not be repeated in the systme 
            }
            while(idd.length() < 7 || idd.length() > 14 || !idd.matches(regex) || exist == true  )//id can not be more than 14 or less than 7 //id can not contain any special character
            {
                    System.out.println("INVALID OR Already existed \n\nPlease Enter ID again");//notify user 
                    id= keyboard.nextLine();//ask again 
                    idd = id.replaceAll("\\s", ""); 
                    exist = confirmationOfID(idd);//check again 
                
            }
            if(exist == false)//if id is not repeated 
            {
               addID(idd); //add id into array of all customers' id 
            }
            setID(id);//set id 
        }
        
        //prompt for gender of customer 
        public void promptForGender()
        {
            String g;//gender of customer 
            System.out.println("Please Enter customer's gender");
            g = keyboard.nextLine();
            String gg = g.replaceAll("\\s", ""); 
            while(!gg.equalsIgnoreCase("female") && !gg.equalsIgnoreCase("male"))//only allow female or male 
            {
                System.out.println("INVALID\n\nPlease Enter customer's gender");//notify user 
                g = keyboard.nextLine(); //ask again   
                gg = g.replaceAll("\\s", ""); 
            }
            setGender(g);//set gender 
        }
        
        //prompt for age of customer 
        public void promptForage()
        {
            String age;//age as string 
            int a = 0;//age as int 
            System.out.println("Please Enter customer's age");
            age = keyboard.nextLine();
            Boolean isNumber = age.matches("-?\\d+(\\.\\d+)?") ;
            if(isNumber == true)
            {
              a = Integer.parseInt(age);//convert string to int
            }
            while(a < 18 || a < 1 || a > 100 || isNumber == false)//customer must be at least 18 // age can not be more than 100 //age can not be negative
            {
                if(isNumber == false)
                {
                    System.out.println("INVALID :: Age need to be digit");
                }
                else if(a < 18)
                {
                    System.out.println("Customer need to be at least 18 years old");//notify user 
                }
                else if(a < 1 || a > 100 )
                {
                    System.out.println("INVALID : Age can be less than 0 or more than 100");//notify user 
                }
                 System.out.println("Please Enter customer's age again");
                 age = keyboard.nextLine();//ask again 
                 isNumber = age.matches("-?\\d+(\\.\\d+)?") ;
                 if(isNumber == true)
                 {
                   a = Integer.parseInt(age);//convert again 
                 }
            }
           setAge(a);//to set age 
        }
        
        //to add a customer who is paying for subscripitons 
        public void addPayingCustomer(ArrayList<SUPPLEMENT> supplements,String name,String email,String id,int age,String gender,String payingmethod)
        {
            customer.add(new PAYINGCUSTOMER(supplements,name,email,id,age,gender,payingmethod));//to add a customer(paying) into customer array//one at each time  
        }
        
         //to add customer who won't be paying for subscriptions 
         public void addAssociateCustomer(ArrayList<SUPPLEMENT> supplements,String name,String email,String id,int age,String gender,String payingCustomer,String payingCustomerID)
        {
            customer.add(new ASSOCIATECUSTOMER(supplements,name,email,id,age,gender,payingCustomer,payingCustomerID));//to add a customer(associative) into customer array//one at each time  
        }
        //need to do for associate customer and for paying customer need to add age and ..
        public void printCustomer()
        {
             for(Customer str: customer)//to loop through customer array 
           {          
               if(str.getClass() == PAYINGCUSTOMER.class)//to check if customer is associative or paying //if customer is paying 
               {
                   //display customer's info 
                   PAYINGCUSTOMER payingcustomer = (PAYINGCUSTOMER) str;
                   System.out.println("Name       -     " + payingcustomer.getName());
                   System.out.println("Email is   -     " + payingcustomer.getEmail());
                   System.out.println("ID is      -     "+ payingcustomer.getID());
                   System.out.println("Age is     -     "+ payingcustomer.getAge());
                   System.out.println("Gender is   -     "+ payingcustomer.getGender());
                   payingcustomer.printSupplements(payingcustomer.getSupplementList());
                   System.out.println("Payment    -     " + payingcustomer.getPaymentMethod());
               }
               else if(str.getClass() == ASSOCIATECUSTOMER.class)//to check if customer is associative or paying //if customer is associative 
               {
                   //display customer's info 
                   ASSOCIATECUSTOMER associatecustomer = (ASSOCIATECUSTOMER) str;
                   System.out.println("Name           -     " + associatecustomer.getName());
                   System.out.println("Email is       -     " + associatecustomer.getEmail());
                   System.out.println("ID is          -     "+ associatecustomer.getID());
                   System.out.println("AGE is         -     "+ associatecustomer.getAge());
                   System.out.println("GENDER is      -     "+ associatecustomer.getGender());
                   System.out.println("Sponser's name -     "+ associatecustomer.getPayingCustomer());
                   System.out.println("Sponser's ID   -     "+ associatecustomer.getPayingCustomerID());
                   associatecustomer.printSupplements(associatecustomer.getSupplementList());                
               }
               else //if customer is neither both //something is wrong //it can not be 
               {
                   System.out.println("Error : Something went wrong");
               }
           }
        }
        
        //to remove customer from the system 
        public void removeCustomer(String id)
        {
            String IDs;//id from customer arraylist 
            String name;//name of customer to be removed 
            String idd;//id of customer to be removed 
            Boolean removed = false;//removed or not 
            int deleted = 0;
            id = id.replaceAll("\\s", ""); 
            for(int i = 0 ; i < customer.size(); i++)//to loop through customer array 
            {
                if(customer.get(i).getClass() == PAYINGCUSTOMER.class )//if customer is paying 
                {
                    PAYINGCUSTOMER payingCustomer = (PAYINGCUSTOMER) customer.get(i);
                    IDs = payingCustomer.getID();//id from customer arraylist 
                    IDs = IDs.replaceAll("\\s", ""); 
                    
                  if(id.equalsIgnoreCase(IDs))//if id of customer soon to be removed is matched with id from arraylist 
                   {
                       customer.remove(i);//remove the customer
                       removed = true;//already removed 
                       deleted = deleted + 1;
                       if(deleted == customer.size())
                       {
                           break;
                       }
                   }
                }
                if(customer.get(i).getClass() == ASSOCIATECUSTOMER.class)//if customer is associative 
                {
                    ASSOCIATECUSTOMER associatecustomer = (ASSOCIATECUSTOMER) customer.get(i);
                    IDs = associatecustomer.getPayingCustomerID();//sponser's id 
                    IDs = IDs.replaceAll("\\s", ""); 
                    name = associatecustomer.getName();//associative customer's name 
                    idd = associatecustomer.getID();//id of associative customer 
                    idd= idd.replaceAll("\\s", ""); 
                    if(id.equalsIgnoreCase(IDs))//if sponser's id is match with customer's id soon to be removed 
                   {
                       customer.remove(i);//to remove associative customer from the system 
                       removed = true;//removed is confirm 
                       deleted = deleted + 1;
                       System.out.println("Customer id "+ idd +"with customer name" + name + " is also removed because Customer id" + id + "is sponsering Customer id" + idd );//notify user
                        if(deleted == customer.size())
                       {
                           break;
                       }
                   }
                }

            }
            
            if(removed == true)//if customer is already removed 
            {
                System.out.println("Customer " + id + " is removed from the system ");//notify user 
            }
            else //if it cannot delecte customer, customer has not existed in the system yet 
            {
                System.out.println("Customer " + id + " is not included in the system");//notify user 
            }
        }
        
        //to check id is already existed in the system 
        public Boolean confirmationOfID(String id)
       {
           return this.ID.contains(id);//return true if id is already existed 
       }
       
        //to add id into id arraylist 
        public void addID(String id)
        {
            this.ID.add(id);//to add id 
        }
        

}


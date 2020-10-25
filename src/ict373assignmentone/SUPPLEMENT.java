package ict373assignmentone;
import java.util.*;
public class SUPPLEMENT 
{
    //private member variables of Supplement class 
    private String name;// name of supplement class
    private int weeklyCost = 0;//weekly cost of the supplment 
    private SUPPLEMENT [] supplement;//array of supplements 
    private ArrayList<String> supplementcopy = new ArrayList<String>();
    private int count = 0;//index of supplement array 
    private Scanner key = new Scanner(System.in);
    
    //default constructor 
    //initiated all member variables 
    public SUPPLEMENT()
    {
        this.name = "unavailable";
        this.weeklyCost = 0;
        this.count = 0;
        supplement = new SUPPLEMENT[100];
    }
    
    //constructor with values from user 
    //initiated all member variables with input user entered
    //constructor for supplement array 
    public SUPPLEMENT(String name,int weeklyCost)
    {
        this.name = name;
        this.weeklyCost = weeklyCost;
        this.supplement = new SUPPLEMENT[100];
        this.count = 0;
    }
    
    //constructor or supplementcopy ArrayList
    //initiated name 
    public SUPPLEMENT(String name)
    {
        this.name = name;
    }
    
    //set method for Supplement class 
    
    //to set supplement's name 
    public void setName(String name)
    {
        this.name = name;
    }
    
    //to set count
    public void setCount(int count)
    {
        this.count = count;
    }
    
    //to set weekly cost of supplement 
    public void setWeeklyCost(int cost)
    {
        this.weeklyCost = cost;
    }
    
    //to set both name and cost 
    public void setAllSupplement(String name,int cost)
    {
           
           String n;//to store supplement name from array when white spaces are removed from it 
           this.name = name;//setting supplement name
           weeklyCost = cost;//setting cost 
           String arrayName;//to store supplement name from array before white spaces are removed from it 
           boolean exist = false;//return true if name that user entered is already existed in supplement array 
           //to check if array is empty or not 
           //if array is empty no need to check for matches 
           //name and cost will be added to array actomatically 
           if(count == 0)
           {
               supplement[count] = new SUPPLEMENT();// an new object 
               supplement[count].setName(name);//to add name into the array 
               supplement[count].setWeeklyCost(weeklyCost);// to add weekly cost into the array 
               count = count + 1;//increase index number for next input  
               //System.out.println("INSERTED");//to show inserted 
           }
           else //if the arrray is not empty , checking for matches are required 
           {
            //to loop through supplement array to find any matched with input 
           for(int counter = 0;counter < count;counter++)
           {
               //to get name from supplement array 
               arrayName = supplement[counter].getName();
               //to remove white spaces from name from supplement array 
               arrayName = arrayName.replaceAll("\\s", ""); 
               //to remove white spaces from name 
               n = name.replace("\\s", "");
               //to check if name user enter is equal to any names from the supplement array regardless of space and letter case 
               if(n.equalsIgnoreCase(arrayName))
               {
                   //if name matches with name from supplement array 
                   exist = true;
                   //then the for loop will be broken 
                   break;
               }
           }
           //if name hasn't been existed in supplement array yet 
           if(exist == false)
           {
               //add it to the array 
               supplement[count] = new SUPPLEMENT();
               supplement[count].setName(name);//to add name into the array 
               supplement[count].setWeeklyCost(weeklyCost);//to add cost into the array 
               count = count + 1;//increase index number for next input 
               //System.out.println("Inserted again!!!");//to show it is inserted 
           }
               
           }
    }
    
    //to set supplement's name as a new arraylist 
     public void setSupplementCopy()
    {
        this.supplementcopy = new ArrayList<String>();
    }
    
    //get methods for Supplement class 
    
    //to get supplement's name
    public String getName()
    {
        return name;
    }
    
    //to get supplement's weekly cost 
    public int getWeeklyCost()
    {
        return weeklyCost;
    }
    
    //to get supplement array
    public SUPPLEMENT [] getArray()
    {
        return supplement;
    }
    
    //to get count
    public int getCount()
    {
        return count;
    }

    //to get number of supplements in supplement array
    public int getSize()
    {
        return this.supplement.length;
    }
    
    //prompt for supplement class
    
    //prompt for name of supplement 
    public void promptForName()
    {
        String sname;//to store supplement's name user entered   
        System.out.println("Please Enter the name of supplement");//prompt for supplement's name 
        sname = key.nextLine();//to get supplement's name 
        Boolean existed = validate(sname);//to check wether the name already existed in the system or not 
        while(sname.length() < 1 || existed == true)//name can not be nulled or can not be repeated 
        {
            if(sname.length()< 1)
            {
                System.out.println("Name can not be nulled");
            }
            if(existed == true)
            {
               System.out.println("Invalid");
            }
            System.out.println("Please Enter the name of supplement");//notify user 
            sname = key.nextLine(); //ask again 
            existed = validate(sname);//check again 
        }
        setName(sname);//to set name 
    }
    

    //prompt for weekly cost of supplement 
    public void promptForCost()
    {
          String cost;//to store cost of supplement as a string 
          int co = 0;//to store cost of supplement as an int 
          System.out.println("Please Enter the cost of supplement");//prompt for cost of supplement 
          cost = key.nextLine();//to get cost 
          Boolean isNumber = cost.matches("-?\\d+(\\.\\d+)?") ;
          if(isNumber == true)
          {
           co = Integer.parseInt(cost);//to convert cost of supplement from string into int 
          }
          while(co < 1 || isNumber == false)//cost can not be negative 
          {
              System.out.println("Invalid Entry\nPlease Enter the cost of supplement");//notify user 
              cost = key.nextLine();//ask again 
              isNumber = cost.matches("-?\\d+(\\.\\d+)?") ;
              if(isNumber == true)
              {
              co = Integer.parseInt(cost);//convert again to checking 
              }
          }
          setWeeklyCost(co);//to set weekly cost of supplement 
    }
    
    //prompt for name of supplement customer 
    //this prompt function is specified for customer's supplement choices 
    //it make sure user can not chose already selected supplements 
    //it also make sure user can not chose more  quantities than the system already contained 
    public void promptOfNameForCustomer()
    {
        String name;//to store supplement name user entered
        Boolean exist;//to check if name user entered is existed in the system 
        Boolean repeated;//to check if user chosing already selected supplement 
        System.out.println("Please Enter customer's choice of supplement's name ");//prompt for name 
        name = key.nextLine();//to get supplement name 
        exist = nameValidatation(name);//to check if name user entered is existed in the system //name must existed in the system  
        repeated = nameRepeated(name);//to check if user chosing already selected supplement  // name can not be repeated 
        while( name.length() < 1 || exist == false || repeated == true)// can not nulled or empty , name must be existed in the system, names can not be repeated
        {
             System.out.println("INVALID OR UNAVIALIBLE\nPlease Enter customer's choice of supplement's name ");//notify user 
              name = key.nextLine();//ask again 
              exist = nameValidatation(name);//check again 
              repeated = nameRepeated(name);//check again 
        }
        if(repeated == false)//if user didn't chose already selected supplement 
        {
            addName(name);//add name into user's choosing supplement arraylist (supplementCopy arraylist)
        }
         setName(name);//to set name 
    }
    
    //to display supplement class values 
    
    //to print supplement's values
    public void printSupplement()
    {
        //to print every supplement inserted in the supplement aray 
        for(int counter = 0; counter < count;counter++)
        {
            //to display data from each supplment 
            supplement[counter].showData();
        }
    }
   
    //to print data from supplement array 
    public void showData()
    {
        //to display name of each supplement 
        System.out.println(getName());
        //to display weekly cost of each supplement 
        System.out.println(getWeeklyCost());
    }
    
    //validation for Supplement class 
    
    //to validate name of supplement 
    //supplement name must already existed in the system(supplement array)
    //names are added into supplement array when user enter new magazines
     public Boolean validate(String name)
    {
        Boolean existed = false;//to check if the name of supplement is already existed in the system 
        name = name.replaceAll("\\s", ""); 
        for(int counter = 0; counter < count ; counter++)//to check matches through supplement array 
        {
            String nam  = supplement[counter].getName();//to get names from supplement array 
            nam = nam.replaceAll("\\s", ""); 
            if(name.equalsIgnoreCase(nam))//if names are matches 
            {
                existed = true;//true 
                break;//break the for loop 
            }
        }
        return existed;//return answer 
    }
    
     //to check names are repeated in supplementCopy arraylist 
     //to prevent user from adding same supplements 
     //names are added into arraylist when user enter their choices of supplements 
    public Boolean nameRepeated(String name)
    {
        return this.supplementcopy.contains(name);//if already contained which mean repeated // true will be returned 
    }
    
    //to validate name of supplement 
    //supplement name must already existed in the system(supplement array)
    //names are added into supplement array when user enter new magazines
    //this function will be used when user enter their choices of supplement 
     public Boolean nameValidatation(String name)
    {
        String n;//to store names from array 
        Boolean exist = false;//exist or not 
        name = name.replaceAll("\\s", ""); 
        for(int i= 0; i< getCount(); i++)//to loop through the array 
        {
            n = supplement[i].getName();//name from array 
            n = n.replaceAll("\\s", ""); 
            if(name.equalsIgnoreCase(n))//if names are matched 
            {
                exist = true;//return true 
                break;//break the loop 
            }
        }
        return exist;//return answer 
    }
    
   //for arraylists in supplement class 
     
   //to clear supplements' name arrylist values 
     public void clearSupplementCopy()
    {
        this.supplementcopy.clear();//remove everything from supplementCopy array 
    }
    
    //to add a new name into supplements' name arraylist
    public void addName(String name)
    {
        this.supplementcopy.add(name);//to add name into array 
    }
     
}


package ict373assignmentone;
import java.util.*;
public class MAGAZINE 
{
    
   //private member variables of Magazine class 
    private String name;// name of magazine 
    private String catalog;//magazine's catalog 
    private String description;//magazine's description 
    private String advertiserName;//name of advertiser in the magazine 
    private String supplementNameone;//name of first supplement in the magazine 
    private String supplementNametwo;//name of second supplement in the magazine 
    private String supplementNamethree;// name of third supplement in the magazine 
    private String supplementNamefour;//name of fourth supplement in the magazine
    private int numberOfSupplement = 0;//number of supplement in this magazine //minimum is three and maximum is four 
    private int weeklyCostone = 0;//weekly cost of first supplement in this magazine 
    private int weeklyCosttwo = 0;//weekly cost of second supplement in this magazine 
    private int weeklyCostthree = 0;//weekly cost of third supplement in this magazine 
    private int weeklyCostfour = 0;//weekly cost of fourth supplement in this magazine
    private int weeklyCostMagazine = 0;//weekly cost of magazine 
    private ArrayList<String>magazineName;
    private MAGAZINE []magazine;//array of magazine class where all magazine and it's details are stored 
    private int count = 0;//index to store magazines in magazine array 
    private Scanner input = new Scanner(System.in);//private scanner for magazine class 
    
    //default constructor 
    //initiated all member variables
    public MAGAZINE()
    {
        name = "unavaliable";
        catalog = "unavalible";
        advertiserName = "unavalible";
        description = "unavlible";
        numberOfSupplement = 0;
        magazine = new MAGAZINE[100];
        count = 0;
        supplementNameone = "unavalible";
        weeklyCostone = 0;
        supplementNametwo = "unavalible";
        weeklyCosttwo = 0;
        supplementNamethree = "unavaliable";
        weeklyCostthree = 0;
        supplementNamefour = "unavaliable";
        weeklyCostfour = 0;
    }
    
    //constructor with values 
    //initiated all member variables with user's input 
    public MAGAZINE(String name,String catalog,String advertiserName,String description,int weeklyCostMagazine,int numberOfSupplement,String supplementNameone,int weeklyCostone,String supplementNametwo,int weeklyCosttwo,String supplementNamethree,int weeklyCostthree,String supplementNamefour,int weeklyCostfour)
    {
        this.name = name;
        this.catalog = catalog;
        this.advertiserName = advertiserName;
        this.description = description;
        this.numberOfSupplement = numberOfSupplement;
        this.magazine = new MAGAZINE[100];
        this.weeklyCostMagazine = weeklyCostMagazine;
        this.supplementNameone = supplementNameone;
        this.weeklyCostone = weeklyCostone;
        this.supplementNametwo = supplementNametwo;
        this.weeklyCosttwo = weeklyCosttwo;
        this.supplementNamethree = supplementNamethree;
        this.weeklyCostthree = weeklyCostthree;
        this.supplementNamefour = supplementNamefour;
        this.weeklyCostfour = weeklyCostfour;
        this.count = 0;
    }
    
    //set methods for magazine class 
    
    //to set name of magazine 
    public void setName(String name)
    {
        this.name = name;
    }
    
    //to set number of supplement 
    public void setNumberOfSupplement(int number)
    {
        this.numberOfSupplement = number;
    }
    
    //to set catalog of supplement 
    public void setCatalog(String catalog)
    {
        this.catalog = catalog;
    }
    
    //to set weekly cost of magazine 
    public void setWeeklyCostM(int cost)
    {
       this.weeklyCostMagazine = cost;
    }
    
    //to set magazine's description 
    public void setDescription(String description)
    {
        
        this.description = description;
    }
    
    //to set magazine's advertiser 
    public void setAdvertiser(String advertiserName)
    {
        this.advertiserName = advertiserName;
    }
    
    //to set name of first supplement 
    public void setSupplementNameOne(String name)
    {
        this.supplementNameone = name;
    }
    
    //to set cost of first supplement 
    public void setSupplementCostOne(int cost)
    {
        this.weeklyCostone = cost;
    }
    
    //to set name of second supplement 
     public void setSupplementNameTwo(String name)
    {
        this.supplementNametwo = name;
    }
    
     //to set cost of second supplement 
    public void setSupplementCostTwo(int cost)
    {
        this.weeklyCosttwo = cost;
    }
    
    //to set name of third supplement 
    public void setSupplementNameThree(String name)
    {
        this.supplementNamethree = name;
    }
    
    //to set cost of third supplement 
    public void setSupplementCostThree(int cost)
    {
        this.weeklyCostthree = cost;
    }
    
    //to set name of fourth supplement 
     public void setSupplementNameFour(String name)
    {
        this.supplementNamefour = name;
    }
    
     //to set weekly cost of fourth supplement 
    public void setSupplementCostFour(int cost)
    {
        this.weeklyCostfour = cost;
    }
    
    //to set index of array 
    public void setCount(int count)
    {
        this.count = count;
    }
    
    //to set new magazine name array for name validataion 
    public void setMagazineName()
    {
        this.magazineName = new ArrayList<String>();
    }
    
    //get methods for magazine class
    
    //to get magazine's name 
    public String getName()
    {
        return name;
    }
    
    //to get magazine's catalog
    public String getCatalog()
    {
        return catalog;
    }
    
    //to get number of supplements in the a magazine 
    //minimum is three 
    //maximum is four 
    public int getNumberOfSupplement()
    {
        return numberOfSupplement;
    }
    
    //to get magazine's description 
    public String getDescription()
    {
        return description;
    }
    
    //to get magazine's advertiser 
    public String getAdvertiser()
    {
        return advertiserName;
    }
    
    //to get weeklyCost of magazine 
    public int getWeeklyCostM()
    {
        return weeklyCostMagazine;
    }
    
    //to get name of first supplement in a magazine 
    public String getSupplementNameOne()
    {
        return supplementNameone;
    }

    //to get cost of first supplement in a magazine 
    public int getSupplementCostOne()
    {
       return weeklyCostone;
    }
    
    //to get name of second supplement in a magazine 
    public String getSupplementNameTwo()
    {
        return supplementNametwo;
    }

    //to get cost of second supplement in a magazine 
    public int getSupplementCostTwo()
    {
       return weeklyCosttwo;
    }

    //to get name of third supplement in a magazine 
    public String getSupplementNameThree()
    {
        return supplementNamethree;
    }

    //to get cost of third supplement in a magazine 
    public int getSupplementCostThree()
    {
       return weeklyCostthree;
    }

    //to get name of fourth supplement in a magazine 
    public String getSupplementNameFour()
    {
        return supplementNamefour;
    }

    //to get cost of fourth supplement in a magazine 
    public int getSupplementCostFour()
    {
       return weeklyCostfour;
    }
    
    //to get current index of magazine array 
    public int getCount()
    {
        return count;
    }
    
    //to get magazines' name arry's size
    public int getSize()
    {
        return this.magazineName.size();
    }
    
    //to get magazine array 
    public MAGAZINE[] getMagazine()
    {
        return magazine;
    }
    
    //inserting data of a new magazine into the magazine array 
    
    //to insert a magazine into the magazine array 
    public void insertingMagazine()
    {
        magazine[count] = new MAGAZINE();//a new magazien 
        magazine[count].setName(name);// to insert the new magazine's name 
        magazine[count].setCatalog(catalog);//to insert the new magazine's catalog 
        magazine[count].setAdvertiser(advertiserName);//to insert the advertiser's name of the new magazine
        magazine[count].setWeeklyCostM(weeklyCostMagazine);//to insert a weekly cost of the new magazine 
        magazine[count].setDescription(description);//to get description of the new magazine 
        magazine[count].setNumberOfSupplement(numberOfSupplement);//to insert number of supplements in the new magazine 
    }
    
    //to insert supplements into the new magazine 
    public void insertingSupplement(int c)
    {
        //for number of supplements in a magazine
        //minimum is three and maximum is four 
        
        //to insert first supplement (not optional)
        if(c == 0)
        {
            magazine[count].setSupplementNameOne(supplementNameone);//to insert first supplement's name 
            magazine[count].setSupplementCostOne(weeklyCostone);//to insert first supplement's weekly cost  
        }
        else if(c == 1)//to insert second supplement (not optional)
        {
            magazine[count].setSupplementNameTwo(supplementNametwo);//to insert second supplement's name 
            magazine[count].setSupplementCostTwo(weeklyCosttwo);//to insert second supplement's weekly cost 
        }
        else if(c == 2)//to insert thrid supplement (not optional)
        {
            magazine[count].setSupplementNameThree(supplementNamethree);//to insert third supplement's name 
            magazine[count].setSupplementCostThree(weeklyCostthree);//to insert third supplement's weekly cost
        }
        else //to insert fourth supplement (optional)
        {
            magazine[count].setSupplementNameFour(supplementNamefour);//to insert fourth supplement's name 
            magazine[count].setSupplementCostFour(weeklyCostfour);//to insert fourth supplement's weekly cost 
        }
    }

    //to add magazines' names into arraylist
    public void insertMagazineName(String name)
    {
        magazineName.add(name);//to add name into array of magazine's array 
    }
    
    //to validate magazine name
    public Boolean validateMagazineName(String name)
    {
        return this.magazineName.contains(name);//return true if magazine array already contain magazine's name user entered
    }
    
    //to increase the index of array for next input
     public void countIncreaser()
    {
        //increase index by 1 
        count = count + 1;
    }
    
   //to print magazine class input 
     
    //to print every magazine from magazine array 
    public void printingMagazine()
    {
        //to print every magazine inserted from magazine array 
        for(int counter = 0; counter < count;counter++)
        {
            //to display each magazine's detail from magazine array 
            magazine[counter].showData();
        }
    }
    
    //to show a magazine's detail 
    public void showData()
    {
        System.out.println(getName());//to display magazine's name
        System.out.println(getCatalog());//to display magazine's catalog
        System.out.println(getAdvertiser());//to dsiplay name of magazine's advertiser 
        System.out.println(getWeeklyCostM());//to display weekly cost of magazine 
        System.out.println(getDescription());//to display magazine's description 
        for(int count = 0; count < getNumberOfSupplement();count++)//to display all supplements' detail in a magazine based on it's number of supplements the array contained which is three or four 
        {
                if(count == 0)//to display first supplement 
                {
                    System.out.println(getSupplementNameOne());//to display first supplement's name 
                    System.out.println(getSupplementCostOne());//to display first supplement's weekly cost 
                }
                else if(count == 1)//to display second supplement 
                {
                    System.out.println(getSupplementNameTwo());//to display second supplement's name 
                    System.out.println(getSupplementCostTwo());//to display second supplement's weekly cost 
                }
                else if(count == 2)//to display third supplement 
                {
                    System.out.println(getSupplementNameThree());//to display third supplement's name 
                    System.out.println(getSupplementCostThree());//to display third supplement's weekly cost 
                }
                else //to display fourth supplement if magazine contain fourth supplement 
                {
                    System.out.println(getSupplementNameFour());//to display fourth supplement's name 
                    System.out.println(getSupplementCostFour());//to display fourth supplement's weekly cost 
                }
        }
    }
    
    //prompts for magazine class 
     
    //prompt for magazine name; 
    public void promptForName()
    {
        String name;//to store the name user will entered 
        Boolean existed = false;//to check if the name of magazine is already existed or not 
        System.out.println("Please Enter the magazine's name");//prompt for magazine's name 
        name = input.nextLine();//to get magazine's name 
        String nam = name.replaceAll("\\s", ""); 
        if(getSize() > 0)//if magazine's name is not the first input 
        {
           existed = validateMagazineName(nam);//it will check whether the name already existed in the system or not 
        }
        while(nam.length()<1 || existed == true)//while loop will continue if name is null or name is already 
        {
          if(nam.length() < 1)//if name is null or empty 
          {
           System.out.println("Magazine's name can not be nulled\nPlease Enter the magazine's name"); //notify user 
          }
          if(existed == true)//if name is already existed in the system
          {
           System.out.println("Magazine's name is already existed\nPlease Enter the magazine's name");//notify user 
          }
          name = input.nextLine(); //ask user again 
          nam = name.replaceAll("\\s", ""); 
          existed = validateMagazineName(nam);//it will check again whether the name already existed in the system or not 
        }
        if(existed == false)//if name hasn't been existed in the system 
        {
            insertMagazineName(nam);//name will be added into array of magazine's name
        }
        setName(name);//set magazine name
    }
    
    //prompt for magazine's catalog
    public void promptForCatalog()
    {
        String catalog;//to store catalog user entered
        System.out.println("Please Enter the magazine's catalog");//prompt for catalog 
        catalog = input.nextLine();//to get catalog 
        String c = catalog.replaceAll("\\s", ""); 
        while(!c.equalsIgnoreCase("Beauty") && !c.equalsIgnoreCase("Men")&& !c.equalsIgnoreCase("WOMEN")&& !c.equalsIgnoreCase("TEEN")&& !c.equalsIgnoreCase("LOVE")&& !c.equalsIgnoreCase("TRAVEL"))//to specified catalog 
        {
           System.out.println("Please enter beauty or men or women or teen or love or travel\n Other options are not allowed\nThank yo");
           System.out.println("Please Enter the magazine's catalog again");
           catalog = input.nextLine(); 
           c = catalog.replaceAll("\\s", "");            
        }
        setCatalog(catalog);//to set catalog 
    }
    
    //prompt for magazine's name of advertiser 
    public void promptForAName()
    {
        String surname;//to stored surname user entered 
        String givenname;//to stored givenname user entered 
        String name;//to store both surname and givenname user entered
        System.out.println("Please Enter advertiser's given name");//prompt for given name 
        givenname = input.nextLine();//to get given name 
        while(givenname.length() < 1)//if given name is null while loop will continue 
        {
           System.out.println("Given name can not be nulled\nPlease Enter advertiser's given name");//notify user
           givenname = input.nextLine(); //to ask user again           
        }
        System.out.println("Please Enter advertiser's surname");//prompt for surname 
        surname = input.nextLine();//to get surname 
        while(surname.length()<1)//if surname is null while loop will continue 
        {
          System.out.println("Surname can not be nulled\nPlease Enter advertiser's surname");//notify user 
          surname = input.nextLine();//ask again     
        }
        name = givenname + " " + surname;//to store advertiser's name 
        setAdvertiser(name);//to set name
    }
    
    //prompt for description of magazine 
    public void promptForDescription()
    {
         String description;//to store description 
         System.out.println("Please Enter magazine's description");//prompt for description 
         description = input.nextLine();//to get description 
         while(description.length()<20)//if 
         {
             System.out.println("Please provide proper description\nPlease Enter magazine's description");//prompt for description 
             description = input.nextLine();//to get description           
         }
         setDescription(description);//set description 
    }
    
    //prompt for weekly cost of magazine 
    public void promptForweeklyCost()
    {
         String wcost;//to store weekly cost of magazine as a string 
         int c = 1;//to store weekly cost of magazine as an integer 
         System.out.println("Please enter magazine's weekly cost");//prompt for weekly cost 
         wcost = input.nextLine();//to get weekly cost 
         Boolean isNumber = wcost.matches("-?\\d+(\\.\\d+)?") ;
         if(isNumber == true)
         {
         c = Integer.parseInt(wcost);//to convert weekly cost from string into integer 
         }
         while(c < 0 || isNumber == false)//weekly cost can not be negative if it is less than 0 while loop will be continued 
         {
           System.out.println("Invalid \nPlease enter magazine's weekly cost");//notify user 
            wcost = input.nextLine();//ask again 
            isNumber = wcost.matches("-?\\d+(\\.\\d+)?") ;
            if(isNumber == true)
            {
             c = Integer.parseInt(wcost);//to convert weekly cost from string into integer 
            }
         }
         setWeeklyCostM(c);//to set weekly cost of magazine 
    }
    
    //prompt for number of supplement the magazine has
    public void promptForNumberOfSupplement()
    {
         String number;//to store number of supplements the magazine contained as string 
         int no  = 0;//to store number of supplements the magazine contained as string 
         System.out.println("Please enter number of supplements for this magazine");//prompt for number of supplement 
         number = input.nextLine();//to get number of supplements
         Boolean isNumber = number.matches("-?\\d+(\\.\\d+)?") ;
         if(isNumber == true)
         {
           no =  Integer.parseInt(number);//to convert number of supplements from string to int
         }
         while(no < 3 || no > 4 || isNumber == false)//number of supplement can not be less than 3 or more than 4 
         {
             if(isNumber == false)
             {
                 System.out.println("Number of supplement need to be digit ");
             }
            System.out.println("Minimun is three and maximum is four\nPlease enter number of supplements for this magazine again");//notify user 
            number = input.nextLine();//ask again 
            isNumber = number.matches("-?\\d+(\\.\\d+)?") ;
            if(isNumber == true)
            {
               no =  Integer.parseInt(number);//convert again  
            }            
         }
         setNumberOfSupplement(no);//set number of supplement 
    }
   
}

package ict373assignmentone;
import java.util.*;

public class Client 
{
    private Scanner input = new Scanner(System.in);
    private int choice = 0;
    private String exist = "No";
    public void run()
    {
         //variables 

          MAGAZINE   m = new MAGAZINE();
          SUPPLEMENT p = new SUPPLEMENT();
          Customer c = new Customer();
          PAYINGCUSTOMER pc = new PAYINGCUSTOMER();
          MESSAGEREPLY r = new MESSAGEREPLY();
          ASSOCIATECUSTOMER a = new ASSOCIATECUSTOMER();
          c.setCustomer();
          m.setMagazineName();
          pc.setPayArray();
          displayMenu();
          promptChoice();
          while(!getExist().equalsIgnoreCase("yes"))
          {
          switch(getChoice())
          {
              case 1:
                  OptionOne(m,p);//finished
                  break;
              case 2:
                  OptionTwo(m,p,c,pc,a);//finished
                  break;
              case 3:
                  OptionThree(r,m,c);//finished
                  break;
              case 4:
                  OptionFour(r,m,c);//finished
                  break;
              case 5:
                   OptionFive(m,p,c,pc,a);//finished
                  break;
              case 6:
                  OptionSix(c,pc);//finished
                  break;
              default:
                  ERROR();
                  break;
          }
          promptExist();
          if(getExist().equalsIgnoreCase("no"))
          {
             displayMenu();
             promptChoice();          
          }
         }
    }
    
    public void displayMenu()
    {
        System.out.println("***************************************************************************************************");
        System.out.println("*                                MENU FOR THIS PROGRAM                                            *");
        System.out.println("***************************************************************************************************");
        System.out.println("*Option one   : ADD A NEW MAGAZINE                                                                *");
        System.out.println("*Option two   : ADD MULTIPLE CUSTOMERS                                                            *");
        System.out.println("*Option three : DISPLAY THE TEXT OF ALL THE EMAILS FOR ALL CUSTOMERS FOR FOUR WEEKS OF MAGAZINES  *");
        System.out.println("*Option four  : DISPLAY THE TEXT FOR THE END OF MONTH EMAILS FOR THE PAYING CUSTOMERS             *");
        System.out.println("*Option five  : ADD A NEW CUSTOMER                                                                *");
        System.out.println("*Option six   : DELECT A CUSTOMER                                                                 *");
        System.out.println("***************************************************************************************************");
        System.out.println(" \n ");
    }
    
    public void ERROR()
    {
        System.out.println("INVALID ENTRY\n");
    }
    
    //set methods for client class
    
    public void setChoice(int choice)
    {
        this.choice = choice;
    }
    
    public void setExist(String exist)
    {
        this.exist = exist;
    }
    
    //get methods for client class 
   
    public int getChoice()
    {
        return choice;
    }
    
    public String getExist()
    {
        return exist;
    }
    //prompt for client class
    
    public void promptChoice()
    {
        String choice ;
        int c = 6;
        System.out.println("Please Enter your choice(a number between 1 - 6)");
        choice = input.nextLine();
        Boolean isNumber = choice.matches("-?\\d+(\\.\\d+)?") ;
        if(isNumber == true )
        {
          c = Integer.parseInt(choice);
        }
        while(c < 1 || c > 6 ||isNumber == false)
        {
            if(c < 1 || c > 6)
            {
            System.out.println("Please Enter a number only between 1 to 6");
            System.out.println("Please enter again");
            }
            if(isNumber == false)
            {
               System.out.println("Choice must be a digit between 1 to 6");
            }
            choice = input.nextLine();
            isNumber = choice.matches("-?\\d+(\\.\\d+)?") ;
            if(isNumber == true)
            {
            c = Integer.parseInt(choice);
            }
        }
        setChoice(c);
    }
    
    public void promptExist()
    {
        String answer;
        System.out.println("Do you want to exit the program(yes/no)");
        answer = input.nextLine();
        answer = answer.replaceAll("\\s", ""); 
        while(!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no"))
        {
           ERROR();
           System.out.println("Please Enter yes or no");
           answer = input.nextLine();
        }
        setExist(answer);
    }
    
    public void OptionSix(Customer c,PAYINGCUSTOMER pc)
    {
    
        String IDToBeDelected = getIDTobeDelected();
        c.removeCustomer(IDToBeDelected);
        pc.removePayID(IDToBeDelected);
    }
    
    public void printID(PAYINGCUSTOMER PC)
    {
        PC.printID();
    }
 
    public void OptionFour(MESSAGEREPLY r,MAGAZINE m,Customer c)
    {
        r.setMagazineCopy();
        r.setSizeOFmagazine(m.getCount());
        r.gettMagazineCopy(m.getMagazine());
        r.setSupplemetCopy();
        r.setCustomerCopy();
        r.copyCustomerCopy(c.getCustomer());
        r.displayMonthlyMessage();
        r.clearCustomerCopy();
    }
    
    public String getIDTobeDelected()
    {
        System.out.println("Please Enter the customer's name to be delected");
        String name = input.nextLine();
        while(name.length() < 1)
        {
           System.out.println("Name can not be nulled \nPlease Enter the customer's name to be delected");
           name = input.nextLine();           
        }
        return name;
    }
    
    public void OptionThree(MESSAGEREPLY r,MAGAZINE m,Customer c)
    {
        r.setMagazineCopy();
        r.setSizeOFmagazine(m.getCount());
        r.gettMagazineCopy(m.getMagazine());
        r.setSupplemetCopy();
        r.setCustomerCopy();
        r.copyCustomerCopy(c.getCustomer());
        r.printFourWeeks();
        r.clearCustomerCopy();
    }
    public void OptionOne(MAGAZINE m,SUPPLEMENT p)
    {
          m.promptForName();
          m.promptForCatalog();
          m.promptForAName();
          m.promptForDescription();
          m.promptForweeklyCost();
          m.promptForNumberOfSupplement();
          m.insertingMagazine();
        for(int count = 0; count < m.getNumberOfSupplement() ;count++)
         {
             p.promptForName();
             if(count == 0)
             {
                 m.setSupplementNameOne(p.getName());
             }
             else if(count == 1)
             {
                 m.setSupplementNameTwo(p.getName());
             }
             else if(count == 2)
             {
                 m.setSupplementNameThree(p.getName());
             }
             else 
             {
                 m.setSupplementNameFour(p.getName());
             }
             p.promptForCost();
              if(count == 0)
             {
                 m.setSupplementCostOne(p.getWeeklyCost());
             }
             else if(count == 1)
             {
                 m.setSupplementCostTwo(p.getWeeklyCost());
             }
             else if(count == 2)
             {
                 m.setSupplementCostThree(p.getWeeklyCost());
             }
             else 
             {
                 m.setSupplementCostFour(p.getWeeklyCost());
             }
             m.insertingSupplement(count);
             p.setAllSupplement(p.getName(), p.getWeeklyCost());
         }
         m.countIncreaser();
         //m.printingMagazine();
    }
    
    public void OptionFive(MAGAZINE m,SUPPLEMENT p,Customer c,PAYINGCUSTOMER pc,ASSOCIATECUSTOMER a)
    {
        ArrayList<SUPPLEMENT> supplements = new ArrayList<SUPPLEMENT>();
        int number = 0;
        Boolean pay = true;
        c.promptForCustomerName();
        c.promptForEmail();
        c.promptForID();
        c.promptForGender();
        c.promptForage();
        if(c.getCustomerSize() > 0)
        {
          pay = PAYORNOT();
        }
        if(pay == true)
        {
          pc.promptForPaymentMethod();
        }
        else 
        {
          a.setPayCopy(pc.getPayArray());
          a.promptForPayCustomer();
          a.clearPay();
        }
        int size = p.getCount();
        number = numberOfSupplement(size);
        p.setSupplementCopy();
        for(int i = 0; i< number;i++)
        {
            p.promptOfNameForCustomer();
            supplements.add(new SUPPLEMENT(p.getName()));
        }
        c.setSupplementList(supplements);
        p.clearSupplementCopy();
        if(pay == true)
        {
           c.addPayingCustomer(c.getSupplementList(),c.getName(),c.getEmail(),c.getID(),c.getAge(),c.getGender(),pc.getPaymentMethod());
           pc.addPay(c.getID());
        }
        else 
        {
          c.addAssociateCustomer(c.getSupplementList(),c.getName(),c.getEmail(),c.getID(),c.getAge(),c.getGender(),a.getPayingCustomer(),a.getPayingCustomerID());
        }
        c.clearSupplementList();
    }
    
    public void OptionTwo(MAGAZINE m,SUPPLEMENT p,Customer c,PAYINGCUSTOMER pc,ASSOCIATECUSTOMER a)
    {
        ArrayList<SUPPLEMENT> supplements = new ArrayList<SUPPLEMENT>();
        int num = 0;
        int number = 0;
        num = numberOFCustomer();
        for(int i = 0; i< num; i++)
        {
        Boolean pay = true;
        c.promptForCustomerName();
        c.promptForEmail();
        c.promptForID();
        c.promptForGender();
        c.promptForage();
        if(c.getCustomerSize() > 0)
        {
          pay = PAYORNOT();
        }
        if(pay == true)
        {
          pc.promptForPaymentMethod();
        }
        else 
        {
          a.setPayCopy(pc.getPayArray());
          a.promptForPayCustomer();
          a.clearPay();
        }
        int size = p.getCount();
        number = numberOfSupplement(size);
        p.setSupplementCopy();
        for(int count = 0; count < number;count++)
        {
            p.promptOfNameForCustomer();
            supplements.add(new SUPPLEMENT(p.getName()));
        }
        c.setSupplementList(supplements);
        p.clearSupplementCopy();
        if(pay == true)
        {
           c.addPayingCustomer(c.getSupplementList(),c.getName(),c.getEmail(),c.getID(),c.getAge(),c.getGender(),pc.getPaymentMethod());
           pc.addPay(c.getID());
        }
        else 
        {
          c.addAssociateCustomer(c.getSupplementList(),c.getName(),c.getEmail(),c.getID(),c.getAge(),c.getGender(),a.getPayingCustomer(),a.getPayingCustomerID());
        }
        c.clearSupplementList();
            
        }
    }
    
    public int numberOFCustomer()
    {
        String number;
        int num = 5;
        System.out.println("Please Enter number of customer you want to entered");
        number = input.nextLine();
        Boolean isNumber = number.matches("-?\\d+(\\.\\d+)?") ;
        if(isNumber == true)
        {
          num = Integer.parseInt(number);
        }
        while(num < 5 || num > 6 || isNumber == false)
        {
            if(num < 5 || num > 6)
            {
            System.out.println("Minimum is 5 and maximum is 7\nPlease Enter number of customer you want to entered");
            }
            
            if(isNumber == false)
            {
                System.out.println("Number of customer must be a number\n Please Enter again");
            }
            number = input.nextLine();
            isNumber = number.matches("-?\\d+(\\.\\d+)?") ;
            if(isNumber == true)
            {
            num = Integer.parseInt(number);
            }
        }
        return num;
    }
    
    public int numberOfSupplement(int size)
    {
        int number = 1;
        String num;
        System.out.println("Please Enter number of supplements ");
        num = input.nextLine();
        Boolean isNumber = num.matches("-?\\d+(\\.\\d+)?") ;
        if(isNumber == true)
        {
         number = Integer.parseInt(num);
        }
        while(number < 1 || number > size || isNumber == false)
        {
            if(number < 1 || number > size)
            {
            System.out.println("INVALID :Please Enter number of supplements again ");
            }
            if(isNumber == false)
            {
                System.out.println("Number of supplement must be a digit ");
            }
            num = input.nextLine();
            isNumber = num.matches("-?\\d+(\\.\\d+)?") ;
            if(isNumber == true)
            {
             number = Integer.parseInt(num);
            }
        }
        return number;
    }
    
    public void printCustomer(Customer c)
    {
        c.printCustomer();
    }
    
    public Boolean PAYORNOT()
    {
        System.out.println("Are you paying??");
        String payornot = input.nextLine();
        payornot = payornot.replaceAll("\\s", ""); 
        while(!payornot.equalsIgnoreCase("yes") && !payornot.equalsIgnoreCase("no"))
        {
             System.out.println("INVALID\nYES OR NO");
             payornot = input.nextLine();          
        }
        if(payornot.equalsIgnoreCase("no"))
        {
            return false;
        }
        else 
        {
            return true;
        }
    }
}

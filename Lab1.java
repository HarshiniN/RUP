package lab1;
import java.io.*;
import java.util.Date;
public class Lab1 {

String name="",mailid="",city="",pwssd="",phno="";
String cart[]=new String[10];
double cartPrice[]=new double[10];
String ordered[]=new String[10];
double orderedPrice[]=new double[10];
String dateOfOrder[]=new String[10];
double cost=0.0;
int itemsincart=0,orderedItems=0;
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    
    void signup()throws IOException
    {
     System.out.println("Enter the details\n");
     System.out.print("Name:");
     this.name=br.readLine();
     do
     {System.out.print("Mail ID:");
     this.mailid=br.readLine();
     if((this.mailid.endsWith(".com"))&&(this.mailid.contains("@")))
     break;
     else
         System.out.println("Invalid mailid");
     }while(true);
     do
     {
     do
     {System.out.print("Password:");
     this.pwssd=br.readLine();
     if(validatepwssd(this.pwssd))
         break;
     else
         System.out.println("your password must have one special character and be of length 10 atleast");
     }while(true);
     System.out.print("Confirm Password:");
     String cpwssd=br.readLine();
     if(pwssd.equals(cpwssd))
     {  
         break;
     }
     System.out.println("Password does not match");
     }while(true);
     
     System.out.print("City:");
     this.city=br.readLine();
     do
     {
     System.out.print("Mobile Number:");
     this.phno=br.readLine();
     if(phno.length()!=10)
     {
         System.out.println("Not a valid phone number");
         continue;
     }
     break;
     }while(true);
     System.out.println("\nYou have signed up! Please login to continue shopping \n");
     
     
    }
    boolean validatepwssd(String p)
    {
        if(((p.contains("*"))||(p.contains("!"))||(p.contains("@"))||(p.contains("#"))||(p.contains("$"))||(p.contains("%"))||(p.contains("^"))||(p.contains("&")))&&(p.length()>=10))
        return true;
        return false;
        
    }
    void login()throws IOException
    {String mid="";
    do
    {
       System.out.print("Mail ID: ");
        mid=br.readLine();
        if(mid.equals(this.mailid))
            break;
        else
        {
            System.out.println("Not a valid mail id. Please check if you have signed up");
            System.out.println("enter 1 to go back, 2 to stay");
            int c=Integer.parseInt(br.readLine());
            if(c==1)
                return;
            else if(c==2)
                continue;
            else
                System.out.println("enter a valid mail ID");
        }
            
        
         
    }while(true);
    do
    {
        System.out.print("Password: ");
        String pw=br.readLine();
        if(pw.equals(pwssd))
            break;
        else
        {
             System.out.println("Wrong password");
              System.out.println("Enter 1 if you have forgotten the password, 2 to re-enter the password, 3 to go back");
              int c=Integer.parseInt(br.readLine());
              if(c==1)
              {System.out.print("Reset your password.\n Enter the new password: ");
              pwssd=br.readLine();
              System.out.println("Password has been reset successful");
              }
              
              else if(c==2)
                 continue;
              else if(c==3)
                  return;
        }
            
        
    }while(true);
      myprofile();  
    }
    void myprofile()throws IOException
    {   do
    {
        System.out.println("Hello,"+this.name+"\n");
        System.out.println("1. Profile");
        System.out.println("2. Cart");
        System.out.println("3. Ordered Items");
        System.out.println("4. Logout\n");
        System.out.print("enter your choice: ");
        int c=Integer.parseInt(br.readLine());
        switch(c)
        {
            case 1: viewProfile();
                break;
            case 2: Cart();
                break;
            case 3: viewOrdered();
                break;
            case 4: System.out.println("\nYou have logged out successfully!");
                return;
            default: System.out.println("Wrong choice");
        }
    }while(true);
    }
    void viewProfile()throws IOException
    {
         System.out.println("Name: "+this.name);
          System.out.println("Mail ID: "+this.mailid);
           System.out.println("City: "+this.city);
            System.out.println("Phone number: "+this.phno);
            System.out.println("\n Do you want to edit your profile? Enter 'y' ofr yes and 'n' for no");
            char yn=br.readLine().charAt(0);
            if(yn=='y')
                editProfile();
            else if(yn=='n')
            {
                System.out.println("Press enter to go back to the other options");
                String goback=br.readLine();
                if(goback=="\n")
                    return;
                        }
            else
                System.out.println("wrong entry");
           
    }
    void editProfile()throws IOException
    {System.out.println("enter the field you want to edit\n");
        do
        { 
     System.out.println("1. Name");
     System.out.println("2. Mail ID");
     System.out.println("3. Password");
     System.out.println("4. City");
     System.out.println("5. Mobile Number");
     System.out.println("6. Go back and View Profile");
     int c=Integer.parseInt(br.readLine());
     switch(c)
     {
         case 1:
         {
             System.out.print("enter the new name:");
             this.name=br.readLine();
             System.out.println("New name updated");
             break;
         }
         case 2:
         {
             System.out.print("enter the new Mail ID:");
             this.mailid=br.readLine();
             System.out.println("New Mail ID updated");
             break;
         }
         case 3:
         {
             do{
             System.out.print("Enter the present password:");
             if(this.pwssd.equals(br.readLine()))
                 break;
             System.out.println("Wrong password");
             }while(true);
             System.out.print("enter the new password:");
             this.pwssd=br.readLine();
             System.out.println("New password updated");
             break;
             
         }
         case 4:
         {
             System.out.print("enter the new city:");
             this.city=br.readLine();
             System.out.println("New City updated");
             break;
         }
         case 5:
         {
             System.out.print("enter the new phone number:");
             this.phno=br.readLine();
             System.out.println("New phone number updated");
             break;
         }
         case 6:
             return;
         default:System.out.println("wrong choice");
         
     }
            
        }while(true);
    }
    void Cart()throws IOException
    {
        do
        {
        System.out.println("1. View cart");
        System.out.println("2. Add to cart");
        System.out.println("3. Delete from cart");
        System.out.println("4. Buy items in cart");
        System.out.println("5. Go back");
        int c=Integer.parseInt(br.readLine());
        if(c==1)
            viewCart();
        else if(c==2)
            addCart();
        else if(c==3)
            delCart();
        else if(c==4)
            buyCart();
        else if(c==5)
            return;
        else
            System.out.println("Wring choice");
        }while(true);
        
    }
    void viewCart()throws IOException
    {
        if(checkEmptyCart())
            System.out.println("\nNo items in cart\n");
        else
        {System.out.println("Item No.\tName\tPrice");
            for(int i=0;i<this.itemsincart;i++)
            {
                System.out.println((i+1)+"\t\t"+this.cart[i]+"\t"+this.cartPrice[i]);
            }                
                        
        }
        
    }
    void dispItems()
    {
        System.out.println("1. Umbrella ");
        System.out.println("2. Pencils");
        System.out.println("3. Fountain pens");
        System.out.println("4. Ballpens");
        System.out.println("5. Gelpens");
        System.out.println("6. Eraser");
        System.out.println("7. Sharpner");
        System.out.println("8. Scale (small)");
        System.out.println("9. Scale (long)");
        System.out.println("10. Long notebook");
    }
    double returnPrice(int i)
    {
        switch(i)
        {
            case 1: return 100;
            case 2: return 5;
            case 3: return 150;
            case 4:return 10;
            case 5: return 15;
            case 6: return 5;
            case 7: return 5;
            case 8: return 10;
            case 9: return 25;
            case 10: return 56;
            default:return 0;
        }
    }
    String returnName(int i)
    {
        switch(i)
        {
            case 1: return "umbrella";
            case 2: return "pencil";
            case 3: return "fountain pen";
            case 4:return "ballpen";
            case 5: return "gelpen";
            case 6: return "eraser";
            case 7: return "sharpner";
            case 8: return "small scale";
            case 9: return "long scale";
            case 10: return "Long notebook";
            default:return "wrong choice";
        }
    }
    void addCart()throws IOException
    {int i=0;
        do
        {
           dispItems();
        System.out.println("Which item to you want to add to cart?");
        i=Integer.parseInt(br.readLine());
        if((i<1)||(i>10))
        {
            System.out.println("No item as such exists. Enter a valid number"); 
            continue;
        }
        break;
            
        }while(true);
        System.out.println("Name of the item: "+returnName(i));
        cart[itemsincart]=returnName(i);
        System.out.println("Price of the item: "+returnPrice(i));
        cartPrice[itemsincart]=returnPrice(i);
        System.out.println("\nThis has been added to your cart.");
        cost=cost+returnPrice(i);
        itemsincart++;      
        
    }
    void delCart()throws IOException
    {
        if(checkEmptyCart())
            System.out.println("No items in cart to delete");
        else
        {
             System.out.println("Which item do you want to delete?");
            for(int i=0;i<itemsincart;i++)
            {
               System.out.println((i+1)+" "+cart[i]);
                
            }
            int di;
            do{
             di=Integer.parseInt(br.readLine());
            if(di<itemsincart)
                break;
            System.out.println("Wrong choice. Please enter the correct item number");
            }while(true);
            if(di!=(itemsincart-1))
            {
                for(int i=di;i<(itemsincart-1);i++)
                {
                    cart[i]=cart[i+1];
                }
                
            }
            itemsincart--;
            System.out.println("Item deleted successfully!");
        }
        
    }
    void buyCart()throws IOException
    {
        System.out.println("These are the items in your cart.");
        viewCart();
        System.out.print("Do you want to buy everything? (y/n) ");
        char c=br.readLine().charAt(0);
        if(c=='y')
        {
            System.out.println("Total amount="+cost);
            Date date=new Date();
            updateOrdered(date.toString());
        }
        else
        {
            System.out.println("Go back and delete the items from the  cart which you don't want to buy");
        }
        for(int i=0;i<itemsincart;i++)
        {
            cart[i]=null;
            cartPrice[i]=0;
        }
        orderedItems=itemsincart;
        itemsincart=0;
    }
    void updateOrdered(String d)
    {
        for(int i=0;i<itemsincart;i++)
        {
            ordered[i]=cart[i];
            orderedPrice[i]=cartPrice[i];
            dateOfOrder[i]=d;
        }
    }
    boolean checkEmptyCart()
    {
        if(itemsincart==0)
            return true;
        else
            return false;
    }
    void viewOrdered()throws IOException
    {
        if(ordered[0]==null)
        {
            System.out.println("You have not ordered any item");
            System.out.println("Press enter to go back");
            if(br.readLine().equals("\n"))
                return;
        }
            
        else
        {System.out.println("Sl.No.\tItem name\tPrice\tDate of Order");
        for(int i=0;i<orderedItems;i++)
        {
            System.out.println((i+1)+"\t\t"+ordered[i]+"\t"+orderedPrice[i]+"\t"+dateOfOrder[i]);
        }
        }
        System.out.println("press enter to go back");
        if(br.readLine().equals("\n"))
                return;
    }
    
    public static void main(String[] args)throws IOException 
    {int choice=0;
    Lab1 obj=new Lab1();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        do
        {System.out.println("MENU");
        System.out.println("1.Signup \n2. Login \n3. Exit ");
        choice= Integer.parseInt(br.readLine());
        if(choice==1)
            obj.signup();
        else if(choice==2)
            obj.login();
        else if(choice==3)
            System.out.println("Thank you for visiting us!");
        else
            System.out.println("Not a valid option");
        
            
        }while(choice!=3);
        
        // TODO code application logic here
    }
    
}


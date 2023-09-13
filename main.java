import java.util.Scanner;
import java.util.ArrayList;


public class main{
    public static int done = 0;

    public static void main(String[] args)
    {
        
        
        
        
        ArrayList<Account> Accounts = new ArrayList<>();
        Account d = new Account(null);
        Accounts.add(d);
        
        while(done != 1){

            int choice = 0;
            System.out.println("Welcome!\n\nare you an existing user?");
            

            while(choice != 1 && choice != 2){
            System.out.println("input 1 for yes   input 2 for no   input any other number to log out");

            Scanner existing = new Scanner(System.in);
            
             choice = existing.nextInt();
             if(choice == 1){
                Account p = retrieveAccount(Accounts);
                if(p == null)
                    break;
                performAction(p);

                
             }
             else if(choice == 2){
                

                System.out.println("Provide name for account\n");
                Scanner name = new Scanner(System.in);
                String Name = name.nextLine();
                Account person = new Account(Name);
                System.out.println("Account created!\n");
                System.out.println("Your account number is: " + person.getAccountNumber() + "\n");
                System.out.println("The name on the account is " + person.getName() + "\n");
                Accounts.add(person);
               Account person2 = retrieveAccount(Accounts);
                performAction(person2);
                continue;

            
             }
             else{
                break;
             }
             

            }

        
            break;
        }


        
    }

    public static Account retrieveAccount(ArrayList<Account> list){
            
        boolean accountFound = false;
        Account foundAccount = null;
        
        while (!accountFound) {
            System.out.println("Please provide your account number");
            Scanner num = new Scanner(System.in);
            int aNum = num.nextInt();
            
            for (Account X : list) {
                if (X.getAccountNumber() == aNum) {
                    System.out.println("Account Found! Welcome back " + X.getName());
                    foundAccount = X;
                    accountFound = true;
                    break; // Exit the loop when the account is found
                }
            }
            
            if (!accountFound) {
                System.out.println("Account not found");
                System.out.println("Input 1 to re-enter Account number");
                System.out.println("Input 3 to log out");
                Scanner choice = new Scanner(System.in);
                int option = choice.nextInt();
                if (option == 1) {
                    // The loop will continue to prompt for the account number
                } else if (option == 3) {
                    break; // Exit the loop if option is 3
                }
            }
        }
        
        return foundAccount; // Return the found account if any
    }
    
    
    
    
    
    
    

    public static void performAction(Account person){
        int Obj = 0;
        int temp = 0;
         while(Obj != 4){

            

        
            System.out.println("What would you like to do?\n\n Withdraw   Deposit   Check Balance");

            System.out.println("input 1 for withdrawal   input 2 for Deposit   input 3 to check balance  input 4 to log out");
            Scanner option = new Scanner(System.in);
            Obj = option.nextInt();

            if(Obj == 1){
                while(temp != 1){
                System.out.println("How much would would you like to withdraw?");
                Scanner withdrawal = new Scanner(System.in);
                double Withdrawal = withdrawal.nextDouble();

                if(Withdrawal > person.getBalance()){
                    System.out.println("Insufficient Funds");
                }
                else{
                    double w = person.getBalance() - Withdrawal;
                    person.setBalance(w);
                    System.out.println("Withdrawal Complete!");
                    System.out.println("Your new balance is: " + person.getBalance());
                    break;
                }
            }
                
            }
            else if(Obj == 2){
                 System.out.println("How much would you like to deposit?\n");
                 Scanner amount = new Scanner(System.in);
                 double Amount = amount.nextDouble();
                 double newBalance = Amount + person.getBalance();
                 person.setBalance(newBalance);

                 System.out.println("You now have: " + person.getBalance() + "in your account!\n");
            }
            else if(Obj == 3){
                 System.out.println("Your balance is: " + person.getBalance() +"\n");
            }
            else if(Obj == 4){
            
                break;
            }
            else{
                System.out.println("Invalid Input\n");
            }
            

        }
    
    }

}



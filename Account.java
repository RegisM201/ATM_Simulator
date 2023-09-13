import java.util.Random;

public class Account {
    private double Balance;
    private String name;
    private int accountNumber;
    Random rand = new Random();
    public Account(String name){
        this.name = name;
        this.Balance = 0;
        this.accountNumber = rand.nextInt(1000);
    }

    public void setBalance(double amount){
        this.Balance = amount;
    }

    public double getBalance(){
        return this.Balance;
    }

    public String getName(){
        return this.name;

    }

    public int getAccountNumber(){
        return this.accountNumber;
    }
}



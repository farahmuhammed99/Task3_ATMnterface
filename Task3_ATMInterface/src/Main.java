/**************************Libraries***************************************/
import java.awt.*;
import java.util.Scanner;
/********************* Bank Account Class*********************************************/
class BankAccount {
    private double Balance;

    public BankAccount(double InitialBalance) {
        this.Balance = InitialBalance;
    }

    public double GetBalance() {
        return Balance;
    }

    public Boolean Withdraw(double Amount) {
        if (Amount > Balance) {
            System.out.println("Transaction failed, Insufficient Balance");
            return false;

        } else {
            Balance -= Amount;
            System.out.println("Transaction Successful");
            System.out.println("Your new Balance is:" + Balance + "L.E");

            return true;
        }

    }

    public double Deposit(double Amount) {
        Balance += Amount;
        System.out.println("Transaction Complete");
        System.out.println("Your new Balance is:" + Balance + "L.E");
return Balance;
    }
}
/***********************ATM DISPLAY CLASS*********************************************************/
class ATM{
    private BankAccount UserAccount;
    public ATM(BankAccount Account){
        this.UserAccount= Account;
    }


    public void DisplayMenu(){
        System.out.println("Welcome to ATM Menu");
        System.out.println("1.Check Balance");
        System.out.println("2.Withdraw Balance");
        System.out.println("3.Deposit Balance");
        System.out.println("4.Exit Menu");
    }

public void SelectChoice( int Choice) {
    Scanner scanner = new Scanner(System.in);
    switch (Choice) {
        case 1:
            System.out.println("your Current Balance is:" + UserAccount.GetBalance());
            break;
        case 2:
            System.out.println("Enter withdrawal Amount");
            double WithdrawalAmount = scanner.nextDouble();
            UserAccount.Withdraw(WithdrawalAmount);
            break;
        case 3:
            System.out.println("Enter the amount you want to deposit");
            double DepositedAmount = scanner.nextDouble();
            UserAccount.Deposit(DepositedAmount);
            break;
        case 4:
            System.out.println("Thank you for banking with us");
            break;
        default:
            System.out.println("Invalid option, please try again");

    }
}



/*************************Main Function*************************************/

    public static void main(String[] args) {
        BankAccount UserAccount = new BankAccount(10000);
        ATM atm = new ATM(UserAccount);
        Scanner scanner = new Scanner(System.in);

atm.DisplayMenu();
System.out.println("Please select your service number");
int Choice = scanner.nextInt();

    atm.SelectChoice(Choice);

        }}

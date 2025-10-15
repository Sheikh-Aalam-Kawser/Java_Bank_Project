package banking.banking;
import java.util.ArrayList;
import java.util.Scanner;
public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();
        boolean run = true;

        System.out.println("*** Welcome to Bank Account Management System ***");
        while(run){
        System.out.println("\n=== Main Menu ===\n");
        System.out.println("1. Create Savings Account");
        System.out.println("2. Create Current Account");
        System.out.println("3. Login Account");
        System.out.println("4. Exit");
        System.out.println(" Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Enter Account Holder Name: ");
                String holderName = sc.nextLine();
                System.out.println("Enter Balance: ");
                double balance = sc.nextDouble();
                sc.nextLine();
                System.out.println("Enter Password: ");
                String password1 = sc.nextLine();
                Savings savings = new Savings(holderName, balance, password1);
                accounts.add(savings);
                System.out.println("Account Created Successfully \n Account number: " + savings.accountNumber);
                break;
            case 2:
                System.out.println("Enter Account Holder Name: ");
                String accountHolderName = sc.nextLine();
                System.out.println("Enter Balance: ");
                double accountBalance = sc.nextDouble();
                sc.nextLine();
                System.out.println("Enter Password: ");
                String password2 = sc.nextLine();
                Current current = new Current(accountHolderName, accountBalance, password2);
                accounts.add(current);
                System.out.println("Account Created Successfully \n Account number: " + current.accountNumber);
                break;
            case 3:
                System.out.println("Enter Account Number: ");
                String accountNumber = sc.nextLine();
                System.out.println("Enter Password: ");
                String password3 = sc.nextLine();
                boolean found = false;
                for (Account acc : accounts) {
                    if (acc.accountNumber.equals(accountNumber) && acc.password.equals(password3)) {
                        found = true;
                        System.out.println("==== Menu ====");
                        System.out.println("1. Deposit ");
                        System.out.println("2. Withdraw");
                        System.out.println("3. Issue Statement");
                        System.out.println("Enter your choice: ");
                        int choice2 = sc.nextInt();
                        switch (choice2) {
                            case 1:
                                System.out.println("Enter amount to deposit: ");
                                double amount = sc.nextDouble();
                                acc.deposit(amount);

                                break;
                            case 2:
                                System.out.println("Enter amount to withdraw: ");
                                double amount2 = sc.nextDouble();
                                acc.withdraw(amount2);
                                break;
                            case 3:
                                acc.statement();
                                break;
                            default:
                                System.out.println("Invalid choice");
                        }
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Incorrect Account number or Passowrd!");
                }
                break;
            case 4:
                run = false;
                System.out.println("Thank you for using our Bank Application");
                break;
            default:
                System.out.println("Invalid choice");
            }
        }
    }
}

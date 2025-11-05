package banking.banking;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();
        boolean run = true;

        System.out.println("*** Welcome to Bank Account Management System ***");
        while (run) {
            System.out.println("\n=== Main Menu ===\n");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Login Account");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Account Holder Name: ");
                    String holderName = sc.nextLine();
                    while (holderName.isEmpty() || !holderName.matches("[a-zA-Z ]+")) {
                        System.out.print("Invalid name! Enter again: ");
                        holderName = sc.nextLine();
                    }
                    System.out.println("Enter Balance: ");
                    double balance = sc.nextDouble();
                    sc.nextLine();
                    while (balance < 500) {
                        System.out.print("Minimum balance should be ₹500. Enter again: ");
                        balance = sc.nextDouble();
                        sc.nextLine();
                    }
                    System.out.println("Enter Password: ");
                    String password1 = sc.nextLine();
                    while (password1.length() < 4) {
                        System.out.print("Password too short! Enter again: ");
                        password1 = sc.nextLine().trim();
                    }
                    Savings savings = new Savings(holderName, balance, password1);
                    accounts.add(savings);
                    System.out.println("Account Created Successfully \n Account number: " + savings.getAccountNumber());
                    break;
                case 2:
                    System.out.println("Enter Account Holder Name: ");
                    String accountHolderName = sc.nextLine();
                    while (accountHolderName.isEmpty() || !accountHolderName.matches("[a-zA-Z ]+")) {
                        System.out.print("Invalid name! Enter again: ");
                        holderName = sc.nextLine();
                    }
                    System.out.println("Enter Balance: ");
                    double accountBalance = sc.nextDouble();
                    sc.nextLine();
                    while (accountBalance < 500) {
                        System.out.print("Minimum balance should be ₹500. Enter again: ");
                        accountBalance = sc.nextDouble();
                        sc.nextLine();
                    }
                    System.out.println("Enter Password: ");
                    String password2 = sc.nextLine();
                    while (password2.length() < 4) {
                        System.out.print("Password too short! Enter again: ");
                        password2 = sc.nextLine().trim();
                    }
                    Current current = new Current(accountHolderName, accountBalance, password2);
                    accounts.add(current);
                    System.out.println("Account Created Successfully \n Account number: " + current.getAccountNumber());
                    break;
                case 3:
                    System.out.println("Enter Account Number: ");
                    String accountNumber = sc.nextLine();
                    System.out.println("Enter Password: ");
                    String password3 = sc.nextLine();
                    boolean found = false;
                    Account loggedIn = null;
                    for (Account acc : accounts) {
                        if (acc.getAccountNumber().equals(accountNumber) && acc.checkPassword(password3)) {
                            found = true;
                            loggedIn = acc;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Invalid account number or password!");
                    }
                    while (found) {
                        System.out.println("==== Menu ====");
                        System.out.println("1. Deposit ");
                        System.out.println("2. Withdraw");
                        System.out.println("3. Issue Statement");
                        System.out.println("4. Logout");
                        System.out.println("Enter your choice: ");
                        int choice2 = sc.nextInt();
                        switch (choice2) {
                            case 1:
                                System.out.println("Enter amount to deposit: ");
                                double amount = sc.nextDouble();
                                loggedIn.deposit(amount);

                                break;
                            case 2:
                                System.out.println("Enter amount to withdraw: ");
                                double amount2 = sc.nextDouble();
                                loggedIn.withdraw(amount2);
                                break;
                            case 3:
                                loggedIn.statement();
                                break;
                            case 4:
                                System.out.println("Logout Successful");
                                found = false;
                                break;
                            default:
                                System.out.println("Invalid choice");
                        }
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

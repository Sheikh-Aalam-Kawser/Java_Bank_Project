package banking.banking;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    static final double minBalanceCurrent = 1000.0;
    static final double minBalanceSavings = 500.0;
    static final int minPasswordLength = 8;

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
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Holder Name: ");
                    String holderName = sc.nextLine();
                    while (holderName.isEmpty() || !holderName.matches("[a-zA-Z ]+")) {
                        System.out.print("Invalid name! Enter again: ");
                        holderName = sc.nextLine();
                    }
                    System.out.print("Enter Balance: ");
                    double balance = sc.nextDouble();
                    sc.nextLine();
                    while (balance < minBalanceSavings) {
                        System.out.print("Minimum balance should be ₹" + minBalanceSavings + ". Enter again: ");
                        balance = sc.nextDouble();
                        sc.nextLine();
                    }
                    System.out.print("Enter Password: ");
                    String password = sc.nextLine();
                    while (password.length() < minPasswordLength) {
                        System.out.print("Password too short! Enter again: ");
                        password = sc.nextLine();
                    }
                    Savings savings = new Savings(holderName, balance, password);
                    accounts.add(savings);
                    System.out.println("Account Created Successfully \n Account number: " + savings.getAccountNumber());
                    break;
                case 2:
                    System.out.print("Enter Account Holder Name: ");
                    String holderNameCurrent = sc.nextLine();
                    while (holderNameCurrent.isEmpty() || !holderNameCurrent.matches("[a-zA-Z ]+")) {
                        System.out.print("Invalid name! Enter again: ");
                        holderNameCurrent = sc.nextLine();
                    }
                    System.out.print("Enter Balance: ");
                    double balanceCurrent = sc.nextDouble();
                    sc.nextLine();
                    while (balanceCurrent < minBalanceCurrent) {
                        System.out.print("Minimum balance should be ₹" + minBalanceCurrent + ". Enter again: ");
                        balanceCurrent = sc.nextDouble();
                        sc.nextLine();
                    }
                    System.out.print("Enter Password: ");
                    String passwordCurrent = sc.nextLine();
                    while (passwordCurrent.length() < minPasswordLength) {
                        System.out.print("Password too short! Enter again: ");
                        passwordCurrent = sc.nextLine();
                    }
                    Current current = new Current(holderNameCurrent, balanceCurrent, passwordCurrent);
                    accounts.add(current);
                    System.out.println("Account Created Successfully \n Account number: " + current.getAccountNumber());
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    String accountNumber = sc.nextLine();
                    System.out.print("Enter Password: ");
                    String loginPassword = sc.nextLine();
                    boolean found = false;
                    Account loggedIn = null;
                    for (Account acc : accounts) {
                        if (acc.getAccountNumber().equals(accountNumber) && acc.checkPassword(loginPassword)) {
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
                        System.out.print("Enter your choice: ");
                        int choice2 = sc.nextInt();
                        sc.nextLine();
                        switch (choice2) {
                            case 1:
                                System.out.print("Enter amount to deposit: ");
                                double amount = sc.nextDouble();
                                sc.nextLine();
                                loggedIn.deposit(amount);
                                break;
                            case 2:
                                System.out.print("Enter amount to withdraw: ");
                                double amountToWithdraw = sc.nextDouble();
                                sc.nextLine();
                                loggedIn.withdraw(amountToWithdraw);
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
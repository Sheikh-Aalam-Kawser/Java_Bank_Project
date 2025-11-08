package banking.banking;

import java.util.ArrayList;

abstract class Account {
    private final String accountNumber;
    private final String holderName;
    protected double balance;
    private final String password;
    protected ArrayList<String> transactions = new ArrayList<>();

    public Account(String accountNumber, String holderName, double balance, String password) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.password = password;
        transactions.add("Account created with initial balance: Rs. " + balance);
    }
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
        } else {
            balance += amount;
            transactions.add("Deposited Rs. " + amount + " | Balance: Rs. " + balance);
            System.out.println("Deposited Rs. " + amount);
            System.out.println("Balance: " + balance);
        }
    }
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance!");
            return;
        }
        balance -= amount;
        transactions.add("Withdrawn Rs. " + amount + " | Balance: Rs. " + balance);
        System.out.println("Withdrawn Rs. " + amount);
        System.out.println("Balance: " + balance);
    }
    public void statement() {
        System.out.println("=============== Account Statement ===============");
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Name of Account Holder: " + getHolderName());
        System.out.println("Account Balance: " + balance);
        System.out.println("-------------- Transaction History --------------");
        for (String tn : transactions) {
            System.out.println(tn);
        }
        System.out.println("--------------------------------------------------");
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public boolean checkPassword(String inputPassword) {
        return password.equals(inputPassword);
    }
}

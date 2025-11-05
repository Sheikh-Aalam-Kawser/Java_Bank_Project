package banking.banking;

import java.util.ArrayList;

abstract class Account {
    private String accountNumber;
    private String holderName;
    protected double balance;
    private String password;
    protected ArrayList<String> transactions = new ArrayList<>();

    public Account(String accountNumber, String holderName, double balance, String password) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.password = password;
        transactions.add("Account created with initial balance: Rs. " + balance);
    }

    abstract void deposit(double amount);

    abstract void withdraw(double amount);

    abstract void statement();

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public boolean checkPassword(String inputPassword) {
        return password.equals(inputPassword);
    }
}

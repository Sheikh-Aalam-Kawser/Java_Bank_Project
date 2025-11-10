package banking.banking;

import java.util.ArrayList;

abstract class Account {
    private final String accountNumber;
    private final String holderName;
    protected double balance;
    private final String password;
    protected ArrayList<String> transactions = new ArrayList<>();

    abstract void deposit(double amount);

    abstract void withdraw(double amount);

    abstract void statement();

    public Account(String accountNumber, String holderName, double balance, String password) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.password = password;
        transactions.add("Account created with initial balance: Rs. " + balance);
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

package banking.banking;

abstract class Account {
    String accountNumber;
    String holderName;
    double balance;
    String password;
    public Account(String accountNumber, String holderName, double balance, String password) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.password=password;
    }
    abstract void deposit(double amount);
    abstract void withdraw(double amount);
    abstract void statement();
}

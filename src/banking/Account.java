package banking.banking;

abstract class Account {
    String accountNumber; // Account number for identification of account
    String holderName;    // Name of the account holder
    double balance;       // Account balance
    String password;      // Password for authentication

    /*
     * Constructor to initialize a new account
     */

    public Account(String accountNumber, String holderName, double balance, String password) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.password = password;
    }

    /* Deposit an amount into the account. */
    abstract void deposit(double amount);

    /* Withdraw an amount from the account. */
    abstract void withdraw(double amount);

    /* Print or return the account statement. */
    abstract void statement();
}

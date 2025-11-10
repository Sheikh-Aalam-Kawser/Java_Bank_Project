package banking.banking;

public class Savings extends Account {
    final double withdrawLimit = 40000;
    final double depositLimit = 1000000;

    @Override
    void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }
        if (amount > depositLimit) {
            System.out.println("Daily limit exceeded!");
            return;
        }
            balance += amount;
            transactions.add("Deposited Rs. " + amount + " \t | \t Balance: Rs. " + balance);
            System.out.println("Deposited Rs. " + amount);
            System.out.println("Balance: " + balance);

    }

    @Override
    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance!");
            return;
        }
        if (amount > withdrawLimit) {
            System.out.println("Transaction limit reached!");
            return;
        }
        balance -= amount;
        transactions.add("Withdrawn Rs. " + amount + " \t | \t  Balance: Rs. " + balance);
        System.out.println("Withdrawn Rs. " + amount);
        System.out.println("Balance: " + balance);

    }

    @Override
    void statement() {
        System.out.println("=============== Account Statement ===============");
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Name of Account Holder: " + getHolderName());
        System.out.println("Account Balance: " + balance);
        System.out.println("--------------- Transaction History ---------------");
        for (String tn : transactions) {
            System.out.println(tn);
        }
        System.out.println("--------------------------------------------------");
    }

    private static long acc = 999999;

    private static String generateAccNo() {
        acc++;
        return "S" + acc;
    }

    public Savings(String holderName, double balance, String password) {
        super(generateAccNo(), holderName, balance, password);
    }
}
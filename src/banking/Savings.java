package banking.banking;

public class Savings extends Account {

    private static long acc = 999999;

    private static String generateAccNo() {
        acc++;
        return "S" + acc;
    }

    public Savings(String holderName, double balance, String password) {
        super(generateAccNo(), holderName, balance, password);
    }
}
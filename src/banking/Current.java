package banking.banking;

public class Current extends Account {

    private static long acc = 999999;

    private static String generateAccNo() {
        acc++;
        return "C" + acc;
    }

    public Current(String holderName, double balance, String password) {
        super(generateAccNo(), holderName, balance, password);
    }
}
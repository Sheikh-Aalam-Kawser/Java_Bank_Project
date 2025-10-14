package banking.banking;

import java.util.Random;

    public class Current extends Account {
        @Override
        void deposit(double amount) {
            if(amount < 0) {
                System.out.println("Invalid amount!");
            }
            else {
                balance += amount;
                System.out.println("Deposited Rs. " + amount);
                System.out.println("Balance: " + balance);
            }

        }
        @Override
        void withdraw(double amount) {
            if(amount < 0) System.out.println("Invalid amount!");

            else if(amount > balance) System.out.println("Insufficient balance!");

            else {
                balance -= amount;
                System.out.println("Withdrawn Rs. " + amount);
                System.out.println("Balance: " + balance);
            }
        }
        @Override
        void statement() {
            System.out.println("=============== Account Statement ===============");
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Name of Account Holder: " + holderName);
            System.out.println("Account Balance: " + balance);
        }
        private static String generateAccNo(){
            long random = new Random().nextLong(9999999);
            long acc= 1000000+random;
            return "C" + acc;
        }
        public Current(String holderName, double balance, String password) {
            super(generateAccNo(),holderName,balance,password);
        }
    }


import java.util.Scanner;

public class ATM {


    private static class BankAccount {
        private double balance;

        public BankAccount(double balance) {
            this.balance = balance;
        }

        public boolean withdraw(double amount) {
            if (amount <= 0) {
                System.out.println("Invalid withdrawal amount in SriramATM.");
                return false;
            }
            if (balance >= amount) {
                balance -= amount;
                return true;
            }
            return false;
        }

        public void deposit(double amount) {
            if (amount <= 0) {
                System.out.println("Invalid deposit amount in SriramATM.");
            }
            balance += amount;
        }

        public double getBalance() {
            return balance;
        }
    }

    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nATM Machine\n" +
                    "1. Withdraw in SriramATM\n" +
                    "2. Deposit in SriramATM\n" +
                    "3. Check Balance in SriramATM\n" +
                    "4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            double amount;
            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to withdraw in SriramATM: ");
                    amount = scanner.nextDouble();
                    if (account.withdraw(amount)) {
                        System.out.println("Amount withdrawn successfully from sriram's account.");
                    } else {
                        System.out.println("Insufficient balance in your sriram's account.");
                    }
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit in sriram's account: ");
                    amount = scanner.nextDouble();
                    account.deposit(amount);
                    System.out.println("Amount deposited successfully.");
                    break;
                case 3:
                    System.out.println("Your current balance is: " + account.getBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        ATM atm = new ATM(account);
        atm.start();
    }
}
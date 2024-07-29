import java.util.HashMap;
import java.util.Scanner;

public class BankYy {
    private static final HashMap<String, Double> accounts = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Welcome to BankY!");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Transfer Funds");
            System.out.println("5. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 :
                    createAccount(sc);
                    break;
                case 2 :
                    depositFund(sc);
                    break;
                case 3 :
                    withdrawFunds(sc);
                    break;
                case 4 :
                    transferFunds(sc);
                    break;
                case 5 :
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
        sc.close();
        System.out.println("Thank you for using BankY!");
    }
    private static void createAccount(Scanner sc) {
        System.out.println("Enter account name : ");
        String accountName = sc.nextLine();
        if (accounts.containsKey(accountName)) {
            System.out.println("Account already exists.");
        } else {
            accounts.put(accountName, 0.0);
            System.out.println("Account created successfully.");
        }
    }

    private static void depositFund(Scanner sc) {
        System.out.println("Enter account name : ");
        String accountName = sc.nextLine();
        if (accounts.containsKey(accountName)) {
            System.out.println("Enter amount to be deposited: ");
            double amount = sc.nextDouble();
            sc.nextLine();
            accounts.put(accountName, accounts.get(accountName) + amount);
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Account does not exist.");
        }
    }

    private static void withdrawFunds(Scanner sc) {
        System.out.println("Enter account name: ");
        String accountName = sc.nextLine();
        if (accounts.containsKey(accountName)) {
            System.out.println("Enter amount to withdraw: ");
            double amount = sc.nextDouble();
            if (accounts.get(accountName) >= amount) {
                accounts.put(accountName, accounts.get(accountName) - amount);
                System.out.println("Amount withdraw successfully.");
            } else {
                System.out.println("Insufficient funds");
            }
        } else {
            System.out.println("Account does not exists.");
        }
    }

    private static void transferFunds(Scanner sc) {
        System.out.println("Enter source account name : ");
        String sourceAccount = sc.nextLine();
        System.out.println("Enter destination account name: ");
        String destinationAccount = sc.nextLine();
        if (accounts.containsKey(sourceAccount) && accounts.containsKey(destinationAccount)) {
            System.out.println("Enter amount to transfer: ");
            double amount = sc.nextDouble();
            sc.nextLine();
            if (accounts.get(sourceAccount) >= amount) {
                accounts.put(sourceAccount, accounts.get(destinationAccount) - amount);
                System.out.println("Amount transferred successfully.");
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("One or both accounts do not exist.");
        }
    }
}
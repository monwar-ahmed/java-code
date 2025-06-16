import java.util.Scanner;
public class AccountApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Simple Bank!");
        System.out.print("Enter Account Holder Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Account Number: ");
        String accNo = scanner.nextLine();
        System.out.print("Set your 4-digit PIN: ");
        int pin = scanner.nextInt();

        Account account = new Account(name, accNo, pin);
        System.out.println("\nAccount created successfully with initial balance of $500!\n");

        int choice;
        do {
            System.out.println("---------- Menu ----------");
            System.out.println("1. View Account Details");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    System.out.println("\nAccount Holder: " + account.getAccountHolderName());
                    System.out.println("Account Number: " + account.getAccountNo());
                    System.out.println("Current Balance: $" + account.getBalance() + "\n");
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Enter PIN to proceed: ");
                    int enteredPin = scanner.nextInt();
                    if(enteredPin == account.getPin()) {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Incorrect PIN!");
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Current Balance: $" + account.getBalance() + "\n");
                    break;
                case 5:
                    System.out.println("Thank you for using Simple Bank. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.\n");
            }

        } while(choice != 5);

        scanner.close();
    }
}
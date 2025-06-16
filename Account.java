public class Account {
    private String accountHolderName;
    private String accountNo;
    private double balance;
    private int pin;

    public Account(String accountHolderName, String accountNo, int pin) {
        this.accountHolderName = accountHolderName;
        this.accountNo = accountNo;
        this.pin = pin;
        this.balance = 500.0;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public int getPin() {
        return pin;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn: " + amount);
        } else {
            System.out.println("Invalid or insufficient balance.");
        }
    }
}

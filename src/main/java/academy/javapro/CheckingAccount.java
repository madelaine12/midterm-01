package academy.javapro;

/**
 * CheckingAccount class extending the abstract Account class.
 * Features overdraft protection and transaction fees.
 */
public class CheckingAccount extends Account {
    private double overdraftLimit;
    private static final double TRANSACTION_FEE = 1.5; // Fee per withdrawal

    public CheckingAccount(String accountNumber, String customerName, double initialBalance, double overdraftLimit) {
        super(accountNumber, customerName, initialBalance); // Call to the parent constructor
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
        System.out.println("Overdraft limit updated to $" + String.format("%.2f", overdraftLimit));
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }

        double totalAmount = amount + TRANSACTION_FEE;
        if (getBalance() + overdraftLimit >= totalAmount) {
            setBalance(getBalance() - totalAmount);
            logTransaction("WITHDRAWAL", amount);
            logTransaction("FEE", TRANSACTION_FEE);
            System.out.println("Withdrew $" + String.format("%.2f", amount) + " from checking account");
            System.out.println("Transaction fee: $" + String.format("%.2f", TRANSACTION_FEE));
            if (getBalance() < 0) {
                System.out.println("Account is in overdraft. Current balance: $" + String.format("%.2f", getBalance()));
            }
        } else {
            System.out.println("Cannot withdraw $" + amount + ". Exceeds overdraft limit.");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo(); 
        System.out.println("Account Type: Checking Account");
        System.out.println("Overdraft Limit: $" + String.format("%.2f", overdraftLimit));
        System.out.println("Transaction Fee: $" + String.format("%.2f", TRANSACTION_FEE));
    }
}
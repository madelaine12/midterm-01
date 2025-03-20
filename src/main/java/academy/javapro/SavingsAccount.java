package academy.javapro;

/**
 * SavingsAccount class extending the abstract Account class.
 * Features interest rate and minimum balance requirement.
 */
public class SavingsAccount extends Account {
    private final double interestRate;
    private static final double MIN_BALANCE = 100.0; // Minimum balance requirement

    public SavingsAccount(String accountNumber, String customerName, double initialBalance, double interestRate) {
        super(accountNumber, customerName, initialBalance); // Call to the parent constructor
        this.interestRate = interestRate;
    }

    public double calculateInterest() {
        return getBalance() * (interestRate / 100);
    }

    public void applyInterest() {
        double interest = calculateInterest();
        setBalance(getBalance() + interest);
        logTransaction("INTEREST", interest);
        System.out.println("Interest applied: $" + String.format("%.2f", interest));
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }

        if (getBalance() - amount < MIN_BALANCE) {
            System.out.println("Cannot withdraw $" + amount + ". Minimum balance of $" + MIN_BALANCE + " must be maintained.");
        } else {
            setBalance(getBalance() - amount);
            logTransaction("WITHDRAWAL", amount);
            System.out.println("Withdrew $" + String.format("%.2f", amount) + " from savings account");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo(); 
        System.out.println("Account Type: Savings Account");
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("Minimum Balance Requirement: $" + MIN_BALANCE);
    }
}
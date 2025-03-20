package academy.javapro;

/**
 * Main class demonstrating the banking system functionality.
 * Creates and operates on different types of accounts using polymorphism.
 */
public class BankingSystem {

    public static void main(String[] args) {
        System.out.println("======= Banking System Demonstration =======\n");

        SavingsAccount savingsAccount = new SavingsAccount("SA001", "John Doe", 1000.0, 2.5);
        CheckingAccount checkingAccount = new CheckingAccount("CA001", "Jane Smith", 2000.0, 500.0);

        Account[] accounts = {savingsAccount, checkingAccount};

        System.out.println("--- Initial Account Information ---");
        for (Account account : accounts) {
            account.displayInfo();
            System.out.println();
        }

        System.out.println("--- Performing Account Operations ---");
        System.out.println("\n1. Testing deposits:");
        savingsAccount.deposit(500.0);
        checkingAccount.deposit(300.0);

        System.out.println("\n2. Testing withdrawals:");
        savingsAccount.withdraw(1300.0); 
        savingsAccount.withdraw(200.0);  
        checkingAccount.withdraw(2500.0); 

        System.out.println("\n3. Testing account-specific operations:");

        System.out.println("\nSavings Account - Applying interest:");
        savingsAccount.applyInterest();

        System.out.println("\nChecking Account - Modifying overdraft limit:");
        checkingAccount.setOverdraftLimit(1000.0);

        System.out.println("\n--- Updated Account Information ---");
        for (Account account : accounts) {
            account.displayInfo();
            System.out.println();
        }

        System.out.println("--- Transaction History ---");

        System.out.println("\nSavings Account Transactions:");
        for (String transaction : savingsAccount.getTransactionHistory()) {
            System.out.println(transaction);
        }

        System.out.println("\nChecking Account Transactions:");
        for (String transaction : checkingAccount.getTransactionHistory()) {
            System.out.println(transaction);
        }

        System.out.println("\n======= End of Banking System Demonstration =======");
    }
}
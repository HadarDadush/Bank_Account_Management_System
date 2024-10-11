public class BankAccount {
    
    // Account number
    private int number; 
    
    // Account name
    private String accountName; 
    
    // Account balance
    private double balance; 

    // Initialize the account
    public BankAccount(int number, String accountName, double initialBalance) {
        this.number = number; 
        this.accountName = accountName; 
        this.balance = initialBalance; 
    }

    // Get account number
    public int getNumber() {
        return number; 
    }

    // Get account name
    public String getAccountName() {
        return accountName; 
    }

    // Get account balance
    public double getBalance() {
        return balance; 
    }

    // Deposit amount into account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount; // Increase balance
        }
    }

    // Withdraw amount from account
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

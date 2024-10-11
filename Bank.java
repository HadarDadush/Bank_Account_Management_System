import java.util.HashMap;
import javax.swing.JOptionPane;

public class Bank {
    
    // Stores bank accounts
    private HashMap<Integer, BankAccount> accounts; 

    // Initialize the accounts
    public Bank() {
        accounts = new HashMap<>(); 
    }

    // Add an account
    public void addAccount(BankAccount account) {
        accounts.put(account.getNumber(), account); 
    }

    // Deposit the amount
    public void deposit(int number, double amount) {
        BankAccount account = accounts.get(number);
        if (account != null) {
            account.deposit(amount);
            JOptionPane.showMessageDialog(null, "Deposit successful!");
        } else {
            JOptionPane.showMessageDialog(null, "Account not found.");
        }
    }


    // Get the account
    public boolean withdraw(int accountNumber, double amount) {

        BankAccount account = accounts.get(accountNumber); 

        if (account == null) {
        	
            // Print error message
            System.out.println("Account not found."); 
            
            // Return false if account doesn't exist
            return false; 
        }

        if (account.getBalance() < amount) {
        	
            // Print error message
            System.out.println("Insufficient funds."); 
            
            // Return false if not enough funds
            return false; 
        }

        // Withdraw the amount
        account.withdraw(amount); 
        return true;
    }

    // Prepare to show balances
    public String showAllBalances() {
        StringBuilder balances = new StringBuilder(); 

        for (BankAccount account : accounts.values()) {
            balances.append("Account number: ").append(account.getNumber())
                    .append(", Account name: ").append(account.getAccountName())
                    .append(", Balance: ").append(account.getBalance()).append("\n");
        }
        
        // Return all balances as a string
        return balances.toString(); 
    }
}

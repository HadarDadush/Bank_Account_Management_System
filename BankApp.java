import javax.swing.JOptionPane;

public class BankApp {
	
    private Bank bank; 
    
    public BankApp() {
        bank = new Bank(); 
    }
    
    public void start() {
        boolean running = true; 
        while (running) {
            String menu = "Welcome to the Bank System\n" +
                    "1. Create a new account\n" +
                    "2. Deposit money\n" +
                    "3. Withdraw money\n" +
                    "4. Show all balances\n" +
                    "5. Exit\n" +
                    "Please choose an option: ";

            String choiceStr = JOptionPane.showInputDialog(menu);
            
            // If user pressed Cancel or closed the window, choiceStr will be null
            if (choiceStr == null) {
                JOptionPane.showMessageDialog(null, "Exiting the application."); 
                return;
            }

            try {
                int choice = Integer.parseInt(choiceStr);

                switch (choice) {
                    case 1:
                        createAccount();
                        break;
                    case 2:
                        deposit();
                        break;
                    case 3:
                        withdraw();
                        break;
                    case 4:
                        showBalances();
                        break;
                    case 5:
                        running = false;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid choice. Please try again."); 
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number."); 
            }
        }
        JOptionPane.showMessageDialog(null, "Thank you for using the bank system!"); 
    }

    // Create a new account
    private void createAccount() {
        String numberStr = JOptionPane.showInputDialog("Enter account number: ");
        int number = Integer.parseInt(numberStr);
        
        String accountName = JOptionPane.showInputDialog("Enter account name: "); // Input for account name
        
        String balanceStr = JOptionPane.showInputDialog("Enter initial balance: ");
        double balance = Double.parseDouble(balanceStr);
        
        BankAccount account = new BankAccount(number, accountName, balance); // Create new bank account
        bank.addAccount(account); // Add account to bank
        JOptionPane.showMessageDialog(null, "Account created successfully!"); 
    }

    // Deposit money into an account
    private void deposit() {
        String numberStr = JOptionPane.showInputDialog("Enter account number: ");
        int number = Integer.parseInt(numberStr);
        String amountStr = JOptionPane.showInputDialog("Enter amount to deposit: ");
        double amount = Double.parseDouble(amountStr);
        bank.deposit(number, amount);
    }


    // Withdraw money from an account
    private void withdraw() {
        String numberStr = JOptionPane.showInputDialog("Enter account number: ");
        
        // If user pressed Cancel
        if (numberStr == null) {
            return;
        }
        
        int number = Integer.parseInt(numberStr);
        String amountStr = JOptionPane.showInputDialog("Enter amount to withdraw: ");
        
        // If user pressed Cancel
        if (amountStr == null) {
            return;
        }
        
        double amount = Double.parseDouble(amountStr);
        
        // Attempt to withdraw money from the account
        boolean success = bank.withdraw(number, amount);
        
        if (success) {
            JOptionPane.showMessageDialog(null, "Withdrawal successful!"); 
        } else {
            JOptionPane.showMessageDialog(null, "Withdrawal failed. Account does not exist or insufficient funds."); 
        }
    }

    // Show all account balances
    private void showBalances() {
        String balances = bank.showAllBalances();
        JOptionPane.showMessageDialog(null, balances); 
    }

    // Main method to start the application
    public static void main(String[] args) {
        new BankApp().start(); 
    }
}

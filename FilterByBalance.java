public class FilterByBalance implements Filter<BankAccount> {
    
    // Threshold for balance filter
    private double balanceThreshold;

    // Constructor to set balance threshold
    public FilterByBalance(double balanceThreshold) {
        this.balanceThreshold = balanceThreshold;
    }

    @Override
    // Check if account balance meets the threshold
    public boolean accept(BankAccount elem) {
        return elem.getBalance() >= balanceThreshold;
    }
}

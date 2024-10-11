import java.util.Iterator;
import java.util.NoSuchElementException;

public class FilteredBankAccountsIterator implements Iterator<BankAccount> {
    
    // Iterator for bank accounts
    private Iterator<BankAccount> iterator;
    
    // Filter to apply to bank accounts
    private Filter<BankAccount> filter;
    
    // Current bank account
    private BankAccount current;

    // Constructor to initialize iterator and filter
    public FilteredBankAccountsIterator(Iterator<BankAccount> iterator, Filter<BankAccount> filter) {
        this.iterator = iterator;
        this.filter = filter;
        this.current = null; // Start with no current account
    }

    @Override
    // Check if there are more accounts that match the filter
    public boolean hasNext() {
        while (iterator.hasNext()) {
            current = iterator.next();
            if (filter.accept(current)) {
                return true;
            }
        }
        return false;
    }

    @Override
    // Get the next account that matches the filter
    public BankAccount next() {
        if (current == null && !hasNext()) {
            throw new NoSuchElementException("No more accounts that match the filter.");
        }
        BankAccount accountToReturn = current;
        current = null;
        return accountToReturn;
    }
}

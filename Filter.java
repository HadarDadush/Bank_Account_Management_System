public interface Filter<T> {
    
    // Check if an element is accepted
    boolean accept(T elem); 
}

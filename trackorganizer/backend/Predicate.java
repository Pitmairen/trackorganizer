
package backend;

/**
 * A predicate is used to search for tracks and media. 
 */
public interface Predicate {
    
    /**
     * 
     * Determine if a object is a match.
     * 
     * @param obj The object to check for match.
     * @return Boolean indicating a match.
     */
    public boolean isMatch(Object obj);
    
    
}

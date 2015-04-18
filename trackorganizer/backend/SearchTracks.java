

package backend;


public class SearchTracks {
   
     
    /**
     * Container for title search
     */
    public static class ByTitle {
       
        private String word;
        
        public ByTitle(String word){
            this.word = word.toLowerCase();
        }
    
        
        /**
         * Creates a predicate that check for word contained in word.
         * @return The predicate
         */
        public Predicate contains(){
            
            return (Object obj) -> {
                boolean res = false;
                if (obj instanceof Track) {
                    res = ((Track) obj).getTitle().toLowerCase().contains(word);
                }
                return res;
            };
            
        }
        
        /**
         * Creates a predicate that check for exact match with word. (Ignoring case)
         * @return The predicate
         */
        public Predicate exact() {
            
            return (Object obj) -> {
                boolean res = false;
                if (obj instanceof Track){
                    res = ((Track)obj).getTitle().toLowerCase().equals(word);
                }
                return res;
            };
            
        }   
    }
    
    
    
    
    
    /**
     * Container for artist search
     */
    public static class ByArtist {
       
        private String word;
        
        public ByArtist(String word){
            this.word = word.toLowerCase();
        }
    
        
        /**
         * Creates a predicate that check for word contained in artist name.
         * @return The predicate
         */
        public Predicate contains(){
            
            return (Object obj) -> {
                boolean res = false;
                if (obj instanceof MusicTrack) {
                    res = ((MusicTrack) obj).getArtist().toLowerCase().contains(word);
                }
                return res;
            };
            
        }
        
        /**
         * Creates a predicate that check for exact match with word. (Ignoring case)
         * @return The predicate
         */
        public Predicate exact() {
            
            return (Object obj) -> {
                boolean res = false;
                if (obj instanceof MusicTrack) {
                    res = ((MusicTrack) obj).getArtist().toLowerCase().equals(word);
                }
                return res;
            };
            
        }   
    } 
    
    
    
    
}

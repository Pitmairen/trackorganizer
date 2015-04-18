package backend;

/**
 * Internal search classes for Media objects.
 */
public class SearchMedia {

    /**
     * Search by name of media.
     */
    public static class ByName implements Predicate {
        // Variables
        private String searchString;
        // Constructor
        public ByName(String searchString) {
            this.searchString = searchString.toLowerCase();
        }
        // Method
        public boolean isMatch(Object obj) {
            boolean result = false;
            if (obj instanceof Media) {
                Media media = (Media) obj;
                if (media.getName().toLowerCase().equals(searchString)) {
                    result = true;
                }
            }
            return result;
        }
    }

    /**
     * Search by artist.
     */
    public static class ByArtist implements Predicate {
        // Variables
        private String searchString;
        // Constructor
        public ByArtist(String searchString) {
            this.searchString = searchString.toLowerCase();
        }
        // Method
        public boolean isMatch(Object obj) {
            boolean result = false;
            if (obj instanceof PhysicalRelease) {
                PhysicalRelease physicalRelease = (PhysicalRelease) obj;
                if (physicalRelease.getArtistName().toLowerCase().equals(searchString)) {
                    result = true;
                }
            }
            return result;
        }
    }
    
     /**
     * Search by archive nr.
     */
    public static class ByNR implements Predicate {
        // Variables
        private int searchNR;
        // Constructor
        public ByNR(int searchNR) {
            this.searchNR = searchNR;
        }
        // Method
        public boolean isMatch(Object obj) {
            boolean result = false;
            if (obj instanceof PhysicalRelease) {
                PhysicalRelease physicalRelease = (PhysicalRelease) obj;
                if (physicalRelease.getArchiveNR() == (searchNR)) {
                    result = true;
                }
            }
            return result;
        }
    }
}
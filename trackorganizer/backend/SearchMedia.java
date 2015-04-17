package backend;

/**
 * Internal search classes for Media objects.
 */
public class SearchMedia {

    /**
     * Search by name of media.
     */
    public static class ByName extends Predicate {
        // Variables
        private String searchString;
        // Constructor
        public ByName(String searchString) {
            this.searchString = searchString;
        }
        // Method
        public boolean isMatch(Object obj) {
            boolean result = false;
            if (obj instanceof Media) {
                Media media = (Media) obj;
                if (media.getName().equals(searchString)) {
                    result = true;
                }
            }
            return result;
        }
    }

    /**
     * Search by artist.
     */
    public static class ByArtist extends Predicate {
        // Variables
        private String searchString;
        // Constructor
        public ByArtist(String searchString) {
            this.searchString = searchString;
        }
        // Method
        public boolean isMatch(Object obj) {
            boolean result = false;
            if (obj instanceof PhysicalRelease) {
                PhysicalRelease physicalRelease = (PhysicalRelease) obj;
                if (physicalRelease.getArtistName().equals(searchString)) {
                    result = true;
                }
            }
            return result;
        }
    }
    
     /**
     * Search by archive nr.
     */
    public static class ByNR extends Predicate {
        // Variables
        private Integer searchNR;
        // Constructor
        public ByNR(Integer searchNR) {
            this.searchNR = searchNR;
        }
        // Method
        public boolean isMatch(Object obj) {
            boolean result = false;
            if (obj instanceof PhysicalRelease) {
                PhysicalRelease physicalRelease = (PhysicalRelease) obj;
                if (physicalRelease.getArchiveNR().equals(searchNR)) {
                    result = true;
                }
            }
            return result;
        }
    }
}

package backend;

/**
 *
 */
public class SearchMedia {

    public static class ByName extends Predicate {

        private String searchString;

        public ByName(String searchString) {
            this.searchString = searchString;
        }

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
}

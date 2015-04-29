package backend;

import java.util.ArrayList;

/**
 * Represents a track organizer.
 */
public class TrackOrganizer {

    // Instance variables
    private String name;
    private ArrayList<Media> medias;

    /**
     * Constructor.
     *
     * @param name Name of track organizer.
     */
    public TrackOrganizer(String name) {
        this.name = name;
        medias = new ArrayList<Media>();
    }

    /**
     * Find media based on the predicate
     *
     * @param pred The predicate for the search
     * @return An array with the matching media.
     */
    public ArrayList<Media> findMedia(Predicate pred) {

        ArrayList<Media> results = new ArrayList<>();
        for (Media media : medias) {
            if (pred.isMatch(media)) {
                results.add(media);
            }
        }
        return results;
    }

    /**
     * Find tracks based on the predicate
     *
     * @param pred The predicate for the search
     * @return An array with the matching tracks.
     */
    public ArrayList<Track> findTracks(Predicate pred) {

        ArrayList<Track> results = new ArrayList<>();
        for (Media media : medias) {
            SearchTracks.filterTrackList(media.getTracks(), results, pred);
        }
        return results;
    }

    /**
     * Adds a media to the media collection.
     *
     * @param media The media to add
     */
    public void addMedia(Media media) {
        medias.add(media);
    }

    /**
     * Returns the number of media objects
     *
     * @return The number of media objects
     */
    public int getMediaCount() {
        return medias.size();
    }

    /**
     * Returns the number of tracks.
     *
     * @return The number of tracks.
     */
    public int getTrackCount() {

        int total = 0;
        for (Media m : medias) {
            total += m.getTracks().size();
        }
        return total;
    }

    /**
     * Returns the media list
     *
     * @return The media list
     */
    public ArrayList<Media> getMediaList() {

        return new ArrayList<>(medias);
    }

    /**
     * Returns the track at the specified index
     *
     * @return A track object
     */
    public Track getTrackAt(int index) {

        int total = 0;

        for (Media m : medias) {

            if (index < (total + m.getTracks().size())) {

                return m.getTracks().get(index - total);
            }
            total += m.getTracks().size();
        }
        return null;
    }

    /**
     * Returns the media at the specified index
     *
     * @return A media object
     */
    public Media getMediaAt(int index) {

        return medias.get(index);
    }

    /**
     * Delete the specified tracks.
     *
     * @param tracks The tracks to delete.
     */
    public void deleteTracks(ArrayList<Track> tracks) {
        for (Track t : tracks) {
            t.getMedia().removeTrack(t);
        }
    }

    /**
     * Delete a media object from the organizer.
     *
     * @param media The media to remove.
     */
    public void deleteMedia(Media media) {
        medias.remove(media);
    }
}

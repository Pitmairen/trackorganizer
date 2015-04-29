package backend;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents a hard drive used for storing audio files.
 */
public class HD extends Media {

    // Instance variables
    private ArrayList<File> files;

    /**
     * Constructor.
     *
     * @param name Name of the hard drive.
     */
    public HD(String name) {
        super(name);
        files = new ArrayList<File>();
    }

    /**
     * Returns the files contained on the hard drive.
     *
     * @return
     */
    public ArrayList<File> getFiles() {
        return files;
    }

    /**
     * Sets the files on the hard drive.
     *
     * @param files
     */
    public void setFiles(ArrayList<File> files) {
        this.files = files;
    }

    /**
     * Returns the tracks associated with this media.
     *
     * @return tracks
     */
    @Override
    public ArrayList<Track> getTracks() {
        ArrayList<Track> tracks = new ArrayList<>();
        for (File f : files) {
            tracks.add(f.getTrack());
        }
        return tracks;
    }

    /**
     * Adds a track to this media.
     *
     * @param track The track to add
     */
    @Override
    public void addTrack(Track track) {

        throw new UnsupportedOperationException("You must add a file to a HD.");

    }

    /**
     * Adds a file to the HD
     *
     * @param file The file to add.
     */
    public void addFile(File file) {
        files.add(file);
    }

    /**
     * Remove a track from this media
     *
     * @param track The track to remove.
     */
    public void removeTrack(Track track) {

        Iterator<File> it = files.iterator();
        while (it.hasNext()) {
            File file = it.next();
            if (track == file.getTrack()) {
                it.remove();
                return;
            }
        }
    }

    /**
     * Returns the tracks at the specified index.
     *
     * @param index The track index
     * @return A Track object.
     */
    public Track getTrackAt(int index) {
        return files.get(index).getTrack();
    }
}

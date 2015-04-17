package backend;

import java.time.Duration;
import java.time.Year;
import java.util.ArrayList;

/**
 * Represents physical releases like CD's and vinyl LP's.
 */
public class PhysicalRelease extends Media {

    // Instance variables
    private String artistName;
    private Year releaseYear;
    private String recordLabel;
    private ArrayList<Track> tracks;
    private int archiveNR;


    /**
     * Constructor.
     * @param title The name of the release.
     * @param artistName Artist name of the physical release.
     * @param releaseYear Year the release was released.
     * @param recordLabel The record label behind the release.
     * @param archiveNR The archive number where the release is stored.
     */
    public PhysicalRelease(String title, String artistName, Year releaseYear, String recordLabel, int archiveNR) {
        super(title);
        this.artistName = artistName;
        this.releaseYear = releaseYear;
        this.recordLabel = recordLabel;
        this.archiveNR = archiveNR;
        this.tracks = new ArrayList<>();
    }

    


    //Getters
    /**
     * Returns the artist name of the release.
     *
     * @return artistName
     */
    public String getArtistName() {
        return artistName;
    }

    /**
     * Returns the release year of the release.
     *
     * @return releaseYear
     */
    public Year getReleaseYear() {
        return releaseYear;
    }

    /**
     * Returns the record label of the release.
     *
     * @return recordLabel
     */
    public String getRecordLabel() {
        return recordLabel;
    }

    /**
     * Returns the total duration of the tracks on the media.
     * @return The total duration of the tracks.
     */
    public Duration getTotalDuration(){
        Duration total = Duration.ZERO;
        for(Track track: tracks){
            total = total.plus(track.getDuration());
        }
        return total;
    }

    /**
     * Returns the tracks contained in the release.
     *
     * @return tracks
     */
    @Override
    public ArrayList<Track> getTracks() {
        return tracks;
    }

    /**
     * Returns the archive number the release is stored under.
     *
     * @return archiveNR
     */
    public Integer getArchiveNR() {
        return archiveNR;
    }

    //Setters
    /**
     * Sets the name of the artist who made the release.
     *
     * @param artistName
     */
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    /**
     * Sets the release year of the release.
     *
     * @param releaseYear
     */
    public void setReleaseYear(Year releaseYear) {
        this.releaseYear = releaseYear;
    }

    /**
     * Sets the record label of the release.
     *
     * @param recordLabel
     */
    public void setRecordLabel(String recordLabel) {
        this.recordLabel = recordLabel;
    }

    /**
     * Sets the tracks of the release.
     *
     * @param tracks
     */
    public void setTracks(ArrayList<Track> tracks) {
        this.tracks = tracks;
    }

    /**
     * Sets the archive number the release is stored under.
     *
     * @param archiveNR
     */
    public void setArchiveNR(int archiveNR) {
        this.archiveNR = archiveNR;
    }
    
    
    /**
     * Adds a track to this media.
     * 
     * @param track The track to add
     */
    @Override
    public void addTrack(Track track){
        tracks.add(track);
    }

}

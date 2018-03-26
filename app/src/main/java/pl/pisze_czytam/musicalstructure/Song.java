package pl.pisze_czytam.musicalstructure;

public class Song {
    private int mAlbumCover;
    private int mArtistImage;
    private String mSongTitle;
    private String mAlbumTitle;
    private String mArtistName;

    public Song(int albumCover, String songTitle, String albumTitle, String artistName) {
        mAlbumCover = albumCover;
        mSongTitle = songTitle;
        mAlbumTitle = albumTitle;
        mArtistName = artistName;
    }
    public Song(int artistImage, String artistName) {
        mArtistImage = artistImage;
        mArtistName = artistName;
    }
    public Song(int albumCover, String albumTitle, String artistName) {
        mAlbumCover = albumCover;
        mAlbumTitle = albumTitle;
        mArtistName = artistName;
    }

    public int getCoverId() {
        return mAlbumCover;
    }
    public int getArtistId() {
        return mArtistImage;
    }
    public String getSongTitle() {
        return mSongTitle;
    }
    public String getAlbumTitle() {
        return mAlbumTitle;
    }
    public String getArtistName() {
        return mArtistName;
    }
}

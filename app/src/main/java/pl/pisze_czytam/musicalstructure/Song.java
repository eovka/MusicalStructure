package pl.pisze_czytam.musicalstructure;

public class Song {
    private int mAlbumCover;
    private String mSongTitle;
    private String mAlbumTitle;
    private String mArtistName;

    public Song(int albumCover, String songTitle, String albumTitle, String artistName) {
        mAlbumCover = albumCover;
        mSongTitle = songTitle;
        mAlbumTitle = albumTitle;
        mArtistName = artistName;
    }

    public int getAlbumCover() {
        return mAlbumCover;
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

package pl.pisze_czytam.musicalstructure;

public class Song {
    private int mMusicImage;
    private String mSongTitle;
    private String mAlbumTitle;
    private String mArtistName;

    public Song(int musicImage, String songTitle, String albumTitle, String artistName) {
        mMusicImage = musicImage;
        mSongTitle = songTitle;
        mAlbumTitle = albumTitle;
        mArtistName = artistName;
    }

    public int getImageId() {
        return mMusicImage;
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

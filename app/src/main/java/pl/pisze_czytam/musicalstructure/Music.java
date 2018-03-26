package pl.pisze_czytam.musicalstructure;

import android.os.Parcel;
import android.os.Parcelable;

public class Music implements Parcelable {
    private int mAlbumCover;
    private int mArtistImage;
    private String mSongTitle;
    private String mAlbumTitle;
    private String mArtistName;

    public Music(int albumCover, String songTitle, String albumTitle, String artistName) {
        mAlbumCover = albumCover;
        mSongTitle = songTitle;
        mAlbumTitle = albumTitle;
        mArtistName = artistName;
    }
    public Music(int artistImage, String artistName) {
        mArtistImage = artistImage;
        mArtistName = artistName;
    }
    public Music(int albumCover, String albumTitle, String artistName) {
        mAlbumCover = albumCover;
        mAlbumTitle = albumTitle;
        mArtistName = artistName;
    }

    protected Music(Parcel in) {
        mAlbumCover = in.readInt();
        mArtistImage = in.readInt();
        mSongTitle = in.readString();
        mAlbumTitle = in.readString();
        mArtistName = in.readString();
    }

    public static final Creator<Music> CREATOR = new Creator<Music>() {
        @Override
        public Music createFromParcel(Parcel in) {
            return new Music(in);
        }

        @Override
        public Music[] newArray(int size) {
            return new Music[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mAlbumCover);
        dest.writeInt(mArtistImage);
        dest.writeString(mSongTitle);
        dest.writeString(mAlbumTitle);
        dest.writeString(mArtistName);
    }
}

package pl.pisze_czytam.musicalstructure;

import android.os.Parcel;
import android.os.Parcelable;

public class MusicItem implements Parcelable {
    private int mAlbumCover;
    private int mArtistImage;
    private String mSongTitle;
    private String mAlbumTitle;
    private String mArtistName;

    public MusicItem(int albumCover, int artistImage, String songTitle, String albumTitle, String artistName) {
        mAlbumCover = albumCover;
        mArtistImage = artistImage;
        mSongTitle = songTitle;
        mAlbumTitle = albumTitle;
        mArtistName = artistName;
    }

    protected MusicItem(Parcel in) {
        mAlbumCover = in.readInt();
        mArtistImage = in.readInt();
        mSongTitle = in.readString();
        mAlbumTitle = in.readString();
        mArtistName = in.readString();
    }

    public static final Creator<MusicItem> CREATOR = new Creator<MusicItem>() {
        @Override
        public MusicItem createFromParcel(Parcel in) {
            return new MusicItem(in);
        }

        @Override
        public MusicItem[] newArray(int size) {
            return new MusicItem[size];
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

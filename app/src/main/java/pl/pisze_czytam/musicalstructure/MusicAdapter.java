package pl.pisze_czytam.musicalstructure;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.graphics.Typeface.BOLD;
import static pl.pisze_czytam.musicalstructure.AlbumsActivity.ALBUMS_ACTIVE;
import static pl.pisze_czytam.musicalstructure.ArtistsActivity.ARTISTS_ACTIVE;

public class MusicAdapter extends ArrayAdapter<MusicItem> {
    public MusicAdapter(Activity context, ArrayList<MusicItem> musicList) {
        super(context,0, musicList);
    }

    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View listSongView = convertView;
        if (listSongView == null) {
            listSongView = LayoutInflater.from(getContext()).inflate(R.layout.song_view, parent, false);
        }
        MusicItem currentMusicItem = getItem(position);
        ImageView musicImage = listSongView.findViewById(R.id.album_cover_view);
        musicImage.setImageResource(currentMusicItem.getCoverId());
        ImageView artistImage = listSongView.findViewById(R.id.artist_photo);
        artistImage.setImageResource(currentMusicItem.getArtistId());
        TextView songTitle = listSongView.findViewById(R.id.song_title_view);
        songTitle.setText(currentMusicItem.getSongTitle());
        TextView albumTitle = listSongView.findViewById(R.id.album_title_view);
        albumTitle.setText(currentMusicItem.getAlbumTitle());
        TextView artistName = listSongView.findViewById(R.id.artist_name_view);
        artistName.setText(currentMusicItem.getArtistName());

        Typeface typeface = Typeface.create("serif-monospace", BOLD);
        if (ARTISTS_ACTIVE) {
            artistName.setTypeface(typeface);
            artistName.setTextSize(20);
        }
        if (ALBUMS_ACTIVE) {
            albumTitle.setTypeface(typeface);
            albumTitle.setTextSize(18);
        }

        if (songTitle.getText().equals("")) {
            songTitle.setVisibility(View.GONE);
        }
        if (albumTitle.getText().equals("")) {
            albumTitle.setVisibility(View.GONE);
        }
        return listSongView;
    }
}

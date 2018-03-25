package pl.pisze_czytam.musicalstructure;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {
    public SongAdapter(Activity context, ArrayList<Song> allSongs) {
        super(context,0, allSongs);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View listSongView = convertView;
        if (listSongView == null) {
            listSongView = LayoutInflater.from(getContext()).inflate(R.layout.song_view, parent, false);
        }
        Song currentSong = getItem(position);
        ImageView musicImage = listSongView.findViewById(R.id.album_cover_view);
        musicImage.setImageResource(currentSong.getImageId());
        TextView songTitle = listSongView.findViewById(R.id.song_title_view);
        songTitle.setText(currentSong.getSongTitle());
        TextView albumTitle = listSongView.findViewById(R.id.album_title_view);
        albumTitle.setText(currentSong.getAlbumTitle());
        TextView artistName = listSongView.findViewById(R.id.artist_name_view);
        artistName.setText(currentSong.getArtistName());

        return listSongView;
    }
}

package pl.pisze_czytam.musicalstructure;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicAdapter extends ArrayAdapter<MusicItem> {
    public MusicAdapter(Activity context, ArrayList<MusicItem> musicList) {
        super(context,0, musicList);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
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

        if (songTitle.getText().equals("")) {
            songTitle.setVisibility(View.GONE);
        }
        if (albumTitle.getText().equals("")) {
            albumTitle.setVisibility(View.GONE);
        }

        return listSongView;
    }
}

package pl.pisze_czytam.musicalstructure;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import pl.pisze_czytam.musicalstructure.databinding.MusicListBinding;

public class ListActivity extends AppCompatActivity {
    MusicListBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.music_list);
        //noinspection ConstantConditions
        String sortType = getIntent().getExtras().getString("sortType");
        //noinspection ConstantConditions
        getSupportActionBar().setTitle(getString(R.string.choose, sortType));

        if (sortType != null && sortType.equals(getResources().getString(R.string.an_artist))) {
            ArrayList<Song> artists = new ArrayList<>();
            artists.add(new Song(R.drawable.tool_band, null, null, "Tool"));
            artists.add(new Song(R.drawable.kult_band, null, null, "Kult"));

            Collections.sort(artists, new Comparator<Song>(){
                public int compare(Song s1, Song s2) {
                    return s1.getArtistName().compareTo(s2.getArtistName());
                }
            });

            SongAdapter artistsAdapter = new SongAdapter(this, artists);
            bind.list.setAdapter(artistsAdapter);
        } else if (sortType != null && sortType.equals(getResources().getString(R.string.an_album))) {
            ArrayList<Song> albums = new ArrayList<>();
            albums.add(new Song(R.drawable.tool_10000days, null, "10,000 Days", "Tool"));

            SongAdapter albumsAdapter = new SongAdapter(this, albums);
            bind.list.setAdapter(albumsAdapter);
        } else {
            ArrayList<Song> allSongs = new ArrayList<>();
            allSongs.add(new Song(R.drawable.tool_10000days, "Vicarious", "10,000 Days", "Tool"));
            allSongs.add(new Song(R.drawable.tool_10000days, "Jambi", "10,000 Days", "Tool"));
            allSongs.add(new Song(R.drawable.tool_10000days, "Wings for Marie (Pt 1)", "10,000 Days", "Tool"));
            allSongs.add(new Song(R.drawable.tool_10000days, "10,000 Days (Wings Pt 2)", "10,000 Days", "Tool"));
            allSongs.add(new Song(R.drawable.tool_10000days, "The Pot", "10,000 Days", "Tool"));
            allSongs.add(new Song(R.drawable.tool_10000days, "Lipan Conjuring", "10,000 Days", "Tool"));
            allSongs.add(new Song(R.drawable.tool_10000days, "Lost Keys (Blame Hofmann)", "10,000 Days", "Tool"));
            allSongs.add(new Song(R.drawable.tool_10000days, "Rosetta Stoned", "10,000 Days", "Tool"));
            allSongs.add(new Song(R.drawable.tool_10000days, "Intension", "10,000 Days", "Tool"));
            allSongs.add(new Song(R.drawable.tool_10000days, "Right in Two", "10,000 Days", "Tool"));
            allSongs.add(new Song(R.drawable.tool_10000days, "Viginti Tres", "10,000 Days", "Tool"));

            SongAdapter allSongsAdapter = new SongAdapter(this, allSongs);
            bind.list.setAdapter(allSongsAdapter);
        }
    }
}
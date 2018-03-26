package pl.pisze_czytam.musicalstructure;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import pl.pisze_czytam.musicalstructure.databinding.MusicListBinding;

public class ListActivity extends AppCompatActivity {
    MusicListBinding bind;
    ArrayList<Song> allSongs = new ArrayList<>();
    ArrayList<Song> artists = new ArrayList<>();
    ArrayList<Song> albums = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.music_list);
        //noinspection ConstantConditions
        String sortType = getIntent().getExtras().getString("sortType");
        //noinspection ConstantConditions
        getSupportActionBar().setTitle(getString(R.string.choose, sortType));

        if (sortType != null && sortType.equals(getResources().getString(R.string.an_artist))) {
            artists.add(new Song(R.drawable.tool_band, null, null, "Tool"));
            artists.add(new Song(R.drawable.kult_band, null, null, "Kult"));
            artists.add(new Song(R.drawable.rammstein_band, null, null, "Rammstein"));
            artists.add(new Song(R.drawable.leningrad_band, null, null, "Leningrad"));

            // sort all artists alphabetically
            Collections.sort(artists, new Comparator<Song>(){
                public int compare(Song s1, Song s2) {
                    return s1.getArtistName().compareTo(s2.getArtistName());
                }
            });

            SongAdapter artistsAdapter = new SongAdapter(this, artists);
            bind.list.setAdapter(artistsAdapter);

            bind.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intentPlayer = new Intent(ListActivity.this, PlayerActivity.class);
                    String artist = artists.get(position).getArtistName();
                    intentPlayer.putExtra("clickedItem", artist);
                    startActivity(intentPlayer);
                }
            });
        } else if (sortType != null && sortType.equals(getResources().getString(R.string.an_album))) {
            albums.add(new Song(R.drawable.tool_10000days, null, "10,000 Days", "Tool"));

            SongAdapter albumsAdapter = new SongAdapter(this, albums);
            bind.list.setAdapter(albumsAdapter);

            bind.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intentPlayer = new Intent (ListActivity.this, PlayerActivity.class);
                    String album = albums.get(position).getAlbumTitle();
                    intentPlayer.putExtra("clickedItem", album);
                    startActivity(intentPlayer);
                }
            });
        } else {
            allSongs.add(new Song(0, "Vicarious", null, "Tool"));
            allSongs.add(new Song(0, "Jambi", null, "Tool"));
            allSongs.add(new Song(0, "Wings for Marie (Pt 1)", null, "Tool"));
            allSongs.add(new Song(0, "10,000 Days (Wings Pt 2)", null, "Tool"));
            allSongs.add(new Song(0, "The Pot", null, "Tool"));
            allSongs.add(new Song(0, "Lipan Conjuring", null, "Tool"));
            allSongs.add(new Song(0, "Lost Keys (Blame Hofmann)", null, "Tool"));
            allSongs.add(new Song(0, "Rosetta Stoned", null, "Tool"));
            allSongs.add(new Song(0, "Intension", null, "Tool"));
            allSongs.add(new Song(0, "Right in Two", null, "Tool"));
            allSongs.add(new Song(0, "Viginti Tres", null, "Tool"));

            SongAdapter allSongsAdapter = new SongAdapter(this, allSongs);
            bind.list.setAdapter(allSongsAdapter);

            bind.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intentPlayer = new Intent(ListActivity.this, PlayerActivity.class);
                    String song = allSongs.get(position).getSongTitle();
                    intentPlayer.putExtra("clickedItem", song);
                    startActivity(intentPlayer);
                }
            });
        }
    }
}
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

public class ArtistsActivity extends AppCompatActivity {
    static boolean ARTISTS_ACTIVE;
    MusicListBinding bind;
    ArrayList<MusicItem> allSongs;
    ArrayList<MusicItem> songsToPick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARTISTS_ACTIVE = true;
        bind = DataBindingUtil.setContentView(this, R.layout.music_list);
        allSongs = getIntent().getParcelableArrayListExtra("allSongs");
        songsToPick = getIntent().getParcelableArrayListExtra("songsToPick");

        // sort all artists alphabetically
        Collections.sort(songsToPick, new Comparator<MusicItem>() {
            public int compare(MusicItem m1, MusicItem m2) {
                return m1.getArtistName().compareTo(m2.getArtistName());
            }
        });

        // clear all repeated artists' name and all needless attributes in this activity
        for (int i = 0; i < songsToPick.size(); i++) {
            while (songsToPick.get(i).getArtistName().equals(songsToPick.get(i + 1).getArtistName())) {
                songsToPick.remove(i + 1);
                if (i == songsToPick.size() - 1) {
                    break;
                }
            }
            songsToPick.get(i).setCoverId(0);
            songsToPick.get(i).setSongTitle("");
            songsToPick.get(i).setAlbumTitle("");
        }

        bind.list.setAdapter(new MusicAdapter(this, songsToPick));

        bind.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent playerIntent = new Intent(ArtistsActivity.this, PlayerActivity.class);
                String artistName = songsToPick.get(position).getArtistName();
                playerIntent.putExtra("flag", "artists");
                playerIntent.putExtra("clickedItem", artistName);
                playerIntent.putParcelableArrayListExtra("allSongs", allSongs);
                startActivity(playerIntent);
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        ARTISTS_ACTIVE = false;
    }

    @Override
    public void onStop() {
        super.onStop();
        ARTISTS_ACTIVE = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        ARTISTS_ACTIVE = true;
    }
}
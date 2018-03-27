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
    MusicListBinding bind;
    ArrayList<MusicItem> allSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.music_list);
        allSongs = getIntent().getParcelableArrayListExtra("allSongs");

        // sort all artists alphabetically
        Collections.sort(allSongs, new Comparator<MusicItem>() {
            public int compare(MusicItem m1, MusicItem m2) {
                return m1.getArtistName().compareTo(m2.getArtistName());
            }
        });

        // clear all repeated artists and all needless attributes in this activity
        for (int i = 0; i < allSongs.size(); i++) {
            while (allSongs.get(i).getArtistName().equals(allSongs.get(i + 1).getArtistName())) {
                allSongs.remove(i + 1);
                if (i == allSongs.size() - 1) {
                    break;
                }
            }
            allSongs.get(i).setCoverId(0);
            allSongs.get(i).setSongTitle("");
            allSongs.get(i).setAlbumTitle("");
        }

        bind.list.setAdapter(new MusicAdapter(this, allSongs));

        bind.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent playerIntent = new Intent(ArtistsActivity.this, PlayerActivity.class);
                String artistName = allSongs.get(position).getArtistName();
                playerIntent.putExtra("clickedItem", artistName);
                playerIntent.putParcelableArrayListExtra("allSongs", allSongs);
                startActivity(playerIntent);
            }
        });

    }
}
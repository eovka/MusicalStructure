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

public class SongsActivity extends AppCompatActivity {
    MusicListBinding bind;
    ArrayList<MusicItem> allSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.music_list);
        allSongs = getIntent().getParcelableArrayListExtra("allSongs");

        Collections.sort(allSongs, new Comparator<MusicItem>() {
            public int compare(MusicItem m1, MusicItem m2) {
                return m1.getSongTitle().compareTo(m2.getSongTitle());
            }
        });

        bind.list.setAdapter(new MusicAdapter(this, allSongs));

        bind.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent playerIntent = new Intent(SongsActivity.this, PlayerActivity.class);
                String songTitle = allSongs.get(position).getSongTitle();
                playerIntent.putExtra("clickedItem", songTitle);
                playerIntent.putParcelableArrayListExtra("allSongs", allSongs);
                startActivity(playerIntent);
            }
        });
    }
}

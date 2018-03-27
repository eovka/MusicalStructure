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

public class AlbumsActivity extends AppCompatActivity {
    MusicListBinding bind;
    ArrayList<MusicItem> allSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.music_list);
        allSongs = getIntent().getParcelableArrayListExtra("allSongs");

        Collections.sort(allSongs, new Comparator<MusicItem>() {
            public int compare(MusicItem m1, MusicItem m2) {
                return m1.getAlbumTitle().compareTo(m2.getAlbumTitle());
            }
        });

        bind.list.setAdapter(new MusicAdapter(this, allSongs));

        bind.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent playerIntent = new Intent(AlbumsActivity.this, PlayerActivity.class);
                playerIntent.putExtra("clickedItem", allSongs.get(position).getAlbumTitle());
                playerIntent.putParcelableArrayListExtra("allSongs", allSongs);
                startActivity(playerIntent);
            }
        });

    }
}

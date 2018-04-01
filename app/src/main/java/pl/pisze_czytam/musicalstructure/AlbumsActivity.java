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
    static boolean ALBUMS_ACTIVE;
    MusicListBinding bind;
    ArrayList<MusicItem> allSongs;
    ArrayList<MusicItem> songsToPick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ALBUMS_ACTIVE = true;
        bind = DataBindingUtil.setContentView(this, R.layout.music_list);
        allSongs = getIntent().getParcelableArrayListExtra("allSongs");
        songsToPick = getIntent().getParcelableArrayListExtra("songsToPick");

        Collections.sort(songsToPick, new Comparator<MusicItem>() {
            public int compare(MusicItem m1, MusicItem m2) {
                return m1.getAlbumTitle().compareTo(m2.getAlbumTitle());
            }
        });

        for (int i = 0; i < songsToPick.size(); i++) {
            while (songsToPick.get(i).getAlbumTitle().equals(songsToPick.get(i + 1).getAlbumTitle())) {
                songsToPick.remove(i + 1);
                if (i == songsToPick.size() - 1) {
                    break;
                }
            }
            songsToPick.get(i).setArtistId(0);
            songsToPick.get(i).setSongTitle("");
        }

        bind.list.setAdapter(new MusicAdapter(this, songsToPick));

        bind.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent playerIntent = new Intent(AlbumsActivity.this, PlayerActivity.class);
                String albumTitle = songsToPick.get(position).getAlbumTitle();
                playerIntent.putExtra("flag", "albums");
                playerIntent.putExtra("clickedItem", albumTitle);
                playerIntent.putParcelableArrayListExtra("allSongs", allSongs);
                startActivity(playerIntent);
            }
        });
    }
    @Override
    public void onStop() {
        super.onStop();
        ALBUMS_ACTIVE = false;
    }
}

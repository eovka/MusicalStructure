package pl.pisze_czytam.musicalstructure;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

import pl.pisze_czytam.musicalstructure.databinding.ActivityPlayerBinding;

public class PlayerActivity extends AppCompatActivity {
    ActivityPlayerBinding bind;
    boolean isPlaying;
    String musicPlaying;
    ArrayList<MusicItem> allSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.activity_player);

        allSongs = getIntent().getParcelableArrayListExtra("allSongs");

        musicPlaying = getIntent().getExtras().getString("clickedItem");
        getSupportActionBar().setTitle(getString(R.string.music_playing, musicPlaying));
        isPlaying = true;

        // check from which activity a user came (flag), which artist or album he chose (clickedItem)
        // and set a list with a proper artist or album
        String checkFlag = getIntent().getStringExtra("flag");
        if (checkFlag.equals("artists")) {
            String artist = getIntent().getExtras().getString("clickedItem");
            for (int i = -1; i < allSongs.size() - 1; i++) {
                while (!artist.equals(allSongs.get(i + 1).getArtistName())) {
                    allSongs.remove(i + 1);
                    if (i == allSongs.size() - 1) {
                        break;
                    }
                }
            }
            for (int i = 0; i < allSongs.size(); i++) {
                allSongs.get(i).setCoverId(0);
                allSongs.get(i).setArtistId(0);
                allSongs.get(i).setAlbumTitle("");
            }
        } else if (checkFlag.equals("albums")) {
            String album = getIntent().getExtras().getString("clickedItem");
            for (int i = -1; i < allSongs.size() - 1; i++) {
                while (!album.equals(allSongs.get(i + 1).getAlbumTitle())) {
                    allSongs.remove(i + 1);
                    if (i == allSongs.size() - 1) {
                        break;
                    }
                }
            }
            for (int i = 0; i < allSongs.size(); i++) {
                allSongs.get(i).setCoverId(0);
                allSongs.get(i).setArtistId(0);
                allSongs.get(i).setAlbumTitle("");
            }
        }

        bind.pauseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying) {
                    bind.pauseImage.setImageDrawable(getResources().getDrawable(R.drawable.button_play));
                    getSupportActionBar().setTitle(getString(R.string.music_paused, musicPlaying));
                    isPlaying = false;
                } else {
                    bind.pauseImage.setImageDrawable(getResources().getDrawable(R.drawable.button_pause_purple));
                    getSupportActionBar().setTitle(getString(R.string.music_playing, musicPlaying));
                    isPlaying = true;
                }
            }
        });
        bind.include.list.setBackground(null);
        bind.include.list.setAdapter(new MusicAdapter(this, allSongs));
    }
}

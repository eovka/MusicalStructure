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
        if (musicPlaying == null) {
            musicPlaying = "unknown";
        }
        getSupportActionBar().setTitle(getString(R.string.music_playing, musicPlaying));

        isPlaying = true;
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

package pl.pisze_czytam.musicalstructure;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
        int songIndex = 0;

        allSongs = getIntent().getParcelableArrayListExtra("allSongs");

        musicPlaying = getIntent().getExtras().getString("clickedItem");
        getSupportActionBar().setTitle(getString(R.string.music_playing, musicPlaying));
        isPlaying = true;

        // check from which activity a user came (flag), which artist, album or song he chose (clickedItem)
        // and set a list with a random song, an artist's songs, songs from one album or with all songs
        String checkFlag = getIntent().getStringExtra("flag");
        switch (checkFlag) {
            case "oneSong":
                double randomNumber = Math.random();
                randomNumber *= allSongs.size();
                int randomIndex = (int) randomNumber;

                String randomSong = allSongs.get(randomIndex).getSongTitle();
                for (int i = -1; i < allSongs.size() - 1; i++) {
                    while (!randomSong.equals(allSongs.get(i + 1).getSongTitle())) {
                        allSongs.remove(i + 1);
                        if (i == allSongs.size() - 1) {
                            break;
                        }
                    }
                }
                for (int i = 0; i < allSongs.size(); i++) {
                    double randomTwo = Math.random();
                    randomTwo *= 2;
                    int toPickPhoto = (int) randomTwo;
                    if (toPickPhoto == 0) {
                        allSongs.get(i).setCoverId(0);
                    } else {
                        allSongs.get(i).setArtistId(0);
                    }
                }
                break;
            case "artists":
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
                break;
            case "albums":
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
                break;
            case "allSongs":
                Collections.sort(allSongs, new Comparator<MusicItem>() {
                    public int compare(MusicItem m1, MusicItem m2) {
                        return m1.getSongTitle().compareTo(m2.getSongTitle());
                    }
                });
                
                String songTitle = getIntent().getExtras().getString("clickedItem");
                for (int i = 0; i < allSongs.size(); i++) {
                    if (songTitle.equals(allSongs.get(i).getSongTitle())) {
                        songIndex = i;
                    }
                }
                for (int i = 0; i < allSongs.size(); i++) {
                    allSongs.get(i).setCoverId(0);
                    allSongs.get(i).setArtistId(0);
                    allSongs.get(i).setAlbumTitle("");
                }
                bind.include.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        musicPlaying = allSongs.get(position).getSongTitle();
                        getSupportActionBar().setTitle(getString(R.string.music_playing, musicPlaying));
                    }
                });
                break;
        }
        bind.include.list.setBackground(null);
        bind.include.list.setAdapter(new MusicAdapter(this, allSongs));
        bind.include.list.setSelection(songIndex);
        bind.include.list.performItemClick(bind.include.list, songIndex, bind.include.list.getItemIdAtPosition(songIndex));

        bind.pauseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying) {
                    bind.pauseImage.setImageResource(R.drawable.button_play);
                    getSupportActionBar().setTitle(getString(R.string.music_paused, musicPlaying));
                    isPlaying = false;
                } else {
                    bind.pauseImage.setImageResource(R.drawable.button_pause_purple);
                    getSupportActionBar().setTitle(getString(R.string.music_playing, musicPlaying));
                    isPlaying = true;
                }
            }
        });
        bind.repeatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bind.repeatButton.setImageResource(R.drawable.repeat_purple);
            }
        });
        bind.backwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bind.backwardButton.setImageResource(R.drawable.backward_purple);
            }
        });
        bind.forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bind.forwardButton.setImageResource(R.drawable.forward_purple);
            }
        });
        bind.shuffleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bind.shuffleButton.setImageResource(R.drawable.shuffle_purple);
            }
        });
    }
}

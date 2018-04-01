package pl.pisze_czytam.musicalstructure;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import pl.pisze_czytam.musicalstructure.databinding.ActivityPlayerBinding;

public class PlayerActivity extends AppCompatActivity {
    ActivityPlayerBinding bind;
    String musicPlaying;
    int playingSongIndex;
    boolean isPlaying;
    boolean isRepeated;
    boolean isShuffled;
    ArrayList<MusicItem> allSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.activity_player);
        playingSongIndex = 0;

        allSongs = getIntent().getParcelableArrayListExtra("allSongs");

        musicPlaying = getIntent().getExtras().getString("clickedItem");
        getSupportActionBar().setTitle(getString(R.string.music_playing, musicPlaying));
        isPlaying = true;
        isRepeated = false;
        isShuffled = false;

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
                        playingSongIndex = i;
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
        MusicAdapter musicAdapter = new MusicAdapter(this, allSongs);
        bind.include.list.setAdapter(musicAdapter);
        musicAdapter.notifyDataSetChanged();
        bind.include.list.setSelection(playingSongIndex);

        bind.pauseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying) {
                    bind.pauseImage.setImageResource(R.drawable.button_pause_grey);
                    getSupportActionBar().setTitle(getString(R.string.music_paused, musicPlaying));
                    isPlaying = false;
                } else {
                    bind.pauseImage.setImageResource(R.drawable.button_play_purple);
                    getSupportActionBar().setTitle(getString(R.string.music_playing, musicPlaying));
                    isPlaying = true;
                }
            }
        });
        bind.repeatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isRepeated) {
                    bind.repeatButton.setImageResource(R.drawable.repeat_purple);
                    isRepeated = true;
                        Toast toast = Toast.makeText(getApplicationContext(), R.string.repeat_song, Toast.LENGTH_SHORT);
                        toast.show();
                    } else {
                    bind.repeatButton.setImageResource(R.drawable.repeat_grey);
                    isRepeated = false;
                    Toast toast = Toast.makeText(getApplicationContext(), R.string.not_repeat_song, Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });
        bind.backwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bind.backwardButton.setImageResource(R.drawable.backward_purple);
                onBackPressed();
            }
        });
        bind.forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bind.forwardButton.setImageResource(R.drawable.forward_purple);
                Intent mainActivity = new Intent (PlayerActivity.this, MainActivity.class);
                startActivity(mainActivity);
            }
        });
        bind.shuffleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isShuffled) {
                    bind.shuffleButton.setImageResource(R.drawable.shuffle_grey);
                    Collections.sort(allSongs, new Comparator<MusicItem>() {
                        public int compare(MusicItem m1, MusicItem m2) {
                            return m1.getSongTitle().compareTo(m2.getSongTitle());
                        }
                    });
                    isShuffled = false;
                    Toast toast = Toast.makeText(getApplicationContext(), R.string.songs_alphabetically, Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    bind.shuffleButton.setImageResource(R.drawable.shuffle_purple);
                    Collections.shuffle(allSongs);
                    isShuffled = true;
                    Toast toast = Toast.makeText(getApplicationContext(), R.string.songs_randomly, Toast.LENGTH_SHORT);
                    toast.show();
        }
    }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

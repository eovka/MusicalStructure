package pl.pisze_czytam.musicalstructure;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import pl.pisze_czytam.musicalstructure.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.activity_main);

        bind.playImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playerIntent = new Intent(MainActivity.this, PlayerActivity.class);
                playerIntent.putExtra("clickedItem", getString(R.string.all_music));
                startActivity(playerIntent);
            }
        });
        bind.playImage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                bind.playImage.setImageDrawable(getResources().getDrawable(R.drawable.button_play_purple));
                bind.playImage.performClick();
                return false;
            }
        });

        bind.songsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent songsIntent = new Intent(MainActivity.this, ListActivity.class);
                songsIntent.putExtra("sortType", getString(R.string.a_song));
                startActivity(songsIntent);
            }
        });

        bind.songsButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                bind.songsButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                bind.songsButton.setTextColor(getResources().getColor(R.color.textColor));
                bind.songsButton.performClick();
                return false;
            }
        });

        bind.artistsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent artistsIntent = new Intent(MainActivity.this, ListActivity.class);
                artistsIntent.putExtra("sortType", getString(R.string.an_artist));
                startActivity(artistsIntent);
            }
        });

        bind.artistsButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                bind.artistsButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                bind.artistsButton.setTextColor(getResources().getColor(R.color.textColor));
                bind.artistsButton.performClick();
                return false;
            }
        });

        bind.albumsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent albumsIntent = new Intent(MainActivity.this, ListActivity.class);
                albumsIntent.putExtra("sortType", getString(R.string.an_album));
                startActivity(albumsIntent);
            }
        });

        bind.albumsButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                bind.albumsButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                bind.albumsButton.setTextColor(getResources().getColor(R.color.textColor));
                bind.albumsButton.performClick();
                return false;
            }
        });
    }
}

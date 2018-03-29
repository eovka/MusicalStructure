package pl.pisze_czytam.musicalstructure;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

import pl.pisze_czytam.musicalstructure.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding bind;
    ArrayList<MusicItem> allSongs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.activity_main);

        allSongs.add(new MusicItem(R.drawable.tool_10000days, R.drawable.tool_band, "Vicarious", "10,000 Days", "Tool"));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, R.drawable.tool_band,"Jambi", "10,000 Days", "Tool"));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, R.drawable.tool_band,"Wings for Marie (Pt 1)", "10,000 Days", "Tool"));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, R.drawable.tool_band,"10,000 Days (Wings Pt 2)", "10,000 Days", "Tool"));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, R.drawable.tool_band,"The Pot", "10,000 Days", "Tool"));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, R.drawable.tool_band,"Lipan Conjuring", "10,000 Days", "Tool"));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, R.drawable.tool_band,"Lost Keys (Blame Hofmann)", "10,000 Days", "Tool"));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, R.drawable.tool_band,"Rosetta Stoned", "10,000 Days", "Tool"));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, R.drawable.tool_band,"Intension", "10,000 Days", "Tool"));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, R.drawable.tool_band,"Right in Two", "10,000 Days", "Tool"));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, R.drawable.tool_band,"Viginti Tres", "10,000 Days", "Tool"));
        allSongs.add(new MusicItem(R.drawable.leningrad_dlya_milionov, R.drawable.leningrad_band,"Меня зовут Шнур", "Для миллионов", "Leningrad"));
        allSongs.add(new MusicItem(R.drawable.leningrad_dlya_milionov, R.drawable.leningrad_band,"Май", "Для миллионов", "Leningrad"));
        allSongs.add(new MusicItem(R.drawable.leningrad_dlya_milionov, R.drawable.leningrad_band,"Хуйня", "Для миллионов", "Leningrad"));
        allSongs.add(new MusicItem(R.drawable.leningrad_dlya_milionov, R.drawable.leningrad_band,"Менеджер", "Для миллионов", "Leningrad"));
        allSongs.add(new MusicItem(R.drawable.leningrad_dlya_milionov, R.drawable.leningrad_band,"Разпиздяй", "Для миллионов", "Leningrad"));
        allSongs.add(new MusicItem(R.drawable.leningrad_dlya_milionov, R.drawable.leningrad_band,"К тебе бегу", "Для миллионов", "Leningrad"));
        allSongs.add(new MusicItem(R.drawable.leningrad_dlya_milionov, R.drawable.leningrad_band,"Зина", "Для миллионов", "Leningrad"));
        allSongs.add(new MusicItem(R.drawable.leningrad_dlya_milionov, R.drawable.leningrad_band,"Хуямба", "Для миллионов", "Leningrad"));
        allSongs.add(new MusicItem(R.drawable.leningrad_dlya_milionov, R.drawable.leningrad_band,"Папа был прав", "Для миллионов", "Leningrad"));
        allSongs.add(new MusicItem(R.drawable.leningrad_pirati_21_vek, R.drawable.leningrad_band,"WWW", "Пираты XXI века", "Leningrad"));
        allSongs.add(new MusicItem(R.drawable.leningrad_pirati_21_vek, R.drawable.leningrad_band,"У меня есть всё", "Пираты XXI века", "Leningrad"));
        allSongs.add(new MusicItem(R.drawable.leningrad_pirati_21_vek, R.drawable.leningrad_band,"Новый год", "Пираты XXI века", "Leningrad"));
        allSongs.add(new MusicItem(R.drawable.leningrad_pirati_21_vek, R.drawable.leningrad_band,"Бананы", "Пираты XXI века", "Leningrad"));
        allSongs.add(new MusicItem(R.drawable.leningrad_pirati_21_vek, R.drawable.leningrad_band,"Без тебя", "Пираты XXI века", "Leningrad"));
        allSongs.add(new MusicItem(R.drawable.kult_ostateczny_krach, R.drawable.kult_band, "Goopya peezda", "Ostateczny krach systemu korporacji", "Kult"));
        allSongs.add(new MusicItem(R.drawable.kult_ostateczny_krach, R.drawable.kult_band,"Panie Waldku, pan się nie boi, czyli Lewy czerwcowy", "Ostateczny krach systemu korporacji", "Kult"));
        allSongs.add(new MusicItem(R.drawable.kult_ostateczny_krach, R.drawable.kult_band,"Gdy nie ma dzieci", "Ostateczny krach systemu korporacji", "Kult"));
        allSongs.add(new MusicItem(R.drawable.kult_ostateczny_krach, R.drawable.kult_band,"Dziewczyna bez zęba na przedzie", "Ostateczny krach systemu korporacji", "Kult"));
        allSongs.add(new MusicItem(R.drawable.kult_ostateczny_krach, R.drawable.kult_band,"Komu bije dzwon", "Ostateczny krach systemu korporacji", "Kult"));
        allSongs.add(new MusicItem(R.drawable.rammstein_band, R.drawable.rammstein_band,"Du riechst so gut", "Herzeleid", "Rammstein"));

        bind.playImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playerIntent = new Intent(MainActivity.this, PlayerActivity.class);
                playerIntent.putExtra("clickedItem", getString(R.string.all_music));
                playerIntent.putExtra("flag", "allSongs");
                playerIntent.putParcelableArrayListExtra("allSongs", allSongs);
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
                Intent songsIntent = new Intent(MainActivity.this, SongsActivity.class);
                songsIntent.putParcelableArrayListExtra("songsToPick", allSongs);
                songsIntent.putParcelableArrayListExtra("allSongs", allSongs);
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

    // intent with 2 Parcelable - 1st to operate in the next activity, 2nd to pass to the Player
        bind.artistsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent artistsIntent = new Intent(MainActivity.this, ArtistsActivity.class);
                artistsIntent.putParcelableArrayListExtra("songsToPick", allSongs);
                artistsIntent.putParcelableArrayListExtra("allSongs", allSongs);
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
                Intent albumsIntent = new Intent(MainActivity.this, AlbumsActivity.class);
                albumsIntent.putParcelableArrayListExtra("songsToPick", allSongs);
                albumsIntent.putParcelableArrayListExtra("allSongs", allSongs);
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

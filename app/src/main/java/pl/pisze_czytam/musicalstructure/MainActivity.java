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

        allSongs.add(new MusicItem(R.drawable.tool_10000days, "Vicarious", "10,000 Days", "Tool"));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, "Jambi", "10,000 Days", "Tool"));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, "Wings for Marie (Pt 1)", "10,000 Days", "Tool"));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, "10,000 Days (Wings Pt 2)", "10,000 Days", "Tool"));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, "The Pot", "10,000 Days", "Tool"));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, "Lipan Conjuring", "10,000 Days", "Tool"));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, "Lost Keys (Blame Hofmann)", "10,000 Days", "Tool"));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, "Rosetta Stoned", "10,000 Days", "Tool"));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, "Intension", "10,000 Days", "Tool"));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, "Right in Two", "10,000 Days", "Tool"));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, "Viginti Tres", "10,000 Days", "Tool"));
        allSongs.add(new MusicItem(R.drawable.leningrad_dlya_milionov, "Меня зовут Шнур", "Для миллионов", "Leningrad"));
        allSongs.add(new MusicItem(R.drawable.leningrad_dlya_milionov, "Май", "Для миллионов", "Leningrad"));
        allSongs.add(new MusicItem(R.drawable.leningrad_dlya_milionov, "Хуйня", "Для миллионов", "Leningrad"));
        allSongs.add(new MusicItem(R.drawable.leningrad_dlya_milionov, "Менеджер", "Для миллионов", "Leningrad"));
        allSongs.add(new MusicItem(R.drawable.leningrad_dlya_milionov, "Разпиздяй", "Для миллионов", "Leningrad"));
        allSongs.add(new MusicItem(R.drawable.leningrad_dlya_milionov, "К тебе бегу", "Для миллионов", "Leningrad"));
        allSongs.add(new MusicItem(R.drawable.leningrad_dlya_milionov, "Зина", "Для миллионов", "Leningrad"));
        allSongs.add(new MusicItem(R.drawable.leningrad_dlya_milionov, "Хуямба", "Для миллионов", "Leningrad"));
        allSongs.add(new MusicItem(R.drawable.leningrad_dlya_milionov, "Папа был прав", "Для миллионов", "Leningrad"));
        allSongs.add(new MusicItem(R.drawable.leningrad_pirati_21_vek, "WWW", "Пираты XXI века", "Leningrad"));
        allSongs.add(new MusicItem(R.drawable.leningrad_pirati_21_vek, "У меня есть всё", "Пираты XXI века", "Leningrad"));
        allSongs.add(new MusicItem(R.drawable.leningrad_pirati_21_vek, "Новый год", "Пираты XXI века", "Leningrad"));
        allSongs.add(new MusicItem(R.drawable.leningrad_pirati_21_vek, "Бананы", "Пираты XXI века", "Leningrad"));
        allSongs.add(new MusicItem(R.drawable.leningrad_pirati_21_vek, "Без тебя", "Пираты XXI века", "Leningrad"));
        allSongs.add(new MusicItem(R.drawable.kult_ostateczny_krach, "Goopya peezda", "Ostateczny krach systemu korporacji", "Kult"));
        allSongs.add(new MusicItem(R.drawable.kult_ostateczny_krach, "Panie Waldku, pan się nie boi, czyli Lewy czerwcowy", "Ostateczny krach systemu korporacji", "Kult"));
        allSongs.add(new MusicItem(R.drawable.kult_ostateczny_krach, "Gdy nie ma dzieci", "Ostateczny krach systemu korporacji", "Kult"));
        allSongs.add(new MusicItem(R.drawable.kult_ostateczny_krach, "Dziewczyna bez zęba na przedzie", "Ostateczny krach systemu korporacji", "Kult"));
        allSongs.add(new MusicItem(R.drawable.kult_ostateczny_krach, "Komu bije dzwon", "Ostateczny krach systemu korporacji", "Kult"));

        bind.playImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playerIntent = new Intent(MainActivity.this, PlayerActivity.class);
                playerIntent.putExtra("clickedItem", getString(R.string.all_music));
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

        bind.artistsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent artistsIntent = new Intent(MainActivity.this, ArtistsActivity.class);
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

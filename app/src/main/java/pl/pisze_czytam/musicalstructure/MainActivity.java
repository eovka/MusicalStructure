package pl.pisze_czytam.musicalstructure;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        allSongs.add(new MusicItem(R.drawable.tool_10000days, R.drawable.tool_band, "Vicarious", getString(R.string.ten_thousands), getString(R.string.tool)));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, R.drawable.tool_band,"Jambi", getString(R.string.ten_thousands), getString(R.string.tool)));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, R.drawable.tool_band,"Wings for Marie (Pt 1)", getString(R.string.ten_thousands), getString(R.string.tool)));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, R.drawable.tool_band,"10,000 Days (Wings Pt 2)", getString(R.string.ten_thousands), getString(R.string.tool)));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, R.drawable.tool_band,"The Pot", getString(R.string.ten_thousands), getString(R.string.tool)));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, R.drawable.tool_band,"Lipan Conjuring", getString(R.string.ten_thousands), getString(R.string.tool)));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, R.drawable.tool_band,"Lost Keys (Blame Hofmann)", getString(R.string.ten_thousands), getString(R.string.tool)));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, R.drawable.tool_band,"Rosetta Stoned", getString(R.string.ten_thousands), getString(R.string.tool)));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, R.drawable.tool_band,"Intension", getString(R.string.ten_thousands), getString(R.string.tool)));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, R.drawable.tool_band,"Right in Two", getString(R.string.ten_thousands), getString(R.string.tool)));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, R.drawable.tool_band,"Viginti Tres", getString(R.string.ten_thousands), getString(R.string.tool)));
        allSongs.add(new MusicItem(R.drawable.leningrad_dlya_milionov, R.drawable.leningrad_band,"Menya zovut Shnur", getString(R.string.dlya_millionov), getString(R.string.leningrad)));
        allSongs.add(new MusicItem(R.drawable.leningrad_dlya_milionov, R.drawable.leningrad_band,"May", getString(R.string.dlya_millionov), getString(R.string.leningrad)));
        allSongs.add(new MusicItem(R.drawable.leningrad_dlya_milionov, R.drawable.leningrad_band,"Khuynya", getString(R.string.dlya_millionov), getString(R.string.leningrad)));
        allSongs.add(new MusicItem(R.drawable.leningrad_dlya_milionov, R.drawable.leningrad_band,"Menedzher", getString(R.string.dlya_millionov), getString(R.string.leningrad)));
        allSongs.add(new MusicItem(R.drawable.leningrad_dlya_milionov, R.drawable.leningrad_band,"Razpizdyay", getString(R.string.dlya_millionov), getString(R.string.leningrad)));
        allSongs.add(new MusicItem(R.drawable.leningrad_dlya_milionov, R.drawable.leningrad_band,"K tebe begu", getString(R.string.dlya_millionov), getString(R.string.leningrad)));
        allSongs.add(new MusicItem(R.drawable.leningrad_dlya_milionov, R.drawable.leningrad_band,"Zina", getString(R.string.dlya_millionov), getString(R.string.leningrad)));
        allSongs.add(new MusicItem(R.drawable.leningrad_dlya_milionov, R.drawable.leningrad_band,"Khuyamba", getString(R.string.dlya_millionov), getString(R.string.leningrad)));
        allSongs.add(new MusicItem(R.drawable.leningrad_dlya_milionov, R.drawable.leningrad_band,"Papa byl prav", getString(R.string.dlya_millionov), getString(R.string.leningrad)));
        allSongs.add(new MusicItem(R.drawable.leningrad_pirati_21_vek, R.drawable.leningrad_band,"WWW", getString(R.string.piraty_xxi_veka), getString(R.string.leningrad)));
        allSongs.add(new MusicItem(R.drawable.leningrad_pirati_21_vek, R.drawable.leningrad_band,"U menya est vsyo", getString(R.string.piraty_xxi_veka), getString(R.string.leningrad)));
        allSongs.add(new MusicItem(R.drawable.leningrad_pirati_21_vek, R.drawable.leningrad_band,"Novy god", getString(R.string.piraty_xxi_veka), getString(R.string.leningrad)));
        allSongs.add(new MusicItem(R.drawable.leningrad_pirati_21_vek, R.drawable.leningrad_band,"Banany", getString(R.string.piraty_xxi_veka), getString(R.string.leningrad)));
        allSongs.add(new MusicItem(R.drawable.leningrad_pirati_21_vek, R.drawable.leningrad_band,"Bez tebya", getString(R.string.piraty_xxi_veka), getString(R.string.leningrad)));
        allSongs.add(new MusicItem(R.drawable.kult_ostateczny_krach, R.drawable.kult_band, "Goopya peezda", getString(R.string.ostateczny_krach), getString(R.string.kult)));
        allSongs.add(new MusicItem(R.drawable.kult_ostateczny_krach, R.drawable.kult_band,"Panie Waldku, pan się nie boi, czyli Lewy czerwcowy", getString(R.string.ostateczny_krach), getString(R.string.kult)));
        allSongs.add(new MusicItem(R.drawable.kult_ostateczny_krach, R.drawable.kult_band,"Gdy nie ma dzieci", getString(R.string.ostateczny_krach), getString(R.string.kult)));
        allSongs.add(new MusicItem(R.drawable.kult_ostateczny_krach, R.drawable.kult_band,"Dziewczyna bez zęba na przedzie", getString(R.string.ostateczny_krach), getString(R.string.kult)));
        allSongs.add(new MusicItem(R.drawable.kult_ostateczny_krach, R.drawable.kult_band,"Komu bije dzwon", getString(R.string.ostateczny_krach), getString(R.string.kult)));
        allSongs.add(new MusicItem(R.drawable.rammstein_band, R.drawable.rammstein_band,"Du riechst so gut", getString(R.string.herzeleid), getString(R.string.rammstein)));

        bind.playImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bind.playImage.setImageDrawable(getResources().getDrawable(R.drawable.button_play_purple));
                Intent playerIntent = new Intent(MainActivity.this, PlayerActivity.class);
                playerIntent.putExtra("clickedItem", getString(R.string.random_song));
                playerIntent.putExtra("flag", "oneSong");
                playerIntent.putParcelableArrayListExtra("allSongs", allSongs);
                startActivity(playerIntent);
            }
        });

        // intent with 2 Parcelable - 1st to operate in the next activity, 2nd to pass to the Player
        bind.songsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bind.songsButton.setBackground(getResources().getDrawable(R.drawable.button_text_up_purple));
                bind.songsButton.setTextColor(getResources().getColor(R.color.textColor));
                Intent songsIntent = new Intent(MainActivity.this, SongsActivity.class);
                songsIntent.putParcelableArrayListExtra("songsToPick", allSongs);
                songsIntent.putParcelableArrayListExtra("allSongs", allSongs);
                startActivity(songsIntent);
            }
        });

        bind.artistsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bind.artistsButton.setBackground(getResources().getDrawable(R.drawable.button_text_middle_purple));
                bind.artistsButton.setTextColor(getResources().getColor(R.color.textColor));
                Intent artistsIntent = new Intent(MainActivity.this, ArtistsActivity.class);
                artistsIntent.putParcelableArrayListExtra("songsToPick", allSongs);
                artistsIntent.putParcelableArrayListExtra("allSongs", allSongs);
                startActivity(artistsIntent);
            }
        });

        bind.albumsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bind.albumsButton.setBackground(getResources().getDrawable(R.drawable.button_text_down_purple));
                bind.albumsButton.setTextColor(getResources().getColor(R.color.textColor));
                Intent albumsIntent = new Intent(MainActivity.this, AlbumsActivity.class);
                albumsIntent.putParcelableArrayListExtra("songsToPick", allSongs);
                albumsIntent.putParcelableArrayListExtra("allSongs", allSongs);
                startActivity(albumsIntent);
            }
        });
    }
}

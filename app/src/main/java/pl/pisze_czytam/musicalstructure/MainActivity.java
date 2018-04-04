package pl.pisze_czytam.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ArrayList<MusicItem> allSongs = new ArrayList<>();
    ImageView playImage;
    Button songsButton;
    Button artistsButton;
    Button albumsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        allSongs.add(new MusicItem(R.drawable.tool_10000days, R.drawable.tool_band, getString(R.string.vicarious), getString(R.string.ten_thousands), getString(R.string.tool)));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, R.drawable.tool_band, getString(R.string.jambi), getString(R.string.ten_thousands), getString(R.string.tool)));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, R.drawable.tool_band, getString(R.string.wings_for_marie), getString(R.string.ten_thousands), getString(R.string.tool)));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, R.drawable.tool_band, getString(R.string.ten_thousands_wings), getString(R.string.ten_thousands), getString(R.string.tool)));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, R.drawable.tool_band, getString(R.string.the_pot), getString(R.string.ten_thousands), getString(R.string.tool)));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, R.drawable.tool_band, getString(R.string.lipan_conjuring), getString(R.string.ten_thousands), getString(R.string.tool)));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, R.drawable.tool_band, getString(R.string.lost_keys), getString(R.string.ten_thousands), getString(R.string.tool)));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, R.drawable.tool_band, getString(R.string.rosetta_stoned), getString(R.string.ten_thousands), getString(R.string.tool)));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, R.drawable.tool_band, getString(R.string.intension), getString(R.string.ten_thousands), getString(R.string.tool)));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, R.drawable.tool_band, getString(R.string.right_in_two), getString(R.string.ten_thousands), getString(R.string.tool)));
        allSongs.add(new MusicItem(R.drawable.tool_10000days, R.drawable.tool_band, getString(R.string.viginti_tres), getString(R.string.ten_thousands), getString(R.string.tool)));
        allSongs.add(new MusicItem(R.drawable.leningrad_dlya_milionov, R.drawable.leningrad_band, getString(R.string.menya_zovut_shnur), getString(R.string.dlya_millionov), getString(R.string.leningrad)));
        allSongs.add(new MusicItem(R.drawable.leningrad_dlya_milionov, R.drawable.leningrad_band, getString(R.string.may), getString(R.string.dlya_millionov), getString(R.string.leningrad)));
        allSongs.add(new MusicItem(R.drawable.leningrad_dlya_milionov, R.drawable.leningrad_band, getString(R.string.khuynya), getString(R.string.dlya_millionov), getString(R.string.leningrad)));
        allSongs.add(new MusicItem(R.drawable.leningrad_dlya_milionov, R.drawable.leningrad_band, getString(R.string.menedzher), getString(R.string.dlya_millionov), getString(R.string.leningrad)));
        allSongs.add(new MusicItem(R.drawable.leningrad_dlya_milionov, R.drawable.leningrad_band, getString(R.string.razpizdyay), getString(R.string.dlya_millionov), getString(R.string.leningrad)));
        allSongs.add(new MusicItem(R.drawable.leningrad_dlya_milionov, R.drawable.leningrad_band, getString(R.string.k_tebe_begu), getString(R.string.dlya_millionov), getString(R.string.leningrad)));
        allSongs.add(new MusicItem(R.drawable.leningrad_dlya_milionov, R.drawable.leningrad_band, getString(R.string.zina), getString(R.string.dlya_millionov), getString(R.string.leningrad)));
        allSongs.add(new MusicItem(R.drawable.leningrad_dlya_milionov, R.drawable.leningrad_band, getString(R.string.khuyamba), getString(R.string.dlya_millionov), getString(R.string.leningrad)));
        allSongs.add(new MusicItem(R.drawable.leningrad_dlya_milionov, R.drawable.leningrad_band, getString(R.string.papa_byl_prav), getString(R.string.dlya_millionov), getString(R.string.leningrad)));
        allSongs.add(new MusicItem(R.drawable.leningrad_pirati_21_vek, R.drawable.leningrad_band, getString(R.string.www), getString(R.string.piraty_xxi_veka), getString(R.string.leningrad)));
        allSongs.add(new MusicItem(R.drawable.leningrad_pirati_21_vek, R.drawable.leningrad_band, getString(R.string.u_menya_est_vsyo), getString(R.string.piraty_xxi_veka), getString(R.string.leningrad)));
        allSongs.add(new MusicItem(R.drawable.leningrad_pirati_21_vek, R.drawable.leningrad_band, getString(R.string.novy_god), getString(R.string.piraty_xxi_veka), getString(R.string.leningrad)));
        allSongs.add(new MusicItem(R.drawable.leningrad_pirati_21_vek, R.drawable.leningrad_band, getString(R.string.banany), getString(R.string.piraty_xxi_veka), getString(R.string.leningrad)));
        allSongs.add(new MusicItem(R.drawable.leningrad_pirati_21_vek, R.drawable.leningrad_band, getString(R.string.bez_tebya), getString(R.string.piraty_xxi_veka), getString(R.string.leningrad)));
        allSongs.add(new MusicItem(R.drawable.kult_ostateczny_krach, R.drawable.kult_band, getString(R.string.goopya_peezda), getString(R.string.ostateczny_krach), getString(R.string.kult)));
        allSongs.add(new MusicItem(R.drawable.kult_ostateczny_krach, R.drawable.kult_band, getString(R.string.panie_waldku), getString(R.string.ostateczny_krach), getString(R.string.kult)));
        allSongs.add(new MusicItem(R.drawable.kult_ostateczny_krach, R.drawable.kult_band, getString(R.string.gdy_nie_ma_dzieci), getString(R.string.ostateczny_krach), getString(R.string.kult)));
        allSongs.add(new MusicItem(R.drawable.kult_ostateczny_krach, R.drawable.kult_band, getString(R.string.dziewczyna_bez_zeba), getString(R.string.ostateczny_krach), getString(R.string.kult)));
        allSongs.add(new MusicItem(R.drawable.kult_ostateczny_krach, R.drawable.kult_band, getString(R.string.komu_bije_dzwon), getString(R.string.ostateczny_krach), getString(R.string.kult)));
        allSongs.add(new MusicItem(R.drawable.rammstein_band, R.drawable.rammstein_band, getString(R.string.komu_bije_dzwon), getString(R.string.herzeleid), getString(R.string.rammstein)));

        playImage = findViewById(R.id.play_image);
        songsButton = findViewById(R.id.songs_button);
        artistsButton = findViewById(R.id.artists_button);
        albumsButton = findViewById(R.id.albums_button);
        playImage.setOnClickListener(this);
        songsButton.setOnClickListener(this);
        artistsButton.setOnClickListener(this);
        albumsButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play_image:
                playImage.setImageDrawable(getResources().getDrawable(R.drawable.button_play_purple));
                Intent playerIntent = new Intent(MainActivity.this, PlayerActivity.class);
                playerIntent.putExtra("clickedItem", getString(R.string.random_song));
                playerIntent.putExtra("flag", "oneSong");
                playerIntent.putParcelableArrayListExtra("allSongs", allSongs);
                startActivity(playerIntent);
                break;
            case R.id.songs_button:
                songsButton.setBackground(getResources().getDrawable(R.drawable.button_text_up_purple));
                songsButton.setTextColor(getResources().getColor(R.color.textColor));
                Intent songsIntent = new Intent(MainActivity.this, SongsActivity.class);
                songsIntent.putParcelableArrayListExtra("songsToPick", allSongs);
                songsIntent.putParcelableArrayListExtra("allSongs", allSongs);
                startActivity(songsIntent);
                break;
            case R.id.artists_button:
                artistsButton.setBackground(getResources().getDrawable(R.drawable.button_text_middle_purple));
                artistsButton.setTextColor(getResources().getColor(R.color.textColor));
                Intent artistsIntent = new Intent(MainActivity.this, ArtistsActivity.class);
                artistsIntent.putParcelableArrayListExtra("songsToPick", allSongs);
                artistsIntent.putParcelableArrayListExtra("allSongs", allSongs);
                startActivity(artistsIntent);
                break;
            case R.id.albums_button:
                albumsButton.setBackground(getResources().getDrawable(R.drawable.button_text_down_purple));
                albumsButton.setTextColor(getResources().getColor(R.color.textColor));
                Intent albumsIntent = new Intent(MainActivity.this, AlbumsActivity.class);
                albumsIntent.putParcelableArrayListExtra("songsToPick", allSongs);
                albumsIntent.putParcelableArrayListExtra("allSongs", allSongs);
                startActivity(albumsIntent);
                break;
        }
    }
}
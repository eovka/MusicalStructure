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
    MusicListBinding bind;
    ArrayList<MusicItem> albums = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.music_list);

        albums.add(new MusicItem(R.drawable.tool_10000days, "10,000 Days","Tool"));
        albums.add(new MusicItem(R.drawable.leningrad_pirati_21_vek, "Пираты XXI века","Leningrad"));
        albums.add(new MusicItem(R.drawable.leningrad_dlya_milionov, "Для миллионов","Leningrad"));
        albums.add(new MusicItem(R.drawable.kult_ostateczny_krach, "Ostateczny krach system korporacji","Kult"));

        Collections.sort(albums, new Comparator<MusicItem>() {
            public int compare(MusicItem m1, MusicItem m2) {
                return m1.getAlbumTitle().compareTo(m2.getAlbumTitle());
            }
        });

        bind.list.setAdapter(new MusicAdapter(this, albums));

        bind.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent playerIntent = new Intent(AlbumsActivity.this, PlayerActivity.class);
                playerIntent.putExtra("clickedItem", albums.get(position).getAlbumTitle());
                startActivity(playerIntent);
            }
        });

    }
}

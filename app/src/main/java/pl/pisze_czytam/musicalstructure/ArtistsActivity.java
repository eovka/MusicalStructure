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


public class ArtistsActivity extends AppCompatActivity {
    MusicListBinding bind;
    ArrayList<Music> artists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.music_list);

        artists.add(new Music(R.drawable.tool_band, "Tool"));
        artists.add(new Music(R.drawable.leningrad_band, "Leningrad"));
        artists.add(new Music(R.drawable.kult_band, "Kult"));

        // sort all artists alphabetically
        Collections.sort(artists, new Comparator<Music>(){
            public int compare(Music m1, Music m2) {
                return m1.getArtistName().compareTo(m2.getArtistName());
            }
        });
        bind.list.setAdapter(new MusicAdapter(this, artists));

        bind.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent playerIntent = new Intent(ArtistsActivity.this, PlayerActivity.class);
                playerIntent.putExtra("clickedItem", artists.get(position).getArtistName());
                startActivity(playerIntent);
            }
        });

    }
}

package pl.pisze_czytam.musicalstructure;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import pl.pisze_czytam.musicalstructure.databinding.MusicListBinding;

public class ListActivity extends AppCompatActivity {
    MusicListBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.music_list);
        //noinspection ConstantConditions
        String sortType = getIntent().getExtras().getString("sortType");
        //noinspection ConstantConditions
        getSupportActionBar().setTitle(getString(R.string.choose, sortType));
    }
}
package pl.pisze_czytam.musicalstructure;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import pl.pisze_czytam.musicalstructure.databinding.ActivityPlayerBinding;

public class PlayerActivity extends AppCompatActivity {
    ActivityPlayerBinding bind;
    boolean isPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.activity_player);

        isPlaying = true;
        bind.pauseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying) {
                    bind.pauseImage.setImageDrawable(getResources().getDrawable(R.drawable.button_play));
                    //noinspection ConstantConditions
                    getSupportActionBar().setTitle(getString(R.string.music_stopped));
                    isPlaying = false;
                } else {
                    bind.pauseImage.setImageDrawable(getResources().getDrawable(R.drawable.button_pause_purple));
                    //noinspection ConstantConditions
                    getSupportActionBar().setTitle(getString(R.string.now_playing));
                    isPlaying = true;
                }
            }
        });
    }
}

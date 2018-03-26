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

public class SongsActivity extends AppCompatActivity {
    MusicListBinding bind;
    ArrayList<Music> allSongs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.music_list);

        allSongs.add(new Music(R.drawable.tool_10000days, "Vicarious", "10,000 Days", "Tool"));
        allSongs.add(new Music(R.drawable.tool_10000days, "Jambi", "10,000 Days", "Tool"));
        allSongs.add(new Music(R.drawable.tool_10000days, "Wings for Marie (Pt 1)", "10,000 Days", "Tool"));
        allSongs.add(new Music(R.drawable.tool_10000days, "10,000 Days (Wings Pt 2)", "10,000 Days", "Tool"));
        allSongs.add(new Music(R.drawable.tool_10000days, "The Pot", "10,000 Days", "Tool"));
        allSongs.add(new Music(R.drawable.tool_10000days, "Lipan Conjuring", "10,000 Days", "Tool"));
        allSongs.add(new Music(R.drawable.tool_10000days, "Lost Keys (Blame Hofmann)", "10,000 Days", "Tool"));
        allSongs.add(new Music(R.drawable.tool_10000days, "Rosetta Stoned", "10,000 Days", "Tool"));
        allSongs.add(new Music(R.drawable.tool_10000days, "Intension", "10,000 Days", "Tool"));
        allSongs.add(new Music(R.drawable.tool_10000days, "Right in Two", "10,000 Days", "Tool"));
        allSongs.add(new Music(R.drawable.tool_10000days, "Viginti Tres", "10,000 Days", "Tool"));
        allSongs.add(new Music(R.drawable.leningrad_dlya_milionov, "Меня зовут Шнур", "Для миллионов", "Leningrad"));
        allSongs.add(new Music(R.drawable.leningrad_dlya_milionov, "Май", "Для миллионов", "Leningrad"));
        allSongs.add(new Music(R.drawable.leningrad_dlya_milionov, "Хуйня", "Для миллионов", "Leningrad"));
        allSongs.add(new Music(R.drawable.leningrad_dlya_milionov, "Менеджер", "Для миллионов", "Leningrad"));
        allSongs.add(new Music(R.drawable.leningrad_dlya_milionov, "Разпиздяй", "Для миллионов", "Leningrad"));
        allSongs.add(new Music(R.drawable.leningrad_dlya_milionov, "К тебе бегу", "Для миллионов", "Leningrad"));
        allSongs.add(new Music(R.drawable.leningrad_dlya_milionov, "Зина", "Для миллионов", "Leningrad"));
        allSongs.add(new Music(R.drawable.leningrad_dlya_milionov, "Хуямба", "Для миллионов", "Leningrad"));
        allSongs.add(new Music(R.drawable.leningrad_dlya_milionov, "Папа был прав", "Для миллионов", "Leningrad"));
        allSongs.add(new Music(R.drawable.leningrad_pirati_21_vek, "WWW", "Пираты XXI века", "Leningrad"));
        allSongs.add(new Music(R.drawable.leningrad_pirati_21_vek, "У меня есть всё", "Пираты XXI века", "Leningrad"));
        allSongs.add(new Music(R.drawable.leningrad_pirati_21_vek, "Новый год", "Пираты XXI века", "Leningrad"));
        allSongs.add(new Music(R.drawable.leningrad_pirati_21_vek, "Бананы", "Пираты XXI века", "Leningrad"));
        allSongs.add(new Music(R.drawable.leningrad_pirati_21_vek, "Без тебя", "Пираты XXI века", "Leningrad"));
        allSongs.add(new Music(R.drawable.kult_ostateczny_krach, "Goopya peezda", "Ostateczny krach systemu korporacji", "Kult"));
        allSongs.add(new Music(R.drawable.kult_ostateczny_krach, "Panie Waldku, pan się nie boi, czyli Lewy czerwcowy", "Ostateczny krach systemu korporacji", "Kult"));
        allSongs.add(new Music(R.drawable.kult_ostateczny_krach, "Gdy nie ma dzieci", "Ostateczny krach systemu korporacji", "Kult"));
        allSongs.add(new Music(R.drawable.kult_ostateczny_krach, "Dziewczyna bez zęba na przedzie", "Ostateczny krach systemu korporacji", "Kult"));
        allSongs.add(new Music(R.drawable.kult_ostateczny_krach, "Komu bije dzwon", "Ostateczny krach systemu korporacji", "Kult"));

        Collections.sort(allSongs, new Comparator<Music>() {
            public int compare(Music m1, Music m2) {
                return m1.getSongTitle().compareTo(m2.getSongTitle());
            }
        });

        bind.list.setAdapter(new MusicAdapter(this, allSongs));

        bind.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent playerIntent = new Intent(SongsActivity.this, PlayerActivity.class);
                String song = allSongs.get(position).getSongTitle();
                playerIntent.putExtra("clickedItem", song);
                startActivity(playerIntent);
            }
        });
    }
}

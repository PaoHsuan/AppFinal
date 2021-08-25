package com.example.loginsqlite.ui.MyMusic;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.loginsqlite.MusicInfo;
import com.example.loginsqlite.MusicTypeActivity;
import com.example.loginsqlite.R;


public class MyMusicFragment extends Fragment {

    private MyMusicViewModel MyMusicViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MyMusicViewModel =
                new ViewModelProvider(this).get(MyMusicViewModel.class);

        //binding = FragmentMenuBinding.inflate(inflater, container, false);
        View root = inflater.inflate(R.layout.fragment_mymusic, container, false);

        /*final TextView textView = root.findViewById(R.id.text_mymusic);
        MyMusicViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }
    public void musicInfo2(View view){
        TextView CurrentMusic = (TextView)view.findViewById(R.id.songName);
        TextView CurrentSinger = (TextView)view.findViewById(R.id.songSinger);
        TextView CurrentAlbum = (TextView)view.findViewById(R.id.songAlbum);
        String currentMusic = CurrentMusic.getText().toString();
        String currentSinger = CurrentSinger.getText().toString();
        String currentAlbum = CurrentAlbum.getText().toString();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MyMusicFragment.this.getContext(), MusicInfo.class);
                Bundle bundle = new Bundle();
                bundle.putString("CurrentMusic", currentMusic);
                bundle.putString("CurrentSinger", currentSinger);
                bundle.putString("CurrentAlbum", currentAlbum);
                Log.d("currentMusic: ",currentMusic);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        }, 1000);
    }

}
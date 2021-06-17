package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class MusicTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_type);
        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("MESSAGE");
        Log.d("Debug","number:"+message);

        String jsonFileString = Utils.getJsonFromAssets(getApplicationContext(), "music.json");
        Log.i("data", jsonFileString);

        Gson gson = new Gson();
        Type listMusicType = new TypeToken<List<MusicResult>>() { }.getType();

        /*List<MusicResult> music = gson.fromJson(jsonFileString, listMusicType);
        for (int i = 0; i < music.size(); i++) {
            Log.i("data", "> Item " + i + "\n" + music.get(i));
        }*/
    }

}
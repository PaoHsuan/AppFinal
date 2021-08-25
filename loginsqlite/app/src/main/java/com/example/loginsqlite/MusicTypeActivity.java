package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.loginsqlite.ui.Menu.MenuFragment;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MusicTypeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Songs>songss;
    Adapter adapter;
    private JSONObject response;
    String type;
    //String currentMusic;
    //private JSONObject songObject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_type);
        recyclerView = findViewById(R.id.songsList);
        songss = new ArrayList<>();
        Log.d("Debug","001");
        try {
            JSONObject songObject = new JSONObject(JsonDataFormAsst());
            JSONArray jsonArray = songObject.getJSONArray("music");

            Log.d("Debug","002");

            for (int i = 0; i < jsonArray.length(); i++) {
                Log.i(String.valueOf(jsonArray.length()),"jsonArray"); //1
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Bundle bundle = getIntent().getExtras();
                String message = bundle.getString("MESSAGE");
                Log.d("Debug","number:"+message);
                switch(message)
                {
                    case "1":
                        type = "chinese";
                        break;
                    case "2":
                        type = "english";
                        break;
                    case "3":
                        type = "korean";
                        break;
                    case "4":
                        type = "japanese";
                        break;
                    case "5":
                        type = "classical";
                        break;
                    case "6":
                        type = "electronic";
                        break;
                    default :
                        type = "chinese";
                }

                JSONArray array = jsonObject.getJSONArray(type);
                Log.d("Debug","33");

                for(int k =0;k<array.length();k++) {
                    Log.i(String.valueOf(array.length()),"array");//3
                    JSONObject t_jsonObject = array.getJSONObject(k);
                    String Mname = t_jsonObject.getString("Mname");
                    String singer = t_jsonObject.getString("singer");
                    String album = t_jsonObject.getString("album");
                     //cover_image = t_jsonObject.getString("cover_image");
                    String id = Integer.toString(k);

                    Songs songs = new Songs();
                    songs.setName(Mname);
                    songs.setSinger(singer);
                    songs.setAlbum(album);
                    songs.setCoverImage(t_jsonObject.getString("cover_image"));
                    songs.setId(id);
                    songss.add(songs);
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));//getApplicationContext()
        Adapter adapter = new Adapter(MusicTypeActivity.this,songss);
        recyclerView.setAdapter(adapter);
        Log.d("Debug","004");
        //queue.add(jsonArrayRequest);
        /*Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("MESSAGE");
        Log.d("Debug","number:"+message);

        String jsonFileString = Utils.getJsonFromAssets(getApplicationContext(), "music.json");
        Log.i("data", jsonFileString);


        Gson gson = new Gson();
        Type listMusicType = new TypeToken<List<MusicResult>>() { }.getType();*/
        /*List<MusicResult> music = gson.fromJson(jsonFileString, listMusicType);
        for (int i = 0; i < music.size(); i++) {
            Log.i("data", "> Item " + i + "\n" + music.get(i));
        }*/
    }

    private String JsonDataFormAsst() {
        String json =null;
        Log.d("Debug","005");
        try {
            InputStream is = getAssets().open("music.json");

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return json;
        }
        return json;

    }

    public void musicInfo(View view){
        TextView CurrentMusic = (TextView)view.findViewById(R.id.songName);
        TextView CurrentSinger = (TextView)view.findViewById(R.id.songSinger);
        TextView CurrentAlbum = (TextView)view.findViewById(R.id.songAlbum);
        String currentMusic = CurrentMusic.getText().toString();
        String currentSinger = CurrentSinger.getText().toString();
        String currentAlbum = CurrentAlbum.getText().toString();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MusicTypeActivity.this, MusicInfo.class);
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

    /*private void extractSongs() throws JSONException {
        JSONObject songObject = null;
        JSONArray jsonArray ;
        public void onResponse (JSONArray response){
            for (int i = 0; i < response.length(); i++) {
                try {
                    songObject = response.getJSONObject(String.valueOf(i));

                    Songs songs = new Songs();
                    songs.setName(songObject.getString("song").toString());
                    songs.setSinger(songObject.getString("artists".toString()));
                    songs.setCoverImage(songObject.getString("cover_image"));

                    songs.add(songs);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }
    }*/



    }


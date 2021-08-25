package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MusicInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_info);

        Bundle bundle = getIntent().getExtras();
        String currentMusic = bundle.getString("CurrentMusic");
        String currentSinger = bundle.getString("CurrentSinger");
        String currentAlbum = bundle.getString("CurrentAlbum");
        Log.d("currentMusic2: ",currentMusic);

        TextView name_i = (TextView)findViewById(R.id.name_i);
        TextView singer_i = (TextView)findViewById(R.id.singer_i);
        TextView album_i = (TextView)findViewById(R.id.album_i);
        TextView message = (TextView)findViewById(R.id.message);
        EditText input = (EditText)findViewById(R.id.EditText);
        Button send = (Button)findViewById(R.id.send);
        Button love = (Button)findViewById(R.id.love);

        name_i.setText(currentMusic);
        singer_i.setText(currentSinger);
        album_i.setText(currentAlbum);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Message = input.getText().toString();
                message.setText(Message);
            }
        });

        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MusicInfo.this, "Save to MyMusic", Toast.LENGTH_SHORT).show();
            }
        });


    }

}
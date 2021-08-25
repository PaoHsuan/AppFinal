package com.example.loginsqlite;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

//    public static int id;
    LayoutInflater inflater;
    List<Songs> songss;
    Context context;

    public Adapter(Context context, List<Songs> songss) {
        this.inflater = LayoutInflater.from(context);
        this.songss = songss;
        Log.i("Debug","100");
    }

    
    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        holder.songName.setText(songss.get(position).getName());
        holder.songSinger.setText(songss.get(position).getSinger());
        holder.songAlbum.setText(songss.get(position).getAlbum());
        Picasso.get().load(songss.get(position).getCoverImage()).into(holder.songCoverImage);
        Log.i("Debug","101");
    }

    @Override
    public int getItemCount() {
        return songss.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{

        protected CardView cv;
        TextView songName,songSinger,songAlbum;
        ImageView songCoverImage;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
//            cv = (CardView)itemView.findViewById(R.id.card_view);
            Log.i("Debug","102");
            songName = itemView.findViewById(R.id.songName);
            songSinger = itemView.findViewById(R.id.songSinger);
            songAlbum = itemView.findViewById(R.id.songAlbum);
            songCoverImage = itemView.findViewById(R.id.coverImage);

//            cv.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    id = cv.getId();
//                    String ID = Integer.toString(id);
//                    Log.d("currentMusic2: ",ID);
//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
////                      String currentMusic = "info";
//                        Intent intent = new Intent(context, MusicInfo.class);
//                        Bundle bundle = new Bundle();
//                        bundle.putInt("currentMusic", id);
//                        String ID = Integer.toString(id);
//                        Log.d("currentMusic: ",ID);
//                        intent.putExtras(bundle);
//                        context.startActivity(intent);
//                        }
//                    }, 1000);
//                }
//            });
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}

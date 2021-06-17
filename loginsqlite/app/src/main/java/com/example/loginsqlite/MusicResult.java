package com.example.loginsqlite;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MusicResult implements Serializable {
    @SerializedName("music")
    @Expose
    private List<String> music = null;

    public List<String> getMusic(){
        return music;
    }

    public void setMusic(List<String> music){
        this.music = music;
    }
}

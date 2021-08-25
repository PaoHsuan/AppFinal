package com.example.loginsqlite;

public class Songs {
    private String name;
    private String singer;
    private String coverImage;
    private String album;
    private String id;

    public Songs(){}
    public Songs(String name,String singer,String album,String coverImagem,String id){
        this.name = name;
        this.singer = singer;
        this.coverImage = coverImage;
        this.album = album;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getId(){return id;}

    public void setId(String id){this.id = id;};

    public void add(Songs songs) {
    }
}

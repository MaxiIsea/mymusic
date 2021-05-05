package ar.edu.unnoba.pdyc.mymusic.dto;

import ar.edu.unnoba.pdyc.mymusic.model.Song;

import java.util.List;

public class PlaylistWithSongsDTO {

    private String playlistName;
    private List<Song> songs;

    public List<Song> getSongs() {
        return songs;
    }

    public PlaylistWithSongsDTO(String playlistName, List<Song> songs) {
        this.playlistName = playlistName;
        this.songs = songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

}

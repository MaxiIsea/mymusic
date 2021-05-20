package ar.edu.unnoba.pdyc.mymusic.service;

import ar.edu.unnoba.pdyc.mymusic.model.Genre;
import ar.edu.unnoba.pdyc.mymusic.model.Song;

import java.util.List;

public interface SongService {
    public List<Song> getSongs();
    public List<Song> getSongsByAuthorGenre(String author, Genre genre);
    public void create(Song song,String ownerEmail);
    public void update(long id,Song song, String loggedEmail) throws Exception;
    void delete(long id,String loggedEmail) throws Exception;
}

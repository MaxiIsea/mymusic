package ar.edu.unnoba.pdyc.mymusic.service;

import ar.edu.unnoba.pdyc.mymusic.model.DBGenre;
import ar.edu.unnoba.pdyc.mymusic.model.Genre;
import ar.edu.unnoba.pdyc.mymusic.model.Song;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SongService {
    public List<Song> getSongs();
    public List<Song> getSongsByAuthorGenre(String author, long genreid);
    public long getGenreDBId(Genre genre);
}

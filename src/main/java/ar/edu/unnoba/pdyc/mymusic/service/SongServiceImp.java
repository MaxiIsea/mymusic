package ar.edu.unnoba.pdyc.mymusic.service;

import ar.edu.unnoba.pdyc.mymusic.model.DBGenre;
import ar.edu.unnoba.pdyc.mymusic.model.Genre;
import ar.edu.unnoba.pdyc.mymusic.model.Song;
import ar.edu.unnoba.pdyc.mymusic.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SongServiceImp implements SongService {

    @Autowired
    private SongRepository songRepository;

    @Override
    public List<Song> getSongs() {
        return songRepository.findAll();
    }

    @Override
    public List<Song> getSongsByAuthorGenre(String author, long genreid) {return songRepository.getSongsByAuthorGenre(author, genreid);}

    @Override
    public long getGenreDBId(Genre genre){ return songRepository.getGenreDBId(genre);}

}

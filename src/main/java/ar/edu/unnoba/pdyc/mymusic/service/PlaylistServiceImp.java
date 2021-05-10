package ar.edu.unnoba.pdyc.mymusic.service;

import ar.edu.unnoba.pdyc.mymusic.model.Playlist;
import ar.edu.unnoba.pdyc.mymusic.model.Song;
import ar.edu.unnoba.pdyc.mymusic.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistServiceImp implements PlaylistService{

    @Autowired
    private PlaylistRepository playlistRepository;

    @Override
    public List<Playlist> getPlaylists() {
        return playlistRepository.findAll();
    }

    @Override
    public void createPlaylist(Playlist playlist){ playlistRepository.save(playlist);}

    @Override
    public List<Song> getSongsByPlaylistId(long id) {
        return playlistRepository.getSongsByPlaylistId(id);
    }

    @Override
    public String getNameById(long id) {
        return playlistRepository.getNameById(id);
    }

    @Override
    public long getOwner(long id){
        return playlistRepository.getOwner(id);
    }
}

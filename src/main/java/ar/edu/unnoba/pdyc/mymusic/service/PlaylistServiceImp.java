package ar.edu.unnoba.pdyc.mymusic.service;

import ar.edu.unnoba.pdyc.mymusic.dto.PlaylistDTO;
import ar.edu.unnoba.pdyc.mymusic.model.Playlist;
import ar.edu.unnoba.pdyc.mymusic.model.Song;
import ar.edu.unnoba.pdyc.mymusic.model.User;
import ar.edu.unnoba.pdyc.mymusic.repository.PlaylistRepository;
import ar.edu.unnoba.pdyc.mymusic.repository.PlaylistsSongsRepository;
import ar.edu.unnoba.pdyc.mymusic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PlaylistServiceImp implements PlaylistService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private PlaylistsSongsRepository playlistsSongsRepository;

    @Override
    public List<Playlist> getPlaylists() {
        return playlistRepository.findAll();
    }

    @Override
    public void create(PlaylistDTO playlistDTO, String loggedEmail){
        User userLogged = userRepository.findByEmail(loggedEmail);
        Playlist playlist = new Playlist();
        playlist.setName(playlistDTO.getName());
        playlist.setUser(userLogged);
        playlistRepository.save(playlist);
    }

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

    @Override
    public void deletePlaylist(long id){
        List<Long> pkABorrar = playlistsSongsRepository.getIdByPlaylistId(id);
        for (Long aLong : pkABorrar) {
            playlistsSongsRepository.deleteById(aLong);
        }
        playlistRepository.deleteById(id);
    }

    @Override
    public long getIdByPlaylistIdAndSongId(long plId, long sId){
        return playlistsSongsRepository.getIdByPlaylistIdAndSongId(plId,sId);
    }

    @Override
    public void deleteSongOfPlaylist(long id){
        playlistsSongsRepository.deleteById(id);
    }
}

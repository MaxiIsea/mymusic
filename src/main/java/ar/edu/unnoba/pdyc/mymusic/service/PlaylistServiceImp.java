package ar.edu.unnoba.pdyc.mymusic.service;

import ar.edu.unnoba.pdyc.mymusic.model.Playlist;
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
}

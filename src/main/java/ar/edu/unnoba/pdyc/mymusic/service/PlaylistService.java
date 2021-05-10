package ar.edu.unnoba.pdyc.mymusic.service;

import ar.edu.unnoba.pdyc.mymusic.model.Playlist;
import ar.edu.unnoba.pdyc.mymusic.model.Song;

import java.util.List;

public interface PlaylistService {
    public List<Playlist>getPlaylists();
    public void createPlaylist(Playlist playlist);
    public List<Song> getSongsByPlaylistId(long id);
    public String getNameById(long id);
    public long getOwner(long id);
}

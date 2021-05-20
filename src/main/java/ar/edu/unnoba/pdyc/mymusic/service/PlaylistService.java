package ar.edu.unnoba.pdyc.mymusic.service;

import ar.edu.unnoba.pdyc.mymusic.dto.PlaylistDTO;
import ar.edu.unnoba.pdyc.mymusic.model.Playlist;
import ar.edu.unnoba.pdyc.mymusic.model.Song;

import java.util.List;

public interface PlaylistService {
    public List<Playlist>getPlaylists();
    public List<Song> getSongsByPlaylistId(long id);
    public String getNameById(long id);
    public long getOwner(long id);
    public void deletePlaylist (long id);
    public long getIdByPlaylistIdAndSongId(long plId, long sId);
    public void deleteSongOfPlaylist(long id);
    public void create(PlaylistDTO playlistDTO, String loggedEmail);
    public void update(long id, PlaylistDTO playlistDTO,String loggedEmail) throws Exception;
}

package ar.edu.unnoba.pdyc.mymusic.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="playlists")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToOne(fetch=FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy = "playlist") //cascade = CascadeType.REMOVE, orphanRemoval = true
    private List<PlaylistsSongs> playlistsSongs;
/*
    @ManyToMany
    @JoinTable(
            name = "playlists_songs",
            joinColumns = @JoinColumn(name = "playlist_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name="song_id", nullable = false)
    )
    private List<Song> songs;
*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<PlaylistsSongs> getPlaylistsSongs() {
        return playlistsSongs;
    }

    public void setPlaylistsSongs(List<PlaylistsSongs> playlistsSongs) {
        this.playlistsSongs = playlistsSongs;
    }

    public void setId(long id) {
        this.id = id;
    }
}

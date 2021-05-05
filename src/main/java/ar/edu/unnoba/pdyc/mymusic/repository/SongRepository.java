package ar.edu.unnoba.pdyc.mymusic.repository;

import ar.edu.unnoba.pdyc.mymusic.model.DBGenre;
import ar.edu.unnoba.pdyc.mymusic.model.Genre;
import ar.edu.unnoba.pdyc.mymusic.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("songRepository")
public interface SongRepository extends JpaRepository<Song,Long>{

    @Query("select s from Song s where s.author=:author and s.dbgenre_id=:genreid")
    public List<Song> getSongsByAuthorGenre(@Param("author") String author, @Param("genreid") long genreid);

    @Query("select dbg from DBGenre dbg where dbg.genre=:genre")
    public long getGenreDBId(@Param("genre") Genre genre);

}

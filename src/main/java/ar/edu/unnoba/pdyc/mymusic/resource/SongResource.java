package ar.edu.unnoba.pdyc.mymusic.resource;

import ar.edu.unnoba.pdyc.mymusic.model.Song;
import ar.edu.unnoba.pdyc.mymusic.service.SongService;
import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/*
URI para retornar listado de canciones es
GET http://localhost:8080/myapp/songs
 */

@Path("/songs")
public class SongResource {

    @Autowired
    private SongService songService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSongs(){
        //Falta aplicar los conceptos de DTO
        List<Song> songs = songService.getSongs();
        return Response.ok(songs).build();
    }
}

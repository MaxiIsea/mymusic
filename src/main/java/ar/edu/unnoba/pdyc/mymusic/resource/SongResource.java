package ar.edu.unnoba.pdyc.mymusic.resource;

import ar.edu.unnoba.pdyc.mymusic.dto.SongDTO;
import ar.edu.unnoba.pdyc.mymusic.model.Genre;
import ar.edu.unnoba.pdyc.mymusic.service.SongService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Type;
import java.util.List;

/*
URI para retornar listado de canciones es
GET http://localhost:8080/mymusic/songs
 */

@Path("/songs")
public class SongResource {

    @Autowired
    private SongService songService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSongsByAuthorGenre(@QueryParam("author") String author, @QueryParam("genre") Genre genre){

        ModelMapper modelMapper = new ModelMapper();
        Type listType = new TypeToken<List<SongDTO>>(){}.getType();
        List<SongDTO> list = modelMapper.map(songService.getSongsByAuthorGenre(author,genre),listType);
        return Response.ok(list).build();

        //Falta aplicar los conceptos de DTO
        /*List<Song> songs = songService.getSongsByAuthorGenre(author, genre);
        return Response.ok(songs).build();*/

    }

    /* canciones sin filtro
    @GET
    @Path("/songs")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSongs(){
        ModelMapper modelMapper = new ModelMapper();
        Type listType = new TypeToken<List<SongDTO>>(){}.getType();
        List<SongDTO> list = modelMapper.map(songService.getSongs(),listType);
        return Response.ok(list).build();
    }*/
}

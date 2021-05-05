package ar.edu.unnoba.pdyc.mymusic.resource;

import ar.edu.unnoba.pdyc.mymusic.dto.SongDTO;
import ar.edu.unnoba.pdyc.mymusic.model.Playlist;
import ar.edu.unnoba.pdyc.mymusic.service.PlaylistService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Type;
import java.util.List;

@Path("/playlists")
public class PlaylistResource {

    @Autowired
    private PlaylistService playlistService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlaylist(){
        /*
        ModelMapper modelMapper = new ModelMapper();
        Type listType = new TypeToken<List<Playlist>>(){}.getType();
        List<Playlist> list = modelMapper.map(playlistService.getPlaylists(),listType);
        return Response.ok(list).build();*/
        System.out.println("holaaaaa");
        List<Playlist> list = playlistService.getPlaylists();
        return Response.ok(list).build();
    }
}

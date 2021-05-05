package ar.edu.unnoba.pdyc.mymusic.resource;

import ar.edu.unnoba.pdyc.mymusic.dto.PlaylistDTO;
import ar.edu.unnoba.pdyc.mymusic.dto.PlaylistWithSongsDTO;
import ar.edu.unnoba.pdyc.mymusic.dto.SongDTO;
import ar.edu.unnoba.pdyc.mymusic.model.Playlist;
import ar.edu.unnoba.pdyc.mymusic.model.Song;
import ar.edu.unnoba.pdyc.mymusic.service.PlaylistService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Path("/playlists")
public class PlaylistResource {

    @Autowired
    private PlaylistService playlistService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlaylist(){

        ModelMapper modelMapper = new ModelMapper();
        Type listType = new TypeToken<List<PlaylistDTO>>(){}.getType();
        List<PlaylistDTO> list = modelMapper.map(playlistService.getPlaylists(),listType);
        return Response.ok(list).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlaylistById(@PathParam("id") long id){

        ModelMapper modelMapper = new ModelMapper();
        Type listType = new TypeToken<String>(){}.getType();
        String list = modelMapper.map(playlistService.getNameById(id),listType);
        Type listType2 = new TypeToken<List<SongDTO>>(){}.getType();
        List<PlaylistDTO> list2 = modelMapper.map(playlistService.getSongsByPlaylistId(id),listType);
        //no anda
        return Response.ok(list2,list).build();
    }
/*
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPlaylist(Playlist playlist){
        playlistService.createPlaylist(playlist);
    }
    */

}

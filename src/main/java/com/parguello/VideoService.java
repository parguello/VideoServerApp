package com.parguello;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import com.parguello.Video;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Path("/video")
public class VideoService {

	private static Map<Integer, Video> videoMap = new HashMap<Integer, Video>();
	
    static {
    	videoMap.put(1, new Video(1, "chameleon bubbles", "https://www.youtube.com/embed/xn54TvpGu7E"));
    	videoMap.put(2, new Video(2, "TrailerHD", "https://media.w3.org/2010/05/sintel/trailer_hd.mp4"));
    }

	@GET
	@Path("/")
	@Produces({ MediaType.APPLICATION_JSON })
	public Collection<Video> videoList() {

		//return videoMap.values().stream().collect(Collectors.toCollection(ArrayList::new));
		return videoMap.values();
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON})
	public Video getVideo(@PathParam("id") int id) {


		if (videoMap.containsKey(id)) {
			return videoMap.get(id);
		} else
			return null;
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addVideo(Video video) throws JSONException {


		if (null != videoMap.get(video.getId())) {
			return Response.status(Response.Status.NOT_MODIFIED).entity("Error: Video is already in the database.").build();
		}

		Video newVideo =  new Video(  videoMap.size()+1, video.getName(), video.getUrl());
		
		videoMap.put(/*video.getId()*/ videoMap.size()+1, newVideo);
		return Response.status(Response.Status.CREATED).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateVideo(Video video) throws JSONException {

		if (null == videoMap.get(video.getId())) {
			return Response.status(Response.Status.NOT_MODIFIED)
					.entity("Error: Video is not in the database").build();
		}

		videoMap.put(video.getId(), video);
		return Response.status(Response.Status.OK).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteVideo(@PathParam("id") int id) {


		if (null == videoMap.get(id)) {
			return Response.status(Response.Status.NOT_FOUND).entity("Error: Video is not in the database.")
					.build();
		}

		videoMap.remove(id);
		return Response.status(Response.Status.OK).build();
	}


}

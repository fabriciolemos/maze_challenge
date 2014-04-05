package com.mazechallange.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Consumes(value = MediaType.APPLICATION_JSON)
@Produces("application/json")
public interface MazeWSClient {

	@Path("init")
	@POST
	CurrentCellVO init();

	@Path("jump")
	@POST
	void jump(@QueryParam("mazeGuid") String mazeGuid, @QueryParam("x") Integer x, @QueryParam("y") Integer y);

	@Path("move")
	@POST
	void move(@QueryParam("mazeGuid") String mazeGuid, @QueryParam("direction") String direction);

	@Path("currentCell")
	@POST
	CurrentCellVO currentCell(@QueryParam("mazeGuid") String mazeGuid);
}

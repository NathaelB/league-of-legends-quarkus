package fr.nathael.resource;

import fr.nathael.service.GameService;
import fr.nathael.service.TeamService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/games")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GameResource {

  @Inject
  GameService gameService;

  @POST()
  @Path("/begin")
  public Response beginGame () {
    gameService.beginGame();
    return Response.ok("Bienvenue sur la Faille de l'Invocateur !").build();
  }

  @POST()
  @Path("/predicate")
  public Response predicateGame () {
    List<TeamService.LaneResult> laneResults = gameService.predicateGame();
    return Response.ok(laneResults).build();
  }
}

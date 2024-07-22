package fr.nathael.resource;

import fr.nathael.dto.TeamDTO;
import fr.nathael.exception.TeamNotFullException;
import fr.nathael.model.Team;
import fr.nathael.service.TeamService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/teams")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeamResource {

  @Inject
  TeamService teamService;

  @GET
  public Response getTeams () {
    return Response.ok(teamService.getTeams()).build();
  }

  @POST
  public Response prepareTeam (TeamDTO teamDTO) {
    if (teamDTO.getChampionsDistribution().size() != 5) {
      throw new TeamNotFullException("Team must have 5 champions");
    }
    Team team = teamService.addTeam(teamDTO);
    return Response.status(Response.Status.CREATED).entity(team).build();
  }
}

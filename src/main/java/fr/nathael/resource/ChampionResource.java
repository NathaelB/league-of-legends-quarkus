package fr.nathael.resource;

import fr.nathael.dto.ChampionDTO;
import fr.nathael.model.Champion;
import fr.nathael.service.ChampionService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/champions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ChampionResource {
  @Inject
  ChampionService championService;

  @GET
  public List<Champion> getChampions (@QueryParam("type") String type, @QueryParam("lane") String lane) {
    return championService.getChampions(type, lane);
  }

  @POST
  public Response add (@Valid ChampionDTO championDTO) {
    championService.create(championDTO);
    return Response.status(Response.Status.CREATED).build();
  }
}

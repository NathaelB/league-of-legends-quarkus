package fr.nathael.exception.champion;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ChampionNotFoundExceptionMapper implements ExceptionMapper<ChampionNotFoundException> {
  @Override
  public Response toResponse (ChampionNotFoundException exception) {
    return Response.status(Response.Status.NOT_FOUND)
        .entity("{\"error\": \"" + exception.getMessage() + "\"}")
        .build();
  }
}

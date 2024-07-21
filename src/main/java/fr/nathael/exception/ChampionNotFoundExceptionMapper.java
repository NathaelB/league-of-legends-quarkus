package fr.nathael.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

public class ChampionNotFoundExceptionMapper implements ExceptionMapper<ChampionNotFoundException> {
  @Override
  public Response toResponse (ChampionNotFoundException exception) {
    return Response.status(Response.Status.NOT_FOUND)
        .entity("{\"error\": \"" + exception.getMessage() + "\"}")
        .build();
  }
}

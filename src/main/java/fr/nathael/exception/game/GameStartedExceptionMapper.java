package fr.nathael.exception.game;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GameStartedExceptionMapper implements ExceptionMapper<GameStartedException> {
  @Override
  public Response toResponse (GameStartedException exception) {
    return Response.status(Response.Status.CONFLICT)
        .entity("{\"error\": \"" + exception.getMessage() + "\"}")
        .build();
  }
}

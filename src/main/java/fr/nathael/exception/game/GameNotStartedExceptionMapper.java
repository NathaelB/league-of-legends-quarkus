package fr.nathael.exception.game;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

public class GameNotStartedExceptionMapper implements ExceptionMapper<GameNotStartedException> {
  @Override
  public Response toResponse (GameNotStartedException exception) {
    return Response.status(Response.Status.CONFLICT)
        .entity("{\"error\": \"" + exception.getMessage() + "\"}")
        .build();
  }
}

package fr.nathael.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

public class TeamNotFullExceptionMapper implements ExceptionMapper<TeamNotFullException> {
  @Override
  public Response toResponse (TeamNotFullException exception) {
    return Response.status(Response.Status.BAD_REQUEST)
        .entity("{\"error\": \"" + exception.getMessage() + "\"}")
        .build();
  }
}

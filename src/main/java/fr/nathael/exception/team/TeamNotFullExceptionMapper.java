package fr.nathael.exception.team;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class TeamNotFullExceptionMapper implements ExceptionMapper<TeamNotFullException> {
  @Override
  public Response toResponse (TeamNotFullException exception) {
    return Response.status(Response.Status.BAD_REQUEST)
        .entity("{\"error\": \"" + exception.getMessage() + "\"}")
        .build();
  }
}

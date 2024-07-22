package fr.nathael.exception.team;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class TeamFullCapacityExceptionMapper implements ExceptionMapper<TeamFullCapacityException> {
  @Override
  public Response toResponse (TeamFullCapacityException exception) {
    return Response.status(Response.Status.CONFLICT)
        .entity("{\"error\": \"" + exception.getMessage() + "\"}")
        .build();
  }
}

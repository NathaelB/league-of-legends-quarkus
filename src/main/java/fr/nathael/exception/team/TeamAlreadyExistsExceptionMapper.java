package fr.nathael.exception.team;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class TeamAlreadyExistsExceptionMapper implements ExceptionMapper<TeamAlreadyExistsException> {
  @Override
  public Response toResponse (TeamAlreadyExistsException exception) {
    return Response.status(Response.Status.CONFLICT)
        .entity("{\"error\": \"" + exception.getMessage() + "\"}")
        .build();
  }
}

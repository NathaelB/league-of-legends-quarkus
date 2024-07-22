package fr.nathael.exception.champion;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ChampionAlreadyExistsExceptionMapper implements ExceptionMapper<ChampionAlreadyExistsException> {
  @Override
  public Response toResponse (ChampionAlreadyExistsException exception) {
    return Response.status(Response.Status.CONFLICT)
        .entity("{\"error\": \"" + exception.getMessage() + "\"}")
        .build();
  }
}

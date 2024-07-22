package fr.nathael.exception.team;

public class TeamAlreadyExistsException extends RuntimeException {
  public TeamAlreadyExistsException (String message) {
    super(message);
  }
}

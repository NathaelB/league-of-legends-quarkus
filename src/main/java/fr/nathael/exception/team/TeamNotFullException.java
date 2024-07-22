package fr.nathael.exception.team;

public class TeamNotFullException extends RuntimeException {
  public TeamNotFullException (String message) {
    super(message);
  }
}

package fr.nathael.exception.team;

public class TeamFullCapacityException extends RuntimeException {
  public TeamFullCapacityException (String message) {
    super(message);
  }
}

package fr.nathael.exception;

public class TeamNotFullException extends RuntimeException {
  public TeamNotFullException (String message) {
    super(message);
  }
}

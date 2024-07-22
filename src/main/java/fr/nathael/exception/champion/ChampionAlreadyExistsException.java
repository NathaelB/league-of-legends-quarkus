package fr.nathael.exception.champion;

public class ChampionAlreadyExistsException extends RuntimeException {
  public ChampionAlreadyExistsException (String message) {
    super(message);
  }
}

package fr.nathael.exception;

public class ChampionNotFoundException extends RuntimeException {
  public ChampionNotFoundException (String message) {
    super(message);
  }
}

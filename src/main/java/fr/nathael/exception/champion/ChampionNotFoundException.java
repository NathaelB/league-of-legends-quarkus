package fr.nathael.exception.champion;

public class ChampionNotFoundException extends RuntimeException {
  public ChampionNotFoundException (String message) {
    super(message);
  }
}

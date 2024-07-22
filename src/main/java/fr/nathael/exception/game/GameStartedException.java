package fr.nathael.exception.game;

public class GameStartedException extends RuntimeException {
  public GameStartedException () {
    super("Game already started");
  }
}

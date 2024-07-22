package fr.nathael.exception.game;

public class GameNotStartedException extends RuntimeException {
  public GameNotStartedException () {
    super("Game not started");
  }
}

package fr.nathael.exception;

public class ChampionAlreadyExistsException extends RuntimeException {
    public ChampionAlreadyExistsException(String message) {
        super(message);
    }
}

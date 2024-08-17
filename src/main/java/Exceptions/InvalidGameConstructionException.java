package main.java.Exceptions;

public class InvalidGameConstructionException extends Exception{

    public InvalidGameConstructionException() {
    }

    public InvalidGameConstructionException(String message) {
        super(message);
    }
}

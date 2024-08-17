package main.java.models;

public class BotPlayer extends Player{

    private Botlevel level;

    public BotPlayer(String name, Character symbol, Botlevel level) {
        super(name, symbol);
        this.level = level;
    }

}

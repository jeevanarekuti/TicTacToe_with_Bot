package main.java.models;

import main.java.Factories.Bot.BotPlayingStrategyFactory;
import main.java.Strategy.Bot.BotPlayingStrategy;

public class BotPlayer extends Player{

    private Botlevel level;
    private BotPlayingStrategy strategy;

    public BotPlayer(String name, Character symbol, Botlevel level) {
        super(name, symbol);
        this.strategy = BotPlayingStrategyFactory.getStrategy(level);
        this.level = level;
    }


    @Override
    public Move makeMove(Board board) {
        System.out.println(getName() + " 's turn");
        Move move = strategy.makeMove(board,this);
        System.out.println("Bot is making a move on " + move.getCell().getRow() + " " + move.getCell().getCol());
        return move;
    }
}

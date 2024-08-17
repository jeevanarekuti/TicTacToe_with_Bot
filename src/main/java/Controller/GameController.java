package main.java.Controller;

import main.java.Exceptions.InvalidGameConstructionException;
import main.java.models.Game;
import main.java.models.GameStatus;
import main.java.models.Player;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    public Game createGame(List<Player> players) throws InvalidGameConstructionException {
        Game game = Game.getBuilder()
                .setPlayers(players)
                .setGameStatus(GameStatus.IN_PROGRESS)
                .setMoves(new ArrayList<>())
                .setCurrPlayerIndex(0)
                .build();
        return game;
    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }

    public void undo(){

    }

    public void displayBoard(Game game){
        game.getBoard().displayBoard();
    }

    public Player getCurrentPlayer(Game game){
        return game.getCurrPlayer();
    }

}

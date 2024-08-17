package main.java;

import main.java.Controller.GameController;
import main.java.Exceptions.InvalidGameConstructionException;
import main.java.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {

    private static GameController gameController = new GameController();

   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many human players are playing?");
        int numHumanPlayers = scanner.nextInt();
        List<Player> players = new ArrayList<>();
        for(int i=0;i<numHumanPlayers;i++){
            System.out.println("Give Player " + (i+1) + " name");
            String name = scanner.next();
            System.out.println("Give symbol for player " + (i+1));
            char symbol = scanner.next().charAt(0);
            //TODO every player should have different symbol check if we have unique symbols
            players.add(new Player(name,symbol));
        }

        System.out.println("Is the Bot going to play? (y/n)");
        char botReply = scanner.next().charAt(0);
        if(botReply == 'Y' || botReply == 'y'){
            System.out.println("Bot level? (h/m/l)");
            //TODO take level as input and create a object
            players.add(new BotPlayer("BOT_1",'B', Botlevel.LOW));
        }

        Game game;
        try {
            game = gameController.createGame(players);
        } catch (Exception e) {
            System.out.println("Error while creating game " + e.getMessage());
            return;
        }

        while(gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)){
            gameController.displayBoard(game);
            Player player = gameController.getCurrentPlayer(game);
            System.out.println(player.getName() + "'s turn, give row and col");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            gameController.makeMove(game,row,col,player);
        }

        if(gameController.getGameStatus(game).equals(GameStatus.ENDED)){
            Player player = gameController.getCurrentPlayer(game);
            System.out.println(player.getName() + " has won!");
        }

    }
}

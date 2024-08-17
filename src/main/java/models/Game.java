package main.java.models;

import main.java.Exceptions.InvalidGameConstructionException;
import main.java.Strategy.winning.OrderNWinningStrategy;
import main.java.Strategy.winning.WinningStrategy;

import java.util.Collections;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private GameStatus gameStatus;
    private int currPlayerIndex;
    private List<Move>moves;
    private WinningStrategy strategy;

    public Game(GameBuilder gameBuilder) {
        this.board = gameBuilder.board;
        this.players = gameBuilder.players;
        this.gameStatus = gameBuilder.gameStatus;
        this.currPlayerIndex = gameBuilder.currPlayerIndex;
        this.moves = gameBuilder.moves;
        this.strategy = new OrderNWinningStrategy();
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getCurrPlayer() {
        return players.get(currPlayerIndex);
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public static GameBuilder getBuilder(){
        return new GameBuilder();
    }

    public void makeMove() {
        //TODO handle scenario where player makes move on pre occupied cell
        //TODO handle draw case

        Player currPlayer = getCurrPlayer();
        Move move = currPlayer.makeMove(getBoard());
        moves.add(move);

        boolean playerHasWon = this.strategy.checkIfWon(board,move);

        if(playerHasWon){
            gameStatus = GameStatus.ENDED;
            return;
        }


        this.currPlayerIndex++;
        this.currPlayerIndex %= players.size();
    }

    public static class GameBuilder{
        private Board board;
        private List<Player> players;
        private GameStatus gameStatus;
        private int currPlayerIndex;
        private List<Move>moves;


        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public GameBuilder setGameStatus(GameStatus gameStatus) {
            this.gameStatus = gameStatus;
            return this;
        }

        public GameBuilder setCurrPlayerIndex(int currPlayerIndex) {
            this.currPlayerIndex = currPlayerIndex;
            return this;
        }

        public GameBuilder setMoves(List<Move> moves) {
            this.moves = moves;
            return this;
        }

        public Game build() throws InvalidGameConstructionException {
            if(this.players == null || players.size()<=1){
                throw new InvalidGameConstructionException("Atleast two players required");
            }
            //Used to assign players randomly.
            Collections.shuffle(players);
            this.board = new Board(this.players.size()+1);
            return new Game(this);
        }
    }

}

package main.java.Strategy.winning;

import main.java.models.Board;
import main.java.models.Move;

public interface WinningStrategy {
    boolean checkIfWon(Board board, Move move);
}

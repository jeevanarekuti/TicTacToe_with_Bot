package main.java.Strategy.Bot;

import main.java.models.Board;
import main.java.models.Move;
import main.java.models.Player;

public interface BotPlayingStrategy {
    Move makeMove(Board board, Player player);
}

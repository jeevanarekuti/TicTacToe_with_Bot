package main.java.Strategy.Bot;

import main.java.models.*;

import java.util.List;

public class easyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move makeMove(Board board, Player player) {
        Cell movecell = null;
        outer : for(List<Cell> row : board.getCells()){
            for(Cell cell : row){
                if(cell.getCellState().equals(CellState.EMPTY)){
                    movecell = cell;
                    break outer;
                }
            }
        }
        if(movecell != null){
            board.setPlayer(player, movecell.getRow(), movecell.getCol());
            return new Move(movecell,player);
        }

        return null;
    }
}

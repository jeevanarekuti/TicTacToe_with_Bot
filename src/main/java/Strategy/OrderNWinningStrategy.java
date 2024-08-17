package main.java.Strategy;

import main.java.models.Board;
import main.java.models.Cell;
import main.java.models.CellState;
import main.java.models.Move;

import java.util.List;

public class OrderNWinningStrategy implements WinningStrategy {

    @Override
    public boolean checkIfWon(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        int size = board.getCells().size();

        List<Cell> cells = board.getCells().get(row);
        int count = 0;
        for(Cell cell:cells){
            if(cell.getCellState() == CellState.OCCUPIED && cell.getPlayer().getSymbol() == move.getPlayer().getSymbol())
                count++;
            else{
                break;
            }
        }
        if (count == cells.size())
            return true;

        count = 0;
        for (int i = 0; i < size; i++) {
            Cell cell = board.getCells().get(i).get(col);
            if (cell.getCellState() == CellState.OCCUPIED &&
                    cell.getPlayer().getSymbol() == move.getPlayer().getSymbol()) {
                count++;
            } else {
                break;
            }
        }
        if (count == size) {
            return true; // Win condition met in column
        }

        count = 0;
        if(row == col){
            // diagonal
            for(int i=0; i<board.getCells().size(); i++){
                Cell cell = board.getCells().get(i).get(i);
                if(cell.getCellState() == CellState.OCCUPIED &&
                        cell.getPlayer().getSymbol() == move.getPlayer().getSymbol()){
                    count++;
                } else {
                    break;
                }
            }
        }
        if(count == cells.size()){
            return true;
        }

        count = 0;
        if(row + col == board.getCells().size() - 1){
            //reverse diagonal
            for(int i=0; i<board.getCells().size(); i++){
                int j = board.getCells().size() - 1 - i;
                Cell cell = board.getCells().get(i).get(j);
                if(cell.getCellState() == CellState.OCCUPIED &&
                        cell.getPlayer().getSymbol() == move.getPlayer().getSymbol()){
                    count++;
                } else {
                    break;
                }
            }
        }
        if(count == cells.size()){
            return true;
        }


        return false;
    }
}

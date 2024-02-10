package Models.Strategies.WinningStrategy;

import Models.Board;
import Models.Move;
import Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagonalStrategy implements WinningStrategy{
    Map<Symbol,Integer> leftDiagonal;
    Map<Symbol,Integer> rightDiagonal;
    public DiagonalStrategy() {
        leftDiagonal=new HashMap<>();
        rightDiagonal=new HashMap<>();
    }
    public boolean checkWinner(Move move,int dimension){
        int row= move.getCell().getRow();
        int col=move.getCell().getCol();
        Symbol symbol=move.getCell().getPlayer().getSymbol();
        if(row==col)
            leftDiagonal.put(symbol,leftDiagonal.getOrDefault(symbol,0)+1);
        if(row+col==dimension-1)
            rightDiagonal.put(symbol,rightDiagonal.getOrDefault(symbol,0)+1);
        if(leftDiagonal.containsKey(symbol))
            if(leftDiagonal.get(symbol)==dimension)
                return true;
        if(rightDiagonal.containsKey(symbol))
            return rightDiagonal.get(symbol) == dimension;
        return false;
    }
}

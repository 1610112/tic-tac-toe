package Models.Strategies.WinningStrategy;

import Models.Board;
import Models.CellStatus;
import Models.Move;
import Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowStrategy implements WinningStrategy{
    Map<Integer, Map<Symbol,Integer>> rowMap;
    public RowStrategy() {
        rowMap=new HashMap<>();
    }
    public boolean checkWinner(Move move,int dimension){
        int row= move.getCell().getRow();
        int col=move.getCell().getCol();
        if(!rowMap.containsKey(row))
            rowMap.put(row,new HashMap<>());
        Map<Symbol,Integer> map=rowMap.get(row);
        Symbol symbol=move.getCell().getPlayer().getSymbol();
        map.put(symbol,map.getOrDefault(symbol,0)+1);
        return map.get(symbol)==dimension;
    }
}

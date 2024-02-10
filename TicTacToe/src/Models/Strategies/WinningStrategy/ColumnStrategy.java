package Models.Strategies.WinningStrategy;

import Models.Board;
import Models.Move;
import Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColumnStrategy implements WinningStrategy{
    Map<Integer, Map<Symbol,Integer>> colMap;
    public ColumnStrategy() {
        colMap=new HashMap<>();
    }
    public boolean checkWinner(Move move,int dimension){
        int row= move.getCell().getRow();
        int col=move.getCell().getCol();
        if(!colMap.containsKey(col))
            colMap.put(col,new HashMap<>());
        Map<Symbol,Integer> map=colMap.get(col);
        Symbol symbol=move.getCell().getPlayer().getSymbol();
        map.put(symbol,map.getOrDefault(symbol,0)+1);
        return map.get(symbol)==dimension;
    }
}

package Models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<List<Cell>> cells;
    public Board(int dimension){
        cells=new ArrayList<>();
        for(int i=0;i<dimension;i++)
        {
            List<Cell> currRow=new ArrayList<>();
            for(int j=0;j<dimension;j++)
            {
                currRow.add(new Cell(i,j));
            }
            cells.add(currRow);
        }
    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public void setCells(List<List<Cell>> cells) {
        this.cells = cells;
    }

    public void displayBoard(){
        for(List<Cell> currRow:cells)
        {
            for(Cell currCell:currRow)
            {
                if(currCell.getCellStatus().equals(CellStatus.BLANK))
                    System.out.print("| |");
                else
                    System.out.print("|"+currCell.getPlayer().getSymbol()+"|");
            }
            System.out.println();
        }

    }
}

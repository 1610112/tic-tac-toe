package Models.Strategies.BotPlayingStrategy;

import Models.Board;
import Models.Cell;
import Models.CellStatus;

import java.util.List;

public class EasyPlayingStrategy implements PlayingStrategy{
    @Override
    public Cell strategy(Board board) {
        for(List<Cell> row:board.getCells())
        {
            for(Cell cell:row) {
                if (cell.getCellStatus().equals(CellStatus.BLANK))
                    return cell;

            }
        }
        return null;

    }
}

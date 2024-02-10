package Models;

public class Move {
    Cell cell;

    Move(Cell cell,Player player)
    {
        this.cell=cell;
        cell.setPlayer(player);
        cell.setCellStatus(CellStatus.FILLED);


    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }


}

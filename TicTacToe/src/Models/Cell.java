package Models;

public class Cell {
    Player player;
    CellStatus cellStatus;
    int row;
    int col;
    Cell(int row,int col){
        cellStatus=CellStatus.BLANK;
        this.row=row;
        this.col=col;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public CellStatus getCellStatus() {
        return cellStatus;
    }

    public void setCellStatus(CellStatus cellStatus) {
        this.cellStatus = cellStatus;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}

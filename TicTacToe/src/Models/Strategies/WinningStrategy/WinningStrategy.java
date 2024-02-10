package Models.Strategies.WinningStrategy;

import Models.Board;
import Models.Move;

public interface WinningStrategy {
    public boolean checkWinner(Move move,int dimension);
}

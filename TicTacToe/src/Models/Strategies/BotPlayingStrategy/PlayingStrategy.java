package Models.Strategies.BotPlayingStrategy;

import Models.Board;
import Models.Cell;

public interface PlayingStrategy {
    Cell strategy(Board board);
}

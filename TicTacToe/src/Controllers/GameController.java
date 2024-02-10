package Controllers;
import Exceptions.InvalidMoveException;
import Exceptions.InvalidPlayerNumberException;
import Exceptions.InvalidWinningStrategyNumber;
import Exceptions.NoMoveToUndoException;
import Models.Game;
import Models.Player;
import Models.Strategies.WinningStrategy.WinningStrategy;

import java.util.List;

public class GameController {
    Game game;
    public GameController(){

    }
    public void createGame(List<Player> players, List<WinningStrategy> winningStrategyList) throws InvalidPlayerNumberException, InvalidWinningStrategyNumber {

        game = Game.getBuilder().setPlayers(players).setWinningStrategies(winningStrategyList).build();

    }
    public boolean playGame() throws InvalidMoveException, NoMoveToUndoException {
        return game.playGame();
    }
    public void displayBoard(){
        game.displayBoard();
    }




}

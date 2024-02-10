import Controllers.GameController;
import Models.Game;
import Models.Player;
import Models.Strategies.WinningStrategy.ColumnStrategy;
import Models.Strategies.WinningStrategy.RowStrategy;
import Models.Strategies.WinningStrategy.WinningStrategy;
import Models.Symbol;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GameController gameController=new GameController();
        List<Player> players=new ArrayList<>();
        players.add(new Player("Mehak", Symbol.O));
        //players.add(new Player("Ashima",Symbol.A));
        List<WinningStrategy> winningStrategies=new ArrayList<>();
        winningStrategies.add(new ColumnStrategy());
        winningStrategies.add(new RowStrategy());
        try {
            gameController.createGame(players, winningStrategies);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            while (gameController.playGame()) {
                gameController.displayBoard();
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
package Models;

import Exceptions.InvalidMoveException;
import Exceptions.InvalidPlayerNumberException;
import Exceptions.NoMoveToUndoException;
import Models.Strategies.BotPlayingStrategy.EasyPlayingStrategy;
import Models.Strategies.WinningStrategy.ColumnStrategy;
import Models.Strategies.WinningStrategy.DiagonalStrategy;
import Models.Strategies.WinningStrategy.RowStrategy;
import Models.Strategies.WinningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Models.Player;

public class Game {
    Board board;
    int dimensionOfBoard;
    List<Player> players;
    List<Move> moves;
    List<WinningStrategy> winningStrategies;

    int currPlayerIndex;
    GameStatus gameStatus;
    public Game(List<Player> players,List<WinningStrategy> winningStrategies,int dimensionOfBoard){
        this.dimensionOfBoard=dimensionOfBoard;
        board=new Board(dimensionOfBoard);
        moves=new ArrayList<>();
        gameStatus=GameStatus.INPROGRESS;
        this.winningStrategies=winningStrategies;
        this.players=players;




    }
    public void displayBoard(){
        board.displayBoard();
    }
//    private void createPlayers(){
//        players=new ArrayList<>();
//        Scanner sc;
////        for(int i=0;i<dimensionOfBoard-1;i++)
////        {
////            System.out.println("Enter Player "+i+" name");
////            sc=new Scanner(System.in);
////            String name=sc.nextLine();
////            System.out.println("Select symbol");
////            sc=new Scanner(System.in);
////            Symbol symbol= Symbol.valueOf(sc.nextLine());
////            players.add(new Player(name,symbol));
////        }
//        players.add(new Player("Mehak",Symbol.O));
//        players.add(new Player("Ashima",Symbol.X));
//    }
    public boolean playGame() throws InvalidMoveException, NoMoveToUndoException {
        Scanner sc;
        System.out.println("To Undo last operation enter undo\nElse enter move");
        sc=new Scanner(System.in);
        if(sc.nextLine().equalsIgnoreCase("undo"))
        {
            undo();
            return true;
        }
       else {
            Player player=players.get(currPlayerIndex%(dimensionOfBoard-1));
            Cell cell=null;
            if(player.getPlayerName().toLowerCase().contains("bot"))
            {
                System.out.println("Bot is playing his turn");
                Bot bot=(Bot) player;
                cell=bot.getBotPlayingStrategy().strategy(board);
                //board.displayBoard();


            }
            else{
                System.out.println(player.getPlayerName()+" 's turn Enter move");
                    sc = new Scanner(System.in);
                    int row = sc.nextInt();
                    sc = new Scanner(System.in);
                    int col = sc.nextInt();
                    if (row < 0 || col < 0 || row >= dimensionOfBoard || col >= dimensionOfBoard) {
                        throw new InvalidMoveException();
                    }
                cell=board.getCells().get(row).get(col);
                }
            currPlayerIndex++;
            Move move = new Move(cell,player);
            moves.add(move);

            return checkGameStatus(move);
          }
    }
    private boolean checkGameStatus(Move move){
        for(WinningStrategy strategy:winningStrategies)
        {
            if(strategy.checkWinner(move,dimensionOfBoard))
            {
                this.gameStatus=GameStatus.FINISHED;
                this.displayBoard();
                System.out.println(move.getCell().getPlayer().getPlayerName()+" is winner");
                return false;
            }
        }
        if(moves.size()==dimensionOfBoard*dimensionOfBoard)
        {
            this.gameStatus=GameStatus.DRAW;
            return false;
        }
        return true;
    }
    private void undo() throws NoMoveToUndoException {
        if(moves.isEmpty())
            throw new NoMoveToUndoException("No moves are there to undo");
        else{
            Move move=moves.get(moves.size()-1);
            moves.remove(move);
            move.getCell().cellStatus=CellStatus.BLANK;
            move.getCell().setPlayer(null);
            currPlayerIndex--;


        }
    }
    public static GameBuilder getBuilder(){
        return new GameBuilder();
    }
    public static class GameBuilder{
        List<Player> players;
        List<WinningStrategy> winningStrategies;
        public GameBuilder setPlayers(List<Player> players)  {
            this.players=players;
            if(players.size()==1)
                this.players.add(new Bot("Bot1",Symbol.A,new EasyPlayingStrategy()));
            return this;
        }
        public GameBuilder setWinningStrategies(List<WinningStrategy> winningStrategyList)
        {
            this.winningStrategies=winningStrategyList;
            return this;
        }
        public Game build() throws InvalidPlayerNumberException{
            if(players.isEmpty())
            {
                throw new InvalidPlayerNumberException();
            }
            else if(winningStrategies.isEmpty()){
                throw new InvalidPlayerNumberException();
            }
            else{
                return new Game(players,winningStrategies,players.size()+1);
            }

        }


    }



}

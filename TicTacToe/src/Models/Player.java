package Models;

public class Player {
    String playerName;
    Symbol symbol;

    public Player(String playerName, Symbol symbol) {
        this.playerName = playerName;
        this.symbol = symbol;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}

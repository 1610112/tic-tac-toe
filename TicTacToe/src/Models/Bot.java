package Models;

import Models.Strategies.BotPlayingStrategy.PlayingStrategy;

public class Bot extends Player{
    PlayingStrategy botPlayingStrategy;
    public Bot(String playerName, Symbol symbol, PlayingStrategy botPlayingStrategy) {
        super(playerName, symbol);
        this.botPlayingStrategy=botPlayingStrategy;
    }

    public PlayingStrategy getBotPlayingStrategy() {
        return botPlayingStrategy;
    }
}

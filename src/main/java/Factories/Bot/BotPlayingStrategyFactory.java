package main.java.Factories.Bot;

import main.java.Strategy.Bot.BotPlayingStrategy;
import main.java.Strategy.Bot.easyBotPlayingStrategy;
import main.java.models.Botlevel;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getStrategy(Botlevel level){
        switch (level){
            case LOW:
            case HIGH:
            case MEDIUM:
                return new easyBotPlayingStrategy();
        }
        throw new UnsupportedOperationException("Unknown bot type");
    }
}

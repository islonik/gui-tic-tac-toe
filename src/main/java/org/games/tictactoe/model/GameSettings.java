package org.games.tictactoe.model;

/**
 * Game storage.
 * @author Lipatov Nikita
 **/
public class GameSettings
{
    private static GameSettings instance = null;

    private boolean isOddGame;

    private GameSettings()
    {
        isOddGame = false;
    }

    public static GameSettings getInstance()
    {
        if(instance == null)
        {
            instance = new GameSettings();
        }
        return instance;
    }

    public boolean isOddGame() {
        return isOddGame;
    }

    public void setOddGame(boolean oddGame)
    {
        isOddGame = oddGame;
    }


}

package org.games.tictactoe.controller;

import org.games.tictactoe.model.Player;
import org.games.tictactoe.model.TicTacToe;
import org.games.tictactoe.model.GameSettings;
import org.games.tictactoe.view.GUI;
import org.games.tictactoe.view.Options;

/**
 * User: Lipatov Nikita
 */
public class Controller {

    private GUI view;
    private TicTacToe model;
    private GameSettings settings;

    public Controller()
    {
        settings = GameSettings.getInstance();

        newGame(Options.getInstance());
    }

    public GUI getView() {
        return view;
    }

    public void setView(GUI view) {
        this.view = view;
    }

    public TicTacToe getModel() {
        return model;
    }

    public void setModel(TicTacToe model) {
        this.model = model;
    }

    public void newGame(Options options)
    {
        if(options.isFirstMoveAlwaysPlayerOne())
        {
            settings.setOddGame(true);
            settings.setFirstGamerMove(true);
        }
        else if(options.isFirstMoveAlwaysPlayerTwo())
        {
            settings.setOddGame(false);
            settings.setFirstGamerMove(false);
        }
        else
        {
            boolean changeValue = settings.isOddGame() ? false : true;
            settings.setOddGame(changeValue);
            settings.setFirstGamerMove(changeValue);
        }

        Player playerOne = new Player();
        playerOne.setComputer(false);
        playerOne.setName(options.getNamePlayerOne());
        Player playerTwo = new Player();
        playerTwo.setComputer(options.isSecondPlayerComputer());
        settings.setComputer(options.isSecondPlayerComputer());

        if(options.isSecondPlayerComputer())
        {
            playerTwo.setName(options.getNameComputer());
        }
        else
        {
            playerTwo.setName(options.getNamePlayerTwo());
        }


        TicTacToe game = new TicTacToe(playerOne, playerTwo);
        this.model = game;
    }

    public void action(int type)
    {
        model.makeHumanMove(type);
        settings.changeGamerMove();

        if(settings.isComputer() && view.hasFreeCells())
        {
            model.makeComputerMove();
            int computerMove = model.getComputerMove();
            view.setUpImage(computerMove);
            settings.changeGamerMove();
        }

        Player winner = model.getWinner();
        if(winner != null)
        {
            view.lockAllCells();
            view.showWinner(winner.getName());
        }

        if(winner == null && !view.hasFreeCells())
        {
            view.lockAllCells();
            view.showDraw();
        }
    }

    public void makeFirstComputerMove()
    {
        if(!settings.isOddGame())
        {
            if(settings.isComputer() && view.hasFreeCells())
            {
                model.makeComputerMove();
                int computerMove = model.getComputerMove();
                view.setUpImage(computerMove);
                settings.changeGamerMove();
            }
        }
    }




}

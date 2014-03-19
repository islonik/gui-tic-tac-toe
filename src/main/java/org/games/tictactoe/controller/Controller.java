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

        model = newGame(Options.getInstance());
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

    public TicTacToe newGame(Options options)
    {
        if(options.isFirstMoveAlwaysPlayerOne())
        {
            settings.setOddGame(true);
        }
        else if(options.isFirstMoveAlwaysPlayerTwo())
        {
            settings.setOddGame(false);
        }
        else
        {
            settings.setOddGame(!settings.isOddGame());
        }

        Player playerOne = new Player();
        playerOne.setComputer(false);
        playerOne.setName(options.getNamePlayerOne());
        Player playerTwo = new Player();
        playerTwo.setComputer(options.isSecondPlayerComputer());

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
        return game;
    }

    public void action(int type)
    {
        model.action(type);

        if(model.isComputer() && view.hasFreeCells())
        {
            int computerMove = model.getComputerMove();
            view.setUpImage(computerMove);
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
            if(model.isComputer() && view.hasFreeCells())
            {
                model.makeComputerMove();
                int computerMove = model.getComputerMove();
                view.setUpImage(computerMove);
            }
        }
    }




}

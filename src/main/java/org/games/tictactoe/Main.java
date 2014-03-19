package org.games.tictactoe;

import org.games.tictactoe.controller.Controller;
import org.games.tictactoe.view.GUI;

/**
 * Trigger point of tic-tac-toe game.
 * @author Lipatov Nikita
 **/
public class Main
{
    /**
     * Main function.
     * @param args It's not used.
     **/
    public static void main(String[] args)
    {
        GUI gui = GUI.getInstance();

        Controller controller = new Controller();
        controller.setView(gui);
        gui.setController(controller);
    }
}

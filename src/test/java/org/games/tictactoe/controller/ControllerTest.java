package org.games.tictactoe.controller;

import org.games.tictactoe.model.TicTacToe;
import org.games.tictactoe.view.GUI;
import org.games.tictactoe.view.Options;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * User: Lipatov Nikita
 */
public class ControllerTest
{

    @Test
    public void testController_testCase01()
    {
        GUI gui = Mockito.mock(GUI.class);

        Controller controller = new Controller();
        controller.setView(gui);
        gui.setController(controller);

        Options options = Mockito.mock(Options.class);
        Mockito.when(options.isSecondPlayerComputer()).thenReturn(false); /* reference attr group */
        Mockito.when(options.getNamePlayerOne()).thenReturn("Player 1"); /* reference attr group */
        Mockito.when(options.getNamePlayerTwo()).thenReturn("Player 2"); /* reference attr group */
        Mockito.when(options.getNameComputer()).thenReturn("Computer"); /* reference attr group */
        Mockito.when(options.isFirstMoveAlwaysPlayerOne()).thenReturn(false); /* reference attr group */
        Mockito.when(options.isFirstMoveAlwaysPlayerTwo()).thenReturn(false); /* reference attr group */

        TicTacToe ticTacToe = controller.newGame(options);

        controller.setModel(ticTacToe);

        controller.action(1); // first player
        controller.action(5); // second player
        controller.action(9); // first player
        controller.action(3); // second player
        controller.action(7); // first player
        controller.action(8); // second player
        controller.action(4); // first player

        Mockito.verify(gui).showWinner("Player 1");
    }

    @Test
    public void testController_testCase02()
    {
        GUI gui = Mockito.mock(GUI.class);

        Controller controller = new Controller();
        controller.setView(gui);
        gui.setController(controller);

        Options options = Mockito.mock(Options.class);
        Mockito.when(options.isSecondPlayerComputer()).thenReturn(false); /* reference attr group */
        Mockito.when(options.getNamePlayerOne()).thenReturn("Player 1"); /* reference attr group */
        Mockito.when(options.getNamePlayerTwo()).thenReturn("Player 2"); /* reference attr group */
        Mockito.when(options.getNameComputer()).thenReturn("Computer"); /* reference attr group */
        Mockito.when(options.isFirstMoveAlwaysPlayerOne()).thenReturn(false); /* reference attr group */
        Mockito.when(options.isFirstMoveAlwaysPlayerTwo()).thenReturn(false); /* reference attr group */

        TicTacToe ticTacToe = controller.newGame(options);

        controller.setModel(ticTacToe);
        controller.action(4); // first player
        controller.action(1); // second player
        controller.action(2); // first player
        controller.action(5); // second player
        controller.action(6); // first player
        controller.action(9); // second player
        Mockito.verify(gui).showWinner("Player 2");

        ticTacToe = controller.newGame(options);
        controller.setModel(ticTacToe);
        controller.action(1); // first player
        controller.action(5); // second player
        controller.action(9); // first player
        controller.action(3); // second player
        controller.action(7); // first player
        controller.action(8); // second player
        controller.action(4); // first player
        Mockito.verify(gui).showWinner("Player 1");
    }
}

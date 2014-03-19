package org.games.tictactoe.model;

/**
 * Game instance
 * @author Lipatov Nikita
 **/
public class TicTacToe
{
    private boolean isSecondPlayerMove = false;
    private Player playerOne;
    private Player playerTwo;
    private GameField gameField;
    private ArtificialIntelligence ai;
    private int computerMove;

    public TicTacToe(Player one, Player two)
    {
        this.playerOne = one;
        this.playerTwo = two;
        this.gameField = new GameField();
        this.ai = new ArtificialIntelligence(one, two, this.gameField);
    }

    public int getComputerMove()
    {
        return computerMove;
    }

    /**
     * @param button int player button
     */
    public void action(int button)
    {
        if(isSecondPlayerMove && !playerTwo.isComputer())
        {
            this.gameField.setPlayer(playerTwo, button);
            this.isSecondPlayerMove = false;
        }
        else
        {
            this.gameField.setPlayer(playerOne, button);
            this.isSecondPlayerMove = true;
        }

        Player winner = gameField.getWinner();
        if(winner != null)
        {
            return;
        }

        this.makeComputerMove();
    }

    public void makeComputerMove()
    {
        if(playerTwo.isComputer())
        {
            this.ai.computerBrain();
            this.computerMove = this.ai.getNextMove();
        }
    }
    
    public Player getWinner()
    {
        return gameField.getWinner();
    }

    public boolean isComputer()
    {
        return playerTwo.isComputer();
    }
    
    public void printState()
    {
        for(int i = 0; i < 3; i++)
        {
            System.out.println("-------");
            for(int y = 0; y < 3; y++)
            {
                Player player = gameField.getGameField()[i][y];
                String print;
                if(player == null) 
                {
                    print = "null";        
                } else {
                    print = player.getName();
                }
                System.out.print(print + " || ");
            }
            System.out.print("\n");
        }
    }
}


package org.games.tictactoe.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * User: Lipatov Nikita
 */
public class ArtificialIntelligence
{
    private Player human;
    private Player computer;
    private GameField gameField;
    private int nextMove = 0;
    
    public ArtificialIntelligence(Player human, Player computer, GameField gameField)
    {
        this.human = human;
        this.computer = computer;
        this.gameField = gameField;
    }

    public GameField getGameField()
    {
        return gameField;
    }

    public void setGameField(GameField gameField)
    {
        this.gameField = gameField;
    }

    public Player getComputer()
    {
        return computer;
    }

    public void setComputer(Player computer)
    {
        this.computer = computer;
    }

    public int getNextMove() // no setter for this variable
    {
        return nextMove;
    }

    /**
     * @return value 1-9
     */
    public void computerBrain()
    {
        this.nextMove = 0;       // clear
        makeMove(this.computer); // victorious move
        if(this.nextMove != 0)
        {
            return;
        }
        makeMove(this.human);    // defensive move
        if(this.nextMove != 0)
        {
            return;
        }
        makeRandomMove();
    }

    public void makeMove(Player player)
    {
        this.makeDiagonalMove(player);
        this.makeVerticalMove(player);
        this.makeHorizontalMove(player);
    }

    private void makeDiagonalMove(Player player)
    {
        int diagonalDown = 0;
        int diagonalUp   = 0;
        for(int i = 0; i < 3; i++)
        {
            if(this.gameField.getGameField()[i][i] == player)
            {
                diagonalDown++;
            }
            if(this.gameField.getGameField()[2-i][i] == player)
            {
                diagonalUp++;
            }
        }
        // make move in the first diagonal
        if(diagonalDown == 2)
        {
            for(int i = 0; i < 3; i++)
            {
                if(this.gameField.getGameField()[i][i] == null)
                {
                    this.gameField.getGameField()[i][i] = computer;
                    this.nextMove = i*3 + i + 1;
                }
            }
        }
        // make move in the second diagonal
        if(diagonalUp == 2)
        {
            for(int i = 0; i < 3; i++)
            {
                if(this.gameField.getGameField()[2-i][i] == null)
                {
                    this.gameField.getGameField()[2-i][i] = computer;
                    this.nextMove = (7 - (2*i));
                }
            }
        }
    }

    private void makeVerticalMove(Player player)
    {
        for(int i = 0; i < 3; i++)
        {
            int verticals = 0;
            for(int y = 0; y < 3; y++)
            {
                Player anotherPlayer = this.gameField.getPlayer(i*3 + y + 1); // verticals counting
                if(anotherPlayer != null && player.equals(anotherPlayer))
                {
                    verticals++;
                }
            }
            if(verticals == 2)
            {
                for(int y = 0; y < 3; y++)
                {
                    Player anotherPlayer = this.gameField.getPlayer(i*3 + y + 1); // verticals counting
                    if(anotherPlayer == null)
                    {
                        this.gameField.setPlayer(computer, i*3 + y + 1);
                        this.nextMove = i*3 + y + 1;
                    }
                }
            }
        }
    }

    private void makeHorizontalMove(Player player)
    {
        for(int i = 0; i < 3; i++)
        {
            int horizontals = 0;
            for(int y = 0; y < 3; y++)
            {
                Player anotherPlayer = this.gameField.getPlayer(y*3 + i + 1); // horizontals counting
                if(anotherPlayer != null && player.equals(anotherPlayer))
                {
                    horizontals++;
                }
            }
            if(horizontals == 2)
            {
                for(int y = 0; y < 3; y++)
                {
                    Player anotherPlayer = this.gameField.getPlayer(y*3 + i + 1); // horizontals counting
                    if(anotherPlayer == null)
                    {
                        this.gameField.setPlayer(computer, y*3 + i + 1);
                        this.nextMove = y*3 + i + 1;
                    }
                }
            }
        }
    }

    private void makeRandomMove()
    {
        Random randomGenerator = new Random();
        int randomNumber;
        randomNumber = randomGenerator.nextInt(9) + 1;
        // force order
        if(this.gameField.getGameField()[1][1] == null)
        {
            this.gameField.getGameField()[1][1] = computer;
            this.nextMove = 5;
            return;
        }
        List<Integer> newArray = new ArrayList<Integer>();
        // find free cells
        for(int i = 0; i < 3; i++)
        {
            for(int y = 0; y < 3; y++)
            {
                if(this.gameField.getGameField()[i][y] == null)
                {
                    newArray.add((3*i) + y + 1);
                }
            }
        }
        // no free cells - game over
        if(newArray.size() == 0)
        {
            return;
        }
        // try to generate random number
        for(;;)
        {
            randomNumber = randomGenerator.nextInt(9) + 1;
            if(newArray.contains(randomNumber))
            {
                break;
            }
        }

        // activate random number
        for(int i = 0; i < 3; i++)
        {
            for(int y = 0; y < 3; y++)
            {
                if(((3*i) + y + 1) == randomNumber)
                {
                    this.gameField.getGameField()[i][y] = computer;
                    this.nextMove = 3*i + y + 1;
                    return;
                }
            }
        }
    }


}

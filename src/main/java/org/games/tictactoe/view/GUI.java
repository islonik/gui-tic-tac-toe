package org.games.tictactoe.view;

import org.games.tictactoe.controller.Controller;
import org.games.tictactoe.model.GameSettings;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 * Main Window
 * @author Lipatov Nikita
 **/
public class GUI extends JFrame implements ActionListener
{

    private List<Cell> cells;
    private static GUI instance = null;

    private Options options;
    private ImageOptions imageOptions;
    private GameSettings gameSettings;
    private boolean isCrossFirstImage  = true;
    private Controller controller;

    private GUI()
    {
        gameSettings = GameSettings.getInstance();
        imageOptions = ImageOptions.getInstance();
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog
            (
                this,
                "Problem with UIManager",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
        initComponents();
        setIconImage(ImageOptions.getInstance().getDefaultIcon().getImage()); // Icon of window
        options = Options.getInstance();
        options.setVisible(false);

        setLocation(480, 240);
        newGameItem.addActionListener(this);
        optionsItem.addActionListener(this);
        imageItem.addActionListener(this);
        aboutItem.addActionListener(this);
        setVisible(true);
    }

    public static GUI getInstance()
    {
        if (instance == null)
        {
            instance = new GUI();
        }
        return instance;
    }

    public Controller getController()
    {
        return controller;
    }

    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    /**
     * Actions for buttons.
     * @param e Event - Click by any button.
     **/
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == newGameItem)
        {
            isCrossFirstImage = (gameSettings.isOddGame()) ? false : true;
            this.unlockAllCells();
            controller.newGame(options);
            controller.makeFirstComputerMove(); // not odd game
        }
        else if(e.getSource() == optionsItem)
        {
            options.setVisible(true);
        }
        else if(e.getSource() == imageItem)
        {
            imageOptions.setVisible(true);
        }
        else if(e.getSource() == aboutItem)
        {
            About.getInstance();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        
        cells = new ArrayList(9);

        for(int i = 1; i < 10; i++)
        {
            Cell cell = new Cell(i);
            cell.setPreferredSize(new Dimension(96, 96));
            cell.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    buttonActionPerformed(evt);
                }
            });
            cells.add(cell);
        }

        menuBar = new javax.swing.JMenuBar();
        gameMenu = new javax.swing.JMenu();
        newGameItem = new javax.swing.JMenuItem();
        optionsMenu = new javax.swing.JMenu();
        optionsItem = new javax.swing.JMenuItem();
        imageItem = new javax.swing.JMenuItem();
        aboutMenu = new javax.swing.JMenu();
        aboutItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tic-tac-toe");
        setResizable(false);

        mainPanel.setMinimumSize(new java.awt.Dimension(384, 384));
        mainPanel.setPreferredSize(new java.awt.Dimension(384, 384));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cells.get(4-1), javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cells.get(1-1), javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(cells.get(5-1), javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cells.get(6-1), javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(cells.get(2-1), javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cells.get(3-1), javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(cells.get(7-1), javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cells.get(8-1), javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cells.get(9-1), javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cells.get(1-1), javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cells.get(2-1), javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cells.get(3-1), javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cells.get(5-1), javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cells.get(4-1), javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cells.get(6-1), javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cells.get(7-1), javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cells.get(8-1), javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cells.get(9-1), javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        gameMenu.setText("Game");

        newGameItem.setText("New Game");
        gameMenu.add(newGameItem);

        menuBar.add(gameMenu);

        optionsMenu.setText("Options");

        optionsItem.setText("Options");
        optionsMenu.add(optionsItem);

        imageItem.setText("Image");
        optionsMenu.add(imageItem);

        menuBar.add(optionsMenu);

        aboutMenu.setText("About");

        aboutItem.setText("About");
        aboutMenu.add(aboutItem);

        menuBar.add(aboutMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }
    // </editor-fold>//GEN-END:initComponents

    private void buttonActionPerformed(ActionEvent evt)
    {
        Cell cell = (Cell)evt.getSource();
        if(!cell.isAlreadyPressed())
        {
            setUpImage(cell.getType());
            controller.action(cell.getType());
        }
    }

    private javax.swing.JMenu optionsMenu;
    private javax.swing.JMenu aboutMenu;
    private javax.swing.JMenu gameMenu;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem aboutItem;
    private javax.swing.JMenuItem imageItem;
    private javax.swing.JMenuItem newGameItem;
    private javax.swing.JMenuItem optionsItem;

    /**
     * Select and install picture in cell
     **/
    public void setUpImage(int button)
    {
        cells.get(button-1).setAlreadyPressed(true);
        try
        {
            Thread.sleep(50);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog
            (
                this,
                "Game is broken",
                "FATAL ERROR",
                JOptionPane.ERROR_MESSAGE
            );
        }

        try
        {
            ImageIcon image;
            if(isCrossFirstImage == true)
            {
                image = new ImageIcon(getClass().getResource(imageOptions.getPictureOne()));
                isCrossFirstImage  = false;
            }
            else
            {
                image = new ImageIcon(getClass().getResource(imageOptions.getPictureTwo()));
                isCrossFirstImage  = true;
            }

            cells.get(button-1).setIcon(image);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog
            (
                this,
                "Game is broken",
                "FATAL ERROR",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void showDraw()
    {
        JOptionPane.showMessageDialog
        (
            this,
            "It's draw!",
            "Draw",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    public void showWinner(String strWinner)
    {
        JOptionPane.showMessageDialog
        (
            this,
            "Congratulations!!! " + strWinner + " is won",
            "Winner",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    public void lockAllCells()
    {
        for(Cell cell : cells)
        {
            cell.setAlreadyPressed(true);
        }
    }

    public void unlockAllCells()
    {
        for(Cell cell : cells)
        {
            cell.setAlreadyPressed(false);
            cell.setIcon(new ImageIcon());
        }
    }

    public boolean hasFreeCells()
    {
        boolean isFreeCellExist = false;
        for(Cell cell : cells)
        {
            if(!cell.isAlreadyPressed())
            {
                isFreeCellExist = true;
            }
        }
        return isFreeCellExist;
    }
}

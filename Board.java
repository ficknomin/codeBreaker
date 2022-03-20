import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Board is the bone structure class of my version of Codebreaker.
 * 
 * It creates a clean CodeBreaker board, when a game is finished there is a choice to close the game or start a new one.
 */

public class Board implements ActionListener
{

    private int difficulty;
    private int counterMain;
    private int counterSupport;
    private int buffer;
    private int guessCount = 0;
    private int correctionCounter = 0;
    private int correctionLabelsCounter = 0;


    private JFrame window = new JFrame("Code Breaker");
    private JFrame winWindow = new JFrame("WIN");
    private JFrame loseWindow = new JFrame("LOSE");

    private JPanel mainPanel = new JPanel();
    private JPanel colourPanel = new JPanel();

    private JLabel[] attemptLabels = new JLabel[100];
    private JLabel[] correctionLabels = new JLabel[100];
    private Guess[] playerGuess = new Guess[100];

    private Guess computerGuess = new Guess(4);
    private Guess computerBuffer = new Guess(4);
    private int[] computerGuessId = new int[100];


    private ImageIcon red = new ImageIcon("Colour_0.png");
    private ImageIcon orange = new ImageIcon("Colour_1.png");
    private ImageIcon yellow = new ImageIcon("Colour_2.png");
    private ImageIcon green = new ImageIcon("Colour_3.png");
    private ImageIcon blue = new ImageIcon("Colour_4.png");
    private ImageIcon indigo = new ImageIcon("Colour_5.png");
    private ImageIcon violet = new ImageIcon("Colour_6.png");
    private ImageIcon empty = new ImageIcon("Empty.png");
    private ImageIcon[] imageIcons = {red, orange, yellow, green, blue, indigo, violet};

    private JButton newGame = new JButton("NEW GAME");
    private JButton exit = new JButton("EXIT CODEBREAKER");

    private JButton colourOne = new JButton(red);
    private JButton colourTwo = new JButton(orange);
    private JButton colourThree = new JButton(yellow);
    private JButton colourFour = new JButton(green);
    private JButton colourFive = new JButton(blue);
    private JButton colourSix = new JButton(indigo);
    private JButton colourSeven = new JButton(violet);
    private JButton[] colours = {colourOne,colourTwo,colourThree, colourFour, colourFive, colourSix, colourSeven};

    /**
     * Constructor for the board class.
     * 
     * @param d is the number of colours guessed.
     * 
     * 2 is added to d into the difficulty variable, which indicates the number of tries a player has.
     */
    public Board(int d)
    {
        window.setSize(320+(d*20),580+(d*20));
        window.setResizable(false);
        window.setContentPane(mainPanel);

        this.difficulty = d + 2;
        mainPanel.setLayout(new GridLayout(difficulty + 1,1));
        mainPanel.setBackground(Color.GRAY);

        counterMain = d;
        counterSupport = d;
        buffer = counterMain;

        newGame.addActionListener(this);
        exit.addActionListener(this);

        for(int y = 0; y < this.difficulty; y++)
        {

            JPanel row = new JPanel();
            row.setLayout(new GridLayout(1, d+1));

            for(int i = 0; i < d; i++)
            {
                JLabel emptyLabel = new JLabel(empty);
                attemptLabels[sizeOfLabels(attemptLabels)] = emptyLabel;
                emptyLabel.setPreferredSize(new Dimension(30,30));
                row.add(emptyLabel);
            }

            JPanel correctionPanel = new JPanel();
            correctionPanel.setLayout(new GridLayout((int) d/2, 2));
            
            for(int z = 0; z < d; z++)
            {
                correctionLabels[z + correctionLabelsCounter] = new JLabel(empty);
                correctionLabels[z + correctionLabelsCounter].setPreferredSize(new Dimension(10, 10));
                correctionPanel.add(correctionLabels[z + correctionLabelsCounter]);
            }
            
            row.add(correctionPanel);
            mainPanel.add(row);

            correctionLabelsCounter = correctionLabelsCounter + d;
        }

        colourPanel.setLayout(new GridLayout(1,7));

        for(int c = 0; c < colours.length; c++)
        {
            colours[c].setPreferredSize(new Dimension(40,40));
            colours[c].addActionListener(this);
            colourPanel.add(colours[c]);
        }

        mainPanel.add(colourPanel);

        window.setVisible(true);
        
        for(int i = 0; i < d; i++)
        {
            computerGuessId[i] = (int) (Math.random()*7);
            computerGuess.addElement(new JLabel(imageIcons[computerGuessId[i]]));
            System.out.println(computerGuess.getElement(computerGuess, i));
        }

        playerGuess[guessCount] = new Guess(d);
        computerGuess.copyPaste(computerGuess, computerBuffer);
    }

    /**
     * Method to count the number of elements of a JLabel array.
     * @param array
     * @return the number of elements.
     */
    public int sizeOfLabels(JLabel[] array)
    {
        int count = 0;
        for(int i = 0; i < array.length; i++)
        {
            if(array[i] != null)
                count++;
        }
        return count;
    }

    /**
     * Action listener that responds to all the buttons pressed.
     * Includes the condition for when the game ends or when the guesses need to be compared.
     */
    public void actionPerformed(ActionEvent e) 
    {   
        
        if(e.getSource() == colourOne)
        {
            attemptLabels[sizeOfLabels(attemptLabels) - counterMain].setIcon(red);
            playerGuess[guessCount].addElement(attemptLabels[sizeOfLabels(attemptLabels) - counterMain]);
            counterMain--;
            counterSupport--;
        }
        
        if(e.getSource() == colourTwo)
        {
            attemptLabels[sizeOfLabels(attemptLabels) - counterMain].setIcon(orange);
            playerGuess[guessCount].addElement(attemptLabels[sizeOfLabels(attemptLabels) - counterMain]);
            counterMain--;
            counterSupport--;
        }

        if(e.getSource() == colourThree)
        {
            attemptLabels[sizeOfLabels(attemptLabels) - counterMain].setIcon(yellow);
            playerGuess[guessCount].addElement(attemptLabels[sizeOfLabels(attemptLabels) - counterMain]);
            counterMain--;
            counterSupport--;
        }

        if(e.getSource() == colourFour)
        {
            attemptLabels[sizeOfLabels(attemptLabels) - counterMain].setIcon(green);
            playerGuess[guessCount].addElement(attemptLabels[sizeOfLabels(attemptLabels) - counterMain]);
            counterMain--;
            counterSupport--;
        }

        if(e.getSource() == colourFive)
        {
            attemptLabels[sizeOfLabels(attemptLabels) - counterMain].setIcon(blue);
            playerGuess[guessCount].addElement(attemptLabels[sizeOfLabels(attemptLabels) - counterMain]);
            counterMain--;
            counterSupport--;
        }

        if(e.getSource() == colourSix)
        {
            attemptLabels[sizeOfLabels(attemptLabels) - counterMain].setIcon(indigo);
            playerGuess[guessCount].addElement(attemptLabels[sizeOfLabels(attemptLabels) - counterMain]);
            counterMain--;
            counterSupport--;
        }

        if(e.getSource() == colourSeven)
        {
            attemptLabels[sizeOfLabels(attemptLabels) - counterMain].setIcon(violet);
            playerGuess[guessCount].addElement(attemptLabels[sizeOfLabels(attemptLabels) - counterMain]);
            counterMain--;
            counterSupport--;
        }

        if(e.getSource() == newGame)
        {
            winWindow.setVisible(false);
            loseWindow.setVisible(false);
            window.setVisible(false);

            Board newGame = new Board(difficulty-2);
        }

        if(e.getSource() == exit)
        {
            System.exit(0);
        }
        
        if(counterSupport < 1)
        {
            counterMain = buffer + (difficulty-2);
            counterSupport = difficulty-2;
            buffer = counterMain;
        }

        if(playerGuess[guessCount].sizeOfGuess(playerGuess[guessCount]) == difficulty - 2)
            {
                int position = playerGuess[guessCount].comparePosition(playerGuess[guessCount], computerGuess);
                int element  = playerGuess[guessCount].compareElement(playerGuess[guessCount], computerGuess);

                if(position == difficulty - 2)
                {
                    winWindow.setSize(200, 100);

                    JPanel winPanel = new JPanel();
                    winPanel.setLayout(new GridLayout(2, 1));
                    winWindow.setContentPane(winPanel);

                    JPanel buttonPanel = new JPanel();
                    buttonPanel.setLayout(new GridLayout(1, 2));

                    JLabel winLabel = new JLabel("YOU WIN!");

                    winPanel.add(winLabel);
                    buttonPanel.add(newGame);
                    buttonPanel.add(exit);
                    winPanel.add(buttonPanel);

                    winWindow.setVisible(true);
                }

                if(guessCount == difficulty - 1 && position != difficulty - 2)
                {
                    loseWindow.setSize(200, 100);

                    JPanel losePanel = new JPanel();
                    losePanel.setLayout(new GridLayout(2, 1));
                    loseWindow.setContentPane(losePanel);

                    JPanel buttonPanel = new JPanel();
                    JLabel winLabel = new JLabel("YOU LOSE :(");

                    buttonPanel.setLayout(new GridLayout(1, 2));
                    buttonPanel.add(newGame);
                    buttonPanel.add(exit);

                    losePanel.add(winLabel);
                    losePanel.add(buttonPanel);
                    
                    loseWindow.setVisible(true);
                }

                for(int i = 0; i < position; i++)
                {
                    System.out.println(correctionLabels[i]);
                    correctionLabels[(sizeOfLabels(correctionLabels) - ((guessCount + 1) * (difficulty-2))) + correctionCounter].setIcon(new ImageIcon("Score_0.png"));
                    correctionCounter++;
                }

                for(int y = 0; y < element; y++)
                {
                    correctionLabels[sizeOfLabels(correctionLabels) - ((guessCount + 1) * (difficulty-2)) + correctionCounter].setIcon(new ImageIcon("Score_1.png"));
                    correctionCounter++;
                }

                guessCount++;
                correctionCounter = 0;
                computerGuess.copyPaste(computerBuffer, computerGuess);
                playerGuess[guessCount] = new Guess(difficulty - 2);
            }
    }

}

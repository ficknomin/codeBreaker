import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board implements ActionListener
{

    private int difficulty;
    private int counterMain = 4;
    private int counterSupport = 4;
    private int buffer = counterMain;
    private int guessCount = 0;
    private int correctionCounter = 0;
    private int correctionLabelsCounter = 0;


    private JFrame window = new JFrame("Code Breaker");
    private JPanel mainPanel = new JPanel();
    private JPanel colourPanel = new JPanel();

    private JLabel[] attemptLabels = new JLabel[100];
    private JLabel[] correctionLabels = new JLabel[100];
    private Guess[] playerGuess = new Guess[100];

    private Guess computerGuess = new Guess(4);
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

    private JButton colourOne = new JButton(red);
    private JButton colourTwo = new JButton(orange);
    private JButton colourThree = new JButton(yellow);
    private JButton colourFour = new JButton(green);
    private JButton colourFive = new JButton(blue);
    private JButton colourSix = new JButton(indigo);
    private JButton colourSeven = new JButton(violet);
    private JButton[] colours = {colourOne,colourTwo,colourThree, colourFour, colourFive, colourSix, colourSeven};

    public Board(int d)
    {
        window.setSize(400,650);
        window.setResizable(false);
        window.setContentPane(mainPanel);

        this.difficulty = d + 2;
        mainPanel.setLayout(new GridLayout(difficulty + 1,1));
        mainPanel.setBackground(Color.GRAY);

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

    }

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
        
        if(counterSupport < 1)
        {
            counterMain = buffer + 4;
            counterSupport = 4;
            buffer = counterMain;
        }

        if(playerGuess[guessCount].getCount(playerGuess[guessCount]) == difficulty - 2)
            {
                int position = playerGuess[guessCount].comparePosition(playerGuess[guessCount], computerGuess);
                int element  = playerGuess[guessCount].compareElement(playerGuess[guessCount], computerGuess);

                System.out.println(position);
                System.out.println(element);

                if(position == difficulty - 2)
                {
                    JFrame winWindow = new JFrame("WIN");
                    winWindow.setSize(200, 100);

                    JPanel winPanel = new JPanel();
                    winWindow.setContentPane(winPanel);

                    JLabel winLabel = new JLabel("YOU WIN!");
                    winPanel.add(winLabel);

                    winWindow.setVisible(true);
                }

                for(int i = 0; i < position; i++)
                {
                    correctionLabels[(sizeOfLabels(correctionLabels) - ((guessCount + 1) * 4)) + correctionCounter].setIcon(new ImageIcon("Score_0.png"));
                    correctionCounter++;
                }


                /*for(int y = 0; y < element; y++)
                {
                    correctionLabels[sizeOfLabels(correctionLabels) - ((guessCount + 1) * 4) + correctionCounter].setIcon(new ImageIcon("Score_1.png"));
                    correctionCounter++;
                }*/


                guessCount++;
                correctionCounter = 0;
                playerGuess[guessCount] = new Guess(difficulty - 2);
            }
    }

}

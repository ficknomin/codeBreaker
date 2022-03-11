import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board implements ActionListener
{

    private int difficulty;
    private int counterMain = 4;
    private int counterSupport = 4;
    private int buffer = counterMain;


    private JFrame window = new JFrame("Code Breaker");
    private JPanel mainPanel = new JPanel();
    private JPanel colourPanel = new JPanel();

    private JLabel[] attemptLabels = new JLabel[100];
    private JLabel[] correctionLabels = new JLabel[100];
    private Guess[] playerGuess = new Guess[100];
    private Guess[] computerCorrecrion = new Guess[100];

    private Guess computerGuess = new Guess(4);
    private int[] computerGuessId = new int[100];


    private Picture red = new Picture("Colour_0.png");
    private Picture orange = new Picture("Colour_1.png");
    private Picture yellow = new Picture("Colour_2.png");
    private Picture green = new Picture("Colour_3.png");
    private Picture blue = new Picture("Colour_4.png");
    private Picture indigo = new Picture("Colour_5.png");
    private Picture violet = new Picture("Colour_6.png");
    private Picture empty = new Picture("Empty.png");
    private Picture[] colourPictures = {red, orange, yellow, green, blue, indigo, violet};

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
                JLabel emptyCorrection = new JLabel(empty);
                correctionLabels[z] = emptyCorrection;
                emptyCorrection.setPreferredSize(new Dimension(10, 10));
                correctionPanel.add(emptyCorrection);
            }
            
            row.add(correctionPanel);
            mainPanel.add(row);
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
            computerGuess.addElement(new JLabel(colourPictures[computerGuessId[i]]));
        }
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
            attemptLabels[sizeOfLabels(attemptLabels) - counterMain].setIcon(new ImageIcon("Colour_0.png"));
            counterMain--;
            counterSupport--;
        }
        
        if(e.getSource() == colourTwo)
        {
            attemptLabels[sizeOfLabels(attemptLabels) - counterMain].setIcon(new ImageIcon("Colour_1.png"));
            counterMain--;
            counterSupport--;
        }

        if(e.getSource() == colourThree)
        {
            attemptLabels[sizeOfLabels(attemptLabels) - counterMain].setIcon(new ImageIcon("Colour_2.png"));
            counterMain--;
            counterSupport--;
        }

        if(e.getSource() == colourFour)
        {
            attemptLabels[sizeOfLabels(attemptLabels) - counterMain].setIcon(new ImageIcon("Colour_3.png"));
            counterMain--;
            counterSupport--;
        }

        if(e.getSource() == colourFive)
        {
            attemptLabels[sizeOfLabels(attemptLabels) - counterMain].setIcon(new ImageIcon("Colour_4.png"));
            counterMain--;
            counterSupport--;
        }

        if(e.getSource() == colourSix)
        {
            attemptLabels[sizeOfLabels(attemptLabels) - counterMain].setIcon(new ImageIcon("Colour_5.png"));
            counterMain--;
            counterSupport--;
        }

        if(e.getSource() == colourSeven)
        {
            attemptLabels[sizeOfLabels(attemptLabels) - counterMain].setIcon(new ImageIcon("Colour_6.png"));
            counterMain--;
            counterSupport--;
        }
        
        if(counterSupport < 1)
        {
            counterMain = buffer + 4;
            counterSupport = 4;
            buffer = counterMain;
        }

    }

}

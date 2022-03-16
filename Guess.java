import javax.swing.*;

public class Guess
{
    int difficulty;
    private JLabel[] guess = new JLabel[100];
    
    public Guess(int d)
    {
        this.difficulty = d;

    }

    public void addElement(JLabel element)
    {
        int count = 0;

        while(guess[count] != null)
        {
            count++;
        }

        guess[count] = element;
    }

    public int compareElement(Guess playerGuess, Guess computerGuess)
    {
        int count = 0;
        JLabel[] playerGuesses = new JLabel[100];
        JLabel[] computerGuesses = new JLabel[difficulty];

        for(int i = 0; i <  difficulty; i++)
        {
            for(int y = 0; y < difficulty; y++)
            {
                if(playerGuess.guess[i].getIcon().toString() == computerGuess.guess[y].getIcon().toString() && i != y)
                {
                    count++;
                }
            }
        }

        return count;
    }

    public int comparePosition(Guess playerGuess, Guess computerGuess)
    {
        int count = 0;

        for(int i = 0; i <  difficulty; i++)
        {
            for(int y = 0; y < difficulty; y++)
            {
                if(playerGuess.guess[i].getIcon().toString() == computerGuess.guess[y].getIcon().toString() && i == y)
                {
                    count++;
                }
            }
        }

        return count;

    }

    public JLabel getElement(Guess computerGuess, int i)
    {
        return computerGuess.guess[i];
    }

    public int getCount(Guess computerGuess)
    {
        int count = 0;

        while(computerGuess.guess[count] != null)
        {
            count++;
        }

        return count;
    }
}
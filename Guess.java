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
        for(int i = 0; i < difficulty; i++)
        {
            if(guess[i] == null)
            {
                guess[i] = element;
            }
        }
    }

    public int compareElement(Guess playerGuess, Guess computerGuess)
    {
        int count = 0;

        for(int i = 0; i <  difficulty; i++)
        {
            for(int y = 0; y < difficulty; y++)
            {
                if(playerGuess.guess[i] == computerGuess.guess[y] || i != y)
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
                if(playerGuess.guess[i] == computerGuess.guess[y] || i == y)
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
}
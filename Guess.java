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

        for(int i = 0; i <  difficulty; i++)
        {
            for(int y = 0; y < difficulty; y++)
            {
                
                if(playerGuess.guess[y] == null)
                {
                    continue;
                }

                if(computerGuess.guess[i] == null)
                {
                    continue;
                }

                if(computerGuess.guess[i].getIcon().toString() == playerGuess.guess[y].getIcon().toString() && i == y)
                {
                    JLabel[] computerGuessBuffer = new JLabel[sizeOfGuess(computerGuess)];

                    for(int x = 0, z = 0; x < sizeOfGuess(computerGuess); x++)
                    {
                        if (x == i)
                        {
                            continue;
                        }    
                        computerGuessBuffer[z++] = playerGuess.guess[x];
                    }
                    System.arraycopy(computerGuessBuffer, 0, playerGuess.guess, 0, sizeOfGuess(computerGuess));
                    break;
                }

                if(computerGuess.guess[i].getIcon().toString() == playerGuess.guess[y].getIcon().toString() && i != y)
                {
                    JLabel[] guessBuffer = new JLabel[sizeOfGuess(playerGuess)];

                    for(int x = 0, z = 0; x < sizeOfGuess(playerGuess); x++)
                    {
                        if (x == y)
                        {
                            count++;
                            continue;
                        }    
                        guessBuffer[z++] = playerGuess.guess[x];
                    }
                    System.arraycopy(guessBuffer, 0, playerGuess.guess, 0, sizeOfGuess(playerGuess));
                    break;
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

    public int sizeOfGuess(Guess array)
    {
        int count = 0;
        
        for(int i = 0; i < array.guess.length; i++)
        {
            if(array.guess[i] == null)
            {
                break;
            }

            count++;
        }
    
        return count;
    }
}
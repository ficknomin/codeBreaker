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
        int countCorrect = 0;

        for(int i = 0; i <  sizeOfGuess(computerGuess); i++)
        {
            for(int y = 0; y < sizeOfGuess(playerGuess); y++)
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
                    countCorrect++;
                    JLabel[] computerGuessBuffer = new JLabel[sizeOfGuess(computerGuess)];
                    JLabel[] guessBuffer = new JLabel[sizeOfGuess(playerGuess)];

                    for(int x = 0, z = 0; x < sizeOfGuess(playerGuess); x++)
                    {
                        if (x == y)
                        {
                            continue;
                        }    
                        guessBuffer[z++] = playerGuess.guess[x];
                    }
                    System.arraycopy(guessBuffer, 0, playerGuess.guess, 0, sizeOfGuess(playerGuess));

                    for(int x = 0, z = 0; x < sizeOfGuess(computerGuess); x++)
                    {
                        if (x == i)
                        {
                            continue;
                        }    
                        computerGuessBuffer[z++] = computerGuess.guess[x];
                    }
                    System.arraycopy(computerGuessBuffer, 0, computerGuess.guess, 0, sizeOfGuess(computerGuess));
                }
            }
        }
        
        for(int i = 0; i <  sizeOfGuess(computerGuess); i++)
        {
            for(int y = 0; y < sizeOfGuess(playerGuess); y++)
            {
                
                if(playerGuess.guess[y] == null)
                {
                    continue;
                }

                if(computerGuess.guess[i] == null)
                {
                    continue;
                }

                if(computerGuess.guess[i].getIcon().toString() == playerGuess.guess[y].getIcon().toString())
                {
                    count++;
                    JLabel[] guessBuffer = new JLabel[sizeOfGuess(playerGuess)];

                    for(int x = 0, z = 0; x < sizeOfGuess(playerGuess); x++)
                    {
                        if (x == y)
                        {
                            continue;
                        }    
                        guessBuffer[z++] = playerGuess.guess[x];
                    }
                    System.arraycopy(guessBuffer, 0, playerGuess.guess, 0, sizeOfGuess(playerGuess));

                    break;
                }
            }
        }

        if(count + countCorrect > difficulty)
        {
            count--;
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

    public void copyPaste(Guess guessOne, Guess guessTwo)
    {
        for (int i = 0; i < sizeOfGuess(guessOne); i++)
        {
            guessTwo.guess[i] = guessOne.guess[i];
        }
    }

    public JLabel getElement(Guess computerGuess, int i)
    {
        return computerGuess.guess[i];
    }

    public JLabel[] getArray()
    {
        return guess;
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
                continue;
            }
            else
            {
                count++;
            }
        }
    
        return count;
    }
}
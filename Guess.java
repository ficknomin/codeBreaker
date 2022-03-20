import javax.swing.*;


/**
 * Guess class creates an array of JLabels to hold any type of guesses(player, computer and buffer).
 * 
 * Methods below give an ability to compare and manipulate with guesses.
 */

public class Guess
{
    int difficulty;
    private JLabel[] guess = new JLabel[100];


    /**
     * 
     * @param d (difficulty) is passed to the constructor determine how many labels a guess will hold.
     */
    public Guess(int d)
    {
        this.difficulty = d;

    }

    /**
     * 
     * @param element is a JLabel that is added to the array when a button is pressed.
     */

    public void addElement(JLabel element)
    {
        int count = 0;

        while(guess[count] != null)
        {
            count++;
        }

        guess[count] = element;
    }

    /**
     * @param playerGuess is the guess that player made(an array of JLabels)
     * @param computerGuess is the guess that the computer made.
     * 
     * Compares two guesses, deletes common elements from the guesses to avoid duplication.
     * 
     * @return the number of white tiles to place (correct colour, but wrong position)
     */
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

    /**
     * @param playerGuess
     * @param computerGuess
     * 
     * Compares the guesses in terms of both colour and position.
     * 
     * @return the number of black tiles to press. (both requirements met).
     */
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

    /**
     * 
     * @param guessOne
     * @param guessTwo
     * 
     * copy pastes the elements of guessOne into guessTwo.
     */
    public void copyPaste(Guess guessOne, Guess guessTwo)
    {
        for (int i = 0; i < sizeOfGuess(guessOne); i++)
        {
            guessTwo.guess[i] = guessOne.guess[i];
        }
    }


    /**
     * 
     * @param computerGuess
     * @param i the index an element of which is needed.
     * 
     * @return the element of the given index
     */
    public JLabel getElement(Guess computerGuess, int i)
    {
        return computerGuess.guess[i];
    }

    /**
     * @return the JLabel array that makes up the guess(used in some calculations).
     */
    public JLabel[] getArray()
    {
        return guess;
    }

    /**
     * 
     * @param array the guess is passed to the method.
     * 
     * @return the number of elements in the guess.
     */
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
import java.util.*;

public class CodeBreaker
{
    public static void main(String[] arg)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the difficulty(number of colours to guess):");

        int difficulty = input.nextInt();

        Board gameArea = new Board(difficulty);
    }
}
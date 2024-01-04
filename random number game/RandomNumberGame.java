import java.util.Random;
import javax.swing.JOptionPane;

public class RandomNumberGame 
{
    public static void main(String[] args) 
    {
        // Define the range
        int min = 1;
        int max = 100;

        // Set the maximum number of attempts
        int maxAttempts = 4;

        // Flag to control the game loop
        boolean playAgain = true;

        // Counter to keep track of the user's score (rounds won)
        int score = 0;

        while (playAgain) 
        {
            // Generate a random number within the specified range for each new round
            int randomNumber = generateRandomNumber(min, max);

            // Reset attempts for each new round
            int attemptsLeft = maxAttempts;

            // Repeat steps 2 and 3 until the user guesses the correct number or runs out of attempts
            while (attemptsLeft > 0) 
            {
                // Prompt the user to enter their guess
                String userInput = JOptionPane.showInputDialog("Attempts left: " + attemptsLeft +
                                                               "\nEnter your guess (between 1 and 100):");

                // Check if the user cancels or closes the input dialog
                if (userInput == null) 
                {
                    playAgain = false; // Exit the game loop if the user cancels or closes the input dialog
                    break;
                }

                try 
                {
                    // Convert the user input to an integer
                    int userGuess = Integer.parseInt(userInput);

                    // Compare the user's guess with the generated number and provide feedback
                    if (compareUserGuess(randomNumber, userGuess)) 
                    {
                        // If the guess is correct, increment the score and break out of the inner loop
                        JOptionPane.showMessageDialog(null, "Congratulations! Your guess is correct.");
                        score++;
                        break;
                    }

                    // Display remaining attempts if the user's guess is incorrect
                    attemptsLeft--;

                    if (attemptsLeft > 0) 
                    {
                        JOptionPane.showMessageDialog(null, "Incorrect guess. " + attemptsLeft + " attempts remaining.");
                    } 
                    else 
                    {
                        JOptionPane.showMessageDialog(null, "Sorry, you've run out of attempts. The correct number was: " + randomNumber);
                    }
                } 
                catch (NumberFormatException e) 
                {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer.");
                }
            }

            // Ask the user if they want to play again
            int playAgainOption = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again", JOptionPane.YES_NO_OPTION);

            if (playAgainOption == JOptionPane.NO_OPTION) 
            {
                playAgain = false; // Exit the game loop if the user chooses not to play again
            }
        }

        // Display the user's final score
        JOptionPane.showMessageDialog(null, "Your final score: " + score);
    }

    // Method to generate a random number within a specified range
    private static int generateRandomNumber(int min, int max) 
    {
        if (min >= max) 
        {
            throw new IllegalArgumentException("Max must be greater than Min");
        }

        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    // Method to compare the user's guess with the generated number and provide feedback
    private static boolean compareUserGuess(int randomNumber, int userGuess) 
    {
        if (userGuess < 1 || userGuess > 100) 
        {
            JOptionPane.showMessageDialog(null, "Invalid guess. Please enter a number between 1 and 100.");
        }
        
        else if (userGuess == randomNumber) 
        {
            return true; // Return true to indicate that the correct number was guessed
        } 
        
        else if (userGuess < randomNumber) 
        {
            JOptionPane.showMessageDialog(null, "Too low! Try again.");
        } 
        
        else 
        {
            JOptionPane.showMessageDialog(null, "Too high! Try again.");
        }
        return false; // Return false to indicate that the correct number was not guessed
    }
}

import java.util.Random;
import javax.swing.JOptionPane;

public class GuessTheNumber {
    public static void main(String[] args) {
        // Set the range of the random number
        int minRange = 1;
        int maxRange = 100;

        // Set the maximum number of attempts
        int maxAttempts = 10;

        // Set the initial score to 0
        int score = 0;

        // Create a random number generator
        Random random = new Random();

        // Generate the random number
        int number = random.nextInt(maxRange - minRange + 1) + minRange;

        // Loop until the user guesses the number or runs out of attempts
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            // Prompt the user to enter their guess
            String guessStr = JOptionPane.showInputDialog("Guess the number (between " + minRange + " and " + maxRange + ")");

            // Convert the user's guess to an integer
            int guess = Integer.parseInt(guessStr);

            // Check if the guess is correct
            if (guess == number) {
                // Increment the score by the number of remaining attempts
                score += maxAttempts - attempt + 1;

                // Display a message congratulating the user
                JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number in " + attempt + " attempt(s). Your score is " + score);

                // Ask the user if they want to play again
                int playAgain = JOptionPane.showConfirmDialog(null, "Do you want to play again?");

                // If the user chooses not to play again, exit the program
                if (playAgain != JOptionPane.YES_OPTION) {
                    System.exit(0);
                }

                // Generate a new random number and reset the attempt counter
                number = random.nextInt(maxRange - minRange + 1) + minRange;
                attempt = 0;

                // Reset the score to 0
                score = 0;
            } else {
                // Tell the user if their guess is too high or too low
                if (guess < number) {
                    JOptionPane.showMessageDialog(null, "Your guess is too low.");
                } else {
                    JOptionPane.showMessageDialog(null, "Your guess is too high.");
                }
            }
        }

        // If the user runs out of attempts, display a message and exit the program
        JOptionPane.showMessageDialog(null, "Sorry, you ran out of attempts. The number was " + number + ". Your score is " + score);

        // Ask the user if they want to play again
        int playAgain = JOptionPane.showConfirmDialog(null, "Do you want to play again?");

        // If the user chooses to play again, restart the program
        if (playAgain == JOptionPane.YES_OPTION) {
            main(args);
        }
    }
}

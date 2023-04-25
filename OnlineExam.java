import java.util.Scanner;

public class OnlineExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = "user123";
        String password = "pass123";
        int timeLimit = 60; // Time limit in minutes
        int remainingTime = timeLimit;
        int totalQuestions = 5;
        int correctAnswers = 0;
        boolean loggedIn = false;

        // Login
        System.out.println("Welcome to the Online Exam System!");
        while (!loggedIn) {
            System.out.print("Username: ");
            String inputUsername = scanner.nextLine();
            System.out.print("Password: ");
            String inputPassword = scanner.nextLine();
            if (inputUsername.equals(username) && inputPassword.equals(password)) {
                System.out.println("Login successful!");
                loggedIn = true;
            } else {
                System.out.println("Incorrect username or password. Please try again.");
            }
        }

        // Update profile and password
        System.out.println("Do you want to update your profile or password? (y/n)");
        String updateChoice = scanner.nextLine();
        if (updateChoice.equals("y")) {
            System.out.println("Enter new profile information:");
            // Code to update profile information
            System.out.println("Enter new password:");
            String newPassword = scanner.nextLine();
            password = newPassword;
            System.out.println("Password updated successfully!");
        }

       // Selecting answers for MCQs
       System.out.println("You have " + timeLimit + " minutes to complete the exam.");
       System.out.println("There are " + totalQuestions + " multiple-choice questions.");
       for (int i = 1; i <= totalQuestions-4; i++) {
         System.out.println("Question " + i + ":");
    // Code to display question and answer options
        System.out.println("What is the capital of India?");
        System.out.println("a) New Delhi");
        System.out.println("b) Mumbai");
        System.out.println("c) Kolkata");
        System.out.println("d) Chennai");
        System.out.print("Enter your answer (a, b, c, or d): ");
        String answer = scanner.nextLine();
    // Code to check if answer is correct
       if (answer.equalsIgnoreCase("a")) {
        correctAnswers++;
    }

    System.out.println("Question " + (i+1) + ":");
    // Code to display question and answer options
    System.out.println("What is the highest mountain in the world?");
    System.out.println("a) K2");
    System.out.println("b) Mount Everest");
    System.out.println("c) Kangchenjunga");
    System.out.println("d) Lhotse");
    System.out.print("Enter your answer (a, b, c, or d): ");
    answer = scanner.nextLine();
    // Code to check if answer is correct
    if (answer.equalsIgnoreCase("b")) {
        correctAnswers++;
    }

    System.out.println("Question " + (i+2) + ":");
// Code to display question and answer options
System.out.println("What is the largest planet in our solar system?");
System.out.println("a) Mars");
System.out.println("b) Venus");
System.out.println("c) Jupiter");
System.out.println("d) Saturn");
System.out.print("Enter your answer (a, b, c, or d): ");
answer = scanner.nextLine();
// Code to check if answer is correct
if (answer.equalsIgnoreCase("c")) {
    correctAnswers++;
}

System.out.println("Question " + (i+3) + ":");
// Code to display question and answer options
System.out.println("Who painted the Mona Lisa?");
System.out.println("a) Pablo Picasso");
System.out.println("b) Leonardo da Vinci");
System.out.println("c) Vincent van Gogh");
System.out.println("d) Claude Monet");
System.out.print("Enter your answer (a, b, c, or d): ");
answer = scanner.nextLine();
// Code to check if answer is correct
if (answer.equalsIgnoreCase("b")) {
    correctAnswers++;
}

// Add more questions and answer options here
System.out.println("Question " + (i+4) + ":");
// Code to display question and answer options
System.out.println("Who is the prime minister of India?");
System.out.println("a) Narendra Modi");
System.out.println("b) kejriwal");
System.out.println("c) Rahul Gandhi");
System.out.println("d) Jagan");
System.out.print("Enter your answer (a, b, c, or d): ");
answer = scanner.nextLine();
// Code to check if answer is correct
if (answer.equalsIgnoreCase("a")) 
{
    correctAnswers++;


}
}


        // Timer and auto submit
        System.out.println("Time remaining: " + remainingTime + " minutes");
        while (remainingTime > 0) {
            try {
                Thread.sleep(60000); // Sleep for 1 minute
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            remainingTime--;
            System.out.println("Time remaining: " + remainingTime + " minutes");
        }
        System.out.println("Time is up! Submitting exam...");

        // Closing session and logout
        System.out.println("You answered " + correctAnswers + " out of " + totalQuestions + " questions correctly.");
        System.out.println("Thank you for taking the exam. Goodbye!");
    }
}


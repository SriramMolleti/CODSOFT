import java.util.Scanner;

public class SriramGame {
    public static void main(String[] args) {
        System.out.println("SRIRAMMOLLETI,TASK1");
        Scanner scanner = new Scanner(System.in);
        int lowerBound = 1;
        int upperBound = 100;
        int attempts = 0;
        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            int randomNumber = generateNumber(lowerBound, upperBound);
            int userGuess = getUserGuess(scanner, lowerBound, upperBound);
            attempts = 1;

            while (userGuess != randomNumber) {
                printFeedback(userGuess, randomNumber);
                userGuess = getUserGuess(scanner, lowerBound, upperBound);
                attempts++;
            }

            System.out.println("Congratulations! You guessed the correct number in SriramGame.");
            System.out.println("It took you " + attempts + " attempts.");
            score++;

            System.out.println("Your current score is in SriramGame " + score + ".");
            playAgain = getPlayAgainInput(scanner);
        }
        scanner.close();
    }

    private static int generateNumber(int lowerBound, int upperBound) {
        return (int) (Math.random() * (upperBound - lowerBound + 1)) + lowerBound;
    }

    private static int getUserGuess(Scanner scanner, int lowerBound, int upperBound) {
        while (true) {
            System.out.println("Enter your guess between " + lowerBound + " and " + upperBound + ": ");
            String userInput = scanner.nextLine();

            if (userInput.matches("\\d+")) {
                int userGuess = Integer.parseInt(userInput);

                if (userGuess >= lowerBound && userGuess <= upperBound) {
                    return userGuess;
                } else {
                    System.out.println("Invalid input in SriramGame. Please enter a number between " + lowerBound + " and " + upperBound + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a number between " + lowerBound + " and " + upperBound + ".");
            }
        }
    }

    private static void printFeedback(int userGuess, int randomNumber) {
        if (userGuess > randomNumber) {
            System.out.println("Your guess is very high, sir/ma'am.");
        } else {
            System.out.println("Your guess is very low, sir/ma'am.");
        }
    }

    private static boolean getPlayAgainInput(Scanner scanner) {
        while (true) {
            System.out.println("Do you want to play SriramGame again? (yes/no): ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("yes")) {
                return true;
            } else if (userInput.equalsIgnoreCase("no")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }
    }
}
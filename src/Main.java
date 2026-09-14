import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int lowerBound = 1;
        int upperBound = 100;

        System.out.println("=================================");
        System.out.println("    NUMBER GUESSING GAME");
        System.out.println("=================================");
        System.out.println("Welcome! Can you guess my secret number?");

        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();
            boolean keepPlaying = true;

            while (keepPlaying) {
                int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
                int tries = 0;

                System.out.println("\nI'm thinking of a number between " 
                        + lowerBound + " and " + upperBound + "...");

                while (true) {
                    System.out.print("Your guess: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Oops, that's not a whole number. Try again!");
                        scanner.next(); // Clear invalid input
                        continue;
                    }

                    int userGuess = scanner.nextInt();

                    // Ignore attempts out of range without penalizing the counter
                    if (userGuess < lowerBound || userGuess > upperBound) {
                        System.out.println("Stick to numbers between " 
                                + lowerBound + " and " + upperBound + "!");
                        continue;
                    }

                    tries++;

                    if (userGuess < targetNumber) {
                        System.out.println("Too low! Go higher.");
                    } else if (userGuess > targetNumber) {
                        System.out.println("Too high! Go lower.");
                    } else {
                        System.out.println("\n🎉 You got it!");
                        System.out.println("The secret number was indeed " + targetNumber + ".");
                        System.out.println("Total attempts: " + tries);

                        giveFeedback(tries);
                        break;
                    }
                }

                System.out.print("\nWant to take another round? (y/n): ");
                String response = scanner.next().trim();
                keepPlaying = response.equalsIgnoreCase("y");
            }

            System.out.println("\nThanks for playing! See you next time. 👋");
        }
    }

    private static void giveFeedback(int totalTries) {
        if (totalTries <= 3) {
            System.out.println("⭐ Incredible precision!");
        } else if (totalTries <= 6) {
            System.out.println("👍 Solid logic, nice work!");
        } else if (totalTries <= 10) {
            System.out.println("🙂 Not bad at all!");
        } else {
            System.out.println("phew, that was a close one! Got there in the end.");
        }
    }
}

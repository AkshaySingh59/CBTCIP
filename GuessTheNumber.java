import java.util.Scanner;
import java.util.Random;
public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        int rounds = 3;
        int maxAttempts = 10;
        int score = 0;
        System.out.println("Welcome to the Guess The NUmber game!");
        System.out.println("You have "+rounds+" rounds to play. In each round you have 10 attempts.");
        System.out.println("You will get points based on your attempts.");
        for (int i = 1; i <= rounds; i++) {
            System.out.println("Round "+i+" begins!");
            int randomNumber = rd.nextInt(100) + 1;
            int attempts = 0;
            boolean guessed = false;
            while (attempts < maxAttempts && !guessed) {
                System.out.println("Enter you guess between 1 to 100: ");
                int userGuess = sc.nextInt();
                attempts++;
                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number.");
                    guessed = true;
                    score += (maxAttempts - attempts + 1);
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            if (!guessed) {
                System.out.println("You've used all your attempts");
                System.out.println("The number was "+randomNumber);
            }
            System.out.println("Your score is "+score);
        }
    }
}
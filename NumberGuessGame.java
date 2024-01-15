import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {
    static Scanner scanner = new Scanner(System.in);

    public static void guessNum(int maxNumber, int maxAttempts) {
        Random random = new Random();
        int rNum = random.nextInt(maxNumber) + 1;

        int counter = 0;
        int score = 0;

        while (counter < maxAttempts) {
            System.out.println("Enter a Number between 1 and " + maxNumber + ": ");
            System.out.println("You have " + (maxAttempts - counter) + " guesses left.");
            int getNum = scanner.nextInt();

            if (getNum < rNum) {
                System.out.println("Too Low. ");
            } else if (getNum > rNum) {
                System.out.println("Too High. ");
            } else {
                System.out.println("You Win! ");
                score += (maxAttempts - counter);
                break;
            }

            counter++;
        }

        if (counter == maxAttempts) {
            System.out.println("You Lose. The correct number was: " + rNum);
        }

        System.out.println("Round Score: " + score);
        totalScore += score;
    }

    static int totalScore = 0;

    public static void main(String args[]) {
        int maxNumber = 100;
        int maxAttempts = 10;
        int numRounds = 3;

        do {
            for (int round = 1; round <= numRounds; round++) {
                System.out.println("Round " + round);
                guessNum(maxNumber, maxAttempts);
                System.out.println("------------------------------");
            }

            System.out.println("Total Score: " + totalScore);

            System.out.println("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (playAgain.equals("no")) {
                break;
            }
        } while (true);

        System.out.println("Game Over. Exiting...");
        scanner.close();
    }
}

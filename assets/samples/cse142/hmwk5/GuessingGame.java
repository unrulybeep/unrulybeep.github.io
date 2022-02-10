// Elle Boyechko
// CSE 142 AP
// Althea Poteet
// Homework #5 (Guessing Game)
// Plays a guessing game with the user by prompting them to enter a number from
// 1 to MAX_RANGE until the correct number is entered. It prompts the user to
// see if they would like to play again, and if so continues the game. If not
// it prints the total attempts by the user, the average number of guesses,
// how many games they've played and how many guesses were in their best game.
import java.util.*;

public class GuessingGame {
   
   public static final int MAX_RANGE = 100;
   
   public static void main(String[] args) {
      haiku();
      startHere();
   }
   
   // Prints out a haiku written by the program's author with instructions for
   // the guessing game.
   public static void haiku() {
      System.out.println("Let us play a game");
      System.out.println("I pick a number, you guess");
      System.out.println("Refrigerator");
   }
   
   // Creates the basis for the game. Uses a while loop to keep going until the
   // user inputs otherwise. Calls playGame by passing the Scanner parameter.
   // Calls method and submits parameters for the user's statistics at conclusion.
   public static void startHere() {
      Scanner console = new Scanner(System.in);
      boolean keepPlaying = true;
      int totalGames = 0;
      double totalAttempts = 0;
      int fewestAttempts = 0;
      
      while (keepPlaying) {
         int gameAttempts = playGame(console);
         totalGames++;
         totalAttempts = totalAttempts + gameAttempts;
         if (totalGames == 1 || gameAttempts < fewestAttempts) {
            fewestAttempts = gameAttempts;
         }
         
         System.out.print("Do you want to play again? ");
         String answer = console.next();
         if (answer.toLowerCase().startsWith("y")) {
            keepPlaying = true;
         }
         else {
            keepPlaying = false;
         }
      }
      printStats(totalGames, totalAttempts, fewestAttempts);
   }
   
   // Accepts the Scanner parameter and returns number of attempts needed to
   // guess right. Prompts the user for their guess and prints clues for
   // incorrect guesses.
   public static int playGame(Scanner console) {
    Random rand = new Random();
      int attempts = 0;
      int guess = -1;
      
      System.out.println();
      System.out.println("I'm thinking of a number between 1 and " + MAX_RANGE
      + "...");
      int numberPicked = rand.nextInt(MAX_RANGE) + 1;
      while (guess != numberPicked) {
         System.out.print("Your guess? ");
         guess = console.nextInt();
         attempts++;
         
         if (guess == numberPicked) {
            if (attempts == 1) {
               System.out.println("You got it right in " + attempts +
               " guess!");
            }
            else {
               System.out.println("You got it right in " + attempts +
               " guesses!");
            }
         }
         else if (numberPicked > guess) {
            System.out.println("It's higher.");
         }
         else {
            System.out.println("It's lower.");
         }
      }
      return attempts;
   }
   
   // Prints out the ending statistics for the game by accepting parameters for
   // total games played, total guesses made by the user, and the attempts
   // for the user's best game.
   public static void printStats(int totalGames, double totalAttempts,
   int fewestAttempts) {
      System.out.println();
      System.out.println("Overall results:");
      System.out.printf("Total games   = %d\n", totalGames);
      System.out.printf("Total guesses = %.0f\n", totalAttempts);
      System.out.printf("Guesses/game  = %.1f\n", totalAttempts / totalGames);
      System.out.printf("Best game     = " + fewestAttempts);
   }
}
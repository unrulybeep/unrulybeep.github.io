// Elle Boyechko
// CSE 142 AP
// Althea Poteet
// Homework #6 (Mad Lib)
// Program let's the user create and play with Mad libs. It will prompt the user
// to either create a Mad Lib or view a Mad Lib by asking for an input file, or
// allow the user to exit the game. If a Mad Lib is created, then the user is
// prompted for the placeholders, and when the Mad Lib is complete it prints it
// to a user specified file. When a user wants to view a Mad Lib, the program
// displays the specified file, and then prompts the user to create, view or exit.

import java.io.*;
import java.util.*;

public class MadLibs {


   public static void main(String[] args) throws FileNotFoundException {
      Scanner console = new Scanner(System.in);
//      Scanner inputFile;
//      PrintStream outputFile;
      String answer = "";

      intro();
      System.out.println();
      answer = menu(console);
      while (!answer.equals("q")) {
         filePrompts(console, answer);
         answer = menu(console);
      }      
   }
   
   //Displays the Mad Lib game menu options and returns the user's answer in
   //lowercase form.
   public static String menu(Scanner console) {
      String answer = "";
      while (!answer.equals("c") && !answer.equals("v") && !answer.equals("q")) {
         System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
         answer = console.nextLine().toLowerCase();
      }
      return answer;
   }
   
   //Asks user for the file name of the mad-lib, repeating prompt if file cannot
   //be found. Then either displays the requested mad-lib to the user, or begins
   //the process of creating one.
   public static void filePrompts(Scanner console, String answer)
                                  throws FileNotFoundException {
      System.out.print("Input file name: ");
      File inputFilename = new File(console.nextLine());
      while (!inputFilename.exists()) {
         System.out.print("File not found. Try again: ");
         inputFilename = new File(console.nextLine());
      }
      Scanner inputFile = new Scanner(inputFilename);
      if (answer.equals("v")) {
         System.out.println();
         while (inputFile.hasNextLine()){
            System.out.println(inputFile.nextLine());
         }
         System.out.println();
      } else if (answer.equals("c")) {
         createMadLib(console, inputFile);
      }
   }
   
   //Asks the user for the file name to write the mad-lib to. Then goes through
   //the file asking the user to fill in the placeholders. The file is written
   //to with the user's answers and a confirmation message is displayed.
   public static void createMadLib(Scanner console, Scanner inputFile)
                                   throws FileNotFoundException {
      System.out.print("Output file name: ");
      PrintStream outputFile = new PrintStream(new File(console.nextLine()));
      System.out.println();
      while(inputFile.hasNextLine()) {
         String line = inputFile.nextLine();
         Scanner words = new Scanner(line);
         while (words.hasNext()) {
            String word = words.next();
            if (word.startsWith("<") && word.endsWith(">")) {
               String wordPrompt = word.substring(1, word.length() - 1);
               if (wordPrompt.contains("-")) {
                  wordPrompt = wordPrompt.replace("-", " ");
               }
               System.out.print("Please type " + articleAgreement(wordPrompt) +
                                " " + wordPrompt + ": ");
               String response = console.nextLine();
               outputFile.print(response + " ");
            } else {
               outputFile.print(word + " ");
            }
         }
         outputFile.println();
      }
      System.out.println("Your mad-lib has been created!");
      System.out.println();
   }
   
   //Displays the Mad Lib game intro to the user's screen.   
   public static void intro() {
      System.out.println("Welcome to the game of Mad Libs.");
      System.out.println("I will ask you to provide various words");
      System.out.println("and phrases to fill in a story.");
      System.out.println("The result will be written to an output file.");     
   }
   
   //Checks whether the placeholder prompt should use "a" or "an".
   public static String articleAgreement(String wordPrompt) {
      String wordPromptCheck = wordPrompt.toLowerCase();
      String article;
      if (wordPromptCheck.startsWith("a") || wordPromptCheck.startsWith("e") ||
          wordPromptCheck.startsWith("i") || wordPromptCheck.startsWith("o") ||
          wordPromptCheck.startsWith("u")) {
         article = "an";
      } else {
         article = "a";
      } 
   return article;
   }   
} 
// Elle Boyechko, CSE 142 B, Winter 2017
// Programming Assignment #1

// Prints the first 6 verses of the song "Twelve Days of Xmas" with a custom 7th verse by the author of this program.
public class Song {
   public static void main(String[] args) {
      firstD();
      secondD();
      thirdD();
      fourthD();
      fifthD();
      sixthD();
      seventhD();
   }

   // Prints the first line of Twelve Days of Xmas, then the gift received on that day.
   public static void firstD() {  
      System.out.println("On the 1st day of \"Xmas\", my true love gave to me");
      firstG();
   }
  
   // Prints the second line of Twelve Days of Xmas, then the gifts received on that day.
   public static void secondD() {
      System.out.println("On the 2nd day of \"Xmas\", my true love gave to me");
      secondG();
   }
  
   // Prints the third line of Twelve Days of Xmas, then the gifts received on that day
   // as well as the previous days.
   public static void thirdD() {
      System.out.println("On the 3rd day of \"Xmas\", my true love gave to me");
      thirdG();
   } 
  
   // Prints the fourth line of Twelve Days of Xmas, then the gifts received on that day
   // as well as the previous days.
   public static void fourthD() {
      System.out.println("On the 4th day of \"Xmas\", my true love gave to me");
      fourthG();
   }
  
   // Prints the fifth line of Twelve Days of Xmas, then the gifts received on that day
   // as well as the previous days. 
   public static void fifthD() {
      System.out.println("On the 5th day of \"Xmas\", my true love gave to me");
      fifthG();
   }
  
   // Prints the sixth line of Twelve Days of Xmas, then the gifts received on that day
   // as well as the previous days. 
   public static void sixthD() {
      System.out.println("On the 6th day of \"Xmas\", my true love gave to me");
      sixthG();
   }
   
   // Prints the gift received on the first day followed by a blank line.
   public static void firstG() {
      System.out.println("a partridge in a pear tree.");
      System.out.println();
   }
   
   // Prints the gift received on the second day, as well as the previous gifts.
   public static void secondG() {
      System.out.println("two turtle doves, and");
      firstG();      
   }

   // Prints the gift received on the third day, as well as the previous gifts.
   public static void thirdG() {
      System.out.println("three French hens,");
      secondG();
   }

   // Prints the gift received on the fourth day, as well as the previous gifts.
   public static void fourthG() {
      System.out.println("four calling birds,");
      thirdG();
   }

   // Prints the gift received on the fifth day, as well as the previous gifts.
   public static void fifthG() {
      System.out.println("five golden rings,");
      fourthG();
   }

   // Prints the gift received on the sixth day, as well as the previous gifts.
   public static void sixthG() {
      System.out.println("six geese a-laying,");
      fifthG();
   }

   // Prints the title to a song by Garabage.
   public static void songTitle() {
      System.out.println("I'm only happy when it rains");   
   }
   
   //Prints a repeated stanza of "Only Happy When It Rains" by Garbage.
   public static void songBridge() {
      System.out.println("Pour your misery down");
      System.out.println("Pour your misery down on me");
   }

   // Prints the lyrics to "Only Happy When It Rains" by Garabage.
   public static void seventhD() {
      songTitle();
      System.out.println("I'm only happy when it's complicated");
      System.out.println("And though I know you can't appreciate it");
      songTitle();
      System.out.println("");
      System.out.println("You know I love it when the news is bad");
      System.out.println("Why it feels so good to feel so sad?");
      songTitle();
      System.out.println("");
      songBridge();
      songBridge();
      System.out.println("");
      songTitle();
      System.out.println("I feel good when things are goin' wrong");
      System.out.println("I only listen to the sad, sad songs");
      songTitle();
      System.out.println("");
      System.out.println("I only smile in the dark");
      System.out.println("My only comfort is the night gone black");
      System.out.println("I didn't accidentally tell you that");
      songTitle();
      System.out.println("You'll get the message by the time I'm through");
      System.out.println("When I complain about me and you");
      songTitle();
   }
}
// Elle Boyechko
// CSE 142 AP
// Althea Poteet
// Homework #2 (ASCII Art / Space Needle) [with constant]
// Displays an custom ascii image by the program's author
public class asciiArt {

   public static void main(String[] args) {
      topL();
      spaceD();
      phraseMe();
      topL();
      spaceD();
      phraseX();
      elleE();
   }


   public static void topL(){
      System.out.print("|");
         for (int topL = 1; topL <= 12; topL ++) {
            System.out.print("-");
         }
      System.out.println("|");
   }
     
   public static void spaceD() {
      System.out.print("|");
      for (int spaced = 1; spaced <= 12; spaced++) {
         System.out.print(" ");
      }
      System.out.println("|");
      System.out.println("|   _________|");
      System.out.println("|   |");
      System.out.println("|   |--------|");
      System.out.print("|");
      for (int spaced = 1; spaced <= 12; spaced++) {
         System.out.print(" ");
      }
      System.out.println("|");
      System.out.println("|   _________|");
      System.out.println("|   |");
      System.out.println("|   |--------|");
      System.out.print("|");
      for (int spaced = 1; spaced <= 12; spaced++) {
         System.out.print(" ");
      }
      System.out.println("|");
      System.out.println("|____________|");     
   }
      
   public static void phraseMe() {
      System.out.println("is for Elle.");
      System.out.println();
   }
   
   public static void phraseX() {
      System.out.println("is for Excellent.");
      System.out.println();
   }
   
   public static void elleE() {
      System.out.println("Elle  Excellent");
      System.out.println("Elle  Excellent");
      System.out.println("Elle");
      System.out.println("Elle");
      System.out.println("Elle  Excellent");
      System.out.println("Elle  Excellent");
      System.out.println("Elle");
      System.out.println("Elle");
      System.out.println("Elle  Excellent");
      System.out.println("Elle  Excellent");
   }
}
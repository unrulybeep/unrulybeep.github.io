// Elle Boyechko
// CSE 142 AP
// Althea Poteet
// Homework #2 (ASCII Art / Space Needle)
// Displays an custom ascii image by the program's author
public class AsciiArt {

   public static void main(String[] args) {
      topL();
      spaceD();
      topL();
      spaceE();
      elleE();
      elleE();
      elleE();
   }


   public static void topL(){
      System.out.print("|");
         for (int topL = 1; topL <= 12; topL ++) {
            System.out.print("-");
         }
      System.out.print("|    ");
      System.out.print("|");
         for (int topL = 1; topL <= 12; topL ++) {
            System.out.print("-");
         }
      System.out.print("|    ");
      System.out.print("|");
         for (int topL = 1; topL <= 12; topL ++) {
            System.out.print("-");
         }
      System.out.print("|    ");
      System.out.print("|");
         for (int topL = 1; topL <= 12; topL ++) {
            System.out.print("-");
         }
      System.out.print("|    ");
      System.out.println();
            System.out.print("|");
      for (int spaced = 1; spaced <= 12; spaced++) {
         System.out.print(" ");
      }
      System.out.print("|    |");
      for (int spaced = 1; spaced <= 12; spaced++) {
         System.out.print(" ");
      }
      System.out.print("|    |");
      for (int spaced = 1; spaced <= 12; spaced++) {
         System.out.print(" ");
      }
      System.out.print("|    |");
      for (int spaced = 1; spaced <= 12; spaced++) {
         System.out.print(" ");
      }
      System.out.println("|  ");
   }
     
   public static void spaceD() {
      System.out.println("|   _________|    |   _________|    |   _________|    |   _________|");
      System.out.println("|   |             |   |             |   |             |   |");
      System.out.println("|   |--------|    |   |--------|    |   |--------|    |   |--------|");
      System.out.println("|            |    |            |    |            |    |            |");
      System.out.println("|   _________|    |   _________|    |   _________|    |   _________|");
      System.out.println("|   |             |   |             |   |             |   |");
      System.out.println("|   |--------|    |   ---------|    |   ---------|    |   |--------|");
      System.out.print("|");
      for (int spaced = 1; spaced <= 12; spaced++) {
         System.out.print(" ");
      }
      System.out.print("|    |");
      for (int spaced = 1; spaced <= 12; spaced++) {
         System.out.print(" ");
      }
      System.out.print("|    |");
      for (int spaced = 1; spaced <= 12; spaced++) {
         System.out.print(" ");
      }
      System.out.print("|    |");
      for (int spaced = 1; spaced <= 12; spaced++) {
         System.out.print(" ");
      }
      System.out.println("|");
      System.out.println("|____________|    |____________|    |____________|    |____________|");
      phraseMe();
   }
   
      public static void spaceE() {
      System.out.println("|   _________|    |   _________|    |   _________|    |   _________|");
      System.out.println("|   |             |   |             |   |             |   |");
      System.out.println("|   |--------|    |   |--------|    |   |--------|    |   |--------|");
      System.out.println("|            |    |            |    |            |    |            |");
      System.out.println("|   _________|    |   _________|    |   _________|    |   _________|");
      System.out.println("|   |             |   |             |   |             |   |");
      System.out.println("|   |--------|    |   ---------|    |   ---------|    |   |--------|");
      System.out.print("|");
      for (int spaced = 1; spaced <= 12; spaced++) {
         System.out.print(" ");
      }
      System.out.print("|    |");
      for (int spaced = 1; spaced <= 12; spaced++) {
         System.out.print(" ");
      }
      System.out.print("|    |");
      for (int spaced = 1; spaced <= 12; spaced++) {
         System.out.print(" ");
      }
      System.out.print("|    |");
      for (int spaced = 1; spaced <= 12; spaced++) {
         System.out.print(" ");
      }
      System.out.println("|");
      System.out.println("|____________|    |____________|    |____________|    |____________|");
      phraseX();
   }
      
   public static void phraseMe() {
      System.out.println("is for Elle.      is for Elle.      is for Elle.      is for Elle.       ");
      System.out.println();
   }
   
   public static void phraseX() {
      System.out.println("is for Excellent. is for Excellent. is for Excellent. is for Excellent.");
      System.out.println();
   }
   
   public static void elleE() {
      System.out.println("Elle  Excellent   Elle  Excellent   Elle  Excellent   Elle  Excellent");
      System.out.println("Elle  Excellent   Elle  Excellent   Elle  Excellent   Elle  Excellent");
      System.out.println("Elle  Elle        Elle              Elle              Elle");
      System.out.println("Elle  Elle        Elle              Elle              Elle");
      System.out.println("Elle  Excellent   Elle  Excellent   Elle  Excellent   Elle  Excellent");
      System.out.println("Elle  Excellent   Elle  Excellent   Elle  Excellent   Elle  Excellent");
      System.out.println("Elle  Elle        Elle              Elle              Elle");
      System.out.println("Elle  Elle        Elle              Elle              Elle");
      System.out.println("Elle  Excellent   Elle  Excellent   Elle  Excellent   Elle  Excellent");
      System.out.println("Elle  Excellent   Elle  Excellent   Elle  Excellent   Elle  Excellent");
      System.out.println();
   }
}
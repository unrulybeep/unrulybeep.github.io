// Elle Boyechko
// CSE 142 AP
// Althea Poteet
// Homework #2 (ASCII Art / Space Needle)
// Displays an ascii image of the Seattle Space Needle
public class SpaceNeedle {
   
   public static final int SIZE = 4;
   
   public static void main(String[] args) {
      needleSingle();
      needleBread();
      needleDivider();
      needleChandelier();
      needleSingle();
      singleSandwich();
      needleBread();
      needleDivider();
   }
   
   // Prints out the single column piece of the Space Needle ascii
   public static void needleSingle() {
      for (int lines = 1; lines <= SIZE; lines++) {
         for (int spaces = 1; spaces <= SIZE * 3; spaces++) {
            System.out.print(" ");
         }
         System.out.println("||");
      }
   }
   
   // Prints the ascii Space Needle's mountain top
   public static void needleBread() {
      for (int lines = 1; lines <= SIZE; lines++) {
         for (int spaces = 1; spaces <= (lines * -3) + (SIZE * 3); spaces++) {
            System.out.print(" ");
         }
         System.out.print("__/");
         for (int colonsL = 1; colonsL <= ((lines * 3) - 3); colonsL++) {
            System.out.print(":");
         }
         System.out.print("||");
         for (int colonsR = 1; colonsR <= ((lines * 3) - 3); colonsR++) {
            System.out.print(":");
         }
         System.out.print("\\__");
         System.out.println();
      }
   }
   
   // Prints the ascii divider between Space Needle's mountain top
   // and chandelier bottom
   public static void needleDivider() {
      System.out.print("|");
      for (int quotes = 1; quotes <= SIZE * 6; quotes++) {
         System.out.print("\"");
      }
      System.out.println("|");
   }
   
   // Prints the ascii chandelier bottom of the Space Needle
   public static void needleChandelier() {
      for (int lines = 1; lines <= SIZE; lines++) {
         for(int spaces = 0; spaces < ((lines * 2) - 2); spaces++) {
            System.out.print(" ");
         }
         System.out.print("\\_");
         for (int pyramids = 1;
              pyramids <= (lines * -2) + 3 * (SIZE - 3) + 10;
              pyramids++) {
            System.out.print("/\\");
         }
         System.out.println("_/");
      }
   }
   
   // Prints the multi-column base of the ascii Space Needle
   public static void singleSandwich() {
      for (int rows = 1; rows <= SIZE * SIZE; rows++) {
         for(int spaces = 1; spaces <= SIZE * 2 + 1; spaces++) {
            System.out.print(" ");
         }
         sandwichArtist();
         sandwichArtist();
         System.out.println();
      }
   }
   
   // Prints one side of the multi-column base of the ascii Space Needle
   public static void sandwichArtist() {
      System.out.print("|");
      for (int width = 1; width <= SIZE - 2; width++) {
         System.out.print("%");
      }
      System.out.print("|");
   }
}
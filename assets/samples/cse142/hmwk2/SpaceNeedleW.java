// Elle Boyechko
// CSE 142 AP
// Althea Poteet
// Homework #2 (ASCII Art / Space Needle) [without constant]
// Displays an ascii image of the Seattle Space Needle
public class SpaceNeedleW {
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
      for (int i = 1; i<=4; i++) {
         for (int j = 1; j<=12; j++) {
            System.out.print(" ");
         }
         System.out.println("||");
      }
   }
   
   // Prints the ascii Space Needle's mountain top
   public static void needleBread() {
         System.out.println("         __/||\\__");
         System.out.println("      __/:::||:::\\__");
         System.out.println("   __/::::::||::::::\\__");
         System.out.println("__/:::::::::||:::::::::\\__");
   }

   // Prints the ascii divider between Space Needle's mountain top
   // and chandelier bottom 
   public static void needleDivider() {
      System.out.print("|");
         for (int i = 1; i <= 24; i++) {
            System.out.print("\"");
         }
      System.out.println("|");
   }
   
   // Prints the ascii chandelier bottom of the Space Needle 
   public static void needleChandelier() {
      for (int line = 1; line <= 4; line++) {
            for(int space = 0; space < ((line * 2) - 2); space++) {
               System.out.print(" ");

            }
            System.out.print("\\_");
            for(int c1 = 1; c1 <= (line * -2) + 13; c1++) {
               System.out.print("/\\");
            }
              System.out.println("_/");
      }
   }
 
   // Prints the double column base of the ascii Space Needle   
   public static void singleSandwich() {
      for (int row = 1; row <=16; row++) {
         for(int spaces = 1; spaces <= 9; spaces++) {
            System.out.print(" ");
         }
         for (int width = 1; width <= 2; width++) {
            System.out.print("|%%|"); 
         }
            System.out.println();
      }
   }
}
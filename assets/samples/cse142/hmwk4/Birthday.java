// Elle Boyechko
// CSE 142 AP
// Althea Poteet
// Homework #4 (Happy Birthday)
// Displays a birthday message to user depending on the dates entered,
// includes a fact about the author's birthyday.
import java.util.*; // so that I can use Scanner

public class Birthday {
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      System.out.println("This program tells you how many days");
      System.out.println("it will be until your next birthday.");
      System.out.println();
      System.out.println("Please enter today's date:");
      int todaysAbsoluteNum = getDate(console);
      System.out.println("Please enter your birthday:");
      int daysUntilBday = daysUntilBday(getDate(console), todaysAbsoluteNum);
      birthdayMessage(daysUntilBday);
   }
   
   //Asks the user to input the current date, and then their birthday.
   //Returns the absolute day in year number, accepts parameter console.
   public static int getDate(Scanner console) {
      System.out.print("What is the month (1-12)? ");
      int month = console.nextInt();
      System.out.print("What is the day   (1-" + daysInMonth(month) + ")? ");
      int day = console.nextInt();
      int absoluteDay = calcDate(month, day);
      System.out.println(month + "/" + day + " is day #" +
      absoluteDay + " of 365.");
      System.out.println();
      return absoluteDay;
   }
   
   //Calculates the absolute day of the year and returns it.
   public static int calcDate(int month, int day) {
      int daysFromDate = 0;
      for (int i = 1; i < month; i++) {
         daysFromDate = daysFromDate + daysInMonth(i);
      }
      daysFromDate = daysFromDate + day;
      return daysFromDate;
   }
   
   //Returns the number of days in the month entered, accepts parameter month.
   public static int daysInMonth(int month) {
      if (month <= 8) {
         if (month == 2) {
            return 28;
         } else if (month == 8 || month % 2 > 0) {
            return 31 ;
         } else {
            return 30;
         }
      } else if (month % 2 == 0) {
         return 31;
      } else {
         return 30;
      }
   }
   
   //Returns the number of days until the birthday entered.
   public static int daysUntilBday(int birthdayAbsoluteNum,
   int todaysAbsoluteNum) {
      if (birthdayAbsoluteNum >= todaysAbsoluteNum){
         return birthdayAbsoluteNum - todaysAbsoluteNum;
      } else {
         return (365 - todaysAbsoluteNum) + birthdayAbsoluteNum;
      }
   }
   
   //Displays a birthday message depending on how far away the day is from
   //the current date.
   public static void birthdayMessage(int daysUntilBday) {
      if (daysUntilBday == 0) {
         System.out.println("Happy birthday!");
      } else if (daysUntilBday == 1) {
         System.out.println("Wow, your birthday is tomorrow!");
      } else {
         System.out.println("Your next birthday is in " + daysUntilBday +
         " days.");
      }
      System.out.println();
      System.out.println("On August 6, 1926 Gertrude Ederle becomes the first"
                         + "woman to swim across the English Channel.");
   }
}
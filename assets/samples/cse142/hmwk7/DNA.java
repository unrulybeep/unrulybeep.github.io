// Elle Boyechko
// CSE 142 AP
// Althea Poteet
// Homework #7 (DNA)
// Converts nucleotide data read from the user's specified file to a human-readable
// format, then prints the data to a user specified file. The printed file will display
// the name of the nucleotide sequence, the text signifiers of the nucleotide, the
// tally of each unique nucleotide type, the total mass of each nucleotide type and the
// mass of the entire nucleotide sequence, a list of the codons present in the nucelotide,
// and whether or not the nucleotide would be considered a protein.
import java.util.*;
import java.io.*;

public class DNA {   
   // The minimum number of codons a valid protein must have.
   public static final int PROTEIN_SIZE = 5;
   // The percentage of mass "C" and "G" combined need to be for the nucleotide
   // to be considered a protein.
   public static final int PROTEIN_MASS_NEEDED = 30;
   // The number of unique nucleotides present in a sequence.
   public static final int UNQIUE_NUCLEOTIDES = 4;
   // The number of unique nucleotide types needed
   public static final int NUCLEOTIDES_PER_CODON = 3;
   
   public static void main (String[] args) throws FileNotFoundException {
      Scanner console = new Scanner(System.in);
      double[] nucMasses = {135.128, 111.103, 151.128, 125.107};
      double[] massPercent = new double[4];
      String seqName = "";
      String nucleotides = "";
      double totalMass = 0;
      
      System.out.println("This program reports information about DNA ");
      System.out.println("nucleotide sequences that may encode proteins.");
      System.out.print("Input file name? ");
      String inputFilename = console.nextLine();
      System.out.print("Output file name? ");
      PrintStream outputFile = new PrintStream(new File(console.nextLine()));
      Scanner input = new Scanner(new File(inputFilename));

      while (input.hasNextLine()) {
         seqName = input.nextLine();
         nucleotides = input.nextLine().toUpperCase();
         int[] nucCounts = new int[4];
         totalMass = nucCounts(nucleotides, nucCounts, nucMasses);
         calcPercent(nucCounts, totalMass, massPercent, nucMasses);
         String[] codonsPerNucleotide = codonCheck(nucleotides);
         roundMassPercent(massPercent);
         String isProtein = isProtein(massPercent, nucleotides, codonsPerNucleotide);
         printData(outputFile, seqName, nucleotides, nucCounts, massPercent,
         totalMass, codonsPerNucleotide, isProtein);
      }
   }
   
   
   // Tallies the number of unique nucleotide types in the sequence. Then adds the
   // type's mass to the total mass of the sequence. Accepts nucleotide, nucCounts,
   // and nucMasses as parameters. Returns the total mass of the sequence.
   public static double nucCounts(String nucleotides, int[] nucCounts,
                                  double[] nucMasses) {
      double totalMass = 0;
      
      for (int i = 0; i < nucleotides.length(); i++) {
         if (nucleotides.charAt(i) == 'A') {
            nucCounts[0]++;
            totalMass += nucMasses[0];
         } else if (nucleotides.charAt(i) == 'C') {
            nucCounts[1]++;
            totalMass += nucMasses[1];
         } else if (nucleotides.charAt(i) == 'G') {
            nucCounts[2]++;
            totalMass += nucMasses[2];
         } else if (nucleotides.charAt(i) == 'T') {
            nucCounts[3]++;
            totalMass += nucMasses[3];
         } else if (nucleotides.charAt(i) == '-') {
            totalMass += 100.00;
         }
      }
      return totalMass;
   }
   
   // Calculates the percentage of each nucleotide type's mass in relation to
   // the mass of the entire sequence, and creates an array from the data.
   // Accepts nucCounts, totalMass, massPercent, and nucMasses as parameters.
   public static void calcPercent(int[] nucCounts, double totalMass,
                                  double[] massPercent, double[] nucMasses) {     
      for (int i = 0; i < nucCounts.length; i++) {
         massPercent[i] = ( nucCounts[i] * nucMasses[i] ) / totalMass;
      }
   }
   
   // Compiles the codons for the sequence. Accepts nucleotide as a parameter.
   // Returns a created array of the list of codons within the nucleotide.
   public static String[] codonCheck(String nucleotide) {
      String nucleotideSimplified = nucleotide.replace("-","");
      
      int arraySize = nucleotideSimplified.length() / NUCLEOTIDES_PER_CODON;
      String[] codonsPerNucleotide = new String[arraySize];
      int firstLetter = 0;
      int lastLetter = NUCLEOTIDES_PER_CODON;
      
      for (int i = 0; i < arraySize; i++) {
         codonsPerNucleotide[i] = nucleotideSimplified.substring(firstLetter, lastLetter);
         firstLetter = firstLetter + NUCLEOTIDES_PER_CODON;
         lastLetter = lastLetter + NUCLEOTIDES_PER_CODON;
      }
      return codonsPerNucleotide;
   }
   
   // Rounds the mass of each nucleotide type to one decimal place. Accepts massPercent
   // as a parameter.
   public static void roundMassPercent(double[] massPercent) {
      for (int i = 0; i < massPercent.length; i++) {
         massPercent[i] = massPercent[i] * 100;
         massPercent[i] = Math.round(massPercent[i] * 10.0) / 10.0;
      }      
   }
   
   // Returns YES or NO as to whether a nucleotide fits the criteria to be
   // a protein. Accepts massPercent, nucleotides, and codonsPerNucleotide
   // as a parameter.
   public static String isProtein(double[] massPercent, String nucleotides,
                                  String[] codonsPerNucleotide) {      
      double cgTotal = massPercent[1] + massPercent[2];
      
      if (nucleotides.startsWith("ATG")
          && cgTotal >= 30
          && codonsPerNucleotide.length >= PROTEIN_SIZE
          && (nucleotides.endsWith("TAA")
              || nucleotides.endsWith("TAG")
              || nucleotides.endsWith("TGA"))) {
         return "YES";
      }      
      return "NO";
   }
   
   // Prints the gathered data to the user specified output file. Accepts outputFile,
   // sequenceName, nucleotides, nucCounts, massPercentRounded, totalMass,
   // codonsPerNucleotide, and isProtein as parameters.
   public static void printData(PrintStream outputFile, String sequenceName,
                                String nucleotides, int[] nucCounts,
                                double[] massPercent, double totalMass,
                                String[] codonsPerNucleotide, String isProtein) {
      outputFile.println("Region Name: " + sequenceName);
      outputFile.println("Nucleotides: " + nucleotides.toUpperCase());
      outputFile.println("Nuc. Counts: " + Arrays.toString(nucCounts));
      double totalMassRounded = Math.round(totalMass * 10.0) / 10.0;
      outputFile.println("Total Mass%: " + Arrays.toString(massPercent) +
                         " of " + totalMassRounded);
      outputFile.println("Codons List: " + Arrays.toString(codonsPerNucleotide));
      outputFile.println("Is Protein?: " + isProtein);
      outputFile.println();
   }
}
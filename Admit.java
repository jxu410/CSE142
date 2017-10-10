// Jason Ku
// 24 October 2016
// CSE142
// TA: Claire Johansen 
// Assingment #4
//
// This program will accept user input for the data of two applicants
// and print the overall applicants scores and which applicant was
// stronger. Applicant scores are determined by GPA and either SAT or 
// ACT scores.

import java.util.*;

public class Admit {
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      
      greeting();
      
      double test1 = testScore(console, 1);
      double gpa1 = gpaScorer(console);
      System.out.println();
      double test2 = testScore(console, 2);
      double gpa2 = gpaScorer(console);
      System.out.println();
      
      compareResults(test1, gpa1, test2, gpa2);   
   }
   
   // prints a message explaining purpose of program
   public static void greeting() {
      System.out.println("This program will compare two applicants by GPA");
      System.out.println("and either SAT or ACT scores. Applicant scores as");
      System.out.println("well which is stronger will be determined and printed.");
   }
   
   // prompts user for ACT or SAT score input
   public static double testScore(Scanner console, int num) {
      double score;
      System.out.println("Information for applicant #" + num + ":");
      System.out.print("\t do you have 1) SAT scores or 2) ACT scores? ");
      int test = console.nextInt();
      if (test == 1) {
         score = satScorer(console);
      } else {
         score = actScorer(console);
      }
      double rounded = round(score);
      System.out.println("\t exam score = " + rounded);
      return rounded;
   }
   
   // asks for categorial scores and calculates exam score
   public static double satScorer(Scanner console) {
      System.out.print("\t SAT math? ");
      int math = console.nextInt();
      System.out.print("\t SAT critical reading? ");
      int reading = console.nextInt();
      System.out.print("\t SAT writing? ");
      int writing = console.nextInt();
      
      double score = (2.0 * math + reading + writing) / 32;
      return score;
   }
   
   //asks for categorial scores and calculates exam score
   public static double actScorer(Scanner console) {
      System.out.print("\t ACT English? ");
      int english = console.nextInt();
      System.out.print("\t ACT math? ");
      int math = console.nextInt();
      System.out.print("\t ACT reading? ");
      int reading = console.nextInt();
      System.out.print("\t ACT science? ");
      int science = console.nextInt();
      
      double score = ((english + 2 * math + reading + science) / 1.8);
      return score;
   }
   
   // asks for GPA and caclulates gpa score
   public static double gpaScorer(Scanner console) {
      System.out.print("\t overall GPA? ");
      double actual = console.nextDouble();
      System.out.print("\t max GPA? ");
      double max = console.nextDouble();
      System.out.print("\t Transcript Multiplier? ");
      double multi = console.nextDouble();
      double score = gpaCalc(actual, max, multi);
      return score;
   }
   
   // calculates a GPA score
   public static double gpaCalc(double actual, double max, double multi) {
      double score = (actual / max) * multi * 100;
      double rounded = round(score);
      System.out.println("\t GPA score = " + rounded);
      return rounded;
   }
   
   // calculates, compares, and prints scores for both applicants 
   public static void compareResults(double test1, double gpa1, double test2, double gpa2) {
      double overall1 = test1 + gpa1;
      double overall2 = test2 + gpa2;
      
      System.out.println("First applicant overall score = " + overall1);
      System.out.println("Second applicant overall score = " + overall2);
      
      if (overall1 > overall2) {
         System.out.println("The first applicant seemed better");
      } else if (overall2 > overall1) {
         System.out.println("The second applicant seems to be better");
      } else { // overall1 == overall2
         System.out.println("The two applicants seem to be equal");
      }
   }
   
   // rounds a double to one decimal point
   public static double round(double num) {
      num *= 10;
      return Math.round(num) / 10.0;
   }
}
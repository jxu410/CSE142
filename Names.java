// Jason Ku
// 11/14/16
// CSE142
// TA: Claire Johansen 
// Assignment #6
// 
// This program will read through a text file and take in a search index for the
// ranks of popularity of baby names. If found, the ranks are plotted on a graph
// using drawingPanel.

import java.util.*;
import java.io.*;
import java.awt.*;

public class Names {
   public static final int START = 1880;
   public static final int WIDTH = 70;
   public static final int DECADES = 14;
   
   public static void main(String[] args) throws FileNotFoundException {
      Scanner console = new Scanner(System.in);
      Scanner input = new Scanner(new File("names.txt"));
      
      intro();
      
      System.out.println("name? ");
      String name = console.next().toLowerCase();
      System.out.println("gender (M or F)? ");
      String gender = console.next().toLowerCase();
      
      String line = search(name, gender, input);
      if (line.length() > 0) {
         DrawingPanel p = new DrawingPanel(WIDTH * DECADES, 550);
         Graphics g = p.getGraphics();
         drawGraph(g);
         getData(line , g);
      } else {
         System.out.println("name/gender combination not found");
      }
   }
   
   // prints a greeting
   public static void intro() {
      System.out.println("This program allows you to search through the");
      System.out.println("data from the Social Security Administration");
      System.out.println("to see how popular a particular name has been");
      System.out.println("since " + START + ".");
      System.out.println();
   }
   
   // takes in a scanner for a text file and matches two strings to a line of text 
   // and returns the line if found, empty string if not
   public static String search(String name, String gender, Scanner input) {
      String line = "";
      while (input.hasNextLine()) {
         line = input.nextLine();
         Scanner find = new Scanner(line);
         if (find.next().toLowerCase().equals(name) && find.next().toLowerCase().equals(gender)) {          
            return line;
         }
      }
      return "";
   }
   
   // takes in a line and tokenizes it to pass information and Graphics to plotData 
   public static void getData(String line, Graphics g) {
      Scanner data = new Scanner(line);
      String name = data.next();
      String gender = data.next();
      int x = 0; // x coordinate for the data point
      int current = data.nextInt(); // used to draw line between data points
      int next = 0;
      int place = 1; // to prevent fencepost 
      
      while (data.hasNext() && place < DECADES) {
         next = data.nextInt(); 
         plotData(current, name, gender, x, next, g);
         x += WIDTH;
         current = next;  
         place++;
      }
      g.drawString(name + " " + gender + " " + next, (DECADES - 1) * WIDTH, getPoint(next));
   }

   // draws the base graph for the data
   public static void drawGraph(Graphics g) {     
     g.drawLine(0, 25, WIDTH * DECADES, 25);
     g.drawLine(0, 525, WIDTH * DECADES, 525);
     for (int i = 0; i < DECADES; i++) {
        g.drawLine(i * WIDTH, 0, i * WIDTH, 550);
        g.drawString(START + (10 * i) + "", i * WIDTH, 550);
     }
     g.setColor(Color.RED); // everything will be drawn in red after
   }
   
   // Takes in rank of name, the name, and gender to plot on graph, and 
   // x and y value for coordinates to plot. Takes in Graphics to access drawingPanel
   public static void plotData(int rank, String name, String gender, int x, int nextY, Graphics g) {
      g.drawString(name + " " + gender + " " + rank, x, getPoint(rank));
      g.drawLine(x, getPoint(rank), x + WIDTH, getPoint(nextY));  
   }  
   
   // Calculates the correct y value of the label for the data point to be graphed
   public static int getPoint(int num) {
      if (num == 0) {
         return 525;
      } else if (num % 2 == 0) {
         return (num - 1) / 2 + 25;
      } else {
         return num / 2 + 25;
      }  
   }

}
// Jason Ku
// 10/16/16
// CSE142
// TA: Claire Johansen
// Assingment #3
// 
// This program will print a row of alternating black and white squares with an
// X on the black square or a grid of these rows with the option to offset 
// every other row by an x value to produce the cafe wall illusion
import java.awt.*;

public class CafeWall {
   public static void main(String[] args) {
      DrawingPanel p = new DrawingPanel(650, 400);
      p.setBackground(Color.GRAY);
      Graphics g = p.getGraphics();
      
      drawRow(g, 0, 0, 4, 20);
      drawRow(g, 50, 70, 5, 30);
      drawGrid(g, 10, 150, 4, 25, 0);
      drawGrid(g, 250, 200, 3, 25, 10);
      drawGrid(g, 425, 180, 5, 20, 10);
      drawGrid(g, 400, 20, 2, 35, 35);
      
      
   }
   
   // prints a single row of alternating black and white squares with 
   // a blue x on the black square
   public static void drawRow(Graphics g, int x, int y, int num, int size) {
      for (int i = 0; i < num; i++) {
         g.setColor(Color.BLACK);
         g.fillRect(x, y, size, size);
         g.setColor(Color.BLUE);
         g.drawLine(x, y, x + size, y + size);
         g.drawLine(x + size, y, x, y + size);
         x += size;
         
         g.setColor(Color.WHITE);
         g.fillRect(x, y, size, size);
         x += size;
      }
   }      
  
   // prints a grid of rows with offset
   public static void drawGrid(Graphics g, int x, int y, int rows, 
                               int size, int offset) {
      for (int i = 0; i < 2 * rows; i++) {
         // x value adds the offset on even numbered rows
         drawRow(g, x + (i % 2) * offset, y, rows, size); 
         y += size + 2; 
      }
   }
} 


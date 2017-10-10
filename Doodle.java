// Jason Ku
// 10/16/16
// CSE142
// TA: Claire Johansen
// Assingment #3

// This program will draw a traffic light

import java.awt.*;

public class Doodle {
   public static void main(String[] args) {
      DrawingPanel p = new DrawingPanel(1000, 1000);
      Graphics g = p.getGraphics();
      
      g.fillRect(200, 0, 600, 800);
      g.setColor(Color.RED);
      g.fillOval(400, 100, 200, 200);    
      g.setColor(Color.YELLOW);
      g.fillOval(400, 300, 200, 200);
      g.setColor(Color.GREEN);
      g.fillOval(400, 500, 200, 200);
   }
}
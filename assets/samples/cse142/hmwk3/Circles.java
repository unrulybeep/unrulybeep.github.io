// Elle Boyechko
// CSE 142 AP
// Althea Poteet
// Homework #3 (Circles)
// Displays an arrangement of circles and squares
import java.awt.*;

public class Circles {   
   public static void main(String[] args) {
      DrawingPanel panel = new DrawingPanel(500, 350);
      Graphics box = panel.getGraphics();
      
      panel.setBackground(Color.CYAN);
      drawSubFigure(box, 0, 0, 100, 100, 10);
      drawSubFigure(box, 130, 25, 100, 100, 10);
      drawSubFigure(box, 260, 0, 60, 60, 6);
      drawSubFigure(box, 360, 50, 80, 80, 4);
      drawGrid(box, 10, 170, 48, 48, 4, 3);
      drawGrid(box, 180, 200, 24, 24, 2, 5);
      drawGrid(box, 330, 170, 72, 72, 9, 2);
   }
   
   // Draws a circle with increasingly smaller circles inside.
   public static void drawSubFigure(Graphics box, int x, int y,
   int width, int height, int numCirc) {
      
      int gap = (width / numCirc) / 2;
      
      for (int i = 1; i <= numCirc; i++) {
         box.setColor(Color.YELLOW);
         box.fillOval(x, y, width, height);
         box.setColor(Color.BLACK);
         box.drawOval(x, y, width, height);
         width = width - gap * 2;
         height = height - gap * 2;
         x = x + gap;
         y = y + gap;
      }
   }
   
   // Displays an arrangement of squares filled with the increasingly
   // small circles displayed above.
   public static void drawGrid(Graphics box, int x, int y, int subWidth,
   int subHeight, int numCirc, int table) {
      
      int rectWidth = subWidth * table;
      int rectHeight = subHeight * table;
      int lineX1 = x;
      int lineY1 = y;
      int lineX2 = lineX1 + rectWidth;
      int lineY2 = lineY1 + rectHeight;
      
      box.setColor(Color.GREEN);
      box.fillRect(x, y, rectWidth, rectHeight);
      box.setColor(Color.BLACK);
      box.drawRect(x, y, rectWidth, rectHeight);
      for (int row = 1; row <= table; row++) {
         for (int i = 1; i <= table; i++) {
            drawSubFigure(box, x, y, subWidth, subHeight, numCirc);
            x = x + subWidth;
         }
         y = y + subHeight;
         x = x - (subWidth * table);
      }
      box.drawLine(lineX1, lineY1, lineX1 + rectWidth, lineY1 + rectHeight);
      box.drawLine(lineX2, lineY1, lineX2 - rectWidth, lineY2);
   }
}

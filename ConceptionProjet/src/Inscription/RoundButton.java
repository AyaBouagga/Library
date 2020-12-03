package Inscription;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

import javax.swing.JButton;

class RoundButton extends JButton
{
   // for mouse detection purposes
   Shape shape;
   BufferedImage bim;
 
   public RoundButton(String label) {
      super(label);
      // allows us to paint a round background
      // if true, it would be rectangular
      setContentAreaFilled(false);
   }
  
  /* protected void paintComponent(Graphics g) {
      // if the button is pressed and ready to be released
      if (getModel().isArmed()) {
         g.setColor(Color.lightGray);
      } else {
         g.setColor(getBackground());
      }
	  g.drawImage(bim, 0, 0, getWidth(), getHeight(), null);    // draw the image, if available

      g.fillOval(0, 0, getSize().width-1, getSize().height-1);
      
      super.paintComponent(g);
   }*/protected void paintComponent(Graphics g) {
	    g.setClip(new Ellipse2D.Double(0, 0, getWidth(), getHeight()));  // set the area that shall be painted
	    g.drawImage(bim, 0, 0, getWidth(), getHeight(), null);    // draw the image, if available
	    if (getModel().isArmed()) {      // show a slight gray shading when pressing the button
	        g.setColor(new Color(127, 127, 127, 80));   // gray with 80 as alpha
	        g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
}

	    super.paintComponent(g);
	}
  
   // paint a round border as opposed to a rectangular one
   protected void paintBorder(Graphics g) {
      g.setColor(getForeground());
      g.drawOval(0, 0, getSize().width-1, getSize().height-1);
   }
  
   // only clicks within the round shape should be accepted
   public boolean contains(int x, int y) {
      if (shape == null || !shape.getBounds().equals(getBounds())) {
         shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
      }
  
      return shape.contains(x, y);
   }
 
}
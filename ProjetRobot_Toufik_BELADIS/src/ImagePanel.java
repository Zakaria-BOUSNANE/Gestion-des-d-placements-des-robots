import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImagePanel 
{
 ImagePanel() 
 {
  try 
  {
   JFrame f = new JFrame("Add an Image to a JPanel");
   JPanel panel = new JPanel();
   panel.setBounds(50, 50, 250, 250);
   BufferedImage img = ImageIO.read(new File("/pollueur.png"));
   JLabel pic = new JLabel(new ImageIcon(img));
   panel.add(pic);
   f.add(panel);
   f.setSize(400, 400);
   f.setLayout(null);
   f.setVisible(true);
  } 
  catch (IOException e) {System.out.println("hey");}
 }
 public static void main(String args[]) 
 {
  new ImagePanel();
 }
}
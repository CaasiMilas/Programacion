/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forma4;

/**
 *
 * @author salim
 */
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MyFrame extends JFrame {
   JButton button;
   MyFrame(){
      this.setSize(640, 480);
      button = new JButton("Close");
      button.addMouseListener(
              new MouseAdapter() {
                 @Override
                 public void mouseClicked(MouseEvent e) {
                    System.exit(0);
                }
              }
      );
      this.add(button);
   }

   public static void main(String[] args) {
      MyFrame frame = new MyFrame();
      frame.setVisible(true);
   }


}

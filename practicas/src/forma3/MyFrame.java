/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forma3;

/**
 *
 * @author salim
 */
import javax.swing.*;
import java.awt.event.ActionEvent;

public class MyFrame extends JFrame {
   JButton button;
   MyFrame(){
      this.setSize(640, 480);
      button = new JButton("Close");
      button.addActionListener((ActionEvent e) -> {
         System.exit(0);
      });

      this.add(button);
   }

   public static void main(String[] args) {
      MyFrame frame = new MyFrame();
      frame.setVisible(true);
   }
}
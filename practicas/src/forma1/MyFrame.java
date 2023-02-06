/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forma1;

/**
 *
 * @author salim
 */
import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
   JButton button;
   MyFrame(){
      this.setSize(640, 480);
      button = new JButton("Close");
      MyListener listener = new MyListener();
      button.addActionListener(listener);
      this.add(button);
   }

   public static void main(String[] args) {
      MyFrame frame = new MyFrame();
      frame.setVisible(true);
   }

}

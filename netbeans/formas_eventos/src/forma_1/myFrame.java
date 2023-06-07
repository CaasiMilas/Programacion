package forma_1;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author salim
 */
public class myFrame extends JFrame {

    JButton button;

    myFrame() {
        this.setSize(640, 480);
        button = new JButton("Close");
        myListener listener = new myListener();
        button.addActionListener(listener);
        this.add(button);
    }

    public static void main(String[] args) {
        myFrame frame = new myFrame();
        frame.setVisible(true);
    }
}

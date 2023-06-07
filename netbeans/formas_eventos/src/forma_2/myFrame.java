package forma_2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author salim
 */
public class myFrame extends JFrame implements ActionListener{
	JButton button;

	public myFrame(){
		this.setSize(640, 480);
		button = new JButton("Close");
		button.addActionListener(this);
		this.add(button);
	}
	
	public static void main(String[] args) {
		myFrame frame = new myFrame();
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent actionEvent){
		System.exit(0);
	}
}

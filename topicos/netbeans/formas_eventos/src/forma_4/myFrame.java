package forma_4;

import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author salim
 */
public class myFrame extends JFrame{
	JButton button;

	public myFrame(){
		this.setSize(640, 480);
		button = new JButton("Close");
		button.addMouseListener(
				new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent event){
						System.exit(0);
					}
				}
		);
		this.add(button);
	}
	
	public static void main(String[] args) {
		myFrame frame = new myFrame();
		frame.setVisible(true);
	}
}

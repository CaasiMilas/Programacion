
package practica1_paneles;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author salim
 */
public class Practica1_paneles {

	public static void run(){
		JFrame frame = new JFrame("Saludador");
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label = new JLabel("Escribe un nombre para saludar");
		JTextField textField = new JTextField();
		JButton button = new JButton("Saludar");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(
						frame, "Hola " + textField.getText() + " !!", "Saludo", JOptionPane.INFORMATION_MESSAGE
				);
			}
		});
		
		frame.add(label, BorderLayout.PAGE_START);
		frame.add(textField, BorderLayout.CENTER);
		frame.add(button, BorderLayout.PAGE_END);
		
		frame.pack();
		
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		run();
	}
	
}

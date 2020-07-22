import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class P0503FlowDemo extends JFrame {

	public P0503FlowDemo () {
		setTitle("FlowDemo"); // ajustes JFrame
		setSize(200, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cp = getContentPane(); // container
		cp.setLayout(new FlowLayout());	 // layout FlowLayout
		for (int i=0; i<5; i++) {
			JButton b = new JButton("Bot\u00E3o "+(i+1));
			cp.add(b); // adição do componente
		}
	}
	
	public static void main (String args[]) {
		// início simplificado
		new P0503FlowDemo().setVisible(true); 
	}
}

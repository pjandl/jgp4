import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class P0504GridDemo extends JFrame {
	
	public P0504GridDemo () {
		setTitle("GridDemo"); // ajustes JFrame
		setSize(200, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cp = getContentPane(); // container
		cp.setLayout(new GridLayout(2, 3)); // layout GridLayout
		for (int i=0; i<5; i++) {
			JButton b = new JButton("Bot\u00E3o "+(i+1));
			cp.add(b); // adição do componente
		}
	}

	public static void main (String args[]) {
		// opção simplificada de início da aplicação
		new P0504GridDemo().setVisible(true);
	}
}

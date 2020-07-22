import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class P0502NullDemo extends JFrame {

	public P0502NullDemo () {
		setTitle("NullDemo"); // ajustes JFrame
		setSize(200, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cp = getContentPane(); // container
		cp.setLayout(null); // layout desativado
		for (int i=0; i<5; i++) {
			JButton b = new JButton("Bot\u00E3o"+(i+1));
			b.setBounds(10+i*90, 30, 80, 20); // x, y, larg, alt
			cp.add(b); // adição do componente
		}
	}

	public static void main (String args[]) {
		// opção simplificada de início da aplicação
		new P0502NullDemo().setVisible(true);
	}
}

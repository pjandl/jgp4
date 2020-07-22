import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class P0505BoxDemo extends JFrame {

	public P0505BoxDemo () {
		setTitle("BoxDemo"); // ajustes JFrame
		setSize(200, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cp = getContentPane(); // container
		// layout BoxLayout: use X._AXIS ou Y_AXIS
		cp.setLayout(new BoxLayout(cp, BoxLayout.X_AXIS));
		// adição dos componentes
		cp.add(new JButton("Bot\u00E3o 1"));
		cp.add(new JButton("Bot\u00E3o 2"));
		cp.add(new JButton("Bot\u00E3o 3 Diferente"));
		cp.add(new JButton("Bot\u00E3o 4"));
	}
	public static void main (String args[]) {
		// início simplificado
		new P0505BoxDemo().setVisible(true);
	}
}

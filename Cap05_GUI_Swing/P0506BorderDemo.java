import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class P0506BorderDemo extends JFrame {
	public P0506BorderDemo () {
		setTitle("BorderDemo"); // ajustes JFrame
		setSize(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cp = getContentPane(); // container
		// BorderLayout é default para JFrame
		// adição dos componentes
		cp.add(new JButton("Bot\u00E3o 1"),"North"); 
		cp.add(new JButton("Bot\u00E3o 2"),"South");
		cp.add(new JButton("Bot\u00E3o 3"),"East");
		cp.add(new JButton("Botão 4"),"West");
		cp.add(new JButton("Botão 5"),"Center");
	}
	public static void main (String args[]) {
		// início simplificado
		new P0506BorderDemo().setVisible(true);
	}
}

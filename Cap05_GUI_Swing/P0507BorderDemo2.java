import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class P0507BorderDemo2 extends JFrame {
	private JButton bFechar;

	public P0507BorderDemo2() {
		super("BorderDemo2");
		// ajustes JFrame
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cp = getContentPane(); // container
		
		// Painel Topo
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p1.add(new JButton(new ImageIcon("./img/cut16.gif")));
		p1.add(new JButton(new ImageIcon("./img/copy16.gif")));
		p1.add(new JButton(new ImageIcon("./img/paste16.gif")));
		cp.add("North", p1);
		
		// Painel Lateral
		p1 = new JPanel();
		JPanel p2 = new JPanel(new GridLayout(2, 1, 5, 5));
		p2.add(new JButton("Abrir"));
		p2.add(bFechar = new JButton("Fechar"));
		p1.add(p2);
		cp.add("East", p1);
		
		// Componente central
		cp.add(new JScrollPane(new JTextArea()), "Center");
		// Listener com lambda
		bFechar.addActionListener((e) -> { bFecharClick(); });
	}

	// Código executado pelo botão
	private void bFecharClick() {
		System.exit(0);
	}

	public static void main(String args[]) {
		// início simplificado
		new P0507BorderDemo2().setVisible(true);
	}
}

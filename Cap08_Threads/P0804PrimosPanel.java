import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class P0804PrimosPanel extends JPanel {
	private JTextField tf1, tf2;
	private JButton b1, b2, b3;
	private JTextArea ta1;

	public P0804PrimosPanel() {
		// Ajusta layout do painel
		setLayout(new BorderLayout());

		// instancia componentes do painel auxiliar superior
		JPanel p1 = new JPanel(new GridLayout(1, 4, 3, 3));
		p1.add(new JLabel("Inicio", JLabel.RIGHT));
		p1.add(tf1 = new JTextField());
		p1.add(new JLabel("Fim", JLabel.RIGHT));
		p1.add(tf2 = new JTextField());

		// instancia componentes da area central (scrollpane auxiliar)
		JScrollPane sp = new JScrollPane(ta1 = new JTextArea());
		ta1.setEditable(false);
		ta1.setLineWrap(true);
		ta1.setWrapStyleWord(true);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		// instancia componentes do painel auxiliar inferior
		JPanel p2 = new JPanel(new GridLayout(1, 3, 3, 3));
		p2.add(b1 = new JButton("Cancelar"));
		p2.add(b2 = new JButton("Limpar"));
		p2.add(b3 = new JButton("Calcular"));
		JPanel p3 = new JPanel();
		p3.add(p2);

		// adiciona paineis auxiliares
		add("North", p1);
		add("Center", sp);
		add("South", p3);
	}

	public JButton getButton1() {
		return b1;
	}

	public JButton getButton2() {
		return b2;
	}

	public JButton getButton3() {
		return b3;
	}

	public JTextArea getTextArea() {
		return ta1;
	}

	public JTextField getTextField1() {
		return tf1;
	}

	public JTextField getTextField2() {
		return tf2;
	}
}

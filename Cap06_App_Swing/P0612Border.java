import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import javax.swing.border.Border;

@SuppressWarnings("serial")
public class P0612Border extends JFrame {
	public P0612Border () {
		setTitle("Bordas em Paineis");
		
		// ajusta layout
		JPanel cp = (JPanel)getContentPane();
		cp.setLayout(new GridLayout(1 ,8, 5, 5));
		cp.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		// cria painéis com bordas diferentes e adicionaao contentPanel
		add(createJPanelWithBorder(BorderFactory.createEtchedBorder()));
		add(createJPanelWithBorder(BorderFactory.createLineBorder(Color.orange, 2)));
		add(createJPanelWithBorder(BorderFactory.createLoweredBevelBorder()));
		add(createJPanelWithBorder(BorderFactory.createMatteBorder(0, 3, 0, 3, Color.blue)));
		add(createJPanelWithBorder(BorderFactory.createMatteBorder(11, 11, 11, 11,
				new ImageIcon("C:/JGP4/Cap06_SwingComp/img/border.gif"))));
		add(createJPanelWithBorder(BorderFactory.createRaisedBevelBorder()));
		add(createJPanelWithBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.green, 2),
				BorderFactory.createMatteBorder(0, 3, 0, 3, Color.blue))));
		add(createJPanelWithBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLoweredBevelBorder(), "Título")));

		setSize(542, 111);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// Cria painel com a borda indicada
	private JPanel createJPanelWithBorder(Border border) {
		JPanel p = new JPanel(); // cria painel
		p.setBorder(border); // adiciona borda indicada
		return p; // retorna painel com borda indicada
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater( // expressão lambda
			() -> { new P0612Border().setVisible(true); }
		);
	}
}

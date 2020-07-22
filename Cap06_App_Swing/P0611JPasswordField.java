import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class P0611JPasswordField extends JFrame {
	private JLabel lRes;
	private JPasswordField pf;
	private JButton bAnalisar;

	public P0611JPasswordField() {
		setTitle("Senhas"); // ajusta titulo
		// layout grade 1x2
		setLayout(new GridLayout(1, 4, 1, 1));
		add(new JLabel("Senha", JLabel.RIGHT));
		add(pf = new JPasswordField(10));
		add(bAnalisar = new JButton("Analisar"));
		// resultado
		add(lRes = new JLabel());
		
		// para rótulo não ser transparente
		lRes.setOpaque(true);
		bAnalisar.addActionListener((e) -> { // expressão lambda
			P0611PasswordStrength forca = P0611PasswordStrength
				.evaluateStrength(pf.getPassword());
			lRes.setText(forca.toString());
			lRes.setBackground(forca.getColor());
		});
		
		// botao como default
		getRootPane().setDefaultButton(bAnalisar);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// autodimensiona janela
		pack();
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater( // expressão lambda
			() -> { new P0611JPasswordField().setVisible(true); }
		);
	}
}

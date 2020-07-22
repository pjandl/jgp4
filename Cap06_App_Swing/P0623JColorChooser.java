import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class P0623JColorChooser extends JFrame {
	private JButton bBack, bFore; // botões de controle
	private JLabel lText; // rótulo de texto

	public P0623JColorChooser () {
		super("Swing JColorChooser"); // ajusta título

		// adiciona componentes
		add("North", bFore = new JButton("Label Foreground"));
		add("Center", lText = new JLabel("Java Guia do Programador 4aEd."));
		add("South", bBack = new JButton("Label Background"));

		// listeners com expressões lambda
		bFore.addActionListener((e) -> {
			lText.setForeground(JColorChooser.showDialog(
					P0623JColorChooser.this, bFore.getText(),
					lText.getForeground()));
		});
		bBack.addActionListener((e) -> {
			lText.setBackground(JColorChooser.showDialog(
					P0623JColorChooser.this, bBack.getText(),
					lText.getBackground()));
		});

		// outros ajustes
		lText.setOpaque(true); // rótulo não-transparente
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ação fechar
		setSize(300, 110); // dimensiona janela
	}

	public static void main(String a[]) {
		SwingUtilities.invokeLater(
			() -> { new P0623JColorChooser().setVisible(true); }
		);
	}
}

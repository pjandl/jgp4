import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class P0605JLabel extends JFrame {
	public P0605JLabel () {
		// ajusta título
		super("Swing Labels"); 
		// ajusta posição e tamanho
		setSize(400, 100); 
		// ajusta layout GridLayout e adiciona componentes
		setLayout(new GridLayout(2,2)); 
		add(new JLabel("Rótulo à Esquerda"));
		add(new JLabel("Rótulo à Direita", JLabel.RIGHT));
		add(new JLabel("Rótulo Centralizado", JLabel.CENTER));
		add(new JLabel("<html><font color=#FF0000>Swing</font>" +
			" é <i>diferente</i>!</html>"));
		// ação fechar
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	
	public static void main (String a[]) {
		SwingUtilities.invokeLater( // expressão lambda
			() -> { new P0605JLabel ().setVisible(true); }
		);
	}
}

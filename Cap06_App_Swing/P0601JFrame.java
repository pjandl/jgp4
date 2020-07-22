import javax.swing.JFrame;

@SuppressWarnings("serial")
public class P0601JFrame extends JFrame {
	public P0601JFrame () {
		super("Swing Frame Um"); // ajusta título
		// ajusta posição e tamanho da janela
		setBounds(50, 50, 250, 100);
		// ajusta ação fechar
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main (String a[]) {
		new P0601JFrame().setVisible(true); // Início simplificado
	}
}

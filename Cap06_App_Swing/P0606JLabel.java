import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class P0606JLabel extends JFrame {
	public P0606JLabel () {
		// ajusta título
		super("Swing Labels com Ícones"); 
		// posição e tamanho da janela
		setSize(300, 100); 
		// ajusta layout GridLayout
		setLayout(new GridLayout(2,2)); 

		// adiciona rótulos
		add(new JLabel("Sem ícone"));
		String imgDir = "C:/JGP4/Cap06_SwingComp/img/";
		add(new JLabel(new ImageIcon(imgDir + "new16.gif"))); // centralizado
		add(new JLabel(new ImageIcon(imgDir + "print16.gif"), JLabel.LEFT));
		add(new JLabel("Ajuda", new ImageIcon(imgDir + "help16.gif"), JLabel.RIGHT));

		// ação fechar
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}

	public static void main (String a[]) {
		SwingUtilities.invokeLater( // expressão lambda
			() -> { new P0606JLabel ().setVisible(true); }
		);
	}
}

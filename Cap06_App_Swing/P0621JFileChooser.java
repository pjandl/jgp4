import java.awt.Color;
import java.awt.GridLayout;

import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class P0621JFileChooser extends JFrame {
	private JButton bDialogo; // botão p/ acionar diálogo
	private JLabel lRes; // rótulo p/ resultados
	private JFileChooser dialogo; // diálogo de arquivos
	
	public P0621JFileChooser () {
		super("SwingFileDialog"); // ajusta título
		setLayout(new GridLayout(2, 1)); // layout grade 4x1
		
		add(bDialogo = new JButton("Selecionar Arquivo"));
		add(lRes = new JLabel("Sem seleção"));
		lRes.setBorder(BorderFactory.
				createMatteBorder(2, 2, 3, 2, Color.green));
		bDialogo.addActionListener((e) -> { // expressão lambda
			dialogo = new JFileChooser(); // instancia diálogo
			/*
			FileNameExtensionFilter filtro1 = new FileNameExtensionFilter("Código fonte C/C++", "c", "cpp");
			FileNameExtensionFilter filtro2 = new FileNameExtensionFilter("Código fonte Java", "java");
			dialogo.addChoosableFileFilter(filtro1);
			dialogo.addChoosableFileFilter(filtro2);
			*/ 
			int res = dialogo.showOpenDialog(P0621JFileChooser.this);
			// verifica se usuário fez seleção
			if (res == JFileChooser.APPROVE_OPTION) { 
				File arq = dialogo.getSelectedFile();
				lRes.setText(arq.getName());
			}
		});
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 90); // ajusta tamanho da janela
	}
	public static void main (String[] args) {
		SwingUtilities.invokeLater(
			() -> { new P0621JFileChooser().setVisible(true); }
		);
	}
}

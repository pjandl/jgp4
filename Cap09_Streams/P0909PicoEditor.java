import java.awt.BorderLayout;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class P0909PicoEditor extends JFrame {
	private JLabel lArquivo = new JLabel("N\u00e3o salvo");
	private JFileChooser fc = new JFileChooser(".");
	private JTextArea taConteudo = new JTextArea();
	private JButton bSalvar = new JButton("Salvar",
		new ImageIcon("img/saveas16.gif"));

	public P0909PicoEditor() { // construtor
		super("PicoEditor ");
		JPanel p = new JPanel(new BorderLayout());
		p.add(lArquivo, "Center");
		p.add(bSalvar, "East");
		add("North", p); // painel e seus componentes na area superior
		JScrollPane sp = new JScrollPane(taConteudo);
		add("Center", sp); // textarea e seu scrollpane na area central

		// registro do listener como expressão lambda
		bSalvar.addActionListener((e) -> {
			fileSelection();
		});
		
		// ajustes nos componentes e janelas
				taConteudo.setTabSize(2); // tamanho da tabulação
		taConteudo.setLineWrap(true); // quebra automática de linha
		taConteudo.setWrapStyleWord(true); // mantém palavras inteiras
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 200);
	}

	private void fileSelection() {
		if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			File arq = fc.getSelectedFile();
			try {
				textFileWrite(taConteudo.getText(), arq.getPath());
				lArquivo.setText(arq.getPath());
			} catch (IOException ioe) {
				JOptionPane.showMessageDialog(this, "Arquivo '" + arq.getPath()
						+ "' n\u00e3o pode ser salvo.", "PicoEditor",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void textFileWrite(String content, String fname) throws IOException {
		// abre arquivo indicado
		PrintWriter out = new PrintWriter(new FileWriter(fname));
		// grava conteudo numa unica operacao de escrita
		out.print(content);
		out.close(); // fecha arquivo
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(
			() -> { new P0909PicoEditor().setVisible(true); }
		);
	}
}

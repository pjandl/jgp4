import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.BoxLayout;
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
public class P0910Random extends JFrame implements ActionListener {
	private JButton b[] = new JButton[3];
	private JTextArea taDados;
	private JLabel lStatus;
	private JFileChooser fc = new JFileChooser(".");
	private String arq;
	private static String labels[] = { "Novos dados", "Abrir dados", "Procurar" };
	private static String cmds[] = { "new", "open", "find" };
	//
	private static String icons[] = { "new16.gif", "open16.gif", "find16.gif" };
	private static String tips[] = { "Cria um novo arquivo de dados",
			"Abre um arquivo de dados existente",
			"Localiza um registro no arquivo de dados" };

	//

	public P0910Random() { // construtor
		super("Acesso Aleat\u00f3rio");
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
		for (int i = 0; i < labels.length; i++) {
			p.add(b[i] = new JButton(labels[i], new ImageIcon("img/"
					+ icons[i])));
			b[i].setActionCommand(cmds[i]); // registro do nome do comando
			b[i].addActionListener(this); // registro do listener
			b[i].setToolTipText(tips[i]); // definicao da dica
		}
		JScrollPane sp = new JScrollPane(taDados = new JTextArea());
		add("North", p);
		add("Center", sp);
		add("South", lStatus = new JLabel());
		//
		// ajustes nos componentes e janela
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 200);
		//
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String b = ((JButton) e.getSource()).getActionCommand();
		if (b.equals(cmds[0])) {
			if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				arq = fc.getSelectedFile().getPath();
				criarDados(arq);
				lStatus.setText("Arquivo de dados criado.");
			}
		} else if (b.equals(cmds[1])) {
			if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				arq = fc.getSelectedFile().getPath();
				taDados.setText(lerDados(arq));
				lStatus.setText("Arquivo de dados lido.");
			}
		} else {
			String opt = JOptionPane
					.showInputDialog("N\u00famero do registro desejado:");
			try {
				lStatus.setText(lerRegistro(arq, Integer.parseInt(opt)));
			} catch (NumberFormatException nfe) {
			}
		}
	}

	private String lerRegistro(String arq, int num) {
		StringBuffer sb = new StringBuffer();
		try (RandomAccessFile raf = new RandomAccessFile(arq, "r")) {
			raf.seek(num * 10);
			sb.append(raf.readChar());
			sb.append("+");
			sb.append(raf.readDouble());
		} catch (IOException exc) {
			JOptionPane.showMessageDialog(this, "Registro #" + num
					+ " do arquivo '" + arq + "' n\u00e3o pode ser lido.",
					"RandomFile", JOptionPane.ERROR_MESSAGE);
		} // raf.close() implicito
		return sb.toString();
	}

	private String lerDados(String arq) {
		StringBuffer sb = new StringBuffer();
		try (RandomAccessFile raf = new RandomAccessFile(arq, "r")) {
			for (int i = 0; i < (raf.length() / 10); i++) {
				sb.append("[" + i + "]");
				sb.append(raf.readChar());
				sb.append("+");
				sb.append(raf.readDouble());
				sb.append("\n");
			}
		} catch (IOException exc) {
			JOptionPane.showMessageDialog(this, "Arquivo '" + arq
					+ "' n\u00e3o pode ser lido.", "RandomFile",
					JOptionPane.ERROR_MESSAGE);
		} // raf.close() implicito
		return sb.toString();
	}

	private void criarDados(String arq) {
		try (RandomAccessFile raf = new RandomAccessFile(arq, "rw")) {
			for (int i = 0; i < 10_000; i++) {
				raf.writeChar(65 + (i % 26));
				raf.writeDouble(i * Math.random());
			}
		} catch (IOException exc) {
			JOptionPane.showMessageDialog(this, "Arquivo '" + arq
					+ "' n\u00e3o pode ser criado.", "RandomFile",
					JOptionPane.ERROR_MESSAGE);
		} // raf.close() implicito
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(
			() -> { new P0910Random().setVisible(true); }
		);
	}
}

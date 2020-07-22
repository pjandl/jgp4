
import java.io.File;

import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class P0613JSplitPane extends JFrame
		implements ListSelectionListener {
	private File corrente, dir[]; // array com info arquivos
	private JList<String> listaDir; // caixa de lista p/ info diretório
	private JTextArea taInfo; // área de texto p/ info arquivo

	public P0613JSplitPane () {
		super("Swing SplitPane"); // ajusta título
		// aponta diretório atual
		corrente = new File(".");
		// lista arquivos do diretório atual
		dir = corrente.listFiles();
		String dirInfo[] = new String[dir.length];
		for (int i=0; i<dir.length; i++)
			dirInfo[i] = (dir[i].isDirectory()? "[D]" : "[F]")
				+ dir[i].getName();

		// painel de divisão
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
			new JScrollPane(listaDir = new JList<>(dirInfo)), // diretório
			new JScrollPane(taInfo = new JTextArea())); // área de texto
		// adiciona painel de divisão a janela
		getContentPane().add(split, "Center");

		// outros ajustes
		split.setResizeWeight(0.5);
		split.setDividerLocation(0.5);
		split.setOneTouchExpandable(true);
		listaDir.addListSelectionListener(this);

		// dimensiona janela
		setSize(500,175);
		// ação fechar
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	// classe implementa listener
	@Override
	public void valueChanged (ListSelectionEvent e) {
		int i = listaDir.getSelectedIndex();
		if (i==-1) return;
		StringBuffer sb = new StringBuffer("Nome: "+ dir[i].getName() + "\n");
		// exibe informações do arquivo: caminho, caminho absolute,
		// atributos, data de modificação e tamanho.
		sb.append("Path: "+ dir[i].getPath() + "\n");
		sb.append("Abs Path: "+ dir[i].getAbsolutePath() + "\n");
		sb.append("Diretório: "+ dir[i].isDirectory() + "\n");
		sb.append("Arquivo: "+ dir[i].isFile() + "\n");
		sb.append("Oculto: "+ dir[i].isHidden() + "\n");
		sb.append("LastModif: " + new Date(dir[i].lastModified()).toString()+"\n");
		sb.append("Tamanho: "+ dir[i].length() + "\n");
		taInfo.setText(sb.toString());
		taInfo.setCaretPosition(0); // reposiciona cursor no início
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater( // expressão lambda
			() -> { new P0613JSplitPane().setVisible(true); }
		);
	}
}


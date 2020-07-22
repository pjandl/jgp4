import java.awt.GridLayout;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JOptionPane.*;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class P0717ConjuntosGUI extends JFrame {
	private JTextArea taRes;
	private JButton bIncluir, bRemover, bContem;
	private List<Collection<String>> col = new ArrayList<>(); // coleções

	public P0717ConjuntosGUI() {
		super("Conjuntos GUI"); // ajusta titulo
		
		/* painel superior */
		JPanel pTop = new JPanel();
		JPanel pAux = new JPanel(new GridLayout(1, 3, 5, 5));
		pAux.add(bIncluir = new JButton("Incluir"));
		pAux.add(bRemover = new JButton("Remover"));
		pAux.add(bContem = new JButton("Contém?"));
		pTop.add(pAux);
		add("North", pTop);
		
		/* area central */
		JScrollPane sp = new JScrollPane(taRes = new JTextArea());
		taRes.setEditable(false);
		add("Center", sp);
		
		/* coleções */
		col.add(new ArrayList<String>()); // lista
		col.add(new HashSet<String>()); // conjunto
		col.add(new LinkedHashSet<String>()); // conjunto
		col.add(new TreeSet<String>()); // conjunto ordenado
		
		/* lambda */
		ActionListener alGeral = (e) -> {
			String elem = showInputDialog(P0717ConjuntosGUI.this, "Elemento?", "");
			// verifica elemento fornecido e seleciona ação
			if (elem == null || elem.trim().length() == 0) {
				return;
			} else if (e.getSource() == bIncluir) {
				incluir(elem);
			} else if (e.getSource() == bRemover) {
				remover(elem);
			} else if (e.getSource() == bContem) {
				contem(elem);
			}
			mostraConteudos();
		};
		
		/* registra eventos */
		bIncluir.addActionListener(alGeral);
		bRemover.addActionListener(alGeral);
		bContem.addActionListener(alGeral);
		
		// ajustes gerais do JFrame
		getRootPane().setDefaultButton(bIncluir);
		setSize(300, 150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// inicia JTextArea
		mostraConteudos();
	}

	protected void incluir(String elem) { // acao do botao bIncluir
		for (Collection<String> c : col) {
			c.add(elem);
		}
	}

	protected void remover(String elem) { // acao do botao bRemover
		int count = 0;
		for (Collection<String> c : col){
			if (c.contains(elem)){
				c.remove(elem);
				count++;
			}
		}
		showMessageDialog(this, count + " ocorrências de '" + elem + "'",
				"Remover", INFORMATION_MESSAGE);
	}

	protected void contem(String elem) { // acao do botao bContem
		int count = 0;
		for (Collection<String> c : col){
			if (c.contains(elem)) count++;
		}
		showMessageDialog(this, count + " ocorrências de '" + elem + "'",
				"Contém", INFORMATION_MESSAGE);
	}

	public void mostraConteudos() { // metodo auxiliar
		taRes.setText("");
		for (Collection<String> c : col) {
			taRes.append(c.getClass().getSimpleName());
			taRes.append(c.toString());
			taRes.append(": " + c.size() + "\n");
		}
	}

	public static void main(String a[]) {
		SwingUtilities.invokeLater(
			() -> { new P0717ConjuntosGUI().setVisible(true); }
		);
	}
}

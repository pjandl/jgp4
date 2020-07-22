/*
 * Java - Guia do Programador - 4a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2020, Novatec Editora Ltda.
 *
 */
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

@SuppressWarnings("serial")
public class P0912Arvore extends JFrame implements TreeSelectionListener {
	private JTree arvore;
	private JLabel lSel;

	public P0912Arvore(String dir, boolean main) {
		super("Árvore de Diretórios");
		arvore = new JTree(criaNodos(new DefaultMutableTreeNode(new File(dir))));
		arvore.getSelectionModel().setSelectionMode(
				TreeSelectionModel.SINGLE_TREE_SELECTION);
		arvore.addTreeSelectionListener(this);
		arvore.addMouseListener(new TreeMouseListener());
		add("Center", new JScrollPane(arvore));
		add("South", lSel = new JLabel("diret\u00f3rio (" + dir + ")"));
		setDefaultCloseOperation(main ? EXIT_ON_CLOSE : DISPOSE_ON_CLOSE);
		pack();
	}

	private DefaultMutableTreeNode criaNodos(DefaultMutableTreeNode raiz) {
		File arq[] = ((File) raiz.getUserObject()).listFiles();
		for (int i = 0; i < arq.length; i++) {
			DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(arq[i]);
			if (arq[i].isDirectory()) {
				criaNodos(nodo);
			}
			raiz.add(nodo);
		}
		return raiz;
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) arvore
				.getLastSelectedPathComponent();
		if (nodo == null)
			return;
		File arq = (File) nodo.getUserObject();
		if (nodo.isLeaf()) {
			lSel.setText("arquivo (" + arq.getName() + ", " + arq.length()
					+ " bytes)");
		} else {
			try {
				lSel.setText("diret\u00f3rio (" + arq.getAbsolutePath() + ")");
			} catch (SecurityException se) {
				showError("Diret\u00f3rio \u00e3o pode ser determinado.", se);
			}
		}
	}

	private void showError(String msg, Exception e) {
		JOptionPane.showMessageDialog(this, msg, "\u00C1rvore",
				JOptionPane.ERROR_MESSAGE);
		System.err.println(e);
	}

	public static void main(final String[] a) {
		SwingUtilities.invokeLater( () -> {
			new P0912Arvore(a.length == 0 ? "." : a[0], true).setVisible(true);
		});
	}

	private class TreeMouseListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			int selRow = arvore.getRowForLocation(e.getX(), e.getY());
			TreePath selPath = arvore.getPathForLocation(e.getX(), e.getY());
			if (selRow != -1 && e.getClickCount() == 2) {
				arvore.setSelectionPath(selPath);
				DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) arvore
						.getLastSelectedPathComponent();
				if (nodo == null) {
					return;
				}
				File arq = (File) nodo.getUserObject();
				if (nodo.isLeaf()) {
					String fName = arq.getAbsolutePath();
					if (fName.endsWith(".txt") || fName.endsWith(".java")) {
						String os = System.getProperty("os.name").toLowerCase();
						try { // identifica SO para usar comando correto
							if (os.indexOf("mac") != -1) {
								Runtime.getRuntime().exec("open " + fName);
							} else if (os.indexOf("win") != -1) {
								Runtime.getRuntime().exec("notepad " + fName);
							} else {
								return;
							}
						} catch (Exception exc) {
							showError("Arquivo '" + arq.getAbsolutePath()
									+ "' \u00e3o pode ser aberto.", exc);
						}
					}
				} else {
					if (!arq.getPath().equals(".")) {
						new P0912Arvore(arq.getPath(), false).setVisible(true);
					}
				}
			}
		}
	}
}

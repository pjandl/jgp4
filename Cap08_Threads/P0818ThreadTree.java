import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

@SuppressWarnings("serial")
public class P0818ThreadTree extends JScrollPane {
	private static P0818ThreadTree instance = null;
	private JTree tree;
	private DefaultTreeModel dtm;

	private P0818ThreadTree () { // construtor privado
		tree = new JTree(); // cria arvore
		dtm = (DefaultTreeModel) tree.getModel(); // obtem modelo de dados
		refresh(); // atualiza dados
		getViewport().setView(tree); // adiciona arvore ao JScrollPane
	}

	public static final P0818ThreadTree  getInstance() {
		if (instance == null) { // verifica instancia
			instance = new P0818ThreadTree (); // cria nova instancia
		}
		return instance; // retorna instancia unica
	}

	public void refresh() {
		Thread threadMain = Thread.currentThread(); // grupo raiz das threads
		ThreadGroup grupoRaiz = threadMain.getThreadGroup().getParent();
		// obtem grupos e threads recursivamente
		dtm.setRoot(listaGrupo(grupoRaiz));
	}

	public DefaultMutableTreeNode listaGrupo(ThreadGroup grupo) {
		DefaultMutableTreeNode node = 
				new DefaultMutableTreeNode(grupo.toString());
		int num = grupo.activeGroupCount(); // informacao dos subgrupos
		ThreadGroup subgrupos[] = new ThreadGroup[num];
		grupo.enumerate(subgrupos);
		node.add(new DefaultMutableTreeNode("subgrupos: " + num));
		for (int s = 0; s < subgrupos.length; s++) {
			node.add(listaGrupo(subgrupos[s])); // recursao
		}
		num = grupo.activeCount(); // informacao das threads
		Thread threads[] = new Thread[num];
		grupo.enumerate(threads);
		DefaultMutableTreeNode aux = new DefaultMutableTreeNode();
		node.add(aux);
		int t = 0;
		for (int i = 0; i < num; i++) {
			if (threads[i].getThreadGroup() == grupo) { // so threads do grupo
				node.add(new DefaultMutableTreeNode(t + ":"
						+ threads[i].toString()));
				t++;
			}
		}
		aux.setUserObject("threads: " + t);
		return node;
	}

	public JTree getJTree() {
		return tree;
	}
}

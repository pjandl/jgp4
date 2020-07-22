import java.awt.Component;

import java.math.BigInteger;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class P0616ListModel extends JFrame {
	// cria lista vazia
	private JList<String> lista = new JList<>();
	private JLabel lSel;

	public P0616ListModel () {
		setTitle("Swing List Model"); // ajusta título

		// adiciona componentes nas regiões
		add(new JLabel("Potências de 2"), "North");
		add(new JScrollPane(lista), "Center");
		add(lSel=new JLabel("Sem Seleção"),"South");

		// modelo para lista
		ListModel<String> potencias = new AbstractListModel<String>() {
			private final BigInteger dois = new BigInteger("2");
			public int getSize() {
				return 256;
			}
			public String getElementAt(int index) {
				return dois.pow(index).toString();
			}
		};
		lista.setModel(potencias);
		
		// listener para lista com lambda
		lista.addListSelectionListener((e) -> {
			int itens[] = lista.getSelectedIndices(); // obtém seleção
			if (itens.length>0) { // verifica selecao
				StringBuffer sb = new StringBuffer();
				// cria lista com seleção
				for (int i=0; i<itens.length-1; i++) {
					sb.append("2^");
					sb.append(itens[i]);
					sb.append(",");
				}
				sb.append("2^");
				sb.append(itens[itens.length-1]);
				lSel.setText("Seleção: "+ sb.toString());
			} else {
				lSel.setText("Sem Seleção");
			}
		}	);
		
		// cell renderer para lista
		lista.setCellRenderer(new P0616CellRenderer());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ação fechar
		pack(); // autodimensiona janela
	}

	public static void main (String args[]) {
		SwingUtilities.invokeLater(// expressão lambda
			() -> { new P0616ListModel().setVisible(true); }
		);
	}
}

// Renderizador de célula (de item da lista)
@SuppressWarnings("serial")
class P0616CellRenderer extends JLabel implements ListCellRenderer<Object> {
	static final ImageIcon RED = new ImageIcon("img/block_red.gif");
	static final ImageIcon GREEN = new ImageIcon("img/block_green.gif");

	// Método obrigatório para implementação de Cell Renderers
	public Component getListCellRendererComponent(
			JList<?> lista,          // a lista
			Object valor,            // valor a exibir
			int indice,              // índice do elemento (célula)
			boolean isSelected,      // flag de seleção da célula
			boolean cellHasFocus)    // flag de foco na célula
{
		setText(valor.toString());
		setIcon((indice%2==0) ? GREEN : RED);
		if (isSelected) {
			setBackground(lista.getSelectionBackground());
			setForeground(lista.getSelectionForeground());
		} else {
			setBackground(lista.getBackground());
			setForeground(lista.getForeground());
		}
		setEnabled(lista.isEnabled());
		setFont(lista.getFont());
		setOpaque(true);
		return this;
	}
}


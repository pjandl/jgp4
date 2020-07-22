import java.awt.GridLayout;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class P0615JList extends JFrame
			implements ItemListener, ListSelectionListener {
	private String opcoes[] = {"Simples","Intervalo","Múltipla"};
	private String elem[] = {"Um","Dois","Três","Quatro","Cinco","Seis","Sete"};
	private JRadioButton rb[] = new JRadioButton[3];
	// cria lista com elementos
	private JList<String> lista = new JList<>(elem);
	private JLabel lSel;

	public P0615JList () {
		setTitle("Swing List"); // ajusta título
		JPanel pRadio = new JPanel(new GridLayout(1, 3));
		ButtonGroup bg = new ButtonGroup(); // grupo de radiobuttons
		for (int i=0; i<3; i++) { // cria e agrupa radiobuttons
			pRadio.add(rb[i] = new JRadioButton(opcoes[i]));
			rb[i].addItemListener(this);  bg.add(rb[i]);
		}
		
		// adiciona componentes nas regiões
		add(pRadio, "North");
		add(new JScrollPane(lista), "Center");
		add(lSel=new JLabel("Sem Seleção"),"South");
		
		// listener para lista
		lista.addListSelectionListener(this);
		// seleciona modo default
		rb[0].setSelected(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ação fechar
		pack(); // autodimensiona janela
	}

	@Override
	public void itemStateChanged (ItemEvent e) {
		if (e.getSource()==rb[0]) { // ajusta modo de seleçãoo
			lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		} else if (e.getSource()==rb[1]) {
			lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		} else {
			lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		int itens[] = lista.getSelectedIndices(); // obtém seleção
		if (itens.length>0) { // verifica selecao
			StringBuffer sb = new StringBuffer();
			// cria lista com seleção
			for (int i=0; i<itens.length-1; i++) {
				sb.append(itens[i]);
				sb.append(",");
			}
			sb.append(itens[itens.length-1]);
			lSel.setText("Seleção: "+ sb.toString());
		} else {
			lSel.setText("Sem Seleção");
		}
	}

	public static void main (String args[]) {
		SwingUtilities.invokeLater(// expressão lambda
			() -> { new P0615JList().setVisible(true); }
		);
	}
}

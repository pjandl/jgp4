import java.awt.Dimension;
import java.awt.GridLayout;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class P0610JTextArea extends JFrame implements ItemListener {
	// componentes ativos
	private JTextArea textArea;
	private JRadioButton rbNoWrap, rbWordWrap, rbCharWrap;

	public  P0610JTextArea () {
		super("SwingTextArea"); // ajusta título
		// layout grade 1x3
		JPanel pTop = new JPanel(new GridLayout(1, 3, 2, 2));
		pTop.setBorder(BorderFactory.createTitledBorder( // borda
			BorderFactory.createEtchedBorder(),"Quebra de Linha"));
		pTop.add(rbNoWrap = new JRadioButton("Sem quebra", true));
		pTop.add(rbWordWrap = new JRadioButton("Palavras"));
		pTop.add(rbCharWrap = new JRadioButton("Caracteres"));
		add(pTop, "North");

		// grupo de radiobuttons
		ButtonGroup bg = new ButtonGroup();
		rbNoWrap.addItemListener(this);
		bg.add(rbNoWrap);
		rbWordWrap.addItemListener(this);
		bg.add(rbWordWrap);
		rbCharWrap.addItemListener(this);
		bg.add(rbCharWrap);
		JScrollPane sp = new JScrollPane(textArea = new JTextArea());
		sp.setPreferredSize(new Dimension(300, 150)); // ajustes do scrollpane
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(sp, "Center");

		pack(); // autodimensiona janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ação fechar
	}
	@Override
	public void itemStateChanged (ItemEvent e) { // classe implementa listener
		textArea.setLineWrap(!rbNoWrap.isSelected());
		textArea.setWrapStyleWord(rbWordWrap.isSelected());
		textArea.repaint();
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater( // expressão lambda
			() -> { new P0610JTextArea().setVisible(true); }
		);
	}
}

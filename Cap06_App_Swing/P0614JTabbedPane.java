import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class P0614JTabbedPane extends JFrame implements ActionListener {
	private JTabbedPane tabs; // painel de abas
	private JButton bAnt, bProx; // botões de navegação

	public P0614JTabbedPane () {
		super("Swing Tabs");	// ajusta título
		tabs = new JTabbedPane();
		String imgDir = "C:/JGP4/Cap06_SwingComp/img/";
/* Aba 1 */ JTextArea ta = new JTextArea();
			ta.setLineWrap(true);
			ta.setWrapStyleWord(true);
			tabs.addTab("Aba 1", new ImageIcon(imgDir + "selected.gif"), 
					new JScrollPane(ta), "Primeira Aba");
/* Aba 2 */ JPanel panel3 = new JPanel();
			panel3.add(new JLabel("Conteúdo da Aba 3"));
			tabs.addTab("", new ImageIcon(imgDir + "selected.gif"), 
					panel3, "Segunda Aba");
/* Aba 3 */ tabs.addTab("Aba 3", new JLabel(new ImageIcon(imgDir + "mini-j.gif")));

		// adiciona painel de abas na area central da janela
		getContentPane().add(tabs, "Center");

		// painel inferior
		JPanel p1 = new JPanel();
		// painel auxiliar
		JPanel p2 = new JPanel(new GridLayout(1,2,5,5));
		// botões
		p2.add(bAnt = new JButton("Anterior", new ImageIcon(imgDir + "previous.gif")));
		p2.add(bProx = new JButton("Próximo",new ImageIcon(imgDir + "next.gif")));
		p1.add(p2);
		getContentPane().add(p1, "South"); // adiciona painel a janela
		// registro listeners
		bAnt.addActionListener(this); 
		bProx.addActionListener(this);

		// dimensiona janela
		setSize(400,180);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ação fechar
	}

	@Override
	public void actionPerformed (ActionEvent e) {
		int i = tabs.getSelectedIndex();
		if (e.getSource()==bAnt) {
			tabs.setSelectedIndex(i>0 ? i-1 : tabs.getTabCount()-1);
		} else {
			tabs.setSelectedIndex(i<tabs.getTabCount()-1 ? i+1 : 0);
		}
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater( // expressão lambda
			() -> { new P0614JTabbedPane().setVisible(true); }
		);
	}
}

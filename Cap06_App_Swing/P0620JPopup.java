import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class P0620JPopup extends JFrame implements ActionListener {
	private JTextArea output = new JTextArea(); // área de edição
	private JPopupMenu popup = new JPopupMenu(); // menu pop-up
	private String menuItens[] = { "Recortar", "Copiar", "Colar" };
	
	public P0620JPopup () {
		super("Swing JPopup");
		// área de edição central
		add(new JScrollPane(output), "Center");
		
		// criação do menu popup
		for (String item: menuItens) { // itens do pop-up
			JMenuItem mi = new JMenuItem(item); // cria item do menu
			mi.addActionListener(this); // registra listener
			popup.add(mi); // adiciona ao popup
		}
		
		// listener para pop-up
		output.addMouseListener(new PopupHandler());
		
		// outros ajustes
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 260);
	}
	
	@Override
	public void actionPerformed (ActionEvent e) {// listener p/ itens do pop-up
		String acao = ((JMenuItem)e.getSource()).getText();
		if (acao.equals("Recortar")) {
			output.cut(); // cut text (recortar)
		} else if (acao.equals("Copiar")) {
			output.copy(); // copy text (copiar)
		} else {
			output.paste(); // paste text (colar)
		}
	}

	public static void main (String[] args) {
		SwingUtilities.invokeLater(
			() -> { new P0620JPopup().setVisible(true); }
		);
	}
	
	// Handler para PopupMenu
	private class PopupHandler extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			mouseReleased(e);
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			if (e.isPopupTrigger()) { // exibe pop-up se acionado botão correto
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		}
	}
}

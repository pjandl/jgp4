import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")public class P0719TestaFila extends JFrame implements ActionListener {
	private JTextArea taVisaoFila; // textarea para conteúdo da fila
	private JTextField tfDado; // textfield para entrada
	private JButton botao[] = new JButton[6]; // botões de controle
	private String cmd[] = {"Add", "Remove", "Element ", "Offer", "Pool", "Peek"};
	private Queue<String> fila = new LinkedList<>(); // fila
	
	public P0719TestaFila() {
		super("TestaFila");
		// instancia componentes e os organiza em paineis
		JPanel pTop = new JPanel(new GridLayout(2, 3, 3, 3));
		for (int i = 0; i < cmd.length; i++) {
			botao[i] = new JButton(cmd[i]);
			botao[i].addActionListener(this);
			pTop.add(botao[i]);
		}
		taVisaoFila = new JTextArea();
		JScrollPane sp = new JScrollPane(taVisaoFila);
		JPanel pBot = new JPanel(new BorderLayout());
		pBot.add("West", new JLabel("Elemento"));
		pBot.add("Center", tfDado = new JTextField());
		// adiciona componentes ao JFrame
		getContentPane().add("North", pTop);
		getContentPane().add("Center", sp);
		getContentPane().add("South", pBot);
		// outros ajuste na interface
		taVisaoFila.setEditable(false);
		taVisaoFila.setText(fila.toString()); // atualiza visao da fila
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}
	
	public void actionPerformed (ActionEvent e) {
		int i; // determina índice do botão que foi acionado
		for(i=0; i<6; i++) { 
			if (e.getSource()==botao[i]) break;
		}
		if (i==6) return;	// em caso de erro
		try { // monitora exceções nas operações
			switch(i) { // operações conforme array cmd
			case 0:
				fila.add(tfDado.getText());
				tfDado.setText("");
				break;
			case 1:
				tfDado.setText(fila.remove());
				break;
			case 2:
				tfDado.setText(fila.element());
				break;
			case 3:
				fila.offer(tfDado.getText());
				tfDado.setText("");
				break;
			case 4:
				tfDado.setText(fila.poll());
				break;
			case 5:
				tfDado.setText(fila.peek());
				break;
			}
		} catch (RuntimeException rte) { // exibe eventual exceção
			JOptionPane.showMessageDialog(this, rte.toString());
		}
		taVisaoFila.setText(fila.toString()); // atualiza visão da fila
	}
	
	public static void main(String a[]) {
		SwingUtilities.invokeLater(
			() -> { new P0719TestaFila().setVisible(true); }
		);
	}
}

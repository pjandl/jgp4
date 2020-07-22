import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class P0622JOptionPane extends JFrame implements ActionListener {
/*acoes*/	private static String[] acao = { "Informação", "Aviso", "Erro", "Mensagem",
			"Input", "Entrada", "Aplicação", "Aviso2", "Confirmação" };
/*botões*/	private JButton[] b = new JButton[acao.length];

	public P0622JOptionPane() {
		// ajusta titulo
		super("Swing JOptionPane");
		// layout grade
		setLayout(new GridLayout(2, b.length / 2));

		// instancia botões e registra seus listeners
		for (int i = 0; i < b.length; i++) {
			b[i] = new JButton(acao[i]);
			add(b[i]);
			b[i].addActionListener(this);
		}

		// outros ajustes
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}

	public void actionPerformed(ActionEvent evt) {
		JButton b = (JButton) evt.getSource();
		String a = b.getText();
		if (a.equals(acao[0])) {
			JOptionPane.showMessageDialog(P0622JOptionPane.this,
					"Uma informação para o usuário", acao[0],
					INFORMATION_MESSAGE);
		} else if (a.equals(acao[1])) {
			JOptionPane.showMessageDialog(P0622JOptionPane.this,
					"Um aviso para o usuário", acao[1],
					WARNING_MESSAGE);
		} else if (a.equals(acao[2])) {
			JOptionPane.showMessageDialog(P0622JOptionPane.this,
					"Um erro para o usuário", acao[2],
					ERROR_MESSAGE);
		} else if (a.equals(acao[3])) {
			JOptionPane.showMessageDialog(P0622JOptionPane.this,
					"Uma mensagem qualquer", acao[3],
					PLAIN_MESSAGE);
		} else if (a.equals(acao[4])) {
			JOptionPane.showInputDialog("Forneça um inteiro");
		} else if (a.equals(acao[5])) {
			JOptionPane.showInputDialog(P0622JOptionPane.this,
					"Digite o nome", acao[5],
					INFORMATION_MESSAGE);
		} else if (a.equals(acao[6])) {
			JOptionPane.showConfirmDialog(P0622JOptionPane.this,
					"Encerrar aplicação?", acao[6],
					OK_CANCEL_OPTION,
					QUESTION_MESSAGE);
		} else if (a.equals(acao[7])) {
			JOptionPane.showConfirmDialog(P0622JOptionPane.this,
					"Deseja continuar?", acao[7],
					YES_NO_OPTION,
					WARNING_MESSAGE);
		} else {
			Object[] options = { "Sim", "Não" };
			JOptionPane.showOptionDialog(null, "Deseja continuar?",
					acao[8], YES_NO_OPTION,
					ERROR_MESSAGE, null, options, options[0]);
		}
	}

	public static void main(String a[]) {
		SwingUtilities.invokeLater(
			() -> { new P0622JOptionPane().setVisible(true); }
		);
	}
}

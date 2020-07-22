import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class P0625JSpinner extends JFrame implements ChangeListener {
	private JLabel lAlvo = new JLabel("PeterJandlJr2020"); // rótulo
	private JSpinner spFSize = new JSpinner(); // spinner
	private SpinnerNumberModel snm; // modelo numérico para spinner

	public P0625JSpinner () {
		super("Swing JSpinner"); // ajusta título
		add("Center", new JScrollPane(lAlvo));

		// cria modelo para JSpinner com tamanho do fonte do rótulo
		snm = new SpinnerNumberModel(lAlvo.getFont().getSize(),6,72,2);
		spFSize.setModel(snm); // ajusta modelo do spinner
		spFSize.addChangeListener(this); // registra listener

		// painel auxiliar
		JPanel pAux = new JPanel();
		pAux.add(new JLabel("Tamanho do Fonte"));
		pAux.add(spFSize);
		add("South", pAux);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ação fechar
		setSize(300, 130); // dimensiona janela
	}

	@Override
	public void stateChanged (ChangeEvent e) {
		Font f = lAlvo.getFont(); // obtêm fonte do rótulo
		float valor = snm.getNumber().floatValue(); // obtém valor do spinner
		lAlvo.setFont(f.deriveFont(valor)); // ajusta fonte do label com outro derivado
		lAlvo.validate(); // valida exibição
	}

	public static void main(String a[]) {
		SwingUtilities.invokeLater(
			() -> { new P0625JSpinner().setVisible(true); }
		);
	}
}


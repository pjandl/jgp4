import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class P0810Corrida extends JFrame implements ActionListener, Runnable {
	private static int numComp = 4; // numero de corredores default
	private JSpinner tfPri[] = new JSpinner[numComp]; // arrays
	private JLabel lDist[] = new JLabel[numComp];
	private P0809Corredor corredor[] = new P0809Corredor[numComp];
	private JButton bInicio;

	public P0810Corrida() {
		super("Corrida"); // ajusta titulo
		JPanel p1 = new JPanel(); // painel
		p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
		for (int i = 0; i < numComp; i++) { // adiciona componentes no painel
			JPanel p2 = new JPanel(new GridLayout(1, 3, 1, 1));
			p2.add(new JLabel("#" + (i + 1))); // numero do corredor
			p2.add(tfPri[i] = new JSpinner( // spinner de prioridade
					new SpinnerNumberModel(Thread.NORM_PRIORITY,
							Thread.MIN_PRIORITY, Thread.MAX_PRIORITY - 1, 1)));
			p2.add(lDist[i] = new JLabel("0", SwingConstants.RIGHT)); // distancia
			p2.setBorder(BorderFactory.createEtchedBorder());
			float v = 1f - i * 0.75f / numComp;
			p2.setBackground(new Color(v, v, v));
			p1.add(p2);
		}
		p1.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		add(p1, "Center");
		add(bInicio = new JButton("Início"), "South");
		bInicio.addActionListener(this); // registro listener
		setDefaultCloseOperation(EXIT_ON_CLOSE); // acao fechar
		pack(); // autodimensiona janela
	}

	public void actionPerformed(ActionEvent e) {
		bInicio.setEnabled(false); // desabilita botao
		SpinnerNumberModel snm;
		for (int i = 0; i < numComp; i++) { // prepara corredores
			tfPri[i].setEnabled(false); // desabilita spinner
			corredor[i] = new P0809Corredor(10_000); // cria corredor
			snm = (SpinnerNumberModel) tfPri[i].getModel(); // modelo spinner
			int pri = snm.getNumber().intValue(); // prioridade dada
			corredor[i].setPriority(pri); // ajusta prio thread
		}
		Thread monitor = new Thread(this); // cria monitor
		monitor.setPriority(Thread.MAX_PRIORITY); // ajusta c/ prio max
		monitor.start(); // inicia monitor
		for (int i = 0; i < numComp; i++) { // inicia corredores
			corredor[i].start();
		}
	}

	public void run() {
		boolean correndo = true;
		while (correndo) { // monitora enquanto todos estao "correndo"
			try {
				Thread.sleep(10);
			} // cede vez para threads menor prio
			catch (InterruptedException e) {
			}
			for (int i = 0; i < numComp; i++) { // verifica corredores
				if (!corredor[i].isAlive())
					correndo = false;
				lDist[i].setText((corredor[i].distancia) + "");
			}
		}
		for (int i = 0; i < numComp; i++) { // finaliza corredores
			tfPri[i].setEnabled(true); // habilita spinners
		}
		bInicio.setEnabled(true); // habilita botao
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(
			() -> { // expressão lambda
				P0810Corrida.numComp = 4; // define no. de corredores
				new P0810Corrida().setVisible(true);
			}
		);
	}
}

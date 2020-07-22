import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class P0806PrimosCT extends JFrame implements ActionListener {
	private P0804PrimosPanel pp;
	private boolean stop;

	public P0806PrimosCT() {
		super("Primos Com Thread");
		setContentPane(pp = new P0804PrimosPanel());
		pp.getButton1().addActionListener(this);
		pp.getButton2().addActionListener(this);
		pp.getButton3().addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 150);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				stop = true;
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pp.getButton3()) {
			try {
				pp.getButton2().setEnabled(false);
				pp.getButton3().setEnabled(false);
				new Calculo().start();
				// Com uso de expressão lambda
//				new Thread(() -> {
//					calcPrimos(Integer.parseInt(pp.getTextField1().getText()),
//							Integer.parseInt(pp.getTextField2().getText()));
//					pp.getButton2().setEnabled(true);
//					pp.getButton3().setEnabled(true);
//				}).start();
			} catch (NumberFormatException nfe) {
				pp.getTextArea().setText("Intervalo inválido!");
				return;
			}
		} else if (e.getSource() == pp.getButton2()) {
			pp.getTextArea().setText(null);
		} else {
			stop = true;
			pp.getButton2().setEnabled(true);
			pp.getButton3().setEnabled(true);
		}
	}

	public void calcPrimos(int inicio, int fim) {
		pp.getTextArea().setText("Calculando:\n");
		stop = false;
		for (int n = inicio; n <= fim && !stop; n++) {
			int i;
			for (i = 2; i < n; i++)
				if (n % i == 0)
					break;
			if (i == n)
				pp.getTextArea().append(n + ", ");
		}
		pp.getTextArea().append("FIM\n");
	}

	private class Calculo extends Thread { // classe interna
		@Override
		public void run() { // aciona calculo
			calcPrimos(Integer.parseInt(pp.getTextField1().getText()),
					Integer.parseInt(pp.getTextField2().getText()));
			pp.getButton2().setEnabled(true);
			pp.getButton3().setEnabled(true);
		}
	}

	public static void main(String a[]) {
		SwingUtilities.invokeLater(
			() -> { new P0806PrimosCT().setVisible(true); }
		);
	}
}

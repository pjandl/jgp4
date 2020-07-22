import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class P0808Relogio extends JFrame {
	public P0808Relogio () {
		super("Relógio");
		P0807JClockPanel clock = new P0807JClockPanel ();
		clock.start();
		getContentPane().add("Center", clock);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}

	public static void main (String a[]) {
		SwingUtilities.invokeLater(
			() -> { new P0808Relogio().setVisible(true); }
		);
	}
}

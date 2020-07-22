import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class P0807JClockPanel  extends JPanel implements Runnable {
	private Thread interna = null;
	private boolean stop = false;
	private DateTimeFormatter tdf;
	private JLabel lTime;
	public static String format = "E dd/MM/yyyy HH:mm:ss";

	public P0807JClockPanel () {
		add(lTime = new JLabel(format));
		tdf = DateTimeFormatter.ofPattern(format);
	}

	public void start() {
		if (interna == null) { // cria e inicia thread se necessário
			interna = new Thread(this, "Relógio");
			interna.start();
		}
	}

	public void stop() {
		stop = true; // para thread
		interna = null; // indica necessidade de nova thread
	}

	@Override
	public void run() { // código da thread
		// só executa se for a thread corrente
		while (Thread.currentThread() == interna && !stop) {
			repaint();
			try {
				Thread.sleep(1000); // um segundo de pausa
				lTime.setText(tdf.format(LocalDateTime.now()));
			} catch (InterruptedException e) {
			}
		}
	}
}

import java.awt.Dimension;
import java.awt.FlowLayout;

import java.time.LocalDateTime;

import java.util.Arrays;
import java.util.PriorityQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class P0721PriorityQueue extends JFrame {
	private JButton bOffer, bPoll;
	private JTextArea taQueue;
	private PriorityQueue<Job> queue = new PriorityQueue<>();

	public P0721PriorityQueue() {
		super("PriorityQueueDemo");
		// instancia componentes e os organiza em paineis
		JPanel pTop = new JPanel(new FlowLayout());
		pTop.add(bOffer = new JButton("Offer"));
		pTop.add(bPoll = new JButton("Poll"));
		JScrollPane sp = new JScrollPane(taQueue = new JTextArea());
		taQueue.setPreferredSize(new Dimension(300, 120));
		// adiciona componentes ao JFrame
		getContentPane().add("North", pTop);
		getContentPane().add("Center", sp);
		// usa expressões lambda para designar funcionalidades
		bOffer.addActionListener((e) -> {
			queue.offer(new Job());
			showQueue();
		});
		bPoll.addActionListener((e) -> {
			queue.poll();
			showQueue();
		});
		// outros ajustes na interface
		taQueue.setEditable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		showQueue();
	}

	private void showQueue() {
		Job data[] = queue.toArray(new Job[0]); // conteudo da fila
		Arrays.sort(data); // ordenacao por id (natural)
		StringBuffer sb = new StringBuffer();
		for (Job e : data) {
			sb.append("[");
			sb.append(e);
			sb.append("]\n");
		}
		taQueue.setText(sb.toString());
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater( // expressao lambda
			() -> { new P0721PriorityQueue().setVisible(true); }
		);
	}

	private class Job implements Comparable<Job> {
		private Integer id; // Id
		private LocalDateTime date; // hora de criacao

		public Job() { // construtor
			id = (int) (Math.random() * 10_000);
			date = LocalDateTime.now();
		}

		// representacao textual
		@Override
		public String toString() {
			return id + ":" + date;
		}

		// comparacao de jobs
		@Override
		public int compareTo(Job arg) {
			return id - arg.id;
		}
	}
}

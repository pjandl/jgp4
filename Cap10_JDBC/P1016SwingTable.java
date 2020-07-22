import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class P1016SwingTable extends JFrame {
	private JTable tabela;

	public P1016SwingTable() { // Construtor
		setTitle("Gases Nobres 2");
		tabela = new JTable(new P1015TableModel());
		getContentPane().add(new JScrollPane(tabela), "Center");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 150);
	}

	public static void main(String a[]) { // main
		SwingUtilities.invokeLater(
			() -> { new P1016SwingTable().setVisible(true); }
		);
	}
}

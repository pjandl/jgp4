import jandl.db.DB;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.io.FileInputStream;
import java.io.IOException;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class P1020DataInsert extends JFrame {
	private JTextField tf[];
	private JButton bClear;
	private JButton bInclude;
	private String sql = null;
	private int params = 0;
	private int types[];

	// Construtor
	public P1020DataInsert(String propFile) {
		try { // Leitura das propriedades
			Properties prop = new Properties();
			prop.load(new FileInputStream(propFile));
			sql = prop.getProperty("DataInsert.sql");
			setTitle(prop.getProperty("DataInsert.title"));
			params = Integer.parseInt(prop.getProperty("DataInsert.params"));
			JPanel p = new JPanel(new GridLayout(2 * params + 1, 1, 1, 1));
			tf = new JTextField[params];
			types = new int[params];
			for (int i = 0; i < params; i++) {
				p.add(new JLabel(prop.getProperty("DataInsert.label" + i),
						JLabel.LEFT));
				p.add(tf[i] = new JTextField());
				types[i] = Integer.parseInt(prop.getProperty("DataInsert.type"
						+ i));
			}
			add("Center", p);
		} catch (IOException ioe) {
			System.err.println(ioe);
		}
		JPanel p = new JPanel(new GridLayout(1, 2, 1, 1));
		p.add(bClear = new JButton("Limpar"));
		p.add(bInclude = new JButton("Incluir"));
		add("South", p);
		bClear.addActionListener((e) -> { // expressão lambda
			bClearClick();
		});
		bInclude.addActionListener((e) -> { // expressão lambda
			bIncludeClick();
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				DB.getInstance().shutdown();
			}
		});
		pack();
	}

	private void bClearClick() { // Limpa campos
		for (int i = 0; i < params; i++)
			tf[i].setText("");
		tf[0].requestFocus();
	}

	private void bIncludeClick() { // executa inclusao
		try {
			PreparedStatement pstmt = DB.getInstance().getConnection()
					.prepareStatement(sql);
			for (int i = 0; i < params; i++) { // ajusta parametros
				switch (types[i]) {
				case Types.INTEGER:
					pstmt.setInt(i + 1, Integer.parseInt(tf[i].getText()));
					break;
				case Types.FLOAT:
					pstmt.setDouble(i + 1, Double.parseDouble(tf[i].getText()));
					break;
				default: // Types.VARCHAR:
					pstmt.setString(i + 1, tf[i].getText());
				}
			}
			pstmt.executeUpdate();
			System.out.println("[Data included]");
			bClearClick();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(),
					"Erro na Inclus\u00E3o", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void main(String[] args) { // Main
		final String propFile = args.length == 0 ? "DataInsert.properties"
				: args[0];
		SwingUtilities.invokeLater(
			() -> { new P1020DataInsert(propFile).setVisible(true); }
		);
	}
}

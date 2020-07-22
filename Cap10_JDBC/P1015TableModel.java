import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class P1015TableModel extends AbstractTableModel {
	private Object[][] dados = {
			{ "He", "Hélio", Integer.valueOf(2), Double.valueOf(4.0026),
					Double.valueOf(0.179), Boolean.TRUE },
			{ "Ne", "Neônio", Integer.valueOf(10), Double.valueOf(20.17),
					Double.valueOf(0.90), Boolean.TRUE },
			{ "Ar", "Argônio", Integer.valueOf(18), Double.valueOf(39.94),
					Double.valueOf(1.78), Boolean.TRUE },
			{ "Kr", "Criptônio", Integer.valueOf(36), Double.valueOf(83.80),
					Double.valueOf(3.7), Boolean.TRUE },
			{ "Xe", "Xenônio", Integer.valueOf(54), Double.valueOf(131.30),
					Double.valueOf(5.85), Boolean.TRUE },
			{ "Rd", "Radônio", Integer.valueOf(86), Double.valueOf(222),
					Double.valueOf(9.73), Boolean.TRUE }
	};
	private String[] colunas = { "Símb", "Nome", "NAtom", "M Atom", "M Espec", "Nobre" };

	// Métodos de implementação obrigatória
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return dados.length;
	}

	@Override
	public Object getValueAt(int lin, int col) {
		return dados[lin][col];
	}

	// Métodos de implementação opcional
	@Override
	public String getColumnName(int col) {
		return colunas[col];
	}

	@Override
	public boolean isCellEditable(int lin, int col) {
		return false;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Class getColumnClass(int col) {
		return dados[0][col].getClass();
	}
}

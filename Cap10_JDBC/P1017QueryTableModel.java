import jandl.db.DB;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class P1017QueryTableModel extends AbstractTableModel {
	private ArrayList<Object[]> linhas = new ArrayList<>();
	private String[] colunas;
	private Statement stmt;
	private String query;

	// Construtor
	public P1017QueryTableModel(String query) { 
		try {
			this.query = query;
			stmt = DB.getInstance().getConnection().createStatement();
			loadData();
		} catch (Exception e) {
			System.out.printf("%s[%s]\n", getClass().getSimpleName(), e.toString());
		}
	}

	// Carrega dados do BD no modelo
	public void loadData() { 
		System.out.println("P1017QueryTableModel[loadData()]");
		try (ResultSet rs = stmt.executeQuery(query);) {
			ResultSetMetaData rsmd = rs.getMetaData();
			int numCols = rsmd.getColumnCount();
			colunas = new String[numCols];
			for (int i = 0; i < numCols; i++) {
				colunas[i] = rsmd.getColumnName(i + 1);
			}
			linhas.clear();
			while (rs.next()) {
				Object l[] = new Object[numCols];
				for (int i = 0; i < numCols; i++) {
					l[i] = rs.getObject(i + 1);
				}
				linhas.add(l);
			}
			fireTableDataChanged();
		} catch (Exception e) {
			System.out.printf("%s[%s]\n", getClass().getSimpleName(), e.toString());
		} // rs.close() implicitos
	}

	// Metodos de implementcao obrigatoria
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return linhas.size();
	}

	@Override
	public Object getValueAt(int lin, int col) {
		try {
			Object l[] = linhas.get(lin);
			return l[col];
		} catch (Exception e) {
			System.out.printf("%s[%s]\n", getClass().getSimpleName(), e.toString());
		}
		return null;
	}

	// Metodos de implementacao opcional
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
		return getValueAt(0, col).getClass();
	}

	@Override
	public void setValueAt(Object value, int lin, int col) {
		Object l[] = linhas.get(lin);
		l[col] = value;
		fireTableCellUpdated(lin, col);
	}
}

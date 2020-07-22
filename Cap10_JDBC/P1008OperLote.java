import jandl.db.DB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class P1008OperLote {
	public static void main(String a[]) throws SQLException {
		// obtém conexão
		Connection con = DB.getInstance().getConnection(); 
		// desativa autocommit
		con.setAutoCommit(false); 
		// cria sessão interativa
		Statement stmt = con.createStatement();
		
		// adiciona comandos ao lote
		stmt.addBatch("UPDATE planetas SET diametro=diametro*2");
		stmt.addBatch("DELETE FROM planetas WHERE posicao>=100");
		stmt.addBatch("UPDATE planetas SET diametro=diametro/2");
		
		// executa lote
		int res[] = stmt.executeBatch(); 
		boolean ok = true; // verifica resultados
		for (int i = 0; i < res.length; i++) {
			if (res[i] < 0) {
				ok = false;
			}
		}
		if (ok) {
			con.commit();
		} else {
			con.rollback();
		}
		
		// fecha sessão
		stmt.close(); 
		con.setAutoCommit(true); // ativa autocommit
		DB.getInstance().shutdown(); // encerra conexão
	}
}
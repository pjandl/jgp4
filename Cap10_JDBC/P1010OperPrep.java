import jandl.db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class P1010OperPrep {
	public static void main(String a[]) throws SQLException {
		// obtém conexão
		Connection con = DB.getInstance().getConnection();

		// cria comando preparado
		String sql = "INSERT INTO planetas(posicao, nome, distancia, diametro) VALUES(?, ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);

		// prepara conjuntos de parâmetros
		for (int i = 0; i < 100; i++) {
			double valor = Math.random(); // gera valor aleatório
			pstmt.setInt(1, 1000 + i); // parâmetro 1
			pstmt.setString(2, "Planeta#" + i); // parâmetro 2
			pstmt.setDouble(3, 1000000 * valor); // parâmetro 3
			pstmt.setDouble(4, 1000 * valor); // parâmetro 4
			pstmt.addBatch(); // separa conjuntos de parâmetros
		}
		
		// processa lote
		int res[] = pstmt.executeBatch(); 
		
		pstmt.close(); // encerra comando preparado
		DB.getInstance().shutdown(); // encerra conexão

		int check = 0; // totalizador de oks
		for (int i = 0; i < res.length; i++) {
			check += res[i] > 0 ? 1 : 0;
		}
		System.out.println(check + " datasets ok em " + res.length);
	}
}

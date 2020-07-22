import jandl.db.DB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class P1007ConversaoGeral {
	public static void main(String a[]) throws SQLException {
		Connection con = DB.getInstance().getConnection(); // obtém conexão
		// cria sessão interativa com resultados atualizáveis
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		// executa consulta
		ResultSet rs = stmt.executeQuery("SELECT * FROM PLANETAS");
		int nPlanetas = 0;
		while (rs.next()) {
			// navega pelo resultado e altera distâncias e diâmetros
			nPlanetas++;
			double distancia = rs.getDouble("DISTANCIA");
			rs.updateDouble("DISTANCIA", distancia / 1.6); //para milha
//			rs.updateDouble("DISTANCIA", distancia * 1.6); //para km
			double diametro = rs.getDouble("DIAMETRO");
			rs.updateDouble("DIAMETRO", diametro / 1.6); //para milha
//			rs.updateDouble("DIAMETRO", diametro * 1.6); //para km
			rs.updateRow();
		}
		stmt.close(); // fecha sessão
		System.out
				.println(nPlanetas + " planetas tiveram valores convertidos.");
		DB.getInstance().shutdown(); // encerramento da conexão
	}
}
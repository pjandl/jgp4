import jandl.db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

public class P1005ListaPlanetas {
	public static void main (String a[]) throws SQLException {
		// formatador decimal em notação de engenharia
		DecimalFormat df = new DecimalFormat("##0.#####E0");

		// obtém conexão
		Connection con = DB.getInstance().getConnection();
		// cria sessão interativa
		Statement stmt = con.createStatement();

		// executa consulta
		ResultSet rs = stmt.executeQuery("SELECT * FROM PLANETAS");

		// exibe resultados
		double distMedia = 0;
		int nPlanetas = 0;
		while (rs.next()) {
//			int colNum= rs.findColumn("DISTANCIA");
//			distMedia += rs.getDouble(colNum);
			distMedia += rs.getDouble("DISTANCIA");
			nPlanetas++;
			System.out.println(rs.getString("POSICAO") + ": " + rs.getString("NOME")
			 + ", " + df.format(rs.getDouble("DIAMETRO")) + "Km");
		}
		rs.close(); // fecha resultados
		System.out.printf("Dist Media = %11.5EGm\n", distMedia/nPlanetas);

		// encerramento da conexão
		DB.getInstance().shutdown();
	}
}

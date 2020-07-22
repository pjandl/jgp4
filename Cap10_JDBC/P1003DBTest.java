import jandl.db.DB;

import java.sql.Connection;

public class P1003DBTest {
	public static void main (String a[]) throws Exception {
		// obtém conexão
		Connection con = DB.getInstance().getConnection();
		// Exibe informações da conexão
		System.out.println(con.getMetaData().getDatabaseProductName() + ":" + con);
		// encerramento da conexão
		DB.getInstance().shutdown();
	}
}

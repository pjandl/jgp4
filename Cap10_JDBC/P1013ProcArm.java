import jandl.db.DB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import java.util.Scanner;

public class P1013ProcArm {
	public static void main(String a[]) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Posicao do Planeta [1..9]? ");
		int posicao = sc.nextInt();
		sc.close();

		// obtém conexão
		Connection con = DB.getInstance().getConnection();

		// cria objeto para executar procedimento armazenado
		String sql = "CALL procNomePlaneta(?, ?)";
		CallableStatement cstmt = con.prepareCall(sql);
		cstmt.setInt(1, posicao); // ajusta parâmetro
		// registra parâmetro de saída
		cstmt.registerOutParameter(2, Types.CHAR);
		cstmt.execute(); // executa procedimento armazenado
		// obtém e exibe resultado
		String res = cstmt.getString(2);
		System.out.println("Resultado=" + res);

		cstmt.close();// encerra procedimento armazenado
		DB.getInstance().shutdown(); // encerramento da conexão
	}
}

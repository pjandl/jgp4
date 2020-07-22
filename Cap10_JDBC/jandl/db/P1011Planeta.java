package jandl.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class P1011Planeta {
	// método privado para organizar obtenção da conexão
	private static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:default:connection");
	}

	// função Java para Apache Derby
	public static int functionPosicaoDoPlaneta(String nome) throws SQLException {
		Connection con = getConnection(); // obtem conexão
		String sql = "SELECT posicao FROM planetas WHERE nome=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, nome);
		ResultSet rs = pstmt.executeQuery();
		// obtém resultado válido ou indica erro
		int posicao = rs.next() ? rs.getInt(1) : -1;
		rs.close(); // fecha recursos usados
		pstmt.close();
		con.close();
		return posicao; // retorno explícito
	}

	// procedimento Java para Apache Derby
	public static void procedurePlanetaNaPosicao(int posicao, String[] planeta)
			throws SQLException {
		Connection con = getConnection(); // obtem conexão
		String sql = "SELECT nome FROM planetas WHERE posicao=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, posicao);
		ResultSet rs = pstmt.executeQuery();
		// obtém resultado válido ou indica erro
		planeta[0] = rs.next() ? rs.getString(1) : "desconhecido";
		rs.close(); // fecha recursos usados
		pstmt.close();
		con.close();
		// retorno implícito de resultado
	}
}

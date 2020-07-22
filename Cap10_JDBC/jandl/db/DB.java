package jandl.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB { // Singleton para acesso a um BD
	private static DB instance = null;
	private Connection connection = null;
	private int clients = 0;

	private DB() { // Construtor privado, pois uso é restrito
		try {
			// Propriedades
			Properties prop = new Properties();
			prop.load(new FileInputStream("DB.properties"));
			String dbDriver = prop.getProperty("db.driver");
			String dbUrl = prop.getProperty("db.url");
			String dbUser = prop.getProperty("db.user");
			String dbPwd = prop.getProperty("db.pwd");
			
			Class.forName(dbDriver); // passo opcional
			
			if (dbUser.length() != 0) { // para acesso com usuário e senha
				connection = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
			} else { // para acesso direto (sem usuário e senha)
				connection = DriverManager.getConnection(dbUrl);
			}
			System.out.println("DB[conexao OK]");
		} catch (ClassNotFoundException | IOException | SQLException e) {
			System.err.println(e);
		}
	}

	public static DB getInstance() { // Retorna instância única
		if (instance == null) {
			instance = new DB();
		}
		return instance;
	}

	public Connection getConnection() { // Retorna conexão
		if (connection == null) {
			throw new RuntimeException("connection==null");
		}
		clients++;
		System.out.println("DB[conexao cliente]");
		return connection;
	}

	public void shutdown() { // Efetua fechamento controlado da conexão
		System.out.println("DB[shutdown cliente]");
		clients--;
		if (clients > 0) {
			return;
		}
		try {
			connection.close();
			instance = null;
			connection = null;
			System.out.println("DB[conexao fechada]");
		} catch (SQLException sqle) {
			System.err.println(sqle);
		}
	}
}

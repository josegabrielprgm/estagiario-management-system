package br.com.jose.sistemaestagiario.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private static final String URL = "jdbc:mysql://localhost:3306/estagio?useSSL=false&serverTimezone=UTC";

	private static final String USER = "root";
	private static final String PASSWORD = "Sua senha aqui";

	public static Connection conectar() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}

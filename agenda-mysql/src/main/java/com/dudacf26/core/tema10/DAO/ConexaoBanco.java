package com.dudacf26.core.tema10.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

	private static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
	private static final String DB_URL = "jdbc:mariadb://localhost:3306/agenda";
	private static final String USER = "root";
	private static final String PASS = "root";

	public static Connection abrir() {
		try {
			Class.forName(JDBC_DRIVER);
			return DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception exception) {
			throw new RuntimeException("Erro na conexao: ", exception);
		}
	}
}

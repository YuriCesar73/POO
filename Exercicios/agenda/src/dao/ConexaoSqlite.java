package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSqlite {

	private Connection conexao;

	public Connection getConexao() throws SQLException {
		String url = "jdbc:sqlite:agendacontatos.db";
		conexao = DriverManager.getConnection(url);
		return conexao;
	}

}

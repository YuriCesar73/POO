package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Table {
	
	public static void main(String[] args) {
		
		Connection conn;
		
		String url = "jdbc:sqlite:agendacontatos.db";
		
		try {
			conn=DriverManager.getConnection(url);
			Statement stmt=conn.createStatement();
			
			stmt.executeUpdate("CREATE TABLE AGENDA " 
			+ "(NOME_CONTATO VARCHAR(32), "
			+ "NUMERO_CONTATO VARCHAR(32))");
			
			System.out.println("Conexão feita e tabela criada!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	
}

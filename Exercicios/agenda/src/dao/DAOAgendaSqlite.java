package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Contato;

public class DAOAgendaSqlite implements DAOAgenda {
	
	private ConexaoSqlite conn = new ConexaoSqlite();

	@Override
	public void addContato(Contato contato) throws Exception {
		String sql = "Insert into AGENDA "
				+ "(NOME_CONTATO, NUMERO_CONTATO)"
				+ "values (?,?)";
		PreparedStatement pstm=conn.getConexao().prepareStatement(sql);
		pstm.setString(1, contato.getNome());
		pstm.setString(2, contato.getTelefone());

	}

	@Override
	public List<Contato> buscarContatos(String nome) throws Exception {
		String sql="Select * from AGENDA where NOME_CONTATO LIKE ? ";
		PreparedStatement pstm=conn.getConexao().prepareStatement(sql);
		pstm.setString(1, "%"+nome+"%");
		
		ResultSet rs=pstm.executeQuery();
		
		List <Contato> contatos = new ArrayList<Contato>();
		
		while(rs.next()) {
			Contato cont = new Contato(
					rs.getString("NOME_CONTATO"),
					rs.getString("NUMERO_CONTATO")
					);
			contatos.add(cont);
		}
		
		
		return contatos;
	}

}

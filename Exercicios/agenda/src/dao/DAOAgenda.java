package dao;

import java.util.List;

import model.Contato;


public interface DAOAgenda {

	public void addContato(Contato contato) throws Exception;
	public List<Contato> buscarContatos(String nome)throws Exception;
}

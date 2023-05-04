package negocio;

import java.util.ArrayList;
import java.util.List;

import exceptions.EmpregadoNaoTemSubordinadoException;

public class Chefe extends Pessoa {

	public Chefe(String nome, Pessoa chefe) {
		super(nome, chefe);
	}
	
	public Chefe(String nome) {
		super(nome);	
	}


	@Override
	public String listarSubordinados() {
		
		String subordinados = "";
		for (Pessoa subordinado: this.getSubordinados()) {
			subordinados += "\n" + subordinado.getNome();
	        String s = subordinado.listarSubordinados();
	        subordinados += s;
		}
		
		return subordinados;
	}

	@Override
	public void addSubordinado(Pessoa subordinado) throws EmpregadoNaoTemSubordinadoException {
		// TODO Auto-generated method stub
		subordinado.setChefe(this);
		this.getSubordinados().add(subordinado);
	}

}
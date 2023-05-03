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
		String s = "";
		for (Pessoa subordinado: this.getSubordinados()) {
			subordinados += "\n" + subordinado.getNome();
			 s = subordinado.listarSubordinados();
		}
		
		return subordinados + s;
		
		
//		for (int i = 0; i < subordinados.length; i++) {
//			Pessoa pessoa = subordinados[i];
//			System.out.println(pessoa.getNome());
//			pessoa.listarSubordinados();	
//		}

	}

	@Override
	public void addSubordinado(Pessoa subordinado) throws EmpregadoNaoTemSubordinadoException {
		// TODO Auto-generated method stub
		subordinado.setChefe(this);
		this.getSubordinados().add(subordinado);
	}

}

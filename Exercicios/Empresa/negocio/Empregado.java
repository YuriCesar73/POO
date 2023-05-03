package negocio;

import exceptions.EmpregadoNaoTemSubordinadoException;

public class Empregado extends Pessoa {

	public Empregado(String nome, Pessoa chefe) {
		super(nome, chefe);
	}
	
	public Empregado(String nome) {
		super(nome);
	}



	@Override
	public String listarSubordinados() {
		return "";

	}

	@Override
	public void addSubordinado(Pessoa subordinado) throws EmpregadoNaoTemSubordinadoException {
		throw new EmpregadoNaoTemSubordinadoException();

	}

}

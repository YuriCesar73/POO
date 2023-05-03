package projetopesquisa;

import excecoes.ProfessorNaoTemSubordinadosException;

public class Professor extends Pesquisador {

	public Professor(String nome, Pesquisador coordenador) {
		super(nome, coordenador);
	}

	@Override
	public void addSubordinado(Pesquisador nome) throws ProfessorNaoTemSubordinadosException {
		throw new ProfessorNaoTemSubordinadosException();
	}

	@Override
	public double getValor() {
		return 220 + (30/100*this.getCoordenador().getValor());
	}

	@Override
	public void listarSubordinados() throws ProfessorNaoTemSubordinadosException {
		throw new ProfessorNaoTemSubordinadosException();
	}

}

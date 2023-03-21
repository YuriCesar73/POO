package entities;

import entities.execption.ProfessorNaoSupervisiona;

public class Professor extends Pesquisador {

	
	
	public Professor(String nome, Pesquisador coordenador) {
		super(nome, coordenador);
		// TODO Auto-generated constructor stub
	}

	public Professor(String nome) {
		super(nome);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public int qtdePesquisadores() throws ProfessorNaoSupervisiona {
		throw new ProfessorNaoSupervisiona();
	}
	
	public double getPagamento() {
		return 200.00 + (0.3 * this.getCoordenador().getPagamento());
	}

}

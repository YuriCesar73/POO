package entities;

import entities.execption.ProfessorNaoSupervisiona;

public class Coordenador extends Pesquisador {

	private Pesquisador subordinados[];
	
	public Coordenador(String nome, Pesquisador coordenador) {
		super(nome, coordenador);
		this.subordinados = new Pesquisador [10];
	}

	public Coordenador(String nome) {
		super(nome);
		this.subordinados = new Pesquisador[10];
	}
	
	

	public Pesquisador[] getSubordinados() {
		return subordinados;
	}

	public void setSubordinados(Pesquisador[] subordinados) {
		this.subordinados = subordinados;
	}

	@Override
	public int qtdePesquisadores() throws ProfessorNaoSupervisiona {
		return subordinados.length;
	}
	
	public void addSubordinado(Pesquisador pesquisador, int pos) {
		subordinados[pos] = pesquisador;
	}
	
	public double getPagamento() {
		return 300.00 - (300.00 * 0.025 * subordinados.length);
	}

}

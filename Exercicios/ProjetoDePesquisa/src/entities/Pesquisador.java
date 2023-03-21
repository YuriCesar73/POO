package entities;

import entities.execption.ProfessorNaoSupervisiona;

public abstract class Pesquisador {

	private String nome;
	private Pesquisador coordenador;
	
	
	public Pesquisador(String nome, Pesquisador coordenador) {
		this.nome = nome;
		this.coordenador = coordenador;
	}
	
	public Pesquisador(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pesquisador getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(Pesquisador coordenador) {
		this.coordenador = coordenador;
	}
	
	public abstract int qtdePesquisadores() throws ProfessorNaoSupervisiona;
	
	public abstract double getPagamento();
}

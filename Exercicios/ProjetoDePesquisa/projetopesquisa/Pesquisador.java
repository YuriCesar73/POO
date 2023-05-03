package projetopesquisa;

import java.util.ArrayList;

import excecoes.ProfessorNaoTemSubordinadosException;

public abstract class Pesquisador {
	
	private String nome;
	private Pesquisador coordenador;
	private ArrayList<Pesquisador> subordinados;
	
	
	public Pesquisador(String nome, Pesquisador coordenador) {
		this.nome = nome;
		this.coordenador = coordenador;
		this.subordinados= new ArrayList<>();
	}
	
	public abstract void addSubordinado(Pesquisador pesquisador)throws ProfessorNaoTemSubordinadosException;

	public abstract double getValor();
	
	public abstract void listarSubordinados()throws ProfessorNaoTemSubordinadosException;
	
	public int getQtdSubordinados() {
		
		int qtdAtual= this.subordinados.size();
		for (Pesquisador pesquisador : subordinados) {
			qtdAtual+=pesquisador.getQtdSubordinados();
		}
		
		return qtdAtual;
	}
	
	public void listarSuperiores() {
		Pesquisador coordenadorAtual=this.getCoordenador();
		if(coordenadorAtual!=null) {
			System.out.println(coordenadorAtual.getNome());
			coordenadorAtual.listarSuperiores();
		}
	}
	
	public Pesquisador acharPesquisador(String nome) {
		
		if(this.nome.equalsIgnoreCase(nome)) {
			return this;
		}
		else {
			for(Pesquisador subordinado: subordinados) {
				Pesquisador colaborador = subordinado.acharPesquisador(nome);
				if(colaborador != null) {
					return colaborador;
				}
			}
		}
		return null;
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

	public ArrayList<Pesquisador> getSubordinados() {
		return subordinados;
	}
	
	
	
	

}

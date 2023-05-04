package negocio;

import java.util.ArrayList;
import java.util.List;

import exceptions.EmpregadoNaoTemSubordinadoException;


public abstract class Pessoa {
	private String nome;
	private Pessoa chefe;
	private List <Pessoa> subordinados;
	
	public List<Pessoa> getSubordinados() {
		return subordinados;
	}

	public Pessoa(String nome) {
		super();
		this.nome = nome;
		this.chefe = null;
		this.subordinados=new ArrayList <Pessoa> ();
	}

	public Pessoa(String nome, Pessoa chefe) {
		this.nome = nome;
		this.chefe = chefe;
		this.subordinados=new ArrayList <Pessoa> ();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pessoa getChefe() {
		return chefe;
	}

	public void setChefe(Pessoa chefe) {
		this.chefe = chefe;
	}
	
	public String listarSuperiores() {
		
		Pessoa chefeAtual = this.getChefe();
	    String subordinados = "";

	    if (chefeAtual != null) {
	        subordinados += chefeAtual.listarSuperiores(); // Concatena a hierarquia dos superiores
	        subordinados += chefeAtual.getNome() + " "; // Adiciona o nome do chefe atual
	    }

	    return subordinados;
		
	}
	
	public Pessoa acharPessoa(String nome) {
		
		if(this.nome.equalsIgnoreCase(nome)) {
			return this;
		}
		else {
			for(Pessoa pessoa: subordinados) {
				Pessoa colaborador = pessoa.acharPessoa(nome);
				if(colaborador != null) {
					return colaborador;
				}
			}
		}
		return null;
	}
	
	public abstract String listarSubordinados();
	
	public abstract void addSubordinado(Pessoa subordinado)throws EmpregadoNaoTemSubordinadoException; 		
			
	

}
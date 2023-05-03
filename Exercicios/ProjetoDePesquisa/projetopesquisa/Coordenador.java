package projetopesquisa;

import excecoes.ProfessorNaoTemSubordinadosException;

public class Coordenador extends Pesquisador {

	public Coordenador(String nome, Pesquisador coordenador) {
		super(nome, coordenador);
	}

	@Override
	public void addSubordinado(Pesquisador pesquisador) throws ProfessorNaoTemSubordinadosException {
		this.getSubordinados().add(pesquisador);
	}

	@Override
	public double getValor() {
		double valor=330 - (2.5/100*this.getQtdSubordinados()*330);
		if(valor<0)
			return 0;
		return valor;
	}

	@Override
	public void listarSubordinados() throws ProfessorNaoTemSubordinadosException {
		for (Pesquisador pesquisador:this.getSubordinados()) {
			System.out.println(pesquisador.getNome());
			pesquisador.listarSubordinados();
		}

	}

}

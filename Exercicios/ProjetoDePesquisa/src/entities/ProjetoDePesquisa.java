package entities;

public class ProjetoDePesquisa {

	private Coordenador pesquisadores[];
	private Coordenador coordenadorChefe;
	
	public ProjetoDePesquisa() {
		this.pesquisadores = new Coordenador [10];
		this.coordenadorChefe = new Coordenador ("Sra Mara Andrade");
	}
	
	/*public void inserirPesquisador(Pesquisador pesquisador, int pos) {
		this.pesquisadores[pos] = pesquisador;
	}*/
	
	
	public void inserirCoordenador(Coordenador coordenador, int pos) {
		pesquisadores[pos] = coordenador;
	}
	
	public Coordenador[] getPesquisadores() {
		return pesquisadores;
	}

	public void setPesquisadores(Coordenador[] pesquisadores) {
		this.pesquisadores = pesquisadores;
	}

	public Coordenador getCoordenadorChefe() {
		return coordenadorChefe;
	}

	public void setCoordenadorChefe(Coordenador coordenadorChefe) {
		this.coordenadorChefe = coordenadorChefe;
	}

	public void inserirProfessor(Professor professor, Coordenador coordenador ,int pos) {
		coordenador.addSubordinado(professor, pos);
	}
	
	public void getQtdPesquisadores(int pos) {
		System.out.println(pesquisadores[pos].getSubordinados());
		
	}
	
	public void getPagamentoProfessor(Professor professor, Coordenador coordenador, int pos) {
		System.out.println(coordenador.getSubordinados()[pos].getPagamento());
	}
	
	public void getPagamentoCoordenador(Coordenador coordenador) {
		coordenador.getPagamento();
	}
}

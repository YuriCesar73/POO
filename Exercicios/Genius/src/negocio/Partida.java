package negocio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import exceptions.SemJogadoresCadastradosException;

public class Partida {

	private int id; // Identificador de partida
	private int dificuldadeAtual; // Indice no array de dificuldade que identifica a dificuldade atual
	private boolean inverseMode; // Indica se o jogo está no modo Inverse
	private int limiteRestante; // Quantidade restante de jogadores que indica o fim da partida
	private List<Jogador> jogadoresCadastrados; // Todos os jogadores que foram cadastrados no início da partida
	private Date data; // Data em que a partida aconteceu
	private Scoreboard relatorio; // Relatório com todas as informações da partida
	
	public Partida(int id){
		this.id = id;
		this.jogadoresCadastrados = new ArrayList<Jogador>();
		this.data = new Date();
		this.dificuldadeAtual = 0;
		this.inverseMode = false;
		this.relatorio = null;
	}

	public void addJogadaEmJogador(int id){
		Random rand = new Random();
		Jogador jogador = this.jogadoresCadastrados.get(id);
		System.out.println(jogador.getNome());
		int jogada = rand.nextInt(4);
		System.out.println(""+jogada);
		jogador.addJogada(jogada);
	}
	

	public void setDificuldadeAtual(int dificuldadeAtual) {
		this.dificuldadeAtual = dificuldadeAtual;
	}
	
	public int getDificuldadeAtual() {
		return dificuldadeAtual;
	}

	public boolean isInverseMode() {
		return inverseMode;
	}

	public List<Jogador> getJogadoresCadastrados() {
		return jogadoresCadastrados;
	}
	
	public Scoreboard getRelatorio() {
		return relatorio;
	}

	public void addJogador(Jogador jogador) {
		this.jogadoresCadastrados.add(jogador);
	}
	
	public void removeJogador(Jogador jogador) {
		this.jogadoresCadastrados.remove(jogador);
	}
	

	public void iniciarPartida() throws SemJogadoresCadastradosException{
		List<Jogador> jogadoresDisputando = jogadoresCadastrados;
		
		int limiteRestante;
		int indiceJogadorAtual = 0;
		
		// Caso não haja jogadores cadastrados, lança exception para ser tratado no action
		if(jogadoresDisputando.size() == 0) {
			throw new SemJogadoresCadastradosException();
		}
		else if (jogadoresDisputando.size() == 1) {
			// Modo 1 jogador, jogo encerrará caso não haja jogadores restantes
			limiteRestante = 0;
		}
		else {
			// Modo multijogador, jogo encerrará caso sobre apenas 1 jogador
			limiteRestante = 1;
		}
		partidaAcontecendo(jogadoresDisputando, limiteRestante);
	}
	
	public Jogador acharJogador(String nome) {
		for (Jogador jogador : jogadoresCadastrados) {
			if(jogador.getNome().equalsIgnoreCase(nome)) {
				return jogador;
			}
		}
		return null;
	}
	
	public String getData() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(this.data);
	}
	
	public int getId() {
		return id;
	}
	
	public void gerarRelatorio(String dificuldade) {
		// Vai gerar o Score da partida
		relatorio = new Scoreboard(id, dificuldade);
		for (Jogador jogador : jogadoresCadastrados) {
			relatorio.getRegistros().add(new RegistroScore(jogador.getNome(), jogador.getPontos(), jogador.isGanhou()));
		}
	}
	
	private void partidaAcontecendo(List<Jogador> jogadoresDisputando, int limiteRestante) {
		boolean partidaAcontecendo = true;
		int indiceJogadorAtual = 0;
		
		// lógica da partida
		while(partidaAcontecendo) {
			if(jogadoresDisputando.size() == limiteRestante) {
				jogadoresDisputando.get(indiceJogadorAtual).ganharPartida();
				break;
			}
			
			jogadoresDisputando.get(indiceJogadorAtual).addJogada(indiceJogadorAtual);
		}
	}
	
	public boolean verificaJogada(int id, int label) {
		Jogador jogador = this.jogadoresCadastrados.get(id);
		ArrayList jogadas = (ArrayList) jogador.getJogadasAtuais();
		int ultimaJogada = (int) jogadas.get(jogadas.size() - 1);
		
		if(ultimaJogada == label) {
			//Jogador acertou a jogada. Segue o jogo
			System.out.println("Jogador acertou");
			return true;
		}
		else {
			//jogador errou a jogada. Sai da partida e verifica se ainda tem jogadores na partida.
			System.out.println("Jogador Errou");
			return true;
		}
		
	}
	
}
		
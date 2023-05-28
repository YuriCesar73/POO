package negocio;

public class RegistroScore {
	private String nomeJogador; // Nome do jogador desse registro
	private int pontos; // Quantos pontos o jogador fez
	private boolean ganhou; // Indica se o jogador venceu a partida registrada
	
	public RegistroScore(String nome, int pontos, boolean ganhou) {
		super();
		this.nomeJogador = nome;
		this.pontos = pontos;
		this.ganhou = ganhou;
	}

	public String getNomeJogador() {
		return nomeJogador;
	}

	public int getPontos() {
		return pontos;
	}

	public boolean isGanhou() {
		return ganhou;
	}
}

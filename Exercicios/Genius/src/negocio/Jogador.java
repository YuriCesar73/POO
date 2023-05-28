package negocio;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
	private String nome; // Identificador de jogador
	private int pontos; // Quantos pontos o jogador está fazendo na partida atual
	private List<Integer> jogadasAtuais; // Sequência de jogadas que o jogador precisa realizar
	private boolean ganhou; // Confirma vitória do jogador em uma partida
	
	public Jogador(String nome) {
		this.nome = nome;
		this.pontos = 0;
		this.jogadasAtuais = new ArrayList<Integer>();
		this.ganhou = false;
	}
	
	public String getNome() {
		return nome;
	}
	public int getPontos() {
		return pontos;
	}
	public List<Integer> getJogadasAtuais() {
		return jogadasAtuais;
	}
	
	public boolean isGanhou() {
		return ganhou;
	}
	
	public void addPonto() {
		pontos++;
	}
	
	public void addJogada(int jogada) {
		jogadasAtuais.add(jogada);
	}
	
	public void ganharPartida() {
		ganhou = true;
	}
}

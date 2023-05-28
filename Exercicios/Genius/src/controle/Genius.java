package controle;

import java.util.ArrayList;
import java.util.List;

import negocio.Jogador;
import negocio.Partida;
import negocio.RegistroScore;

public class Genius {
	private String dificuldades[] = {"Fácil", "Médio", "Difícil", "Pesadelo"}; // Array com dificuldades possíveis
	// velocidades
	private List<Partida> historico; // Histórico com todas as partidas jogadas
	private int idAutoIncrement; // Gerador de id de partida
	private Partida partidaAtual; // Partida que está acontecendo atualmente
	
	public Genius() {
		historico = new ArrayList<Partida>();
		idAutoIncrement = 0;
		partidaAtual = new Partida(idAutoIncrement);
	}
	
	public String[] getDificuldades() {
		return dificuldades;
	}
	
	public List<Partida> getHistorico() {
		return historico;
	}
	
	public Partida getPartidaAtual() {
		return partidaAtual;
	}

	private void addIdAutoIncrement() {
		idAutoIncrement++;
	}

	// Encontra uma partida dado um id
	public Partida encontrarPartidaId(int id) {
		for (Partida partida : historico) {
			if(partida.getId() == id) {
				return partida;
			}
		}
		return null;
	}
	
	// Retorna todas as partidas em que um determinado jogador participou
	public List<Partida> encontrarPartidas(Jogador jogador){
		List<Partida> partidasEncontradas = new ArrayList<Partida>();
		
		// Vai em cada registro de cada partida e adiciona a uma lista de partidas que será retornada
		for (Partida partida : historico) {
			for (RegistroScore registro : partida.getRelatorio().getRegistros()) {
				if(registro.getNomeJogador().equalsIgnoreCase(jogador.getNome())) {
					partidasEncontradas.add(partida);
					break;
				}
			}
		}
		return partidasEncontradas;
	}
	
	// Salva uma partida no historico e instancia uma nova partida
	public Partida novaPartida() {
		
		return partidaAtual;
		
		/*historico.add(partidaAtual);
		
		addIdAutoIncrement();
		partidaAtual = new Partida(idAutoIncrement);
		return partidaAtual;
		*/
	}
}

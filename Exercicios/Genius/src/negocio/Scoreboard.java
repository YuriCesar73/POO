package negocio;

import java.util.ArrayList;
import java.util.List;

public class Scoreboard {
	private int idPartida; // id da partida registrada
	private String dificuldade; // Dificuldade em que a partida foi jogada
	private List<RegistroScore> registros; // Registro de cada jogador na partida
	
	public Scoreboard(int idPartida, String dificuldade) {
		this.idPartida = idPartida;
		this.dificuldade = dificuldade;
		this.registros = new ArrayList<RegistroScore>();
	}

	public int getIdPartida() {
		return idPartida;
	}

	public String getDificuldade() {
		return dificuldade;
	}

	public List<RegistroScore> getRegistros() {
		return registros;
	}
}

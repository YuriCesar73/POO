package negocio;

import java.util.ArrayList;
import java.util.List;

public class BBB {
	
	private List<Participante> participantes;
	private List<Integer> votos;

	public BBB() {
		this.participantes = new ArrayList<>();
		this.votos = new ArrayList<>();
		this.votos.add(0);
	}

	public List<Participante> getParticipantes() {
		return participantes;
	}
	
	public void addParticipante(Participante participante) {
		this.participantes.add(participante);
		participante.setCod(gerarCodigoParticipante());
		this.votos.add(participante.getCod(), 0);
	}
	
	public void armazenarVotosPorCodigo(int codigo) {
		int qtdVotosAtual = this.votos.get(codigo);
		qtdVotosAtual++;
		this.votos.add(codigo, qtdVotosAtual);
	}
	
	public void armazenarVotosPorNome(String nome) {
		Participante participante = (Participante) participantes.stream().filter(s-> s.getNome().equalsIgnoreCase(nome));
		armazenarVotosPorCodigo(participante.getCod());
	}
	
	private int gerarCodigoParticipante() {
		int codigo = this.votos.size();
		return codigo;
	}
	
	public Participante buscarParticipanteCodigo(String codigo) {
		int cod = Integer.parseInt(codigo);
		Participante participante = (Participante) this.participantes.stream().filter(p -> p.getCod() == cod);
		return participante;
	}
	
	public Participante buscarParticipanteNome(String nome) {
		Participante participante = (Participante) this.participantes.stream().filter(p -> p.getNome().equalsIgnoreCase(nome));
		return participante;
	}
	
	
	
	
	
	

}

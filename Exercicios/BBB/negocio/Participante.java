package negocio;

public class Participante {

	private String nome;
	private int cod;
	
	public Participante(String nome) {
		this.nome = nome;
	}
	
	public Participante(String nome, int cod) {
		this.nome = nome;
		this.cod = cod;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	
	
	
}

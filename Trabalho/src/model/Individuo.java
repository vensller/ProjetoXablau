package model;

public class Individuo implements Desenhavel, Gravavel{

	private String nome;
	private Vertice localizacao;
	
	@Override
	public String getStringParaDocumento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void desenhar() {
		// TODO Auto-generated method stub
		
	}

	public Individuo(String nome, Vertice localizacao) {
		super();
		this.nome = nome;
		this.localizacao = localizacao;
	}

	@Override
	public String toString() {
		return "Individuo [nome=" + nome + ", localizacao=" + localizacao + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Vertice getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Vertice localizacao) {
		this.localizacao = localizacao;
	}
	
	

}

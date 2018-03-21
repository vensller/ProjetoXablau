package model;

public class Aresta implements Desenhavel, Gravavel{
	
	private String nome;
	private Vertice vertice01;
	private Vertice vertice02;
	private double comprimento;
	private double excenticidade;

	@Override
	public String getStringParaDocumento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void desenhar() {
		// TODO Auto-generated method stub
		
	}

	public Aresta(String nome, Vertice vertice01, Vertice vertice02, double comprimento) {
		super();
		this.nome = nome;
		this.vertice01 = vertice01;
		this.vertice02 = vertice02;
		this.comprimento = comprimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Vertice getVertice01() {
		return vertice01;
	}

	public void setVertice01(Vertice vertice01) {
		this.vertice01 = vertice01;
	}

	public Vertice getVertice02() {
		return vertice02;
	}

	public void setVertice02(Vertice vertice02) {
		this.vertice02 = vertice02;
	}

	public double getComprimento() {
		return comprimento;
	}

	public void setComprimento(double comprimento) {
		this.comprimento = comprimento;
	}

	public double getExcenticidade() {
		return excenticidade;
	}

	public void setExcenticidade(double excenticidade) {
		this.excenticidade = excenticidade;
	}

	@Override
	public String toString() {
		return "Aresta [nome=" + nome + ", vertice01=" + vertice01 + ", vertice02=" + vertice02 + ", comprimento="
				+ comprimento + ", excenticidade=" + excenticidade + "]";
	}

}

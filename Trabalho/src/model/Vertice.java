package model;

public class Vertice implements Desenhavel, Gravavel {
	
	private double nome;
	private double valorX;
	private double valorY;
	

	@Override
	public String getStringParaDocumento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void desenhar() {
		// TODO Auto-generated method stub
		
	}
	
	public Vertice(double nome, double valorX, double valorY) {
		super();
		this.nome = nome;
		this.valorX = valorX;
		this.valorY = valorY;
	}

	@Override
	public String toString() {
		return "Vertice [nome=" + nome + ", valorX=" + valorX + ", valorY=" + valorY + "]";
	}

	public double getNome() {
		return nome;
	}

	public void setNome(double nome) {
		this.nome = nome;
	}

	public double getValorX() {
		return valorX;
	}

	public void setValorX(double valorX) {
		this.valorX = valorX;
	}

	public double getValorY() {
		return valorY;
	}

	public void setValorY(double valorY) {
		this.valorY = valorY;
	}
	
}

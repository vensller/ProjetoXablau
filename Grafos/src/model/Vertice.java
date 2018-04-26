package model;

public class Vertice implements Desenhavel {
	
	private String nome;
	private double valorX;
	private double valorY;
	

	@Override
	public String getStringParaDocumento() {		
		return "v:" + this.nome + ","
                            + this.valorX + ","
                            + this.valorY + ";\n";
	}

	@Override
	public void desenhar(java.awt.Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
	public Vertice(String nome, double valorX, double valorY) {		
		this.nome = nome;
		this.valorX = valorX;
		this.valorY = valorY;
	}

	@Override
	public String toString() {
		return "Vertice [nome=" + nome + ", valorX=" + valorX + ", valorY=" + valorY + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
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

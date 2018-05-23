package model;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

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
            final int raio = 10;
            Graphics2D g2 = (Graphics2D) g;
            Ellipse2D.Double circle =  new Ellipse2D.Double(valorX-raio/2, valorY-raio/2, raio, raio);
            g2.setColor(Color.green);
            g2.fill(circle);
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

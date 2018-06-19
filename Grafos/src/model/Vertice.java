package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Vertice implements Desenhavel {
    
    private static final int RAIO = 10;

    private String nome;
    private double valorX;
    private double valorY;
    private boolean pontoEncontro;

    @Override
    public String getStringParaDocumento() {
        return "v:" + this.nome + ","
                + this.valorX + ","
                + this.valorY + ";\n";
    }

    @Override
    public void desenhar(java.awt.Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        String nome = this.nome;
        double x, y;
        x = valorX - RAIO/2;
        y = valorY - RAIO/2;
        
        Ellipse2D.Double circle = new Ellipse2D.Double(
            valorX - RAIO / 2, valorY - RAIO / 2, RAIO, RAIO);
        
        if (isPontoEncontro())
            g2.setColor(Color.ORANGE);
        else g2.setColor(Color.BLUE);
        
        g2.fill(circle);
    }

    public Vertice(String nome, double valorX, double valorY) {
        this.nome = nome;
        this.valorX = valorX;
        this.valorY = valorY;
        this.pontoEncontro = false;
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

    public boolean isPontoEncontro() {
        return pontoEncontro;
    }

    public void setPontoEncontro(boolean pontoEncontro) {
        this.pontoEncontro = pontoEncontro;
    }   

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vertice other = (Vertice) obj;
        if (Double.doubleToLongBits(this.valorX) != Double.doubleToLongBits(other.valorX)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorY) != Double.doubleToLongBits(other.valorY)) {
            return false;
        }
        return true;
    }

    @Override
    public void andar() {
    }

    @Override
    public boolean existemPontos() {
        return false;
    }

    
}

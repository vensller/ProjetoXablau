package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Individuo implements Desenhavel {

    private String nome;
    private Vertice localizacao;
    private ListaCaminho caminho;
    
    private double proximoX;
    private double proximoY;

    @Override
    public String getStringParaDocumento() {
        return "i:" + this.localizacao.getNome() + ", " + nome + ";\n";
    }

    @Override
    public void desenhar(java.awt.Graphics g) {
        final int raio = 10;
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D.Double circle =  new Ellipse2D.Double(proximoX-raio/2, proximoY-raio/2, raio, raio);
        g2.setColor(Color.red);
        g2.fill(circle);
    }

    public Individuo(Vertice localizacao, String nome) {        
        this.nome = nome;
        this.localizacao = localizacao;
        this.caminho = null;
        proximoX = localizacao.getValorX();
        proximoY = localizacao.getValorY();
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

    public ListaCaminho getCaminho() {
        return caminho;
    }

    public void setCaminho(ListaCaminho caminho) {
        this.caminho = caminho;
    }    

}

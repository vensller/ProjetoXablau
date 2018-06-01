package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.List;

public class Individuo implements Desenhavel {
    
    private final static int RAIO = 10;
    
    private String nome;
    private Vertice localizacao;
    private ListaCaminho caminho;
    
    private int verticeAtual = 0;
    private List<Vertice> listaVerticesCaminho;

    @Override
    public String getStringParaDocumento() {
        return "i:" + this.localizacao.getNome() + ", " + nome + ";\n";
    }

    @Override
    public void desenhar(java.awt.Graphics g) {
        Vertice pontoAtual = listaVerticesCaminho.get( verticeAtual );
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D.Double circle = new Ellipse2D.Double(
           pontoAtual.getValorX()-RAIO/2, pontoAtual.getValorY()-RAIO/2, RAIO, RAIO);
        g2.setColor(Color.red);
        g2.fill(circle);
    }

    public Individuo(Vertice localizacao, String nome) {        
        this.nome = nome;
        this.localizacao = localizacao;
        this.caminho = null;
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
        calcularCaminho();
    }    

    private void calcularCaminho() {
        listaVerticesCaminho = caminho.calcularCaminho();
    }
    
    @Override
    public boolean existemPontos(){
        return verticeAtual < listaVerticesCaminho.size()-1;
    }

    @Override
    public void andar() {
        if( verticeAtual < listaVerticesCaminho.size()-1 ){
            verticeAtual++;
        }
    }
}

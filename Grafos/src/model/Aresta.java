package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.QuadCurve2D;
import java.util.ArrayList;
import java.util.List;
import utilitarios.CalculosCurva;

public class Aresta implements Desenhavel {

    private String nome;
    private Vertice origem;
    private Vertice destino;
    private double comprimento;
    private double excentricidade;
    private boolean bidirecional;
    private List<Vertice> pontos;
    private List<Vertice> pontosInvertidos;
    
    private final double RAIO = 3;

    @Override
    public String getStringParaDocumento() {
        return "a:" + this.origem.getNome() + ","
                + this.destino.getNome() + ","
                + this.comprimento + ","
                + this.bidirecional + ","
                + this.nome + ";\n";
    }

    @Override
    public void desenhar(java.awt.Graphics g) {        
        Graphics2D g2 = (Graphics2D) g;
        QuadCurve2D q = new QuadCurve2D.Float();
        
//        String nome = this.nome;
//        double origemX, origemY, maximoX, maximoY, destinoX, destinoY;
//        origemX = origem.getValorX();
//        origemY = origem.getValorY();
//        maximoX = cc.getValorXmaximo();
//        maximoY = cc.getValorYMaximo();
//        destinoX = destino.getValorX();
//        destinoY = destino.getValorY();          
        
        for( int i = 0; i < pontos.size(); i ++){
            Ellipse2D.Double circle = new Ellipse2D.Double(
            pontos.get(i).getValorX()-RAIO/2, pontos.get(i).getValorY()-RAIO/2, RAIO, RAIO);
            g2.setColor(Color.GRAY);            
            g2.fill(circle);
        }
        
//        q.setCurve(
//            origem.getValorX(), origem.getValorY(),
//            cc.getValorXmaximo(), cc.getValorYMaximo(),
//            destino.getValorX(), destino.getValorY()
//        );
        
        g2.draw(q);
//        origem.desenhar(g.create());
//        destino.desenhar(g.create());
    }

    public Aresta(Vertice vertice01, Vertice vertice02, double comprimento, boolean bidirecional, String nome) {
        if( possuiComprimentoPossivel( vertice01, vertice02, comprimento ) > comprimento ){
            comprimento = possuiComprimentoPossivel( vertice01, vertice02, comprimento );
            System.err.println("Valor para comprimento da aresta {" + (nome.isEmpty()?"null":nome) + 
                "} com origem {" + (vertice01.getNome().isEmpty()?"null":vertice01.getNome()) + 
                "} e destino {" + (vertice02.getNome().isEmpty()?"null":vertice02.getNome()) +
                "} passado como argumento em arquivo é menor que a distância em linha reta," + 
                "Assim sera considerado como comprimento o valor entre a origem e o destino");
        }
        
        this.origem = vertice01;
        this.destino = vertice02;
        this.comprimento = comprimento;
        this.bidirecional = bidirecional;
        this.nome = nome;
        CalculosCurva cc = new CalculosCurva(this);
        pontos = cc.getPontos();
        calcularPontosInvertidos();
    }
    
    public void calcularPontosInvertidos(){
        pontosInvertidos = new ArrayList<>();
        for (int i = pontos.size() - 1; i >= 0; i--){
            pontosInvertidos.add(pontos.get(i));
        }
        
        if (pontosInvertidos.size() > 0){
            boolean invertido = false;
            if ((pontosInvertidos.get(0).getValorX() == origem.getValorX()) && (pontosInvertidos.get(0).getValorY() == origem.getValorY()))
                invertido = true;

            if ((pontosInvertidos.get(0).getValorX() - origem.getValorX() < 1) && (pontosInvertidos.get(0).getValorX() - origem.getValorX() > - 1)){              
                if ((pontosInvertidos.get(0).getValorY() - origem.getValorY() < 1) && (pontosInvertidos.get(0).getValorY() - origem.getValorY() > - 1))
                    invertido = true;
            }
            
            if ((pontosInvertidos.get(0).getValorY() - origem.getValorY() < 1) && (pontosInvertidos.get(0).getValorY() - origem.getValorY() > - 1)){
                if ((pontosInvertidos.get(0).getValorX() - origem.getValorX() < 1) && (pontosInvertidos.get(0).getValorX() - origem.getValorX() > - 1))
                    invertido = true;
            }
            
            if (invertido){
                List<Vertice> controle = pontos;
                pontos = pontosInvertidos;
                pontosInvertidos = controle;
            }
              
        }        
    }

    public Vertice getOrigem() {
        return origem;
    }

    public void setOrigem(Vertice origem) {
        this.origem = origem;
    }

    public Vertice getDestino() {
        return destino;
    }

    public void setDestino(Vertice destino) {
        this.destino = destino;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public double getExcentricidade() {
        return excentricidade;
    }

    public void setExcentricidade(double excentricidade) {
        this.excentricidade = excentricidade;
    }

    public boolean isBidirecional() {
        return bidirecional;
    }

    public void setBidirecional(boolean bidirecional) {
        this.bidirecional = bidirecional;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Aresta [origem=" + origem + ", destino=" + destino + ", comprimento="
                + comprimento + ", excenticidade=" + excentricidade + "]";
    }

    @Override
    public void andar() {
    }

    @Override
    public boolean existemPontos() {
        return false;
    }

    private double possuiComprimentoPossivel(Vertice vertice01, Vertice vertice02, double comprimento) {
        double xA = vertice01.getValorX();
        double yA = vertice01.getValorY();
        double xB = vertice02.getValorX();
        double yB = vertice02.getValorY();
        return ( Math.sqrt( Math.pow(xA - xB, 2) + Math.pow(yA - yB, 2) ) );
    }

    public List<Vertice> getPontos() {
        return pontos;
    }

    public void setPontos(List<Vertice> pontos) {
        this.pontos = pontos;
    }

    public List<Vertice> getPontosInvertidos() {
        return pontosInvertidos;
    }

    public void setPontosInvertidos(List<Vertice> pontosInvertidos) {
        this.pontosInvertidos = pontosInvertidos;
    }
    
}

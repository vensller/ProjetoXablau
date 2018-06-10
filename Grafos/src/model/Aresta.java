package model;

import java.awt.Graphics2D;
import java.awt.geom.QuadCurve2D;
import utilitarios.CalculosCurva;

public class Aresta implements Desenhavel {

    private String nome;
    private Vertice origem;
    private Vertice destino;
    private double comprimento;
    private double excentricidade;
    private boolean bidirecional;

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
        CalculosCurva cc = new CalculosCurva( this );
        Graphics2D g2 = (Graphics2D) g;
        QuadCurve2D q = new QuadCurve2D.Float();
        
        String nome = this.nome;
        double origemX, origemY, maximoX, maximoY, destinoX, destinoY;
        origemX = origem.getValorX();
        origemY = origem.getValorY();
        maximoX = cc.getValorXmaximo();
        maximoY = cc.getValorYMaximo();
        destinoX = destino.getValorX();
        destinoY = destino.getValorY();
        
        q.setCurve(
            origem.getValorX(), origem.getValorY(),
            cc.getValorXmaximo(), cc.getValorYMaximo(),
            destino.getValorX(), destino.getValorY()
        );
        g2.draw(q);
//        origem.desenhar(g.create());
//        destino.desenhar(g.create());
    }

    public Aresta(Vertice vertice01, Vertice vertice02, double comprimento, boolean bidirecional, String nome) {
        if( possuiComprimentoPossivel( vertice01, vertice02, comprimento ) ){
//            throw new RuntimeException("Comprimento para a aresta <" 
//                + (!nome.equals("")?nome:"nomeNulo") + "> é menor que a distância em l"
//                + "inha reta dos pontos de origem e destino");
        }
        
        this.origem = vertice01;
        this.destino = vertice02;
        this.comprimento = comprimento;
        this.bidirecional = bidirecional;
        this.nome = nome;
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

    private boolean possuiComprimentoPossivel(Vertice vertice01, Vertice vertice02, double comprimento) {
        double xA = vertice01.getValorX();
        double yA = vertice01.getValorY();
        double xB = vertice02.getValorX();
        double yB = vertice02.getValorY();
        return comprimento < ( Math.sqrt( Math.pow(xA - xB, 2) + Math.pow(yA - yB, 2) ) );
    }

}

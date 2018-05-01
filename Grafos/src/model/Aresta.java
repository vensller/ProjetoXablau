package model;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

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
        Graphics2D G2D = (Graphics2D) g;
//        G2D.setStroke(new BasicStroke(3.0f));
        Point2D P2D = new Point2D.Double(origem.getValorX(), origem.getValorY());
        Point2D P2D2 = new Point2D.Double(destino.getValorX(), destino.getValorY());
        Line2D L2D = new Line2D.Float(P2D, P2D2);
        G2D.draw(L2D);
//        g.drawLine(vertice01.getValorX(), vertice01.getValorY(), vertice02.getValorX(), vertice02.getValorY());

    }

    public Aresta(Vertice vertice01, Vertice vertice02, double comprimento, boolean bidirecional, String nome) {
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

    @Override
    public String toString() {
        return "Aresta [origem=" + origem + ", destino=" + destino + ", comprimento="
                + comprimento + ", excenticidade=" + excentricidade + "]";
    }

}

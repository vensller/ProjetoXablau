package model;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class Aresta implements Desenhavel {

    private String nome;
    private Vertice vertice01;
    private Vertice vertice02;
    private double comprimento;
    private double excentricidade;
    private boolean bidirecional;

    @Override
    public String getStringParaDocumento() {
        return "a:" + this.vertice01.getNome() + ","
                + this.vertice02.getNome() + ","
                + this.comprimento + ","
                + this.bidirecional + ","
                + this.nome + ";\n";
    }

    @Override
    public void desenhar(java.awt.Graphics g) {
        Graphics2D G2D = (Graphics2D) g;
//        G2D.setStroke(new BasicStroke(3.0f));
        Point2D P2D = new Point2D.Double(vertice01.getValorX(), vertice01.getValorY());
        Point2D P2D2 = new Point2D.Double(vertice02.getValorX(), vertice02.getValorY());
        Line2D L2D = new Line2D.Float(P2D, P2D2);
        G2D.draw(L2D);
//        g.drawLine(vertice01.getValorX(), vertice01.getValorY(), vertice02.getValorX(), vertice02.getValorY());

    }

    public Aresta(Vertice vertice01, Vertice vertice02, double comprimento, boolean bidirecional, String nome) {
        this.vertice01 = vertice01;
        this.vertice02 = vertice02;
        this.comprimento = comprimento;
        this.bidirecional = bidirecional;
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
        return "Aresta [vertice01=" + vertice01 + ", vertice02=" + vertice02 + ", comprimento="
                + comprimento + ", excenticidade=" + excentricidade + "]";
    }

}

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
        q.setCurve(
            origem.getValorX(), origem.getValorY(),
            cc.getValorXmaximo(), cc.getValorYMaximo(),
            destino.getValorX(), destino.getValorY()
        );
        g2.draw(q);
        origem.desenhar(g.create());
        destino.desenhar(g.create());
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

    @Override
    public void andar() {
    }

    @Override
    public boolean existemPontos() {
        return true;
    }

}

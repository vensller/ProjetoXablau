package model;

public class Aresta implements Desenhavel{
	
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
    public void desenhar() {
            // TODO Auto-generated method stub

    }

    public Aresta(Vertice vertice01, Vertice vertice02, double comprimento, boolean bidirecional, String nome) {
            super();
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

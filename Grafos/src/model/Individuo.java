package model;

public class Individuo implements Desenhavel {

    private String nome;
    private Vertice localizacao;
    private ListaCaminho caminho;

    @Override
    public String getStringParaDocumento() {
        return "i:" + this.localizacao.getNome() + ", " + nome + ";\n";
    }

    @Override
    public void desenhar() {
        // TODO Auto-generated method stub

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
    }    

}

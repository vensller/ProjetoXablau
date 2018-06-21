package model;

/**
 *
 * @author Ivens
 */
public class No {
    
    private Aresta aresta;
    private No proximo;
    private boolean invertido;

    public No(Aresta aresta, No proximo, boolean invertido) {
        this.aresta = aresta;
        this.proximo = proximo;
        this.invertido = invertido;
    }

    public No(){
        this.aresta = null;
        this.proximo = null;
    }

    public Aresta getAresta() {
        return aresta;
    }

    public void setAresta(Aresta aresta) {
        this.aresta = aresta;
    }       

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public boolean isInvertido() {
        return invertido;
    }

    public void setInvertido(boolean invertido) {
        this.invertido = invertido;
    }
   
}

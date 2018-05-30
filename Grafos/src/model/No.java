package model;

/**
 *
 * @author Ivens
 */
public class No {
    
    private Aresta aresta;
    private No proximo;

    public No(Aresta aresta, No proximo) {
        this.aresta = aresta;
        this.proximo = proximo;
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
   
}

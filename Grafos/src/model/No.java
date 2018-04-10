package model;

/**
 *
 * @author Ivens
 */
public class No {
    
    private Vertice vertice;
    private No proximo;

    public No(Vertice vertice, No proximo) {
        this.vertice = vertice;
        this.proximo = proximo;
    }

   public No(){
       this.vertice = null;
       this.proximo = null;
   }
    
    public Vertice getVertice() {
        return vertice;
    }

    public void setVertice(Vertice vertice) {
        this.vertice = vertice;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
   
}

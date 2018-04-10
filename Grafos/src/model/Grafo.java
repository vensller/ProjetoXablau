package model;

/**
 *
 * @author Ivens
 */
public class Grafo {
    private Double vertices[][];
    
    public Grafo(int numVertices){
        vertices = new Double[numVertices][numVertices];
    }
    
    public void adicionaVerticesGrafo(int vertice1, int vertice2, Double peso){
        vertices[vertice1][vertice2] = peso;
        vertices[vertice2][vertice1] = peso;
    }
    
    public void removerVerticesGrafo(int vertice1, int vertice2){
        vertices[vertice1][vertice2] = 0.0;
        vertices[vertice1][vertice2] = 0.0;
    }
    
    public Double getCusto(int vertice1, int vertice2){
        return vertices[vertice1][vertice2];
    }

    public Double[][] getVertices() {
        return vertices;
    }

    public void setVertices(Double[][] vertices) {
        this.vertices = vertices;
    }
    
    
   
}

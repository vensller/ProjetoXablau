package controller;

import java.util.List;
import model.Individuo;
import model.Mapa;
import model.Vertice;
import utilitarios.Dijkstra;
import utilitarios.FloydWarshall;

public class OperadorGrafo {

    private Mapa mapa;
    private Vertice pontoEncontro;

    public OperadorGrafo(Mapa m) {
        this.mapa = m;
        this.pontoEncontro = null;
    }

    public void definirPontoEncontro(){
        FloydWarshall floyd = new FloydWarshall(mapa);
        pontoEncontro = floyd.calcularSolucao();        
    }
    
    public void definirCaminhosIndividuosDestino(Vertice destino){
        List<Individuo> individuos = mapa.getIndividuos();        
        if (!individuos.isEmpty()){
            Dijkstra dijkstra = new Dijkstra(mapa);
            for (Individuo i : individuos){
                i.setCaminho(dijkstra.retornaMenorCaminho(i.getLocalizacao(), destino));
            }
        }
    }
    
    public Vertice getPontoEncontro(){
        return this.pontoEncontro;
    }
    
}
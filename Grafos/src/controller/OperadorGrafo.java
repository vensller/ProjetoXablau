package controller;

import java.util.List;
import model.Individuo;
import model.Mapa;
import model.Vertice;
import utilitarios.Dijkstra;
import utilitarios.FloydWarshall;

public class OperadorGrafo {

    private Mapa mapa;

    public OperadorGrafo(Mapa m) {
        this.mapa = m;
    }

    public Vertice definirPontoEncontro(){
        FloydWarshall floyd = new FloydWarshall(mapa);
        return floyd.calcularSolucao();        
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
    
}
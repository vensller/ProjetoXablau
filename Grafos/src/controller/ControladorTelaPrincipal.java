/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author douglas
 */
public class ControladorTelaPrincipal implements ObservadoTelaPrincipal{

    private List<ObservadorTelaPrincipal> observadores = new ArrayList<>();
    
    @Override
    public void addObservador(ObservadorTelaPrincipal obs) {
        observadores.add(obs);
    }

    @Override
    public void removeObservador(ObservadorTelaPrincipal obs) {
        observadores.add(obs);
    }

    //contrução de um novo mapa
    public void novoMapa() {     
        
    }
    
}

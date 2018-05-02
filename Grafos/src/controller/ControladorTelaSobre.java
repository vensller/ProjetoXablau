/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;

/**
 *
 * @author douglas
 */
public class ControladorTelaSobre implements ObservadoTelaSobre{

    List<ObservadorTelaSobre> observadores = new ArrayList<>();

    @Override
    public void addObservador(ObservadorTelaSobre obs) {
        observadores.add(obs);
    }

    @Override
    public void removeObservador(ObservadorTelaSobre obs) {
        observadores.add(obs);
    }
    
    public JInternalFrame getInternalFrame(){
        return observadores.get(0).getInternalFrame();
    }
    
}

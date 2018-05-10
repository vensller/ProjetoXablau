package utilitarios;

import model.Aresta;

public class CalculosCurva {
    
    private double a;
    private double b;
    private double teta;
    
    private double xA;
    private double xB;
    private double yA;
    private double yB;
    
    //Nosso comprimento da curva.
    private double d;
    
    private CalculosCurva( Aresta aresta ){
        xA = aresta.getOrigem().getValorX();
        xB = aresta.getDestino().getValorX();
        yA = aresta.getOrigem().getValorY();
        yB = aresta.getDestino().getValorY();
        d  = aresta.getComprimento();
        
        calcularValorA();
        calcularValorB();
        calcularTeta();
    }
    
    private void calcularValorA(){
        double aux = 
            Math.pow(( xA + xB ) / 2 - xA, 2) +
            Math.pow(( yA + yB ) / 2 - yA, 2);
        a = Math.sqrt( aux );
    }
    
    private void calcularValorB(){
        b = Math.sqrt( ( 2*d*d )/( Math.PI * Math.PI ) - a*a );
    }
    
    private void calcularTeta(){
        double var = ( yB - yA )/( xB - xA );
        teta = Math.atan( Math.toRadians( var ) );
    }
    
//    private double[] calcularPonto( double x ){
//        double coordenadas[] = new double[ 2 ];
//        
//        coordenadas[ 0 ] = x*Math.cos( Math.toRadians( teta )) + xA +
//             b*Math.sin( Math.toRadians( x / a)) * -1 * Math.sin( teta );
//        
//        coordenadas[ 1 ] = x*Math.sin( Math.toRadians( teta ) ) + yA +
//            b*Math.sin( Math.toRadians( x / a ) ) * Math.cos( Math.toRadians( teta ) );
//        
//        return coordenadas;
//    }
}

package utilitarios;

import model.Aresta;

public class CalculosCurva {
    
    private static int CONTADOR = 1;
    
    private double a;
    private double b;
    private double teta;
    
    private double xA;
    private double xB;
    private double yA;
    private double yB;
    private double xO;
    private double yO;
    
    private double xP;
    private double yP;
    
    //Nosso comprimento da curva.
    private double d;
    
    public CalculosCurva( Aresta aresta ){
        xA = aresta.getOrigem().getValorX();
        xB = aresta.getDestino().getValorX();
        yA = aresta.getOrigem().getValorY();
        yB = aresta.getDestino().getValorY();
        d  = aresta.getComprimento();
        
        calcularValorA();
        calcularValorB();
        calcularOrigem();
        calcularTeta();
        calcularPontoMaximo();
        
        CONTADOR++;
    }
    
    private void calcularValorA(){
        double aux = 
            Math.pow(( xA + xB ) / 2 - xA, 2) +
            Math.pow(( yA + yB ) / 2 - yA, 2);
        a = Math.sqrt( aux );
        System.out.println( CONTADOR + "-a: " + a);
    }
    
    private void calcularValorB(){
        b = Math.sqrt( ( 2*d*d )/( Math.PI * Math.PI ) - a*a );
        System.out.println(CONTADOR + "-b: " + b);
    }
    
    private void calcularOrigem(){
        xO = ( xA - xB)/2;
        yO = ( yA - yB)/2;
        System.out.println(CONTADOR + "-xO: " + xO);
        System.out.println(CONTADOR + "-yO: " + yO);
    }
    
    private void calcularTeta(){
        double var = ( yB - yA )/( xB - xA );
        teta = Math.atan( Math.toRadians( var ) );
        System.out.println(CONTADOR + "-teta: " + teta);
    }
    
    private void calcularPontoMaximo(){
        double coordenadas[] = new double[ 2 ];
        
        double x = xO;
        double y = Math.sqrt( b*b*(1- (xO*xO)/(a*a) ) );
//        double y = b*Math.sin( Math.toRadians( x/(2*a) ) );
        double sen  = Math.sin( Math.toRadians( teta ) );
        double cos  = Math.cos( Math.toRadians( teta ) );
        
        xP = x*cos - y*sen + xA;
        yP = x*sen + y*cos + yA;
        
        System.out.println( CONTADOR + "-xP: " + xP);
        System.out.println( CONTADOR + "-yP: " + yP);
    }
    
    public double getValorXmaximo(){
        return xP;
    }
    
    public double getValorYMaximo(){
        return yP;
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

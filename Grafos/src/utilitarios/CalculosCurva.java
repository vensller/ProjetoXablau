package utilitarios;

import java.util.ArrayList;
import java.util.List;
import model.Aresta;
import model.Vertice;

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
    
    private double[] calcular(int xValor){
        double[] valores = new double[2];
        
        double x = xValor;
        double y = Math.sqrt( b*b*(1- (x*x)/(a*a) ) );
        double sen  = Math.sin( Math.toRadians( teta ) );
        double cos  = Math.cos( Math.toRadians( teta ) );
        
        valores[0] = x;
        valores[1] = y;
//        valores[0] = x*cos - y*sen + xA;
//        valores[1] = x*sen + y*cos + yA;
        return valores;
    }
    
    public double getValorXmaximo(){
        return xP;
    }
    
    public double getValorYMaximo(){
        return yP;
    }
    
    public List<Vertice> getPontos(){
        double fim = 2*a;
        double[] valores;
        List<Vertice> listaPontos = new ArrayList<>();
        for( int i = 0; i < ( (int) fim); i++ ){
            valores = calcular( i );
            listaPontos.add(new Vertice("", valores[0],valores[1]) );
        }
        return listaPontos;
        
    }
}

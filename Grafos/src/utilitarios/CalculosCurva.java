package utilitarios;

import java.util.ArrayList;
import java.util.List;
import model.Aresta;
import model.Vertice;

public class CalculosCurva {

    private final String nome;

    private double a;
    private double b;

    private double teta;
    private double sen;
    private double cos;

    private final double xA;
    private final double xB;
    private final double yA;
    private final double yB;
    private double xO;
    private double yO;

    private double xP;
    private double yP;

    //Nosso comprimento da curva.
    private final double d;

    public CalculosCurva(Aresta aresta) {
        nome = aresta.getNome();
        xA = aresta.getOrigem().getValorX();
        xB = aresta.getDestino().getValorX();
        yA = aresta.getOrigem().getValorY();
        yB = aresta.getDestino().getValorY();
        d = aresta.getComprimento();

        calcularOrigem();
        calcularValorA();
        calcularValorB();
        calcularTeta();
        calcularPontoMaximo();

    }

    private void calcularValorA() {
        double aux
                = Math.pow(xB - xA, 2)
                + Math.pow(yB - yA, 2);
        a = Math.sqrt(aux) / 2;
//        System.out.println( "a: " + a);
    }

    private void calcularValorB() {
        double aux = (2 * d * d) / (Math.PI * Math.PI) - a * a;
        if (aux < 0) {
            b = 0;
        } else {
            b = Math.sqrt(aux);
        }
//        b = Math.sqrt( ( 2*d*d )/( Math.PI * Math.PI ) - a*a );
//        System.out.println("b: " + b);
    }

    private void calcularOrigem() {
        xO = (xA + xB) / 2;
        yO = (yA + yB) / 2;
//        System.out.println("xO: " + xO);
//        System.out.println("yO: " + yO);
    }

    private void calcularTeta() {
        if( xA == xB ){
            teta = 90;
        }else{
            double var = (yB - yA) / (xB - xA);
            teta = Math.toDegrees( Math.atan(var) );
        }
//        if( xA < xB && yA == yB ){
//            teta = 0;
//        }else if( xA == xB && yA > yB ){
//            teta = 90;
//        }else if( xA > xB && yA == yB ){
//            teta = 180;
//        }else if( xA == xB && yA < yB ){
//            teta = 270;
//        }else{
//            
//
//        }

        sen = Math.sin(Math.toRadians(teta));
        cos = Math.cos(Math.toRadians(teta));
//        System.out.println("teta: " + teta);
    }

    private void calcularPontoMaximo() {
        double x = xO - xA;
//        double y = Math.sqrt(b * b * (1 - (x * x) / (a * a)));
        double y = b*Math.sin( Math.toRadians( x/(2*a) ) );

        x = x * cos - y * sen + xA;
        y = x * sen + y * cos + yA;
        xP = x;
        yP = y;

//        System.out.println( "xP: " + xP);
//        System.out.println( "yP: " + yP);
    }

    public double getValorXmaximo() {
        return xP;
    }

    public double getValorYMaximo() {
        return yP;
    }

//    public List<Vertice> getPontos(){
//        double x, y;
//        double ys[] = new double[ (int) a/2 ];
//        Vertice vAux;
//       
//        for( int i = 1; i <= ( (int) a/2 ); i++){
//            ys[ i ] = Math.sqrt( b*b*(1- (i*i)/(a*a) ) ); 
//        }
//        
//        List<Vertice> listaVertices = new ArrayList<>();
//        for( int i = 0; i < ys.length; i++ ){
//            listaVertices.add( new Vertice("", i, ys[i] ) );
//        }
//        for( int i = 0; i < ys.length; i++){
//            listaVertices.add( new Vertice("", i+a, ys[(int) a-i] ) );
//        }
//        
//        for( int i = 0; i < listaVertices.size(); i++ ){
//            vAux = listaVertices.get(i);
//            x = vAux.getValorX();
//            y = vAux.getValorY();
//            vAux.setValorX( x*cos + y*sen+ xA );
//            vAux.setValorY( -1*x*sen + y*cos + yA );
//        }
//        return listaVertices;
//    }
    public List<Vertice> getPontos() {
        double[] valores;
        List<Vertice> listaPontos = new ArrayList<>();

        for (int i = 1; i <= ((int) 2 * a); i++) {
            valores = calcular(i);
            listaPontos.add(new Vertice("", valores[0], valores[1]));
        }
        valores = calcular(2 * a);
        listaPontos.add(new Vertice("", valores[0], valores[1]));

        return listaPontos;

    }

    private double[] calcular(double xValor) {
        double[] valores = new double[2];

        double x = xValor;
        double y = b * Math.sin(Math.toRadians(x / (2* a)));
//        double y = Math.sqrt( b*b*(1- (x*x)/(a*a) ) );

        valores[0] = x * cos - y * sen + xA;
        valores[1] = x * sen + y * cos + yA;
        return valores;
    }
}

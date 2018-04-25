import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Fractal extends JFrame{
    
    private static final int WIDTH = 400;
    private static final int HEIGHT = 480;
    private static final int MIN_LEVEL = 0;
    private static final int MAX_LEVEL = 16;
    
    public Fractal(){
        super("FRACTAL");
        
        final JLabel labelNivel = new JLabel("LEVEL: 0");
        
        final FractalJPanel desenharEspaco = new FractalJPanel( 0 );
        
        final JPanel painelControle = new JPanel();
        painelControle.setLayout( new FlowLayout() );
        
        final JButton botaoMudarCor = new JButton("Cor");
        painelControle.add( botaoMudarCor );
        botaoMudarCor.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    Color cor = JColorChooser.showDialog( 
                            Fractal.this, "Mudar de cor", Color.BLUE);

                    if( cor == null ){
                        cor = Color.BLUE;
                    }

                    desenharEspaco.setColor( cor );
                }
            }
        );
        
        final JButton botaoDiminuirNivel = new JButton("Diminuir nível");
        painelControle.add( botaoDiminuirNivel );
        botaoDiminuirNivel.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    int nivel = desenharEspaco.getLevel();
                    nivel--;

                    if( nivel >= MIN_LEVEL && nivel <= MAX_LEVEL ){
                        labelNivel.setText( "Nivel: " + nivel );
                        desenharEspaco.setNivel( nivel );
                        repaint();
                    }else{
                        JOptionPane.showMessageDialog(null, "Chega !!");
                    }
                }
            }
        );
        
        final JButton botaoAumentarNivel = new JButton("Aumentar Nível");
        painelControle.add( botaoAumentarNivel );
        botaoAumentarNivel.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    int nivel = desenharEspaco.getLevel();
                    nivel++;
                    
                    if( nivel >= MIN_LEVEL && nivel <= MAX_LEVEL ){
                        labelNivel.setText( "Level: " + nivel);
                        desenharEspaco.setNivel( nivel );
                        repaint();
                    }else{
                        JOptionPane.showMessageDialog(null, "Chega !!");
                    }
                }
            }
        );
        
        painelControle.add( labelNivel );
        
        final JPanel painelPrinciapl = new JPanel();
        painelPrinciapl.add( painelControle );
        painelControle.add( desenharEspaco );
        
        add( painelPrinciapl );
        
        setSize(WIDTH, HEIGHT);
        setVisible( true );
    }
    
    public static void main(String[] args) {
        Fractal f = new Fractal();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
        
    }
}

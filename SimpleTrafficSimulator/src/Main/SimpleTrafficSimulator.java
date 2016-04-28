package Main;

import UI.GeneraMapa;
import java.awt.Color;
import javax.swing.JFrame;

@SuppressWarnings({ })
public class SimpleTrafficSimulator {

    public static void main (String args[]){
        JFrame jf = new JFrame("Mapa");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GeneraMapa mapa = new GeneraMapa();
        mapa.setBackground(Color.WHITE);
        jf.add(mapa);
        jf.setSize(400, 220);
        jf.setVisible(true);
        
    }
    
}

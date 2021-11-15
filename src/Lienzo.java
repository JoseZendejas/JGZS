
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author josen
 */
public class Lienzo extends JPanel implements MouseListener{
    
    private Vector<Nodo> vectorNodo;
    public Lienzo(){
        this.vectorNodo= new Vector<>();
        this.addMouseListener(this);
    }
    @Override
    public void paint(Graphics g){
        for (Nodo nodos : vectorNodo){
            nodos.pintar(g);
        }
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton()==MouseEvent.BUTTON1){
        this.vectorNodo.add(new Nodo(e.getX(), e.getY()));
        repaint();
    }
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
}

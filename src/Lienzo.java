
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
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
    private Vector<Enlace> vectorEnlaces;
    private Point p1,p2;
    public Lienzo(){
        this.vectorNodo= new Vector<>();
        this.vectorEnlaces= new Vector<>();
        this.addMouseListener(this);
    }
    @Override
    public void paint(Graphics g){
        for (Nodo nodos : vectorNodo){
            nodos.pintar(g);
        }
        for (Enlace enlace: vectorEnlaces){
            enlace.pintar(g);
        }
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton()==MouseEvent.BUTTON1){
        this.vectorNodo.add(new Nodo(e.getX(), e.getY()));
        repaint();
    }
        if(e.getButton()== MouseEvent.BUTTON3)
            for (Nodo nodo: vectorNodo){
                if(new Rectangle(nodo.getX() - Nodo.d/2, nodo.getY()-Nodo.d/2, Nodo.d, Nodo.d).contains(e.getPoint())){
                if (p1==null)
                    p1= new Point(nodo.getX(), nodo.getY());
                   else
                   p2= new Point(nodo.getX(), nodo.getY());
                this.vectorEnlaces.add(new Enlace(p1.x,p1.y,p2.x,p2.y));
                repaint();
                p1=null;
                p2=null;
                }
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

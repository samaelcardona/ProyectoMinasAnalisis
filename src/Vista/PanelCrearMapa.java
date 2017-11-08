/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorParaCrearMina;
import Modelo.ImagenARotar;
import Modelo.Tunel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;

/**
 *
 * @author Victor
 */
public class PanelCrearMapa extends javax.swing.JPanel implements MouseMotionListener, MouseListener, KeyListener {

    ImagenARotar imagenEnMovimientoPanel;
    int x = 20;
    int y = 10;
    private ControladorParaCrearMina controladorParaCrearMina;
    private FrameCrearMapa frame;

    public PanelCrearMapa() {
        initComponents();

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        addMouseListener(this);
        addMouseMotionListener(this);
        imagenEnMovimientoPanel=new ImagenARotar(0, 0, null);
        controladorParaCrearMina=new ControladorParaCrearMina();
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(153, 153, 255));
        setMaximumSize(new java.awt.Dimension(1120, 560));
        setMinimumSize(new java.awt.Dimension(1120, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1120, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
         ImageIcon imagenIcon=new ImageIcon(getClass().getResource("/Imagenes/fondoParaPanelMina.jpg"));
         g.drawImage(imagenIcon.getImage(),0, 0,getSize().width,getSize().height ,this);
        
        
        for (int i = 0; i <= x; i++) {
            g.drawLine((i * 56), 0, (i * 56), 560);
        }
        g.drawLine(1119, 0, 1119, 560);

        ///aca se grafica las lineas  verticales para la cuadricula.
        for (int i = 0; i <= y; i++) {
            g.drawLine(0, (i * 56), 1120, (i * 56));
        }
        g.drawLine(0, 559, 1120, 559);

        //llenar matriz 
        
        if (imagenEnMovimientoPanel.getImagen() != null) {
              g.drawImage(imagenEnMovimientoPanel.getImagen().getImage(),imagenEnMovimientoPanel.getPosicionx(), imagenEnMovimientoPanel.getPosiciony(),imagenEnMovimientoPanel.getImagen().getIconWidth(),imagenEnMovimientoPanel.getImagen().getIconHeight(),this);
        }
        
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (controladorParaCrearMina.getMinaNueva().getMatrizTuneles()[i][j].getImagenTunel()!=null) {
                    g.drawImage(controladorParaCrearMina.getMinaNueva().getMatrizTuneles()[i][j].getImagenTunel().getImage(),(int)controladorParaCrearMina.getMinaNueva().getMatrizTuneles()[i][j].getX1Tunel(),(int)controladorParaCrearMina.getMinaNueva().getMatrizTuneles()[i][j].getY1Tunel(),controladorParaCrearMina.getMinaNueva().getMatrizTuneles()[i][j].getImagenTunel().getIconWidth(),controladorParaCrearMina.getMinaNueva().getMatrizTuneles()[i][j].getImagenTunel().getIconHeight(),this);
                }
            }
        }
       
        

        repaint();
    } 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseDragged(MouseEvent me) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (imagenEnMovimientoPanel.getImagen() != null) {
            imagenEnMovimientoPanel.setPosicionx(e.getX() - 23);
            imagenEnMovimientoPanel.setPosiciony(e.getY() - 23);
            repaint();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {             
        int x = (int) e.getPoint().getX();
        int y = (int) e.getPoint().getY();
       
        ///aca llamo el meotodo para crear tunel en la clase controladorparacrearmina
        if (frame.getjRadioButton1().isSelected()) {
            controladorParaCrearMina.agregarElementoTunelEntrada(x, y);
        }
        if (frame.getjRadioButton2().isSelected()) {
            controladorParaCrearMina.agregarElementoTunelDeposito(x, y);
        }
        if (frame.getjRadioButton3().isSelected()) {
            controladorParaCrearMina.agregarElementoTunelSencillo(x, y);
        }
        
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
       
    }
    

    @Override
    public void mouseReleased(MouseEvent me) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public FrameCrearMapa getFrame() {
        return frame;
    }

    public void setFrame(FrameCrearMapa frame) {
        this.frame = frame;
    }

    public ImagenARotar getImagenEnMovimientoPanel() {
        return imagenEnMovimientoPanel;
    }

        
    
    
}

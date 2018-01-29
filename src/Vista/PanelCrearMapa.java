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
    private FrameCrearMapa frameCrearMapa;
    private boolean iniciarGraficosEnPaint=false;

    public PanelCrearMapa() {
        initComponents();

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        addMouseListener(this);
        addMouseMotionListener(this);
        imagenEnMovimientoPanel = new ImagenARotar(0, 0, null);

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
        ImageIcon imagenIcon = new ImageIcon(getClass().getResource("/Imagenes/fondoParaPanelMina.jpg"));
        g.drawImage(imagenIcon.getImage(), 0, 0, getSize().width, getSize().height, this);

        for (int i = 0; i <= x; i++) {
            g.drawLine((i * 56), 0, (i * 56), 560);
        }
        g.drawLine(1119, 0, 1119, 560);

        ///aca se grafica las lineas  verticales para la cuadricula.
        for (int i = 0; i <= y; i++) {
            g.drawLine(0, (i * 56), 1120, (i * 56));
        }
        g.drawLine(0, 559, 1120, 559);

        //metodo para mostrar la imagen seleccionada sobre el panel y poder moverla
        if (imagenEnMovimientoPanel.getImagen() != null) {
            g.drawImage(imagenEnMovimientoPanel.getImagen().getImage(), imagenEnMovimientoPanel.getPosicionx(), imagenEnMovimientoPanel.getPosiciony(), imagenEnMovimientoPanel.getImagen().getIconWidth(), imagenEnMovimientoPanel.getImagen().getIconHeight(), this);
        }

        //metodo para pintar lo que se va poniendo en el mapa 
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (this.frameCrearMapa != null) {
                    if (this.frameCrearMapa.controladorCrearMina.getMinaNueva().getMatrizTuneles()[i][j].getImagenTunel() != null) {
                        g.drawImage(this.frameCrearMapa.controladorCrearMina.getMinaNueva().getMatrizTuneles()[i][j].getImagenTunel().getImage(), (int) this.frameCrearMapa.controladorCrearMina.getMinaNueva().getMatrizTuneles()[i][j].getX1Tunel(), (int) this.frameCrearMapa.controladorCrearMina.getMinaNueva().getMatrizTuneles()[i][j].getY1Tunel(), this.frameCrearMapa.controladorCrearMina.getMinaNueva().getMatrizTuneles()[i][j].getImagenTunel().getIconWidth(), this.frameCrearMapa.controladorCrearMina.getMinaNueva().getMatrizTuneles()[i][j].getImagenTunel().getIconHeight(), this);
                        g.drawOval(this.frameCrearMapa.controladorCrearMina.getMinaNueva().getMatrizTuneles()[i][j].getListadeNodosEnElTunel().get(0).getxNodoGrafoMina(), this.frameCrearMapa.controladorCrearMina.getMinaNueva().getMatrizTuneles()[i][j].getListadeNodosEnElTunel().get(0).getyNOdoGrafoMina(), 10, 10);
                        g.drawOval(this.frameCrearMapa.controladorCrearMina.getMinaNueva().getMatrizTuneles()[i][j].getListadeNodosEnElTunel().get(1).getxNodoGrafoMina(), this.frameCrearMapa.controladorCrearMina.getMinaNueva().getMatrizTuneles()[i][j].getListadeNodosEnElTunel().get(1).getyNOdoGrafoMina(), 10, 10);
                        g.drawOval(this.frameCrearMapa.controladorCrearMina.getMinaNueva().getMatrizTuneles()[i][j].getListadeNodosEnElTunel().get(2).getxNodoGrafoMina(), this.frameCrearMapa.controladorCrearMina.getMinaNueva().getMatrizTuneles()[i][j].getListadeNodosEnElTunel().get(2).getyNOdoGrafoMina(), 10, 10);
                        g.drawOval(this.frameCrearMapa.controladorCrearMina.getMinaNueva().getMatrizTuneles()[i][j].getListadeNodosEnElTunel().get(3).getxNodoGrafoMina(), this.frameCrearMapa.controladorCrearMina.getMinaNueva().getMatrizTuneles()[i][j].getListadeNodosEnElTunel().get(3).getyNOdoGrafoMina(), 10, 10);
                    }
                }
            }
        }

        //metodo para ir pintando las transiciones o aristas finales
        if (this.iniciarGraficosEnPaint==true) {
            for (int i = 0; i < this.frameCrearMapa.controladorCrearMina.getMinaNueva().getListaDeAristasGrafoMina().size(); i++) {
                g.drawLine(this.frameCrearMapa.controladorCrearMina.getMinaNueva().getListaDeAristasGrafoMina().get(i).getNodoA().getxNodoGrafoMina(), this.frameCrearMapa.controladorCrearMina.getMinaNueva().getListaDeAristasGrafoMina().get(i).getNodoA().getyNOdoGrafoMina(), this.frameCrearMapa.controladorCrearMina.getMinaNueva().getListaDeAristasGrafoMina().get(i).getNodoB().getxNodoGrafoMina(), this.frameCrearMapa.controladorCrearMina.getMinaNueva().getListaDeAristasGrafoMina().get(i).getNodoB().getyNOdoGrafoMina());
            }
        }

        repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    public void recibirPadreFrameCrearMapa(FrameCrearMapa frameCrearMapa) {
        this.frameCrearMapa = frameCrearMapa;
    }

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
        if (frameCrearMapa.getjRadioButton1().isSelected()) {
            frameCrearMapa.controladorCrearMina.agregarElementoTunelEntrada(x, y);
        }
        if (frameCrearMapa.getjRadioButton2().isSelected()) {
            frameCrearMapa.controladorCrearMina.agregarElementoTunelDeposito(x, y);
            frameCrearMapa.contadorIdDeposito++;
        }
        if (frameCrearMapa.getjRadioButton3().isSelected()) {
            frameCrearMapa.controladorCrearMina.agregarElementoTunelSencillo(x, y);
        }

        repaint();
    }

    public boolean isIniciarGraficosEnPaint() {
        return iniciarGraficosEnPaint;
    }

    public void setIniciarGraficosEnPaint(boolean iniciarGraficosEnPaint) {
        this.iniciarGraficosEnPaint = iniciarGraficosEnPaint;
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

    public FrameCrearMapa getFrameCrearMapa() {
        return frameCrearMapa;
    }

    public void setFrameCrearMapa(FrameCrearMapa frameCrearMapa) {
        this.frameCrearMapa = frameCrearMapa;
    }

    public ImagenARotar getImagenEnMovimientoPanel() {
        return imagenEnMovimientoPanel;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.PuntosLimiteCuadricula;
import Modelo.Tunel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author Victor
 */
public class PanelCrearMapa extends javax.swing.JPanel implements MouseMotionListener, MouseListener, KeyListener {

    Tunel tunel;
    int x = 20;
    int y = 10;
    private FrameCrearMapa frame;
    PuntosLimiteCuadricula[][] matrizPuntosLimitesCuadriculaMapa = new PuntosLimiteCuadricula[20][10];
    boolean esPrimerObjetoEnMapa = true;

    public PanelCrearMapa() {
        initComponents();

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        addMouseListener(this);
        addMouseMotionListener(this);
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                matrizPuntosLimitesCuadriculaMapa[i][j] = new PuntosLimiteCuadricula();
            }
        }

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
        ///aca se grafica las lineas horizontales para la cuadricula
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
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                matrizPuntosLimitesCuadriculaMapa[i - 1][j - 1].setX1(((i - 1) * 56));
                matrizPuntosLimitesCuadriculaMapa[i - 1][j - 1].setX2((i * 56));
                matrizPuntosLimitesCuadriculaMapa[i - 1][j - 1].setY1(((j - 1) * 56));
                matrizPuntosLimitesCuadriculaMapa[i - 1][j - 1].setY2((j * 56));
            }
            
        }
        
        if (tunel != null) {
            g.drawImage(tunel.getImagenTunel().getImage(), (int)tunel.getX1Tunel(), (int)tunel.getY1Tunel(), tunel.getAnchoTunel(), tunel.getAltoTunel(), this);            
            g.setColor(Color.white);
            g.drawRect((int)tunel.getX1Tunel(), (int)tunel.getY1Tunel(),tunel.getAnchoTunel(), tunel.getAltoTunel());
        }

        repaint();
    }

    public void recibirFrameCrearMapa(FrameCrearMapa frameRecibido) {
        this.frame = frameRecibido;
    }
    
    
    public int[] retornarPosicionCuadriculaSeleccionada(int x, int y) {

        boolean encontroX = false;
        boolean encontroY = false;
        int i = 0;
        int j = 0;
        int[] datosXY = new int[2];

        //para encontrar limites en x 
        while (i < 20 && encontroX == false) {
            if (matrizPuntosLimitesCuadriculaMapa[i][j].getX1() <= x && matrizPuntosLimitesCuadriculaMapa[i][j].getX2() >= x) {
                encontroX = true;
                datosXY[0] = i;
            }
            i++;
        }

        //para encontrar limites en y despues de haber encontrado x
        if (encontroX == true) {
            while (j < 10 && encontroY == false) {
                if (matrizPuntosLimitesCuadriculaMapa[datosXY[0]][j].getY1() <= y && matrizPuntosLimitesCuadriculaMapa[datosXY[0]][j].getY2() >= y) {
                    encontroY = true;
                    datosXY[1] = j;
                }
                j++;
            }
        } else {
            System.out.println("verifique posiciones seleccionadas");
        }
        if (encontroY == true) {
            return datosXY;
        }
        return null;
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
        if (tunel != null) {
            tunel.setX1Tunel(e.getX() - 23);
            tunel.setY1Tunel(e.getY() - 23);
            repaint();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {             
        int x = (int) e.getPoint().getX();
        int y = (int) e.getPoint().getY();
        System.out.println("X: "+x+" Y: "+y);
        int posicion [] = retornarPosicionCuadriculaSeleccionada(x, y);
        System.out.println("X: "+posicion[0]+" Y: "+posicion[1]);  
        
        
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

    public PuntosLimiteCuadricula[][] getMatrizPuntosLimitesCuadriculaMapa() {
        return matrizPuntosLimitesCuadriculaMapa;
    }

    public void setMatrizPuntosLimitesCuadriculaMapa(PuntosLimiteCuadricula[][] matrizPuntosLimitesCuadriculaMapa) {
        this.matrizPuntosLimitesCuadriculaMapa = matrizPuntosLimitesCuadriculaMapa;
    }

    public boolean isEsPrimerObjetoEnMapa() {
        return esPrimerObjetoEnMapa;
    }

    public void setEsPrimerObjetoEnMapa(boolean esPrimerObjetoEnMapa) {
        this.esPrimerObjetoEnMapa = esPrimerObjetoEnMapa;
    }

    public Tunel getTunel() {
        return tunel;
    }

    public void setTunel(Tunel tunel) {
        this.tunel = tunel;
    }

        
    
}

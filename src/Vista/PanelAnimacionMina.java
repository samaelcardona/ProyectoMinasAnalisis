/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author SAMAEL
 */
public class PanelAnimacionMina extends javax.swing.JPanel {

    int x = 20;
    int y = 10;
    
    
    /**
     * Creates new form PanelAnimacionMina
     */
    public PanelAnimacionMina() {
        initComponents();
        
        
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
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
        
    }

    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

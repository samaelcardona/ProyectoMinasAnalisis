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
    FrameAdministrarMinas frameAdministrarMinas;
    String idMinaParaMostrar;

    /**
     * Creates new form PanelAnimacionMina
     */
    public PanelAnimacionMina() {
        initComponents();


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

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

        //metodo para pintar lo que se va poniendo en el mapa 
        if (idMinaParaMostrar!=null) {
            for (int h = 0; h < this.frameAdministrarMinas.frameAdminEmpresa.minerals.getListaDeMinas().size(); h++) {                
                if (idMinaParaMostrar.equals(this.frameAdministrarMinas.frameAdminEmpresa.minerals.getListaDeMinas().get(h).getIdMina() + "")) {
                    for (int i = 0; i < x; i++) {
                        for (int j = 0; j < y; j++) {
                            if (this.frameAdministrarMinas != null) {

                                if (this.frameAdministrarMinas.frameAdminEmpresa.minerals.getListaDeMinas().get(h).getMatrizTuneles()[i][j].getImagenTunel() != null) {
                                    g.drawImage(this.frameAdministrarMinas.frameAdminEmpresa.minerals.getListaDeMinas().get(h).getMatrizTuneles()[i][j].getImagenTunel().getImage(), (int) this.frameAdministrarMinas.frameAdminEmpresa.minerals.getListaDeMinas().get(h).getMatrizTuneles()[i][j].getX1Tunel(), (int) this.frameAdministrarMinas.frameAdminEmpresa.minerals.getListaDeMinas().get(h).getMatrizTuneles()[i][j].getY1Tunel(), this.frameAdministrarMinas.frameAdminEmpresa.minerals.getListaDeMinas().get(h).getMatrizTuneles()[i][j].getImagenTunel().getIconWidth(), this.frameAdministrarMinas.frameAdminEmpresa.minerals.getListaDeMinas().get(h).getMatrizTuneles()[i][j].getImagenTunel().getIconHeight(), this);
                                    g.drawOval(this.frameAdministrarMinas.frameAdminEmpresa.minerals.getListaDeMinas().get(h).getMatrizTuneles()[i][j].getListadeNodosEnElTunel().get(0).getxNodoGrafoMina(), this.frameAdministrarMinas.frameAdminEmpresa.minerals.getListaDeMinas().get(h).getMatrizTuneles()[i][j].getListadeNodosEnElTunel().get(0).getyNOdoGrafoMina(), 10, 10);
                                    g.drawOval(this.frameAdministrarMinas.frameAdminEmpresa.minerals.getListaDeMinas().get(h).getMatrizTuneles()[i][j].getListadeNodosEnElTunel().get(1).getxNodoGrafoMina(), this.frameAdministrarMinas.frameAdminEmpresa.minerals.getListaDeMinas().get(h).getMatrizTuneles()[i][j].getListadeNodosEnElTunel().get(1).getyNOdoGrafoMina(), 10, 10);
                                    g.drawOval(this.frameAdministrarMinas.frameAdminEmpresa.minerals.getListaDeMinas().get(h).getMatrizTuneles()[i][j].getListadeNodosEnElTunel().get(2).getxNodoGrafoMina(), this.frameAdministrarMinas.frameAdminEmpresa.minerals.getListaDeMinas().get(h).getMatrizTuneles()[i][j].getListadeNodosEnElTunel().get(2).getyNOdoGrafoMina(), 10, 10);
                                    g.drawOval(this.frameAdministrarMinas.frameAdminEmpresa.minerals.getListaDeMinas().get(h).getMatrizTuneles()[i][j].getListadeNodosEnElTunel().get(3).getxNodoGrafoMina(), this.frameAdministrarMinas.frameAdminEmpresa.minerals.getListaDeMinas().get(h).getMatrizTuneles()[i][j].getListadeNodosEnElTunel().get(3).getyNOdoGrafoMina(), 10, 10);
                                
                                }
                            }

                        }
                    }
                    
                    for (int i = 0; i < this.frameAdministrarMinas.frameAdminEmpresa.minerals.getListaDeMinas().get(h).getListaDeMinerosEspecializadosEnMina().size(); i++) {
                        g.drawImage(this.frameAdministrarMinas.frameAdminEmpresa.minerals.getListaDeMinas().get(h).getListaDeMinerosEspecializadosEnMina().get(i).getImagen().getImage(), (int) this.frameAdministrarMinas.frameAdminEmpresa.minerals.getListaDeMinas().get(h).getListaDeMinerosEspecializadosEnMina().get(i).getxMinero(), (int) this.frameAdministrarMinas.frameAdminEmpresa.minerals.getListaDeMinas().get(h).getListaDeMinerosEspecializadosEnMina().get(i).getyMinero(), this.frameAdministrarMinas.frameAdminEmpresa.minerals.getListaDeMinas().get(h).getListaDeMinerosEspecializadosEnMina().get(i).getImagen().getIconWidth(), this.frameAdministrarMinas.frameAdminEmpresa.minerals.getListaDeMinas().get(h).getListaDeMinerosEspecializadosEnMina().get(i).getImagen().getIconHeight(), this);
                        
                    }
                    
                    for (int i = 0; i < this.frameAdministrarMinas.frameAdminEmpresa.minerals.getListaDeMinas().get(h).getListaDeMinerosComodinsEnMina().size(); i++) {
                        g.drawImage(this.frameAdministrarMinas.frameAdminEmpresa.minerals.getListaDeMinas().get(h).getListaDeMinerosComodinsEnMina().get(i).getImagen().getImage(), (int) this.frameAdministrarMinas.frameAdminEmpresa.minerals.getListaDeMinas().get(h).getListaDeMinerosComodinsEnMina().get(i).getxMinero(), (int) this.frameAdministrarMinas.frameAdminEmpresa.minerals.getListaDeMinas().get(h).getListaDeMinerosComodinsEnMina().get(i).getyMinero(), this.frameAdministrarMinas.frameAdminEmpresa.minerals.getListaDeMinas().get(h).getListaDeMinerosComodinsEnMina().get(i).getImagen().getIconWidth(), this.frameAdministrarMinas.frameAdminEmpresa.minerals.getListaDeMinas().get(h).getListaDeMinerosComodinsEnMina().get(i).getImagen().getIconHeight(), this);
                        
                    }
                    

                    //metodo para ir pintando las transiciones o aristas finales
                   // System.out.println("Cantidad de aristas"+this.frameAdministrarMinas.frameAdminEmpresa.minerals.getListaDeMinas().get(h).getListaDeAristasGrafoMina().size());
                    for (int i = 0; i < this.frameAdministrarMinas.frameAdminEmpresa.minerals.getListaDeMinas().get(h).getListaDeAristasGrafoMina().size(); i++) {
                       // System.out.println("x nodo A"+this.frameAdministrarMinas.frameAdminEmpresa.minerals.getListaDeMinas().get(h).getListaDeAristasGrafoMina().get(i).getNodoA().getxNodoGrafoMina());
                        g.drawLine(this.frameAdministrarMinas.frameAdminEmpresa.minerals.getListaDeMinas().get(h).getListaDeAristasGrafoMina().get(i).getNodoA().getxNodoGrafoMina(), this.frameAdministrarMinas.frameAdminEmpresa.minerals.getListaDeMinas().get(h).getListaDeAristasGrafoMina().get(i).getNodoA().getyNOdoGrafoMina(), this.frameAdministrarMinas.frameAdminEmpresa.minerals.getListaDeMinas().get(h).getListaDeAristasGrafoMina().get(i).getNodoB().getxNodoGrafoMina(), this.frameAdministrarMinas.frameAdminEmpresa.minerals.getListaDeMinas().get(h).getListaDeAristasGrafoMina().get(i).getNodoB().getyNOdoGrafoMina());
                    }
                }
            }
        }
        
        repaint();
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

    public void recibirPadreFrameCrearMapa(FrameAdministrarMinas frameAdministrarMinas) {
        this.frameAdministrarMinas = frameAdministrarMinas;
    }

    public String getIdMinaParaMostrar() {
        return idMinaParaMostrar;
    }

    public void setIdMinaParaMostrar(String idMinaParaMostrar) {
        this.idMinaParaMostrar = idMinaParaMostrar;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

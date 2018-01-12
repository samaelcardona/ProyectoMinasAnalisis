/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.swing.ImageIcon;

/**
 *
 * @author SAMAEL
 * 
 * Imagen para crear la animacion cuando estoy creando la mina  poderlo mover
 * 
 */
public class ImagenARotar {
    
    int posicionx;
    int posiciony;
    ImageIcon imagen;

    public ImagenARotar(int posicionx, int posiciony, ImageIcon imagen) {
        this.posicionx = posicionx;
        this.posiciony = posiciony;
        this.imagen = imagen;
    }

    public int getPosicionx() {
        return posicionx;
    }

    public void setPosicionx(int posicionx) {
        this.posicionx = posicionx;
    }

    public int getPosiciony() {
        return posiciony;
    }

    public void setPosiciony(int posiciony) {
        this.posiciony = posiciony;
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }
    
    
    
}

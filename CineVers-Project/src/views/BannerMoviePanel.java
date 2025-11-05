/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author Paola
 */
public class BannerMoviePanel extends JPanel {

    private Image image;

    public BannerMoviePanel() {
        this.setLayout(new BorderLayout());
    }

    // Guarda la imagen y repinta el panel
    public void paintBanner(Image image) {
        this.image = image;
        repaint(); // fuerza a Swing a redibujar el panel
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (image != null) {
            // Dibuja la imagen escalada para ocupar todo el panel
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

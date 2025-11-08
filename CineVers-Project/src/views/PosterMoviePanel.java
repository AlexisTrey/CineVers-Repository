/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */
public class PosterMoviePanel extends JPanel {

    private Color backgroundColor = new Color(240, 240, 240);
    private Color accentColor = new Color(200, 50, 50);
    private BufferedImage posterImage;

    public PosterMoviePanel() {
        setPreferredSize(new Dimension(600, 600));
        setBackground(backgroundColor);

        // Cargar la imagen del poster
        try {
            posterImage = ImageIO.read(getClass().getResource("/resources/images/poster_together.png"));
        } catch (IOException e) {
            System.err.println("Error al cargar la imagen: " + e.getMessage());
            // Crear una imagen placeholder si no se encuentra la imagen
            posterImage = createPlaceholderImage(150, 225);
        }
    }

    private BufferedImage createPlaceholderImage(int width, int height) {
        BufferedImage placeholder = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = placeholder.createGraphics();
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillRect(0, 0, width, height);
        g2d.setColor(Color.DARK_GRAY);
        g2d.drawRect(0, 0, width - 1, height - 1);
        g2d.setFont(new Font("Arial", Font.PLAIN, 12));

        // Centrar el texto "Poster no disponible"
        String text = "Poster no disponible";
        FontMetrics fm = g2d.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getHeight();
        g2d.drawString(text, (width - textWidth) / 2, (height + textHeight) / 2 - 5);

        g2d.dispose();
        return placeholder;
    }

    @Override
    protected void paintComponent(Graphics g) {
super.paintComponent(g);
        if (posterImage == null) return;

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        // Dibujar la imagen escalada al tamaño completo del panel
        int panelWidth = getWidth();
        int panelHeight = getHeight();

        g2d.drawImage(posterImage, 0, 0, panelWidth, panelHeight, this);

    }

//    private void drawPosterSection(Graphics2D g2d, int contentWidth, int x, int y) {
//        if (posterImage != null) {
//            // Calcular dimensiones para mantener la proporción
//            int imgWidth = 150;
//            int imgHeight = 225; // Proporción 2:3
//
//            // Centrar la imagen horizontalmente
//            int xPos = (getWidth() - imgWidth) / 2;
//
//            // Dibujar la imagen con sombra
//            drawImageWithShadow(g2d, posterImage, xPos, y, imgWidth, imgHeight);
//        }
//    }

    private void drawImageWithShadow(Graphics2D g2d, BufferedImage image, int x, int y, int width, int height) {
        // Dibujar sombra
        g2d.setColor(new Color(0, 0, 0, 30));
        g2d.fillRoundRect(x + 2, y + 2, width, height, 5, 5);

        // Dibujar la imagen
        g2d.drawImage(image, x, y, width, height, this);

        // Borde de la imagen
        g2d.setColor(new Color(150, 150, 150));
        g2d.drawRoundRect(x, y, width, height, 5, 5);
    }

}

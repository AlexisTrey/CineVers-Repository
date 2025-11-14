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
import javax.swing.JPanel;  

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */
public class SinopsisMovie extends JPanel {

    private Color titleColor = new Color(102, 0, 161);
    private Color textColor = new Color(80, 80, 80);
    private String[][] info;

    public SinopsisMovie() {
        setPreferredSize(new Dimension(20, 20));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int padding = 20;
        int contentWidth = getWidth() - 2 * padding;
        int currentY = padding;
        // Título SINOPSIS
        g2d.setColor(titleColor);
        g2d.setFont(new Font("Arial", Font.BOLD, 24));
        g2d.drawString("SINOPSIS", padding, currentY);
        currentY += 40;

        // Texto de la sinopsis
        g2d.setColor(textColor);
        g2d.setFont(new Font("Arial", Font.PLAIN, 14));

        String sinopsis = "Una mudanza al campo desata fuerzas sobrenaturales que transforman "
                + "la relación de una pareja, su realidad y sus cuerpos.";

        // Dibujar texto con wrap
        currentY = drawWrappedText(g2d, sinopsis, padding, currentY, contentWidth, 18);
        currentY += 30;

        // Línea divisoria
        g2d.setColor(new Color(200, 200, 200));
        g2d.fillRect(padding, currentY, contentWidth, 2);
        currentY += 30;

        // Información de la película (sin título "INFORMACIÓN")
        drawMovieInfo(g2d, padding, currentY, contentWidth);
    }

    private void drawMovieInfo(Graphics2D g2d, int x, int y, int maxWidth) {
        int currentY = y;

        // Información de la película en formato simple
        info = new String[][] {
                { "Nombre original:", "TOGETHER" },
                { "Clasificación:", "Para mayores de 15 años" },
                { "Reparto:", "Dave Franco, Alison Brie, Damon Herriman" },
                { "Director:", "Michael Shanks" },
                {"Sala:", "Sala 01"}
        };

        g2d.setFont(new Font("Arial", Font.BOLD, 12));

        for (String[] item : info) {
            String label = item[0];
            String value = item[1];

            // Dibujar label en negrita
            g2d.setColor(titleColor);
            g2d.drawString(label, x, currentY);

            // Calcular posición para el valor
            int labelWidth = g2d.getFontMetrics().stringWidth(label);
            int valueX = x + labelWidth + 5;

            // Dibujar valor en texto normal
            g2d.setColor(textColor);
            g2d.setFont(new Font("Arial", Font.PLAIN, 12));

            // Dibujar el valor con wrap si es necesario
            int availableWidth = maxWidth - (valueX - x);
            currentY = drawWrappedText(g2d, value, valueX, currentY, availableWidth, 16);
            currentY += 5;

            g2d.setFont(new Font("Arial", Font.BOLD, 12));
        }
    }

    private int drawWrappedText(Graphics2D g2d, String text, int x, int y, int maxWidth, int lineHeight) {
        FontMetrics fm = g2d.getFontMetrics();
        String[] words = text.split(" ");
        StringBuilder currentLine = new StringBuilder();
        int currentY = y;

        for (String word : words) {
            String testLine = currentLine + (currentLine.length() > 0 ? " " : "") + word;
            int testWidth = fm.stringWidth(testLine);

            if (testWidth > maxWidth && currentLine.length() > 0) {
                // Dibujar la línea actual
                g2d.drawString(currentLine.toString(), x, currentY);
                currentY += lineHeight;
                currentLine = new StringBuilder(word);
            } else {
                currentLine = new StringBuilder(testLine);
            }
        }

        // Dibujar la última línea
        if (currentLine.length() > 0) {
            g2d.drawString(currentLine.toString(), x, currentY);
        }

        return currentY + lineHeight;
    }

    public String[][] getInfo() {
        return info;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.Color;
import java.awt.Dimension;
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
public class RoundedPanel extends JPanel {
    private int cornerRadius = 15; // Radio de la esquina
    private Color backgroundColor = new Color(128, 0, 128, 20); // Púrpura muy claro (transparente)
    
    // Constructor
    public RoundedPanel(int radius, Color bgColor) {
        this.cornerRadius = radius;
        this.backgroundColor = bgColor;
        setOpaque(false); // Necesario para ver el dibujo del fondo
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(cornerRadius, cornerRadius);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        
        // Suaviza los bordes
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibuja el fondo con el color y las esquinas redondeadas
        graphics.setColor(backgroundColor);
        graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);
        
        // Dibuja el borde (opcional, si quieres un contorno)
        // graphics.setColor(getForeground());
        // graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);
    }
}

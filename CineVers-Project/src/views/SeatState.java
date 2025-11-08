/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Paola
 */
public class SeatState extends JPanel {

    private Color titleColor = new Color(102, 0, 161);
    private Color textColor = new Color(80, 80, 80);
    private Color greenTag = new Color(0, 180, 0);

    public SeatState() {
        setPreferredSize(new Dimension(300, 600));
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int padding = 20;
        int x = padding;
        int y = 40;

        //ESTADOS DE SILLAS 
        g2d.setColor(titleColor);
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.drawString("Estados de sillas:", x, y);
        y += 30;

        g2d.setFont(new Font("Arial", Font.PLAIN, 15));
        int iconSize = 10;

        // Disponible
        g2d.setColor(Color.GREEN);
        g2d.fillOval(x, y, iconSize, iconSize);
        g2d.setColor(textColor);
        g2d.drawString("Disponible", x + 20, y + 10);
        y += 25;

        // No disponible
        g2d.setColor(Color.RED);
        g2d.fillOval(x, y, iconSize, iconSize);
        g2d.setColor(textColor);
        g2d.drawString("No disponible", x + 20, y + 10);
        y += 25;

        // Ocupada (morado)
        g2d.setColor(new Color(102, 0, 161));
        g2d.fillOval(x, y, iconSize, iconSize);
        g2d.setColor(textColor);
        g2d.drawString("Ocupada", x + 20, y + 10);
        y += 25;

        // Escogida (verde más oscuro)
        g2d.setColor(new Color(0, 180, 0));
        g2d.fillOval(x, y, iconSize, iconSize);
        g2d.setColor(textColor);
        g2d.drawString("Escogida", x + 20, y + 10);
        y += 40;

        //TIPOS DE SILLAS 
        g2d.setColor(titleColor);
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.drawString("Tipos de sillas:", x, y);
        y += 30;

        g2d.setFont(new Font("Arial", Font.PLAIN, 15));
        // Standard
        g2d.setColor(textColor);
        g2d.drawString("Standard", x + 30, y + 10);
        drawPriceTag(g2d, x + 120, y - 5, "$8.000");
        y += 30;

        // Discapacitados
        g2d.setColor(textColor);
        g2d.drawString("Discapacitados", x + 30, y + 10);
        drawPriceTag(g2d, x + 150, y - 5, "$8.000");
        y += 40;

        // Línea divisoria
        g2d.setColor(new Color(200, 200, 200));
        g2d.fillRect(x, y, getWidth() - 2 * x, 2);
        y += 40;

        // ---------- CANTIDAD DE SILLAS ----------
        g2d.setColor(titleColor);
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.drawString("Cantidad de sillas:", x, y);
        y += 40;

        // Botones - y +
        drawButton(g2d, x, y, "-", true);
        drawQuantityBox(g2d, x + 60, y, "0");
        drawButton(g2d, x + 130, y, "+", true);
        y += 70;

        // Texto sillas seleccionadas
        g2d.setColor(new Color(120, 0, 180));
        g2d.setFont(new Font("Arial", Font.BOLD, 15));
        g2d.drawString("Sillas seleccionadas:", x, y);
        y += 20;
        g2d.setFont(new Font("Arial", Font.PLAIN, 13));
        g2d.drawString("Aún no has seleccionado sillas", x, y);

        y += 60;

        // ---------- BOTONES
        drawActionButton(g2d, x, y, "Volver");
        drawActionButton(g2d, x + 150, y, "Confirmar");
    }

    private void drawPriceTag(Graphics2D g2d, int x, int y, String text) {
        FontMetrics fm = g2d.getFontMetrics();
        int w = fm.stringWidth(text) + 16;
        int h = 20;
        g2d.setColor(new Color(0, 180, 0));
        g2d.fillRoundRect(x, y, w, h, 10, 10);
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, 12));
        g2d.drawString(text, x + 8, y + 15);
    }

    private void drawButton(Graphics2D g2d, int x, int y, String text, boolean purple) {
        int w = 40, h = 40;
        Color color1 = new Color(140, 0, 200);
        Color color2 = new Color(100, 0, 160);
        GradientPaint gp = new GradientPaint(x, y, color1, x, y + h, color2);
        g2d.setPaint(gp);
        g2d.fillRoundRect(x, y, w, h, 12, 12);

        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, 24));
        FontMetrics fm = g2d.getFontMetrics();
        int tx = x + (w - fm.stringWidth(text)) / 2;
        int ty = y + (h + fm.getAscent() - fm.getDescent()) / 2 - 4;
        g2d.drawString(text, tx, ty);
    }

    private void drawQuantityBox(Graphics2D g2d, int x, int y, String text) {
        g2d.setColor(new Color(230, 220, 250));
        g2d.fillRoundRect(x, y, 60, 40, 12, 12);
    }

    private void drawActionButton(Graphics2D g2d, int x, int y, String text) {
        int w = 120, h = 40;
        GradientPaint gp = new GradientPaint(x, y, new Color(140, 0, 200), x, y + h, new Color(100, 0, 160));
        g2d.setPaint(gp);
        g2d.fillRoundRect(x, y, w, h, 12, 12);
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        FontMetrics fm = g2d.getFontMetrics();
        int tx = x + (w - fm.stringWidth(text)) / 2;
        int ty = y + (h + fm.getAscent() - fm.getDescent()) / 2 - 3;
        g2d.drawString(text, tx, ty);
    }
    
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            JFrame frame = new JFrame("Estados de sillas");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//            SeatState panel = new SeatState();
//            frame.add(panel);
//
//            frame.pack();
//            frame.setLocationRelativeTo(null);
//            frame.setVisible(true);
//        });
//    }
}

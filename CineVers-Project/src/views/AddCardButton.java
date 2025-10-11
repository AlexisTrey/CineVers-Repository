/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */
public class AddCardButton extends JButton {

    private String labelText;
    private boolean isHover;

    public AddCardButton(String labelText) {
        this.labelText = labelText;
        setPreferredSize(new Dimension(350, 180));
        setOpaque(false);
        setBorder(null);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                isHover = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isHover = false;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int arc = 40;
        Shape shape = new RoundRectangle2D.Double(5, 5, getWidth() - 10, getHeight() - 10, arc, arc);
        
        g2d.setColor(new Color(0, 0, 0, 40));
        g2d.fillRoundRect(8, 8, getWidth() - 16, getHeight() - 16, arc, arc);

        g2d.setColor(Color.WHITE);
        g2d.fill(shape);

        if (isHover) {
            g2d.setStroke(new BasicStroke(1.8f));
            g2d.setColor(new Color(122, 43, 191, 80));
        } else {
            g2d.setStroke(new BasicStroke(1.2f));
            g2d.setColor(new Color(0, 0, 0, 40));
        }
        g2d.draw(shape);

        Font plusFont = new Font("Segoe UI", Font.BOLD, 100);
        g2d.setFont(plusFont);
        GradientPaint gradient = new GradientPaint(0, 0,
                new Color(155, 100, 220),
                0, getHeight(),
                new Color(122, 43, 191));
        g2d.setPaint(gradient);

        FontMetrics fm = g2d.getFontMetrics();
        int plusWidth = fm.stringWidth("+");
        int plusHeight = fm.getAscent();
        int plusX = (getWidth() - plusWidth) / 2;
        int plusY = getHeight() / 2 - 10;
        g2d.drawString("+", plusX, plusY);

        g2d.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        g2d.setColor(new Color(140, 140, 140));
        FontMetrics fmText = g2d.getFontMetrics();
        int textWidth = fmText.stringWidth(labelText);
        int textX = (getWidth() - textWidth) / 2;
        int textY = plusY + 50;
        g2d.drawString(labelText, textX, textY);

        g2d.dispose();
    }
}

package views;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */
public class ShapedButtons extends BasicButtonUI {

    @Override
    public void paint(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D) g;
        AbstractButton button = (AbstractButton) c;
        boolean isHover = button.getModel().isRollover();
        String text = button.getText();

        switch (text) {
            case "Cartelera":
                btnRoundRectangle(g2d, c.getWidth(), c.getHeight(), isHover);
                break;
            case "Próximos estrenos":
                btnRoundRectangle(g2d, c.getWidth(), c.getHeight(), isHover);
                break;
            case "Mi Cuenta":
                btnRoundRectangle(g2d, c.getWidth(), c.getHeight(), isHover);
                break;
            case "Ver Detalles":
                btnGradientRounded(g2d, c.getWidth(), c.getHeight(), isHover);
                break;
            case "<":
                btnRound(g2d, c.getWidth(), c.getHeight());
                break;
            case ">":
                btnRound(g2d, c.getWidth(), c.getHeight());
                break;
            case "Edición de Funciones":
            case "Edición de Cartelera":
            case "Edición de Salas":
                btnGradientRoundedEdits(g2d, c.getWidth(), c.getHeight(), isHover);
                break;
            case "Editar":
                btnGradientEdit(g2d, c.getWidth(), c.getHeight(), isHover);
                break;
            case "Eliminar":
                btnGradientDelete(g2d, c.getWidth(), c.getHeight(), isHover);
                break;
        }

        g2d.setColor(Color.WHITE);
        g2d.setFont(c.getFont());
        String textBtn = ((AbstractButton) c).getText();
        FontMetrics fm = g2d.getFontMetrics();
        int textWidth = fm.stringWidth(textBtn);
        int textHeight = fm.getAscent();
        int x = (c.getWidth() - textWidth) / 2;
        int y = (c.getHeight() + textHeight) / 2 - 3;
        g2d.drawString(textBtn, x, y);
    }

    private void btnRoundRectangle(Graphics2D g2d, int width, int height, boolean isHover) {
        Shape buttonShape = new RoundRectangle2D.Double(0, 0, width, height, 10, 10);
        if (isHover) {
            g2d.setPaint(new Color(34, 34, 54)); //Hover
        } else {
            g2d.setPaint(new Color(14, 14, 24)); // Normal
        }
        g2d.fill(buttonShape);
    }

    private void btnRectangle(Graphics2D g2d, int width, int height, boolean isHover) {
        Shape buttonShape = new Rectangle2D.Double(0, 0, width, height);
        if (isHover) {
            g2d.setPaint(new Color(255, 255, 255, 50));
            g2d.fill(buttonShape);
            g2d.setColor(Color.WHITE);
            g2d.drawLine(0, height - 2, width, height - 2); // Línea inferior
        } else {
            g2d.setPaint(new Color(0, 0, 0, 0));
            g2d.fill(buttonShape);
        }
    }

    private void btnFill(Graphics2D g2d, int width, int height, boolean isHover) {
        Shape buttonShape = new Rectangle2D.Double(0, 0, width, height);
        if (isHover) {
            g2d.setPaint(new Color(0, 116, 126));
            g2d.fill(buttonShape);
            g2d.setColor(Color.WHITE);
        } else {
            g2d.setPaint(new Color(0, 129, 140));
            g2d.fill(buttonShape);
        }
    }

    private void btnRound(Graphics2D g2d, int width, int height) {
        int diameter = Math.min(width, height);
        int x = (width - diameter) / 2;
        int y = (height - diameter) / 2;
        Shape buttonShape = new Ellipse2D.Double(x, y, diameter, diameter); // ¡Usa x e y aquí!
        g2d.setColor(new Color(102, 0, 161));
        g2d.setStroke(new BasicStroke(2));
        g2d.fill(buttonShape);
    }

    private void btnGradientRounded(Graphics2D g2d, int width, int height, boolean isHover) {
        Shape buttonShape = new RoundRectangle2D.Double(0, 0, width, height, 40, 40);

        Color startColor = isHover ? new Color(110, 70, 190) : new Color(85, 60, 160);
        Color endColor = isHover ? new Color(140, 100, 210) : new Color(105, 80, 185);

        java.awt.GradientPaint gradient = new java.awt.GradientPaint(0, 0, startColor, width, height, endColor);
        g2d.setBackground(new Color(255, 255, 255, 255));
        g2d.clearRect(0, 0, width, height);

        g2d.setPaint(gradient);
        g2d.fill(buttonShape);
        g2d.setColor(new Color(255, 255, 255, 255));
        g2d.setStroke(new BasicStroke(1.5f));
        g2d.draw(buttonShape);
    }

    private void btnGradientRoundedEdits(Graphics2D g2d, int width, int height, boolean isHover) {
        Shape buttonShape = new RoundRectangle2D.Double(0, 0, width, height, 40, 40);

        Color startColor = isHover ? new Color(110, 70, 190) : new Color(85, 60, 160);
        Color endColor = isHover ? new Color(140, 100, 210) : new Color(105, 80, 185);

        java.awt.GradientPaint gradient = new java.awt.GradientPaint(0, 0, startColor, width, height, endColor);
        g2d.setBackground(new Color(122, 43, 191, 255));
        g2d.clearRect(0, 0, width, height);

        g2d.setPaint(gradient);
        g2d.fill(buttonShape);
        g2d.setColor(new Color(122, 43, 191, 255));
        g2d.setStroke(new BasicStroke(1.5f));
        g2d.draw(buttonShape);
    }

    private void btnGradientEdit(Graphics2D g2d, int width, int height, boolean isHover) {
        Shape buttonShape = new RoundRectangle2D.Double(0, 0, width, height, 40, 40);

        Color startColor = isHover ? new Color(60, 180, 100) : new Color(45, 150, 80);
        Color endColor = isHover ? new Color(100, 220, 140) : new Color(70, 190, 110);

        java.awt.GradientPaint gradient = new java.awt.GradientPaint(0, 0, startColor, width, height, endColor);
        g2d.setBackground(new Color(255, 255, 255, 255));
        g2d.clearRect(0, 0, width, height);

        g2d.setPaint(gradient);
        g2d.fill(buttonShape);
        g2d.setColor(new Color(255, 255, 255, 255));
        g2d.setStroke(new BasicStroke(1.5f));
        g2d.draw(buttonShape);
    }

    private void btnGradientDelete(Graphics2D g2d, int width, int height, boolean isHover) {
        Shape buttonShape = new RoundRectangle2D.Double(0, 0, width, height, 40, 40);

        Color startColor = isHover ? new Color(210, 60, 80) : new Color(180, 40, 60);
        Color endColor = isHover ? new Color(240, 90, 110) : new Color(200, 60, 80);

        java.awt.GradientPaint gradient = new java.awt.GradientPaint(0, 0, startColor, width, height, endColor);
        g2d.setBackground(new Color(255, 255, 255, 255));
        g2d.clearRect(0, 0, width, height);

        g2d.setPaint(gradient);
        g2d.fill(buttonShape);
        g2d.setColor(new Color(255, 255, 255, 255));
        g2d.setStroke(new BasicStroke(1.5f));
        g2d.draw(buttonShape);
    }
}

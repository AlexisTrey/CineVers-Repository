package views;

import java.awt.BasicStroke;
import java.awt.Color;
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
            case "Buscar Estudiante":
                btnRoundRectangle(g2d, c.getWidth(), c.getHeight(), isHover);
                break;
            case "Agregar Asignatura":
                btnRoundRectangle(g2d, c.getWidth(), c.getHeight(), isHover);
                break;
            case "Borrar Asignatura":
                btnRoundRectangle(g2d, c.getWidth(), c.getHeight(), isHover);
                break;
            case "Asignar":
                btnRoundRectangle(g2d, c.getWidth(), c.getHeight(), isHover);
                break;
            case "Cancelar":
                btnRectangle(g2d, c.getWidth(), c.getHeight(), isHover);
                break;
            case "Guardar":
                btnRectangle(g2d, c.getWidth(), c.getHeight(), isHover);
                break;
        }
        super.paint(g2d, c);
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
        Shape buttonShape = new Ellipse2D.Double(0, 0, diameter, diameter);
        g2d.setColor(new Color(135, 206, 235));
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(Color.WHITE);
        g2d.draw(buttonShape);
    }
}

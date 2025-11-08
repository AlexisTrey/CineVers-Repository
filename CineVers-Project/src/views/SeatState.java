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
import java.awt.event.ActionListener;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 *
 * @author Paola
 */
public class SeatState extends JPanel {

    private JLabel lblCantidad;
    private JLabel lblSillasSeleccionadas;
    private int cantidad = 0;

    private Color titleColor = new Color(102, 0, 161);
    private Color textColor = new Color(80, 80, 80);
    private Color greenTag = new Color(0, 180, 0);

    public SeatState(ActionListener listener) {
        setPreferredSize(new Dimension(300, 600));
        setBackground(Color.WHITE);
        setLayout(null);

        int yBase = 320; // posición vertical base para los botones de cantidad

        // Botón -
        JButton btnMenos = new JButton("-");
        btnMenos.setFont(new Font("Arial", Font.BOLD, 22));
        btnMenos.setForeground(Color.WHITE);
        btnMenos.setBackground(new Color(100, 0, 160));
        btnMenos.setFocusPainted(false);
        btnMenos.setBounds(20, yBase, 50, 40);
        btnMenos.addActionListener(e -> cambiarCantidad(-1));
        add(btnMenos);

        // Cuadro cantidad
        lblCantidad = new JLabel("0", SwingConstants.CENTER);
        lblCantidad.setOpaque(true);
        lblCantidad.setBackground(new Color(230, 220, 250));
        lblCantidad.setFont(new Font("Arial", Font.BOLD, 20));
        lblCantidad.setBounds(80, yBase, 60, 40);
        add(lblCantidad);

        // Botón +
        JButton btnMas = new JButton("+");
        btnMas.setFont(new Font("Arial", Font.BOLD, 22));
        btnMas.setForeground(Color.WHITE);
        btnMas.setBackground(new Color(100, 0, 160));
        btnMas.setFocusPainted(false);
        btnMas.setBounds(150, yBase, 50, 40);
        btnMas.addActionListener(e -> cambiarCantidad(1));
        add(btnMas);

        // Etiqueta de sillas seleccionadas
        JLabel lblTituloSillas = new JLabel("Sillas seleccionadas:");
        lblTituloSillas.setFont(new Font("Arial", Font.BOLD, 16));
        lblTituloSillas.setForeground(new Color(120, 0, 180));
        lblTituloSillas.setBounds(20, 370, 250, 25);
        add(lblTituloSillas);

        lblSillasSeleccionadas = new JLabel("Aún no has seleccionado sillas");
        lblSillasSeleccionadas.setFont(new Font("Arial", Font.PLAIN, 14));
        lblSillasSeleccionadas.setForeground(textColor);
        lblSillasSeleccionadas.setBounds(20, 400, 260, 40);
        add(lblSillasSeleccionadas);

        // Botón Volver
        JButton btnVolver = new JButton("< Volver");
        btnVolver.setFont(new Font("Arial", Font.BOLD, 16));
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setBackground(new Color(100, 0, 160));
        btnVolver.setFocusPainted(false);
        btnVolver.setBounds(20, 520, 110, 40);
        btnVolver.addActionListener(listener);
        add(btnVolver);

        // Botón Confirmar
        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setFont(new Font("Arial", Font.BOLD, 16));
        btnConfirmar.setForeground(Color.WHITE);
        btnConfirmar.setBackground(new Color(0, 180, 0));
        btnConfirmar.setFocusPainted(false);
        btnConfirmar.setBounds(150, 520, 120, 40);
        btnConfirmar.addActionListener(listener);
        add(btnConfirmar);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int padding = 20;
        int x = padding;
        int y = 40;

        // ---------- ESTADOS DE SILLAS ----------
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

        // Escogida (verde oscuro)
        g2d.setColor(new Color(0, 180, 0));
        g2d.fillOval(x, y, iconSize, iconSize);
        g2d.setColor(textColor);
        g2d.drawString("Escogida", x + 20, y + 10);
        y += 40;

        // ---------- TIPOS DE SILLAS ----------
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
        y += 20;

        // ---------- CANTIDAD DE SILLAS ----------
        g2d.setColor(titleColor);
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.drawString("Cantidad de sillas:", x, y);
    }

    private void cambiarCantidad(int delta) {
        cantidad += delta;
        if (cantidad < 0) {
            cantidad = 0;
        }
        lblCantidad.setText(String.valueOf(cantidad));
    }

    public void actualizarSillasSeleccionadas(Set<String> sillasSeleccionadas) {
        if (sillasSeleccionadas.isEmpty()) {
            lblSillasSeleccionadas.setText("Aún no has seleccionado sillas");
            cantidad = 0;
        } else {
            lblSillasSeleccionadas.setText(String.join(", ", sillasSeleccionadas));
            cantidad = sillasSeleccionadas.size();
        }
        lblCantidad.setText(String.valueOf(cantidad));
    }

    private void drawPriceTag(Graphics2D g2d, int x, int y, String text) {
        FontMetrics fm = g2d.getFontMetrics();
        int w = fm.stringWidth(text) + 16;
        int h = 20;
        g2d.setColor(greenTag);
        g2d.fillRoundRect(x, y, w, h, 10, 10);
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, 12));
        g2d.drawString(text, x + 8, y + 15);
    }
    
      public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Estados de sillas");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            SeatState panel = new SeatState (null);
            frame.add(panel);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
      }
}

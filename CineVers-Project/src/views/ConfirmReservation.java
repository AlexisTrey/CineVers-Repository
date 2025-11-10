/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Paola
 */
public class ConfirmReservation extends JDialog {

    public static final String ACTION_OK = "CONFIRM_OK";
    private final ActionListener listener;

    public ConfirmReservation(Frame owner, ActionListener listener) {
        super(owner, true);
        this.listener = listener;
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        initComponents(owner);
    }

    private void initComponents(Frame owner) {
        setAlwaysOnTop(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new GridBagLayout());
        ((JComponent) getContentPane()).setOpaque(false);

        final int WIDTH = 380;
        final int HEIGHT = 160;

        JPanel card = new JPanel(new BorderLayout(12, 12)) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.WHITE);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                g2.setColor(new Color(0, 0, 0, 30));
                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        card.setOpaque(false);
        card.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        card.setBorder(new EmptyBorder(20, 24, 20, 24));

        JLabel message = new JLabel(
                "<html><div style='text-align:center; line-height:1.4;'>"
                + "✅ Reservación confirmada correctamente."
                + "</div></html>",
                SwingConstants.CENTER
        );
        message.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        message.setForeground(new Color(50, 50, 50));

        JButton btnOk = new JButton("Aceptar") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                GradientPaint gp = new GradientPaint(0, 0, new Color(90, 180, 90), getWidth(), getHeight(), new Color(60, 150, 70));
                g2.setPaint(gp);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        btnOk.setForeground(Color.WHITE);
        btnOk.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnOk.setFocusPainted(false);
        btnOk.setContentAreaFilled(false);
        btnOk.setBorderPainted(false);
        btnOk.setPreferredSize(new Dimension(120, 40));
        btnOk.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnOk.setActionCommand(ACTION_OK);
        btnOk.addActionListener(e -> {
            if (listener != null) {
                listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ACTION_OK));
            }
            dispose();
        });

        JPanel south = new JPanel(new FlowLayout(FlowLayout.CENTER));
        south.setOpaque(false);
        south.add(btnOk);

        card.add(message, BorderLayout.CENTER);
        card.add(south, BorderLayout.SOUTH);

        getContentPane().add(card);
        pack();
        setSize(card.getPreferredSize());
        setLocationRelativeTo(owner);
    }
}

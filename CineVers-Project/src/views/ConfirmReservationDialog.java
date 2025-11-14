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
public class ConfirmReservationDialog extends JDialog {

    public static final String ACTION_OK = "CONFIRM_OK";
    private final ActionListener listener;

    public ConfirmReservationDialog(Frame owner, ActionListener listener) {
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

        final int CARD_W = 420;
        final int CARD_H = 180;

        JPanel card = new JPanel(new BorderLayout(12, 12)) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int arc = 20;
                g2.setColor(Color.WHITE);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), arc, arc);

                g2.setColor(new Color(0, 0, 0, 25));
                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

                g2.dispose();
                super.paintComponent(g);
            }
        };

        card.setOpaque(false);
        card.setPreferredSize(new Dimension(CARD_W, CARD_H));
        card.setBorder(new EmptyBorder(18, 20, 18, 20));

        // === TÍTULO (estilo LoginPromptDialog) ===
        JLabel title = new JLabel("Reserva confirmada", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setForeground(new Color(160, 60, 190));

        // === MENSAJE ===
        JLabel message = new JLabel(
                "<html><div style='text-align:center; line-height:1.4;'>"
                + "Tu reservación se ha realizado correctamente."
                + "</div></html>",
                SwingConstants.CENTER);

        message.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        message.setForeground(new Color(50, 50, 50));
        message.setBorder(new EmptyBorder(10, 10, 10, 10));

        // === BOTÓN (misma estética morada del LoginPromptDialog) ===
        JButton btnOk = new JButton("Aceptar") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                GradientPaint gp = new GradientPaint(
                        0, 0, new Color(180, 70, 220),
                        getWidth(), getHeight(), new Color(230, 130, 200)
                );

                g2.setPaint(gp);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 26, 26);

                g2.dispose();
                super.paintComponent(g);
            }
        };

        btnOk.setForeground(Color.WHITE);
        btnOk.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnOk.setFocusPainted(false);
        btnOk.setContentAreaFilled(false);
        btnOk.setBorderPainted(false);
        btnOk.setPreferredSize(new Dimension(150, 44));
        btnOk.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnOk.setActionCommand(ACTION_OK);

        btnOk.addActionListener(e -> {
            if (listener != null) {
                listener.actionPerformed(
                        new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ACTION_OK)
                );
            }
            dispose();
        });

        JPanel south = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        south.setOpaque(false);
        south.add(btnOk);

        // === ADD COMPONENTS ===
        card.add(title, BorderLayout.NORTH);

        JPanel center = new JPanel(new BorderLayout());
        center.setOpaque(false);
        center.add(message, BorderLayout.CENTER);
        card.add(center, BorderLayout.CENTER);

        card.add(south, BorderLayout.SOUTH);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        getContentPane().add(card, gbc);

        pack();
        setSize(card.getPreferredSize());
        setMinimumSize(card.getPreferredSize());
        setLocationRelativeTo(owner);
    }
}

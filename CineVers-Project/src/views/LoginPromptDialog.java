/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
 /**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */

public class LoginPromptDialog extends JDialog {

    public static final String ACTION_GO_LOGIN = "PROMPT_GO_LOGIN";
    private final ActionListener listener;

    public LoginPromptDialog(Frame owner, ActionListener listener) {
        super(owner, true);
        this.listener = listener;
        setUndecorated(true);
        setBackground(new Color(0,0,0,0));
        initComponents(owner);
    }

    private void initComponents(Frame owner) {
        setAlwaysOnTop(true);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        getContentPane().setLayout(new GridBagLayout());
        ((JComponent) getContentPane()).setOpaque(false);

        final int CARD_W = 460;
        final int CARD_H = 200;

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

        JLabel title = new JLabel("Atención", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setForeground(new Color(160, 60, 190));
JLabel message = new JLabel(
        "<html><div style='text-align:center; line-height:1.4;'>"
      + "Debes iniciar sesión para continuar con la compra<br>"
      + "y acceder a las opciones de reserva."
      + "</div></html>",
        SwingConstants.CENTER);

message.setFont(new Font("Segoe UI", Font.PLAIN, 14));
message.setForeground(new Color(50, 50, 50));
message.setBorder(new EmptyBorder(10, 10, 10, 10));

        JButton btnLogin = new JButton("Iniciar sesión") {
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
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnLogin.setFocusPainted(false);
        btnLogin.setContentAreaFilled(false);
        btnLogin.setBorderPainted(false);
        btnLogin.setPreferredSize(new Dimension(180, 44));
        btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnLogin.setActionCommand(ACTION_GO_LOGIN);
        btnLogin.addActionListener(evt -> {
            if (listener != null) {
                listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ACTION_GO_LOGIN));
            }
            SwingUtilities.invokeLater(this::dispose);
        });

        card.add(title, BorderLayout.NORTH);
JPanel center = new JPanel(new BorderLayout());
center.setOpaque(false);
center.add(message, BorderLayout.CENTER);
card.add(center, BorderLayout.CENTER);


        JPanel south = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        south.setOpaque(false);
        south.add(btnLogin);
        card.add(south, BorderLayout.SOUTH);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        getContentPane().add(card, gbc);

        pack();
        setSize(card.getPreferredSize());
        setMinimumSize(card.getPreferredSize());

        if (getOwner() != null) {
            setLocationRelativeTo(getOwner());
        } else {
            setLocationRelativeTo(null);
        }

        getRootPane().registerKeyboardAction(e -> {}, 
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_IN_FOCUSED_WINDOW);
    }
}

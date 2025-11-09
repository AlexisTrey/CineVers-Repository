/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author meloc
 */


public class UserMenuPanel extends JPopupMenu {

    private JLabel lblName, lblEmail, lblRole;
    private JButton btnLogout;

    public UserMenuPanel(ActionListener listener) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        setFocusable(false);

        lblName = new JLabel("Nombre de Usuario");
        lblName.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblName.setForeground(Color.DARK_GRAY);
        lblName.setBorder(new EmptyBorder(10, 10, 2, 10));

        lblEmail = new JLabel("correo@ejemplo.com");
        lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblEmail.setForeground(Color.GRAY);
        lblEmail.setBorder(new EmptyBorder(0, 10, 5, 10));

        lblRole = new JLabel("Rol: Cliente");
        lblRole.setFont(new Font("Segoe UI", Font.ITALIC, 11));
        lblRole.setForeground(Color.GRAY);
        lblRole.setBorder(new EmptyBorder(0, 10, 10, 10));

        btnLogout = new JButton("Cerrar sesión");
        btnLogout.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnLogout.setForeground(Color.WHITE);
        btnLogout.setBackground(Color.decode("#7B2CBF"));
        btnLogout.setFocusPainted(false);
        btnLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnLogout.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnLogout.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        btnLogout.setActionCommand("CERRAR_SESION");
        btnLogout.addActionListener(listener);

        add(lblName);
        add(lblEmail);
        add(lblRole);
        add(new JSeparator());
        add(btnLogout);
    }

    public void updateUserInfo(String name, String email, String role) {
        lblName.setText(name);
        lblEmail.setText(email);
        lblRole.setText("Rol: " + role);
    }
}

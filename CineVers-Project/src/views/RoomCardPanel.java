/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */
public class RoomCardPanel extends JPanel {

    private JLabel lblIcon;
    private JLabel lblTitle;
    private JLabel lblName;
    private JLabel lblCapacity;
    private JLabel lblStatus;
    private JButton btnEdit;
    private JButton btnDelete;

    public RoomCardPanel(String title, String name, String capacity, String status, ImageIcon icon) {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1100, 180));
        setOpaque(false);
        setBorder(new EmptyBorder(15, 25, 15, 25));

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setOpaque(false);
        mainPanel.setBackground(Color.WHITE);

        JPanel leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setOpaque(false);

        GridBagConstraints gbcLeft = new GridBagConstraints();
        gbcLeft.insets = new Insets(10, 10, 10, 10);
        gbcLeft.anchor = GridBagConstraints.WEST;

        JPanel iconPanel = new JPanel(new BorderLayout());
        iconPanel.setPreferredSize(new Dimension(150, 150));
        iconPanel.setBackground(new Color(167, 102, 213));
        iconPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        lblIcon = new JLabel();
        lblIcon.setHorizontalAlignment(SwingConstants.CENTER);

        if (icon != null) {
            Image img = icon.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH);
            lblIcon.setIcon(new ImageIcon(img));
        }

        iconPanel.add(lblIcon, BorderLayout.CENTER);

        gbcLeft.gridx = 0;
        gbcLeft.gridy = 0;
        leftPanel.add(iconPanel, gbcLeft);

        JPanel infoPanel = new JPanel(new GridBagLayout());
        infoPanel.setBackground(Color.WHITE);

        GridBagConstraints gInfo = new GridBagConstraints();
        gInfo.anchor = GridBagConstraints.WEST;
        gInfo.insets = new Insets(4, 15, 4, 0);
        gInfo.gridx = 0;
        gInfo.gridy = 0;

        lblTitle = new JLabel(title);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitle.setForeground(Color.BLACK);
        infoPanel.add(lblTitle, gInfo);

        gInfo.gridy++;
        lblName = new JLabel("Nombre: " + name);
        lblName.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblName.setForeground(new Color(130, 130, 130));
        infoPanel.add(lblName, gInfo);

        gInfo.gridy++;
        lblCapacity = new JLabel("Capacidad: " + capacity);
        lblCapacity.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblCapacity.setForeground(new Color(130, 130, 130));
        infoPanel.add(lblCapacity, gInfo);

        gInfo.gridy++;
        lblStatus = new JLabel("Estado: " + status);
        lblStatus.setFont(new Font("Segoe UI", Font.ITALIC, 16));
        lblStatus.setForeground(new Color(90, 90, 90));
        infoPanel.add(lblStatus, gInfo);

        gbcLeft.gridx = 1;
        gbcLeft.gridy = 0;
        leftPanel.add(infoPanel, gbcLeft);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false);

        btnEdit = new JButton("Editar");
        btnEdit.setUI(new ShapedButtons());
        btnEdit.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnEdit.setForeground(Color.WHITE);
        btnEdit.setPreferredSize(new Dimension(110, 40));
        btnEdit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnEdit.setOpaque(true);
        btnEdit.setContentAreaFilled(true);
        btnEdit.setBorderPainted(false);
        btnEdit.setFocusPainted(false);

        btnDelete = new JButton("Eliminar");
        btnDelete.setUI(new ShapedButtons());
        btnDelete.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setPreferredSize(new Dimension(110, 40));
        btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnDelete.setOpaque(true);
        btnDelete.setContentAreaFilled(true);
        btnDelete.setBorderPainted(false);
        btnDelete.setFocusPainted(false);

        GridBagConstraints gBtns = new GridBagConstraints();
        gBtns.insets = new Insets(10, 10, 10, 10);
        gBtns.gridx = 0;
        gBtns.gridy = 0;
        buttonPanel.add(btnEdit, gBtns);

        gBtns.gridy++;
        buttonPanel.add(btnDelete, gBtns);

        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(buttonPanel, BorderLayout.EAST);

        add(mainPanel, BorderLayout.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int arc = 30;
        Shape cardShape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arc, arc);
        g2d.setColor(Color.WHITE);
        g2d.fill(cardShape);
        g2d.setColor(new Color(0, 0, 0, 40));
        g2d.setStroke(new BasicStroke(1.5f));
        g2d.draw(cardShape);
        g2d.dispose();
        super.paintComponent(g);
    }

    public JButton getBtnEdit() {
        return btnEdit;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }
}

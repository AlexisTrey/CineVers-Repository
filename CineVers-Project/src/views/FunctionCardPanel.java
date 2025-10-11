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
public class FunctionCardPanel extends JPanel {

    private JLabel lblPoster;
    private JLabel lblTitle;
    private JLabel lblRoom;
    private JLabel lblSeats;
    private JLabel lblTime;
    private JLabel lblType;
    private JButton btnEdit;
    private JButton btnDelete;

    public FunctionCardPanel(String title, String room, String seats, String time, String type, ImageIcon poster) {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1100, 220));
        setOpaque(false);
        setBorder(new EmptyBorder(15, 25, 15, 25));

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setOpaque(false);

        lblPoster = new JLabel();
        lblPoster.setHorizontalAlignment(SwingConstants.CENTER);
        lblPoster.setVerticalAlignment(SwingConstants.CENTER);
        lblPoster.setPreferredSize(new Dimension(200, 220));
        lblPoster.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 15));

        if (poster != null) {
            Image img = poster.getImage().getScaledInstance(180, 220, Image.SCALE_SMOOTH);
            lblPoster.setIcon(new ImageIcon(img));
        }

        JPanel infoPanel = new JPanel(new GridBagLayout());
        infoPanel.setBackground(Color.WHITE);

        GridBagConstraints gbcInfo = new GridBagConstraints();
        gbcInfo.anchor = GridBagConstraints.WEST;
        gbcInfo.insets = new Insets(4, 10, 4, 10);
        gbcInfo.gridx = 0;
        gbcInfo.gridy = 0;

        lblTitle = new JLabel(title);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitle.setForeground(Color.BLACK);
        infoPanel.add(lblTitle, gbcInfo);

        gbcInfo.gridy++;
        lblRoom = new JLabel("Sala: " + room);
        lblRoom.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblRoom.setForeground(new Color(130, 130, 130));
        infoPanel.add(lblRoom, gbcInfo);

        gbcInfo.gridy++;
        lblSeats = new JLabel("Asientos disponibles: " + seats);
        lblSeats.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblSeats.setForeground(new Color(130, 130, 130));
        infoPanel.add(lblSeats, gbcInfo);

        gbcInfo.gridy++;
        lblTime = new JLabel("Hora función: " + time);
        lblTime.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblTime.setForeground(new Color(130, 130, 130));
        infoPanel.add(lblTime, gbcInfo);

        gbcInfo.gridy++;
        lblType = new JLabel("Tipo: " + type);
        lblType.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblType.setForeground(new Color(130, 130, 130));
        infoPanel.add(lblType, gbcInfo);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false);

        btnEdit = new JButton("Editar");
        btnEdit.setUI(new ShapedButtons());
        btnEdit.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnEdit.setForeground(Color.WHITE);
        btnEdit.setPreferredSize(new Dimension(120, 42));
        btnEdit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnEdit.setFocusPainted(false);
        btnEdit.setBorderPainted(false);

        btnDelete = new JButton("Eliminar");
        btnDelete.setUI(new ShapedButtons());
        btnDelete.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setPreferredSize(new Dimension(120, 42));
        btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnDelete.setFocusPainted(false);
        btnDelete.setBorderPainted(false);

        GridBagConstraints gbcBtns = new GridBagConstraints();
        gbcBtns.insets = new Insets(10, 10, 10, 10);
        gbcBtns.gridx = 0;
        gbcBtns.gridy = 0;
        buttonPanel.add(btnEdit, gbcBtns);

        gbcBtns.gridy++;
        buttonPanel.add(btnDelete, gbcBtns);

        mainPanel.add(lblPoster, BorderLayout.WEST);
        mainPanel.add(infoPanel, BorderLayout.CENTER);
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

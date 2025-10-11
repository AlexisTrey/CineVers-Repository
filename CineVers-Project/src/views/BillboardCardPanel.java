/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
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
public class BillboardCardPanel extends JPanel {

    private JLabel lblPoster;
    private JLabel lblTitle;
    private JLabel lblGenre;
    private JLabel lblTags;
    private JButton btnEdit;
    private JButton btnDelete;

    public BillboardCardPanel(String title, String genre, String tags, ImageIcon poster) {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(350, 570));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        //Poster
        lblPoster = new JLabel();
        lblPoster.setHorizontalAlignment(SwingConstants.CENTER);
        lblPoster.setPreferredSize(new Dimension(320, 400));

        if (poster != null) {
            Image img = poster.getImage().getScaledInstance(320, 440, Image.SCALE_SMOOTH);
            lblPoster.setIcon(new ImageIcon(img));
        } else {
            lblPoster.setText("Sin imagen");
            lblPoster.setHorizontalAlignment(SwingConstants.CENTER);
            lblPoster.setForeground(Color.GRAY);
        }

        //Panel
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(Color.WHITE);
        infoPanel.setBorder(new EmptyBorder(10, 5, 5, 5));

        lblTitle = new JLabel(title);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitle.setForeground(new Color(40, 40, 40));
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        lblGenre = new JLabel(genre);
        lblGenre.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblGenre.setForeground(new Color(130, 130, 130));
        lblGenre.setAlignmentX(Component.CENTER_ALIGNMENT);

        lblTags = new JLabel(tags);
        lblTags.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblTags.setForeground(new Color(255, 215, 0));
        lblTags.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Botones
        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(Color.WHITE);
        btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.X_AXIS));
        btnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnEdit = createStyledButton("Editar");
        btnDelete = createStyledButton("Eliminar");

        btnPanel.add(Box.createHorizontalGlue());
        btnPanel.add(btnEdit);
        btnPanel.add(Box.createHorizontalStrut(10));
        btnPanel.add(btnDelete);
        btnPanel.add(Box.createHorizontalGlue());

        infoPanel.add(lblTitle);
        infoPanel.add(lblGenre);
        infoPanel.add(Box.createVerticalStrut(5));
        infoPanel.add(lblTags);
        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(btnPanel);

        add(lblPoster, BorderLayout.NORTH);
        add(infoPanel, BorderLayout.CENTER);

        setOpaque(false);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setUI(new ShapedButtons());
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setForeground(Color.WHITE);
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(140, 45));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return button;
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
        g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);
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

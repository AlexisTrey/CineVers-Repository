/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import utilities.Utilities;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */
public class Footer extends Background {

    public Footer() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(0, 180));
        components();
    }

    private void components() {
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);
        topPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 10, 40));

        JLabel lblLogo = new JLabel();
        lblLogo.setIcon(loadIcon(Utilities.LOGO_FOOTER_PATH, 200, 50));

        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        logoPanel.setOpaque(false);
        logoPanel.add(lblLogo);

        JPanel linksPanel = new JPanel();
        linksPanel.setOpaque(false);
        linksPanel.setLayout(new BoxLayout(linksPanel, BoxLayout.Y_AXIS));

        JLabel lblTerms = createFooterLabel("- Términos y Condiciones");
        JLabel lblQuestions = createFooterLabel("- Preguntas Frecuentes");
        JLabel lblHabeas = createFooterLabel("- Habeas Data");

        linksPanel.add(lblTerms);
        linksPanel.add(lblQuestions);
        linksPanel.add(lblHabeas);

        JPanel iconsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 0));
        iconsPanel.setOpaque(false);
        iconsPanel.add(createIconLabel(Utilities.INSTAGRAM_PATH));
        iconsPanel.add(createIconLabel(Utilities.TIKTOK_PATH));
        iconsPanel.add(createIconLabel(Utilities.FACEBOOK_PATH));
        iconsPanel.add(createIconLabel(Utilities.TELEGRAM_PATH));

        topPanel.add(logoPanel, BorderLayout.WEST);
        topPanel.add(linksPanel, BorderLayout.CENTER);
        topPanel.add(iconsPanel, BorderLayout.EAST);

        JPanel bottomPanel = new JPanel(new GridLayout(2, 1));
        bottomPanel.setOpaque(false);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel lblCopyright = new JLabel("Copyright 2025© - TODOS LOS DERECHOS RESERVADOS", SwingConstants.CENTER);
        lblCopyright.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        lblCopyright.setForeground(Color.WHITE);

        JLabel lblLegal = new JLabel("Cine Vers S.A.S. NIT 495.283.921-3. Cra. 58 #68-27 Miami, USA. Teléfono: 3100000000. Correo Notificaciones Judiciales: notificaciones@cine-vers.com", SwingConstants.CENTER);
        lblLegal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblLegal.setForeground(Color.WHITE);

        bottomPanel.add(lblCopyright);
        bottomPanel.add(lblLegal);

        add(topPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private JLabel createFooterLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        label.setForeground(Color.WHITE);
        return label;
    }

    private JLabel createIconLabel(String path) {
        JLabel label = new JLabel();
        label.setIcon(loadIcon(path, 40, 40));
        return label;
    }

    private ImageIcon loadIcon(String path, int width, int height) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL);
            Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(img);
        }
        return new ImageIcon();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */
public class HomePanel extends JPanel {

    private JPanel mainContent;
    private JPanel topPanel;
    private JPanel contentPanel;
    private JScrollPane scrollPane;

    public HomePanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(44, 44, 84));

        mainContent = new JPanel();
        mainContent.setLayout(new BoxLayout(mainContent, BoxLayout.Y_AXIS));
        mainContent.setBackground(new Color(44, 44, 84));

        createTopPanel();
        createContentPanel();

        mainContent.add(topPanel);
        mainContent.add(contentPanel);

        scrollPane = new JScrollPane(mainContent);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        add(scrollPane, BorderLayout.CENTER);
    }

    private void createTopPanel() {
        topPanel = new JPanel(new GridBagLayout());
        topPanel.setBackground(new Color(122, 43, 191));
        topPanel.setPreferredSize(new Dimension(0, 250));

        JLabel lblTitle = new JLabel("Tu portal al universo del cine");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 40));
        lblTitle.setForeground(Color.WHITE);

        JLabel lblSubTitle = new JLabel("Disfruta de los últimos éxitos de taquilla en un ambiente apto para toda la familia.");
        lblSubTitle.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        lblSubTitle.setForeground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.insets = new java.awt.Insets(10, 0, 10, 0);
        topPanel.add(lblTitle, gbc);

        gbc.gridy = 1;
        topPanel.add(lblSubTitle, gbc);
    }

    private void createContentPanel() {
        contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(new Color(240, 240, 240));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new java.awt.Insets(30, 30, 30, 30);
        gbc.gridy = 0;

        // Tarjeta 1
        gbc.gridx = 0;
        contentPanel.add(new MovieCardPanel(
                "Orgullo y Prejuicio",
                "Drama • Romance",
                "2D ⭐VIP",
                new ImageIcon(getClass().getResource("/resources/images/OrgulloyPrejuicio.png"))
        ), gbc);

        // Tarjeta 2
        gbc.gridx = 1;
        contentPanel.add(new MovieCardPanel(
                "Venom 3",
                "Acción",
                "3D ⭐VIP",
                new ImageIcon(getClass().getResource("/resources/images/Together.png"))
        ), gbc);

        // Tarjeta 3
        gbc.gridx = 2;
        contentPanel.add(new MovieCardPanel(
                "Inside Out 2",
                "Animación",
                "2D",
                new ImageIcon(getClass().getResource("/resources/images/OtroViernesDeLocos.png"))
        ), gbc);
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }
}

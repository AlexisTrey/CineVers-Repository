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
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */
public class HomePanel extends JPanel {

    private JPanel topPanel;
    private JPanel contentPanel;

    public HomePanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(44, 44, 84)); // color oscuro elegante

        createTopPanel();
        createContentPanel();

        add(topPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
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
        contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setLayout(new BorderLayout());
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }
}

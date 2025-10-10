/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */
public class RoomEditionPanel extends JPanel {

    private JMenuBar menuBar;
    private JMenu menuPanel;
    private JMenu menuBillboard;
    private JMenu menuUsers;
    private JPanel contentPanel;

    public RoomEditionPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(240, 240, 240));

        createMenuBar();
        createContentPanel();

        add(menuBar, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
    }

    private void createMenuBar() {
        menuBar = new JMenuBar();
        menuBar.setBackground(new Color(122, 43, 191));
        menuBar.setPreferredSize(new Dimension(0, 60));

        menuPanel = createStyledMenu("Panel");
        menuBillboard = createStyledMenu("Cartelera");
        menuUsers = createStyledMenu("Usuarios");

        menuBar.add(menuPanel);
        menuBar.add(menuBillboard);
        menuBar.add(menuUsers);
    }

    private JMenu createStyledMenu(String text) {
        JMenu menu = new JMenu(text);
        menu.setFont(new Font("Segoe UI", Font.BOLD, 18));
        menu.setForeground(Color.WHITE);

        menu.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));

        return menu;
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

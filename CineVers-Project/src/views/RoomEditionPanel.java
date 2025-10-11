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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import utilities.Utilities;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */
public class RoomEditionPanel extends JPanel {

    private JPanel menuPanel;
    private JButton btnFunctions;
    private JButton btnBillboard;
    private JButton btnRooms;
    private JPanel contentPanel;

    public RoomEditionPanel(ActionListener listener) {
        setLayout(new BorderLayout());
        setBackground(new Color(240, 240, 240));

        createMenuPanel(listener);
        createContentPanel();

        add(menuPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
    }

    private void createMenuPanel(ActionListener listener) {
        menuPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 40, 16));
        menuPanel.setBackground(new Color(122, 43, 191));
        menuPanel.setPreferredSize(new Dimension(0, 80));
        menuPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(98, 43, 160)));

        btnFunctions = createStyledButton("Edición de Funciones", "EDITAR_FUNCIONES", listener);
        btnBillboard = createStyledButton("Edición de Cartelera", "EDITAR_CARTELERA", listener);
        btnRooms = createStyledButton("Edición de Salas", "EDITAR_SALAS", listener);

        menuPanel.add(btnFunctions);
        menuPanel.add(btnBillboard);
        menuPanel.add(btnRooms);
    }

    private JButton createStyledButton(String text, String actionCommand, ActionListener listener) {
        JButton button = new JButton(text);
        button.setUI(new ShapedButtons());
        button.setPreferredSize(new Dimension(230, 45));
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setForeground(Color.WHITE);
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setActionCommand(actionCommand);
        button.addActionListener(listener);
        return button;
    }

    private void createContentPanel() {
        contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(new Color(240, 240, 240));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new java.awt.Insets(30, 0, 40, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        AddCardButton btnAddRoom = new AddCardButton("Agregar Sala");
        contentPanel.add(btnAddRoom, gbc);

        gbc.gridy++;
        gbc.insets = new java.awt.Insets(15, 30, 15, 30);

        RoomCardPanel[] rooms = {
            new RoomCardPanel("Sala 1 – VIP 3D", "VIP Platino", "40 | Disponibles: 35", "Activa",
            new ImageIcon(getClass().getResource(Utilities.ICON_ROOM_PATH))),
            new RoomCardPanel("Sala 2 – Estándar 2D", "Estándar 2D", "Capacidad: 80 | Disponibles: 72", "Activa",
            new ImageIcon(getClass().getResource(Utilities.ICON_ROOM_PATH))),
            new RoomCardPanel("Sala 3 – D-BOX", "D-BOX (2D + movimiento)", "50 | Disponibles: 45", "Mantenimiento",
            new ImageIcon(getClass().getResource(Utilities.ICON_ROOM_PATH))),
            new RoomCardPanel("Sala 4 – Premium Dolby Atmos", "Premium Dolby Atmos", "60 | Disponibles: 58", "Activa",
            new ImageIcon(getClass().getResource(Utilities.ICON_ROOM_PATH))),
            new RoomCardPanel("Sala 5 – Infantil", "Infantil (2D)", "30 | Disponibles: 27", "Activa",
            new ImageIcon(getClass().getResource(Utilities.ICON_ROOM_PATH)))
        };

        for (RoomCardPanel room : rooms) {
            contentPanel.add(room, gbc);
            gbc.gridy++;
        }
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }
}

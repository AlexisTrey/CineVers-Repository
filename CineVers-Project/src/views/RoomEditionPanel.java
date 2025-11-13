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
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import models.CineVersSystem;
import models.Room;
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
    private ActionListener listener;
    private CineVersSystem cine;

    public RoomEditionPanel(ActionListener listener) {
        this.listener = listener;
        this.cine = new CineVersSystem();
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
        contentPanel.setBorder(new EmptyBorder(20, 0, 30, 0));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 0, 30, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        AddCardButton btnAddRoom = new AddCardButton("Agregar Sala");
        btnAddRoom.setActionCommand("AGREGAR_SALA");
        btnAddRoom.addActionListener(listener);
        contentPanel.add(btnAddRoom, gbc);

        gbc.gridy++;
        refreshContent();
    }

    public void refreshContent() {
        for (int i = contentPanel.getComponentCount() - 1; i >= 1; i--) {
            contentPanel.remove(i);
        }

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 30, 10, 30);
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy = 1;

        cine.refreshRooms();
        List<Room> rooms = cine.getRooms();

        if (rooms.isEmpty()) {
            JLabel lbl = new JLabel("No hay salas registradas");
            lbl.setFont(new Font("Segoe UI", Font.ITALIC, 18));
            lbl.setForeground(new Color(100, 100, 100));
            contentPanel.add(lbl, gbc);
        } else {
            for (Room room : rooms) {
                RoomCardPanel card = new RoomCardPanel(
                        room.getName(),
                        room.getType(),
                        String.valueOf(room.getCapacity()),
                        "Activa",
                        new ImageIcon(getClass().getResource(Utilities.ICON_ROOM_PATH))
                );

                //Acción de editar
                card.getBtnEdit().setActionCommand("EDITAR_SALA_" + room.getId());
                card.getBtnEdit().addActionListener(listener);

                //Acción de eliminar
                card.getBtnDelete().setActionCommand("ELIMINAR_SALA_" + room.getId());
                card.getBtnDelete().addActionListener(listener);

                contentPanel.add(card, gbc);
                gbc.gridy++;
            }
        }

        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }
}
